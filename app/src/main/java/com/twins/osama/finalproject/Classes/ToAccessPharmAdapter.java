package com.twins.osama.finalproject.Classes;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * Created by Osama on 12/5/2017.
 */
@RealmClass
public class ToAccessPharmAdapter extends RealmObject {
    @PrimaryKey
    private String Key;
    private RealmList<Pharm> pharms;

    public ToAccessPharmAdapter() {
    }

    public ToAccessPharmAdapter(String key, RealmList<Pharm> pharms) {
        Key = key;
        this.pharms = pharms;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public RealmList<Pharm> getPharms() {
        return pharms;
    }

    public void setPharms(RealmList<Pharm> pharms) {
        this.pharms = pharms;
    }
}
