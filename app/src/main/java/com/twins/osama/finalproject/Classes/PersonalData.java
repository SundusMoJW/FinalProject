package com.twins.osama.finalproject.Classes;

import io.realm.RealmObject;

/**
 * Created by Osama on 9/19/2017.
 */

public class PersonalData extends RealmObject {
    private String RCN_NO;
    private String RrisFamilyId;
    private String Team;
    private String BloodType;
    private String Name;
    private String Address;
    private String Key;

    public PersonalData() {
    }

    public PersonalData(String RCN_NO, String rrisFamilyId, String team, String bloodType, String name, String address, String key) {
        this.RCN_NO = RCN_NO;
        RrisFamilyId = rrisFamilyId;
        Team = team;
        BloodType = bloodType;
        Name = name;
        Address = address;
        Key = key;
    }

    public String getRCN_NO() {
        return RCN_NO;
    }

    public void setRCN_NO(String RCN_NO) {
        this.RCN_NO = RCN_NO;
    }

    public String getRrisFamilyId() {
        return RrisFamilyId;
    }

    public void setRrisFamilyId(String rrisFamilyId) {
        RrisFamilyId = rrisFamilyId;
    }

    public String getTeam() {
        return Team;
    }

    public void setTeam(String team) {
        Team = team;
    }

    public String getBloodType() {
        return BloodType;
    }

    public void setBloodType(String bloodType) {
        BloodType = bloodType;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }
}
