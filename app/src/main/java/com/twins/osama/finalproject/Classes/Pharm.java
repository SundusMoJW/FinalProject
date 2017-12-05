package com.twins.osama.finalproject.Classes;

import io.realm.RealmObject;

/**
 * Created by Osama on 12/1/2017.
 */

public class Pharm  extends RealmObject {
    private String Qty;
    private String Drug;
    private String RCN;
    private String time;
    private String key;
    private String week;
    public Pharm(){}

    public Pharm(String qty, String drug, String RCN,
                 String time, String week,String key) {
        Qty = qty;
        Drug = drug;
        this.RCN = RCN;
        this.time = time;
        this.week = week;
        this.key=key;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getQty() {
        return Qty;
    }

    public void setQty(String qty) {
        Qty = qty;
    }

    public String getDrug() {
        return Drug;
    }

    public void setDrug(String drug) {
        Drug = drug;
    }

    public String getRCN() {
        return RCN;
    }

    public void setRCN(String RCN) {
        this.RCN = RCN;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
}
