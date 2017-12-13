package com.twins.osama.finalproject.Helpar;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;

/**
 * Created by Osama on 12/5/2017.
 */

public class Util {

    private static String LOG_TAG = "check internet ";

    public static String getDate(long time_stamp_server) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
        return formatter.format(time_stamp_server);
    }

    public static class MyWebViewClient extends WebViewClient {
        @Override
        //show the web page in webview but not in web browser
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }

    private static boolean isNetworkAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null;
    }

    public static boolean hasActiveInternetConnection(Context context) {
        if (isNetworkAvailable(context)) {
//            Integer downloadFilesTask=new DownloadFilesTask().doInBackground();
            HttpURLConnection urlc = null;
            try {
                urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());

                urlc.setRequestProperty("User-Agent", "Test");
                urlc.setRequestProperty("Connection", "close");
                urlc.setConnectTimeout(1500);
                urlc.connect();
                return (urlc.getResponseCode()== 200);
            } catch (IOException e) {
                e.printStackTrace();
            }
//            return (downloadFilesTask == 200);
        } else {
            Log.d(LOG_TAG, "No network available!");
            return false;
        }
        return false;
    }
 }
