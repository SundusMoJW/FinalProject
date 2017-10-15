package com.twins.osama.finalproject.Classes;

/**
 * Created by osama on 19/9/2017.
 */

public class RvLabs {
    public String nameLabe;
    public String DateLab;
    public String resultLab;

    public RvLabs(String nameLabe, String dateLab, String resultLab) {
        this.nameLabe = nameLabe;
        DateLab = dateLab;
        this.resultLab = resultLab;
    }

    public String getNameLabe() {
        return nameLabe;
    }

    public void setNameLabe(String nameLabe) {
        this.nameLabe = nameLabe;
    }

    public String getDateLab() {
        return DateLab;
    }

    public void setDateLab(String dateLab) {
        DateLab = dateLab;
    }

    public String getResultLab() {
        return resultLab;
    }

    public void setResultLab(String resultLab) {
        this.resultLab = resultLab;
    }
}

