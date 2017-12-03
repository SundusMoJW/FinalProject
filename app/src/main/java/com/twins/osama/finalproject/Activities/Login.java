package com.twins.osama.finalproject.Activities;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.twins.osama.finalproject.Classes.PersonalData;
import com.twins.osama.finalproject.Helpar.SharedPrefUtil;
import com.twins.osama.finalproject.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmResults;

import static com.twins.osama.finalproject.Helpar.Const.STATUS_SHARED_PREF;
import static com.twins.osama.finalproject.Helpar.Const.USER_RCN_LOGIN;

public class Login extends AppCompatActivity {
    private Realm realm;
    private EditText LoginPassword;
    private EditText LoginUser;
    private Button login;
    private FirebaseDatabase database;
    private SharedPrefUtil sharedPrefUtil;
    private String uRRIS_SSN_NO;
    private ArrayList<PersonalData> personalDatas = new ArrayList<>();
    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginUser = (EditText) findViewById(R.id.LoginUser);
        LoginPassword = (EditText) findViewById(R.id.LoginPassword);
        login = (Button) findViewById(R.id.login);
        sharedPrefUtil = new SharedPrefUtil(Login.this);
        database = FirebaseDatabase.getInstance();
        view= findViewById(R.id.layout);

        Realm.init(getApplication());
        realm = Realm.getDefaultInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {
                if(!(LoginUser.getText().toString().isEmpty())&&!(LoginPassword.getText().toString().isEmpty())) {
                    final Query patient = database.getReference().child("AddPatient").orderByChild("RCN")
                            .equalTo(LoginUser.getText().toString().trim());
//                database.getReference().child("AddPatient").orderByChild("RCN")
//                        .equalTo(LoginUser.getText().toString().trim())
                    patient.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(DataSnapshot dataSnapshot) {
                            Log.i("aaaa", dataSnapshot.getValue().toString());

                            if (dataSnapshot.exists()) {
                                for (DataSnapshot data : dataSnapshot.getChildren()) {
//                                        JSONObject   dt = new JSONObject((Map) dataSnapshot.child(dataSnapshot.getKey()).getValue());
                                    JSONObject dt = new JSONObject((Map) data.getValue());
//                                    try {
//                                        JSONObject dt1=dt.getJSONObject(dataSnapshot.child(dataSnapshot.getKey()).toString());
                                    Log.i("aaaa", "//" + dt.toString());
//                                    Map<String, String> map=(Map<String, String>) dataSnapshot.getValue();
//                                    Log.i("aaaa", "//"+map.toString());
//                                    String uRCN=   map.get("RCN");
//                                    String uRRIS_SSN_NO =   map.get("RRIS_SSN_NO");

                                    uRRIS_SSN_NO = dt.optString("RRIS_SSN_NO");

                                    Log.i("aaaa", "//" + dt.optString("RCN"));
//                        String title = dt.optString("title"//);
//                                    private String RCN_NO;
//                                    private String RrisFamilyId;
//                                    private String Team;
//                                    private String BloodType;
//                                    private String Name;
//                                    private String Address;
//                                    private String Key;
                                    if (uRRIS_SSN_NO.equals(LoginPassword.getText().toString().trim())) {

                                        realm.beginTransaction();
                                        RealmResults<PersonalData> result = realm.where(PersonalData.class).findAll();
                                        if (!(result.isEmpty())) {
                                            result.deleteAllFromRealm();
                                            realm.commitTransaction();
                                        } else realm.cancelTransaction();

                                        String uRCN = dt.optString("RCN");
                                        String RrisFamilyId = dt.optString("RRIS_Family_ID");
                                        String Team = dt.optString("Team");
                                        String BloodType = dt.optString("Blood_Type");
                                        String Name = dt.optString("Patient_Name");
                                        String Address = dt.optString("Address");
                                        String Key = dt.optString("PatientId");
                                        sharedPrefUtil.saveBoolean(STATUS_SHARED_PREF, true);
                                        sharedPrefUtil.saveString(USER_RCN_LOGIN, uRCN);

                                        PersonalData pData=new PersonalData(uRCN,uRRIS_SSN_NO,RrisFamilyId,Team,BloodType,Name,Address,Key);
                                        personalDatas.add(pData);
                                        for (PersonalData b : personalDatas) {
//                                             Persist your data easily
                                            realm.beginTransaction();
                                            realm.copyToRealm(b);
                                            realm.commitTransaction();
//                            Log.i("///", "///" + "" +/* b.getImages()+b.getTitels()*/meals.get(0).getName());
                                        }
                                        startActivity(new Intent(Login.this, MainActivity.class));
                                        finish();
                                    } else {
                                         Snackbar.make(view, getString(R.string.invalid_login), Snackbar.LENGTH_SHORT).show();
                                    }
//                                        Toast.makeText(Login.this, "Invalid RCN or Password", Toast.LENGTH_SHORT).show();
                                }
                            } else
                                Snackbar.make(view, getString(R.string.acc_not_found), Snackbar.LENGTH_SHORT).show();
//                                Toast.makeText(Login.this, "This account not found", Toast.LENGTH_SHORT).show();
                        }

//                    }

                        @Override
                        public void onCancelled(DatabaseError databaseError) {
                            Toast.makeText(Login.this, "You must enter your account", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else Toast.makeText(Login.this, "You must enter your account", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
