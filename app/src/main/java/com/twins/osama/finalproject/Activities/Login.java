package com.twins.osama.finalproject.Activities;

import android.content.Intent;
import android.os.Bundle;
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
import com.twins.osama.finalproject.Helpar.SharedPrefUtil;
import com.twins.osama.finalproject.R;

import org.json.JSONObject;

import java.util.Map;

import static com.twins.osama.finalproject.Helpar.Const.STATUS_SHARED_PREF;
import static com.twins.osama.finalproject.Helpar.Const.USER_RCN_LOGIN;
import static com.twins.osama.finalproject.Helpar.Const.USER_SSN_LOGIN;

public class Login extends AppCompatActivity {
    EditText LoginPassword;
    EditText LoginUser;
    private Button login;
    FirebaseDatabase database;
    SharedPrefUtil sharedPrefUtil;
    String uRRIS_SSN_NO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginUser = (EditText) findViewById(R.id.LoginUser);
        LoginPassword = (EditText) findViewById(R.id.LoginPassword);
        login = (Button) findViewById(R.id.login);
        sharedPrefUtil = new SharedPrefUtil(Login.this);
        database = FirebaseDatabase.getInstance();


        login.setOnClickListener(new View.OnClickListener() {
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
                                    String uRCN = dt.optString("RCN");
                                    uRRIS_SSN_NO = dt.optString("RRIS_SSN_NO");

                                    Log.i("aaaa", "//" + dt.optString("RCN"));


//                        String title = dt.optString("title"
//);

//                        String body = dt.optString("body");
                                    if (uRRIS_SSN_NO.equals(LoginPassword.getText().toString().trim())) {
                                        sharedPrefUtil.saveBoolean(STATUS_SHARED_PREF, true);
                                        sharedPrefUtil.saveString(USER_RCN_LOGIN, LoginUser.getText().toString().trim());
                                        sharedPrefUtil.saveString(USER_SSN_LOGIN, LoginPassword.getText().toString().trim());
                                        startActivity(new Intent(Login.this, MainActivity.class));
                                        finish();
                                    } else
                                        Toast.makeText(Login.this, "Invalid RCN or Password", Toast.LENGTH_SHORT).show();
                                }
                            } else
                                Toast.makeText(Login.this, "This account not found", Toast.LENGTH_SHORT).show();
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
