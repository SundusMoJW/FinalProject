package com.twins.osama.finalproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.twins.osama.finalproject.Helpar.SharedPrefUtil;
import com.twins.osama.finalproject.R;

import static com.twins.osama.finalproject.Helpar.Const.STATUS_SHARED_PREF;

public class Splash extends AppCompatActivity {

    private SharedPrefUtil sharedPrefUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                sharedPrefUtil = new SharedPrefUtil(getApplicationContext());
                if (sharedPrefUtil.getBoolean(STATUS_SHARED_PREF)) {
                    startActivity(new Intent(Splash.this, MainActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(Splash.this, Login.class));
                    finish();
               }
            }
        }, 2000);
    }
}
