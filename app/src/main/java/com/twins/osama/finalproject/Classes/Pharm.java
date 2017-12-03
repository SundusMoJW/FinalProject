package com.twins.osama.finalproject.Classes;

import java.util.List;

/**
 * Created by Osama on 12/1/2017.
 */

public class Pharm {
    private String month;
    private List<String> drug;

    public Pharm(String month, List<String> drug) {
        this.month = month;
        this.drug = drug;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public List<String> getDrug() {
        return drug;
    }

    public void setDrug(List<String> drug) {
        this.drug = drug;
    }
}
