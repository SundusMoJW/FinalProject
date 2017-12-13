package com.twins.osama.finalproject.Classes;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by osama on 19/9/2017.
 */

public class RVDeadline extends RealmObject {
    private   String Resone;
    @PrimaryKey
    private int ApId;
    private String Date;
    private String houer;
    public RVDeadline(){}

    public RVDeadline(String resone, int apId, String date, String houer) {
        Resone = resone;
        ApId = apId;
        Date = date;
        this.houer = houer;
    }

    public String getResone() {
        return Resone;
    }

    public void setResone(String resone) {
        Resone = resone;
    }

    public int getApId() {
        return ApId;
    }

    public void setApId(int apId) {
        ApId = apId;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getHouer() {
        return houer;
    }

    public void setHouer(String houer) {
        this.houer = houer;
    }
}
