package com.twins.osama.finalproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;

import com.twins.osama.finalproject.Helpar.Util;
import com.twins.osama.finalproject.R;

public class PregnantActivity extends AppCompatActivity {
    private ImageView menu;
    private WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregnant);
        menu = (ImageView) findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(PregnantActivity.this, SettingActivity.class));
            }
        });
        webview = (WebView) findViewById(R.id.webview);
        webview.loadUrl("file:///android_asset/temp7.html");
        webview.getSettings().setJavaScriptEnabled(true);
        webview.getSettings().setSaveFormData(true);
        webview.getSettings().setBuiltInZoomControls(true);
        webview.setWebViewClient(new Util.MyWebViewClient());
    }
}
