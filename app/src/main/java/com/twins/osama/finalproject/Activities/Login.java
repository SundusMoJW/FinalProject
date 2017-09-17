package com.twins.osama.finalproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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
    TextView LoginPassword;
    TextView LoginUser;
    private Button login;
    FirebaseDatabase database;
    SharedPrefUtil sharedPrefUtil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        LoginUser = (TextView) findViewById(R.id.LoginUser);
        LoginPassword = (TextView) findViewById(R.id.LoginPassword);
        login = (Button) findViewById(R.id.login);
        sharedPrefUtil = new SharedPrefUtil(Login.this);
        database = FirebaseDatabase.getInstance();
        final Query patient = database.getReference().child("AddPatient");

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                patient.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                JSONObject dt = new JSONObject((Map) data.getValue());
                                String uRCN = dt.optString("RCN");
                                String uRRIS_SSN_NO = dt.optString("RRIS_SSN_NO");
//                        String title = dt.optString("title");
//                        String body = dt.optString("body");
                                if (uRCN.equals(LoginUser.getText())&&uRRIS_SSN_NO.equals(LoginPassword.getText())){
                                    sharedPrefUtil.saveBoolean(STATUS_SHARED_PREF,true);
                                    sharedPrefUtil.saveString(USER_RCN_LOGIN, LoginUser.getText()+"");
                                    sharedPrefUtil.saveString(USER_SSN_LOGIN, LoginPassword.getText()+"");
                                    startActivity(new Intent(Login.this, MainActivity.class));
                                    finish();
                                }
                            }
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });

            }
        });


    }
}
