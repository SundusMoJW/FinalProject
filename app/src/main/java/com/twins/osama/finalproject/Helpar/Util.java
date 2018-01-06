package com.twins.osama.finalproject.Helpar;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.twins.osama.finalproject.R;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Locale;

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

    public static void setLangSettings(Activity activity) {
        SharedPrefUtil sharedPrefUtil = new SharedPrefUtil(activity);
        Resources res = activity.getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        android.content.res.Configuration conf = res.getConfiguration();
        if (TextUtils.isEmpty(sharedPrefUtil.getString(Const.LANG))) {
            if (res.getConfiguration().locale.getDisplayLanguage().equalsIgnoreCase(res.getString(R.string.Arabic))) {

                sharedPrefUtil.saveString(Const.LANG, "Arabic");
            } else {
                sharedPrefUtil.saveString(Const.LANG, "English");
            }
        } else {
            conf.locale = new Locale(sharedPrefUtil.getString(Const.LANG).substring(0, 2)
                    .toLowerCase());
        }
        res.updateConfiguration(conf, dm);
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
