package com.twins.osama.finalproject.Fragments;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.twins.osama.finalproject.Helpar.Util;
import com.twins.osama.finalproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InfoFragment extends Fragment {


    public InfoFragment() {
        // Required empty public constructor
    }


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_info, container, false);

        WebView mWebView=(WebView)view.findViewById(R.id.webview);

        mWebView.loadUrl("file:///android_asset/baby.html");
        mWebView.getSettings().setJavaScriptEnabled(true);
//        mWebView.loadDataWithBaseURL("file:///android_asset/baby.html",null,"text/html", "UTF-8", null);
        mWebView.getSettings().setSaveFormData(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new Util.MyWebViewClient());

        return view;
    }

}
