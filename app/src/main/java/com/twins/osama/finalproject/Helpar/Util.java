package com.twins.osama.finalproject.Helpar;

import java.text.SimpleDateFormat;

/**
 * Created by Osama on 12/5/2017.
 */

public class Util {

    public static String getDate(long time_stamp_server) {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
            return formatter.format(time_stamp_server);
        }
}
