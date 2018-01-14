package com.twins.osama.finalproject.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.twins.osama.finalproject.Helpar.Util;
import com.twins.osama.finalproject.R;

public class sugarInfoActivity extends AppCompatActivity {
    private LinearLayout select1;
    private ImageView arrowUpStep1;
    private ImageView arrowDownStep1;
    private WebView webview;
    private LinearLayout select2;
    private ImageView arrowUpStep2;
    private ImageView arrowDownStep2;
    private WebView webview2;
    private LinearLayout select3;
    private ImageView arrowUpStep3;
    private ImageView arrowDownStep3;
    private WebView webview3;
    private LinearLayout select4;
    private ImageView arrowUpStep4;
    private ImageView arrowDownStep4;
    private WebView webview4;
    private LinearLayout select5;
    private ImageView arrowUpStep5;
    private ImageView arrowDownStep5;
    private WebView webview5;
    private WebView mWebView;
    private ImageView menu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar_info);
        findViews();
        webview.setVisibility(View.GONE);
        menu = (ImageView) findViewById(R.id.menu);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(sugarInfoActivity.this, SettingActivity.class));
            }
        });
        select1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webview.getVisibility() == View.GONE) {
                    arrowUpStep1.setVisibility(View.GONE);
                    arrowUpStep2.setVisibility(View.VISIBLE);
                    arrowUpStep3.setVisibility(View.VISIBLE);
                    arrowUpStep4.setVisibility(View.VISIBLE);
                    arrowUpStep5.setVisibility(View.VISIBLE);
                    arrowDownStep1.setVisibility(View.VISIBLE);
                    arrowDownStep2.setVisibility(View.GONE);
                    arrowDownStep3.setVisibility(View.GONE);
                    arrowDownStep4.setVisibility(View.GONE);
                    arrowDownStep5.setVisibility(View.GONE);
                    webview.setVisibility(View.VISIBLE);
                    webview2.setVisibility(View.GONE);
                    webview3.setVisibility(View.GONE);
                    webview4.setVisibility(View.GONE);
                    webview5.setVisibility(View.GONE);
                    webview.loadUrl("file:///android_asset/temp1.html");
                    webview.getSettings().setJavaScriptEnabled(true);
                    webview.getSettings().setSaveFormData(true);
                    webview.getSettings().setBuiltInZoomControls(true);
                    webview.setWebViewClient(new Util.MyWebViewClient());
                } else {
                    arrowUpStep1.setVisibility(View.VISIBLE);
                    arrowDownStep1.setVisibility(View.GONE);
                    webview.setVisibility(View.GONE);
                    webview2.setVisibility(View.GONE);
                    webview3.setVisibility(View.GONE);
                    webview4.setVisibility(View.GONE);
                    webview5.setVisibility(View.GONE);
                }
            }
        });
        select2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webview2.getVisibility() == View.GONE) {
                    arrowUpStep1.setVisibility(View.VISIBLE);
                    arrowUpStep2.setVisibility(View.GONE);
                    arrowUpStep3.setVisibility(View.VISIBLE);
                    arrowUpStep4.setVisibility(View.VISIBLE);
                    arrowUpStep5.setVisibility(View.VISIBLE);
                    arrowDownStep1.setVisibility(View.GONE);
                    arrowDownStep2.setVisibility(View.VISIBLE);
                    arrowDownStep3.setVisibility(View.GONE);
                    arrowDownStep4.setVisibility(View.GONE);
                    arrowDownStep5.setVisibility(View.GONE);
                    webview.setVisibility(View.GONE);
                    webview2.setVisibility(View.VISIBLE);
                    webview3.setVisibility(View.GONE);
                    webview4.setVisibility(View.GONE);
                    webview5.setVisibility(View.GONE);
                    webview2.loadUrl("file:///android_asset/template.html");
                    webview2.getSettings().setJavaScriptEnabled(true);
                    webview2.getSettings().setSaveFormData(true);
                    webview2.getSettings().setBuiltInZoomControls(true);
                    webview2.setWebViewClient(new Util.MyWebViewClient());
                } else {
                    arrowUpStep2.setVisibility(View.VISIBLE);
                    arrowDownStep2.setVisibility(View.GONE);
                    webview.setVisibility(View.GONE);
                    webview2.setVisibility(View.GONE);
                    webview3.setVisibility(View.GONE);
                    webview4.setVisibility(View.GONE);
                    webview5.setVisibility(View.GONE);
                }
            }
        });
        select3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webview3.getVisibility() == View.GONE) {
                    arrowUpStep1.setVisibility(View.VISIBLE);
                    arrowUpStep2.setVisibility(View.VISIBLE);
                    arrowUpStep3.setVisibility(View.GONE);
                    arrowUpStep4.setVisibility(View.VISIBLE);
                    arrowUpStep5.setVisibility(View.VISIBLE);
                    arrowDownStep1.setVisibility(View.GONE);
                    arrowDownStep2.setVisibility(View.GONE);
                    arrowDownStep3.setVisibility(View.VISIBLE);
                    arrowDownStep4.setVisibility(View.GONE);
                    arrowDownStep5.setVisibility(View.GONE);
                    webview.setVisibility(View.GONE);
                    webview2.setVisibility(View.GONE);
                    webview3.setVisibility(View.VISIBLE);
                    webview4.setVisibility(View.GONE);
                    webview5.setVisibility(View.GONE);
                    webview3.loadUrl("file:///android_asset/templat3.html");
                    webview3.getSettings().setJavaScriptEnabled(true);
                    webview3.getSettings().setSaveFormData(true);
                    webview3.getSettings().setBuiltInZoomControls(true);
                    webview3.setWebViewClient(new Util.MyWebViewClient());
                } else {
                    arrowUpStep3.setVisibility(View.VISIBLE);
                    arrowDownStep3.setVisibility(View.GONE);
                    webview.setVisibility(View.GONE);
                    webview2.setVisibility(View.GONE);
                    webview3.setVisibility(View.GONE);
                    webview4.setVisibility(View.GONE);
                    webview5.setVisibility(View.GONE);
                }
            }
        });
        select4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (webview4.getVisibility() == View.GONE) {
                    arrowUpStep1.setVisibility(View.VISIBLE);
                arrowUpStep2.setVisibility(View.VISIBLE);
                arrowUpStep3.setVisibility(View.VISIBLE);
                arrowUpStep4.setVisibility(View.GONE);
                arrowUpStep5.setVisibility(View.VISIBLE);
                arrowDownStep1.setVisibility(View.GONE);
                arrowDownStep2.setVisibility(View.GONE);
                arrowDownStep3.setVisibility(View.GONE);
                arrowDownStep4.setVisibility(View.VISIBLE);
                arrowDownStep5.setVisibility(View.GONE);
                webview.setVisibility(View.GONE);
                webview2.setVisibility(View.GONE);
                webview3.setVisibility(View.GONE);
                webview4.setVisibility(View.VISIBLE);
                webview5.setVisibility(View.GONE);
                webview4.loadUrl("file:///android_asset/temp4.html");
                webview4.getSettings().setJavaScriptEnabled(true);
                webview4.getSettings().setSaveFormData(true);
                webview4.getSettings().setBuiltInZoomControls(true);
                webview4.setWebViewClient(new Util.MyWebViewClient());
                } else {
                    arrowUpStep4.setVisibility(View.VISIBLE);
                    arrowDownStep4.setVisibility(View.GONE);
                    webview.setVisibility(View.GONE);
                    webview2.setVisibility(View.GONE);
                    webview3.setVisibility(View.GONE);
                    webview4.setVisibility(View.GONE);
                    webview5.setVisibility(View.GONE);
                }
            }
        });
        select5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    if (webview5.getVisibility() == View.GONE) {
                arrowUpStep1.setVisibility(View.GONE);
                arrowDownStep1.setVisibility(View.VISIBLE);
                arrowUpStep2.setVisibility(View.VISIBLE);
                arrowUpStep3.setVisibility(View.VISIBLE);
                arrowUpStep4.setVisibility(View.VISIBLE);
                arrowUpStep5.setVisibility(View.VISIBLE);
                arrowDownStep2.setVisibility(View.GONE);
                arrowDownStep3.setVisibility(View.GONE);
                arrowDownStep4.setVisibility(View.GONE);
                arrowDownStep5.setVisibility(View.GONE);
                webview.setVisibility(View.GONE);
                webview2.setVisibility(View.GONE);
                webview3.setVisibility(View.GONE);
                webview4.setVisibility(View.GONE);
                webview5.setVisibility(View.VISIBLE);
                webview5.loadUrl("file:///android_asset/templat2.html");
                webview5.getSettings().setJavaScriptEnabled(true);
                webview5.getSettings().setSaveFormData(true);
                webview5.getSettings().setBuiltInZoomControls(true);
                webview5.setWebViewClient(new Util.MyWebViewClient());
                    } else {
                        arrowUpStep5.setVisibility(View.VISIBLE);
                        arrowDownStep5.setVisibility(View.GONE);
                        webview.setVisibility(View.GONE);
                        webview2.setVisibility(View.GONE);
                        webview3.setVisibility(View.GONE);
                        webview4.setVisibility(View.GONE);
                        webview5.setVisibility(View.GONE);
                    }
            }
        });
    }

    private void findViews() {
        select1 = (LinearLayout) findViewById(R.id.select1);
        arrowUpStep1 = (ImageView) findViewById(R.id.arrow_up_step1);
        arrowDownStep1 = (ImageView) findViewById(R.id.arrow_down_step1);
        webview = (WebView) findViewById(R.id.webview);
        select2 = (LinearLayout) findViewById(R.id.select2);
        arrowUpStep2 = (ImageView) findViewById(R.id.arrow_up_step2);
        arrowDownStep2 = (ImageView) findViewById(R.id.arrow_down_step2);
        webview2 = (WebView) findViewById(R.id.webview2);
        select3 = (LinearLayout) findViewById(R.id.select3);
        arrowUpStep3 = (ImageView) findViewById(R.id.arrow_up_step3);
        arrowDownStep3 = (ImageView) findViewById(R.id.arrow_down_step3);
        webview3 = (WebView) findViewById(R.id.webview3);
        select4 = (LinearLayout) findViewById(R.id.select4);
        arrowUpStep4 = (ImageView) findViewById(R.id.arrow_up_step4);
        arrowDownStep4 = (ImageView) findViewById(R.id.arrow_down_step4);
        webview4 = (WebView) findViewById(R.id.webview4);
        select5 = (LinearLayout) findViewById(R.id.select5);
        arrowUpStep5 = (ImageView) findViewById(R.id.arrow_up_step5);
        arrowDownStep5 = (ImageView) findViewById(R.id.arrow_down_step5);
        webview5 = (WebView) findViewById(R.id.webview5);
    }
}
