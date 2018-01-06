package com.twins.osama.finalproject.Classes;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Osama on 12/22/2017.
 */
@RealmClass
public class GeneralLab extends RealmObject {
    @PrimaryKey
    private String ApIdlab;
    private String Date;

    public GeneralLab() {
    }

    public GeneralLab(String apIdlab, String date) {
        ApIdlab = apIdlab;
        Date = date;
    }

    public String getApIdlab() {
        return ApIdlab;
    }

    public void setApIdlab(String apIdlab) {
        ApIdlab = apIdlab;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
