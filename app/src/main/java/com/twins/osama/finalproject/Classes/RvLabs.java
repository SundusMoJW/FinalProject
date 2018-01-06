package com.twins.osama.finalproject.Classes;

import io.realm.RealmObject;
import io.realm.annotations.RealmClass;

/**
 * Created by osama on 19/9/2017.
 */
@RealmClass
public class RvLabs extends RealmObject {
    private String Name_Test;
    private String Request_By;
    private String Result_Date;
    private String Test_Result;
    private boolean isResult;
    private String Result_By;

    public RvLabs() {
    }

    public RvLabs(String name_Test, String request_By,  String Result_By, String result_Date, String test_Result, boolean isResult) {
        Name_Test = name_Test;
        Request_By = request_By;
        Result_Date = result_Date;
        Test_Result = test_Result;
        this.isResult = isResult;
        this.Result_By=Result_By;
    }

    public String getName_Test() {
        return Name_Test;
    }

    public String getResult_By() {
        return Result_By;
    }

    public void setResult_By(String result_By) {
        Result_By = result_By;
    }

    public void setName_Test(String name_Test) {
        Name_Test = name_Test;
    }

    public String getRequest_By() {
        return Request_By;
    }

    public void setRequest_By(String request_By) {
        Request_By = request_By;
    }

    public String getResult_Date() {
        return Result_Date;
    }

    public void setResult_Date(String result_Date) {
        Result_Date = result_Date;
    }

    public String getTest_Result() {
        return Test_Result;
    }

    public void setTest_Result(String test_Result) {
        Test_Result = test_Result;
    }

    public boolean isResult() {
        return isResult;
    }

    public void setResult(boolean result) {
        isResult = result;
    }
}

