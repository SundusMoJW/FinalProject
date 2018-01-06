package com.twins.osama.finalproject.Activities;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.twins.osama.finalproject.Helpar.SharedPrefUtil;
import com.twins.osama.finalproject.Helpar.Util;
import com.twins.osama.finalproject.R;

import java.util.Locale;

import static com.twins.osama.finalproject.Helpar.Const.LANG;

public class SettingActivity extends AppCompatActivity {

    private SharedPrefUtil sharedPrefUtil;
    private String strLanguge;
    private Switch switch_language;
    private ImageView menu;
    private TextView logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Util.setLangSettings(this);
        setContentView(R.layout.activity_setting);
        sharedPrefUtil = new SharedPrefUtil(this);
        strLanguge = sharedPrefUtil.getString(LANG);
        menu = (ImageView) findViewById(R.id.menu);
        logout=findViewById(R.id.logout);


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        switch_language = (Switch) findViewById(R.id.switch_Language);
        switch_language.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String arabic = (String) getResources().getText(R.string.Arabic);
                String english = (String) getResources().getText(R.string.English);
                if (buttonView.isChecked()) {
                    if (switch_language.getText() == arabic) {
                        switch_language.setText(english);
                        sharedPrefUtil.saveString(LANG, english);
                        String languageToLoad = "en";
                        Locale locale = new Locale(languageToLoad);
                        Locale.setDefault(locale);
                        Configuration config = new Configuration();
                        config.locale = locale;
                        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                        Intent intent = new Intent(SettingActivity.this, Splash.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                      finish();

                    } else {
                        switch_language.setText((String) getResources().getText(R.string.Arabic));
                        sharedPrefUtil.saveString(LANG, arabic);
                        String languageToLoad = "ar";
                        Locale locale = new Locale(languageToLoad);
                        Locale.setDefault(locale);
                        Configuration config = new Configuration();
                        config.locale = locale;
                       getResources().updateConfiguration(config, getResources().getDisplayMetrics());
                        Intent intent = new Intent(SettingActivity.this, Splash.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                        finish();
                    }
                } else {

                    if (switch_language.getText() == arabic) {
                        switch_language.setText(english);
                        sharedPrefUtil.saveString(LANG, english);
                        String languageToLoad = "en";
                        Locale locale = new Locale(languageToLoad);
                        Locale.setDefault(locale);
                        Configuration config = new Configuration();
                        config.locale = locale;
                       getResources().updateConfiguration(config,getResources().getDisplayMetrics());
                        Intent intent = new Intent(SettingActivity.this, Splash.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                       finish();
                    } else {
                        switch_language.setText((String) getResources().getText(R.string.Arabic));
                        sharedPrefUtil.saveString(LANG, arabic);
                        String languageToLoad = "ar";
                        Locale locale = new Locale(languageToLoad);
                        Locale.setDefault(locale);
                        Configuration config = new Configuration();
                        config.locale = locale;
                        getResources().updateConfiguration(config,getResources().getDisplayMetrics());
                        Intent intent = new Intent(SettingActivity.this, Splash.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(intent);
                       finish();
                    }
                }
            }

        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });
    }
    private void Logout() {
        //Creating an alert dialog to confirm logout
        android.support.v7.app.AlertDialog.Builder alertDialogBuilder = new android.support.v7.app.AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to logout?");
        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        sharedPrefUtil = new SharedPrefUtil(SettingActivity.this);
                        sharedPrefUtil.clear();
                        Intent intent = new Intent(SettingActivity.this, Login.class);
                        startActivity(intent);
                       finish();
                    }
                });
        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                    }
                });

        android.support.v7.app.AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();

    }
}
