package com.twins.osama.finalproject.Classes;

import java.util.List;

/**
 * Created by Osama on 12/5/2017.
 */

public class ToAccessPharmAdapter {
    private String Key;
private List<Pharm>pharms;

    public ToAccessPharmAdapter(String key, List<Pharm> pharms) {
        Key = key;
        this.pharms = pharms;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public List<Pharm> getPharms() {
        return pharms;
    }

    public void setPharms(List<Pharm> pharms) {
        this.pharms = pharms;
    }
}
