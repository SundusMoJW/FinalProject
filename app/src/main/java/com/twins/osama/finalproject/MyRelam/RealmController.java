package com.twins.osama.finalproject.MyRelam;

import android.app.Activity;
import android.app.Application;
import android.app.Fragment;

import com.twins.osama.finalproject.Classes.RVDeadline;
import com.twins.osama.finalproject.Classes.ToAccessPharmAdapter;

import org.json.JSONArray;

import java.util.ArrayList;

import io.realm.Realm;
import io.realm.RealmResults;

/**
 * Created by Osama on 8/26/2017.
 */

public class RealmController {


    private static RealmController instance;
    private final Realm realm;

    public RealmController(Application application) {
        realm = Realm.getDefaultInstance();
    }

    public static RealmController with(Fragment fragment) {

        if (instance == null) {
            instance = new RealmController(fragment.getActivity().getApplication());
        }
        return instance;
    }

    public static RealmController with(Activity activity) {

        if (instance == null) {
            instance = new RealmController(activity.getApplication());
        }
        return instance;
    }

    public static RealmController with(Application application) {

        if (instance == null) {
            instance = new RealmController(application);
        }
        return instance;
    }

    public static RealmController getInstance() {

        return instance;
    }

    public Realm getRealm() {

        return realm;
    }

    //Refresh the realm istance
    public void refresh() {

        realm.refresh();
    }

    public void putDeadlineList(JSONArray jsonObject) {
        realm.beginTransaction();
        realm.createOrUpdateAllFromJson(RVDeadline.class, jsonObject);
        realm.commitTransaction();
    }

    public ArrayList<RVDeadline> getDeadlineList() {
        RealmResults<RVDeadline> rvDeadlines = realm.where(RVDeadline.class).findAll();
        return (ArrayList<RVDeadline>) realm.copyFromRealm(rvDeadlines);
    }
    public ArrayList<ToAccessPharmAdapter> getPharmList() {
        RealmResults<ToAccessPharmAdapter> toAccessPharmAdapters = realm.where(ToAccessPharmAdapter.class).findAll();
        return (ArrayList<ToAccessPharmAdapter>) realm.copyFromRealm(toAccessPharmAdapters);
    }
}

//
//    public void putMarketList(JSONArray marketList) {
//        realm.beginTransaction();
//        realm.createOrUpdateAllFromJson(Market.class, marketList);
//        realm.commitTransaction();
//    }
//
//    public void putTypeList(JSONArray typeList) {
//        realm.beginTransaction();
//        realm.createOrUpdateAllFromJson(TypeList.class, typeList);
//        realm.commitTransaction();
//    }
//
//    public void putSliderImage(JSONArray sliderImage) {
//        realm.beginTransaction();
//        realm.createOrUpdateAllFromJson(Slider.class, sliderImage);
//        realm.commitTransaction();
//    }
//    public RealmResults<CartItem> getCartItems() {
//        return realm.where(CartItem.class).findAll();
//    }
//
//    public CartItem cheackCartItem(int id,int idTypeList) {
//        return realm.where(CartItem.class).equalTo("Id",id).equalTo("IdTypeList",idTypeList).findFirst();
//    }
//
//    public void putInCartItem(CartItem cartItem){
//        realm.beginTransaction();
//        realm.copyToRealm(cartItem);
//        realm.commitTransaction();
//    }
//    public void getMarketAdditionsAPI(){}
//}
