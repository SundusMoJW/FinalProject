package com.twins.osama.finalproject.Fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.twins.osama.finalproject.Helpar.Util;
import com.twins.osama.finalproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {
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
    public InfoFragment() {
        // Required empty public constructor
    }


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Util.setLangSettings(getActivity());
        View view = inflater.inflate(R.layout.fragment_info, container, false);
        findViews(view);
//        final WebView mWebView = (WebView) view.findViewById(R.id.webview);
        select1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                webview.loadUrl("file:///android_asset/index1.html");
                webview.getSettings().setJavaScriptEnabled(true);
                webview.getSettings().setSaveFormData(true);
                webview.getSettings().setBuiltInZoomControls(true);
                webview.setWebViewClient(new Util.MyWebViewClient());
            }
        });
        select2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                webview2.loadUrl("file:///android_asset/index1.html");
                webview2.getSettings().setJavaScriptEnabled(true);
                webview2.getSettings().setSaveFormData(true);
                webview2.getSettings().setBuiltInZoomControls(true);
                webview2.setWebViewClient(new Util.MyWebViewClient());
            }
        });
        select3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                webview3.loadUrl("file:///android_asset/index1.html");
                webview3.getSettings().setJavaScriptEnabled(true);
                webview3.getSettings().setSaveFormData(true);
                webview3.getSettings().setBuiltInZoomControls(true);
                webview3.setWebViewClient(new Util.MyWebViewClient());
            }
        });
        select4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                webview4.loadUrl("file:///android_asset/index1.html");
                webview4.getSettings().setJavaScriptEnabled(true);
                webview4.getSettings().setSaveFormData(true);
                webview4.getSettings().setBuiltInZoomControls(true);
                webview4.setWebViewClient(new Util.MyWebViewClient());
            }
        });
        select5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
                webview5.loadUrl("file:///android_asset/index1.html");
                webview5.getSettings().setJavaScriptEnabled(true);
                webview5.getSettings().setSaveFormData(true);
                webview5.getSettings().setBuiltInZoomControls(true);
                webview5.setWebViewClient(new Util.MyWebViewClient());

            }
        });
        return view;
    }

    private void findViews(View view) {
        select1 = (LinearLayout) view.findViewById(R.id.select1);
        arrowUpStep1 = (ImageView) view.findViewById(R.id.arrow_up_step1);
        arrowDownStep1 = (ImageView) view.findViewById(R.id.arrow_down_step1);
        webview = (WebView) view.findViewById(R.id.webview);
        select2 = (LinearLayout) view.findViewById(R.id.select2);
        arrowUpStep2 = (ImageView) view.findViewById(R.id.arrow_up_step2);
        arrowDownStep2 = (ImageView) view.findViewById(R.id.arrow_down_step2);
        webview2 = (WebView) view.findViewById(R.id.webview2);
        select3 = (LinearLayout) view.findViewById(R.id.select3);
        arrowUpStep3 = (ImageView) view.findViewById(R.id.arrow_up_step3);
        arrowDownStep3 = (ImageView) view.findViewById(R.id.arrow_down_step3);
        webview3 = (WebView) view.findViewById(R.id.webview3);
        select4 = (LinearLayout) view.findViewById(R.id.select4);
        arrowUpStep4 = (ImageView) view.findViewById(R.id.arrow_up_step4);
        arrowDownStep4 = (ImageView) view.findViewById(R.id.arrow_down_step4);
        webview4 = (WebView) view.findViewById(R.id.webview4);
        select5 = (LinearLayout) view.findViewById(R.id.select5);
        arrowUpStep5 = (ImageView) view.findViewById(R.id.arrow_up_step5);
        arrowDownStep5 = (ImageView) view.findViewById(R.id.arrow_down_step5);
        webview5 = (WebView) view.findViewById(R.id.webview5);
    }
}
