package com.twins.osama.finalproject.Fragments;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.twins.osama.finalproject.Adapters.PharmAdapter;
import com.twins.osama.finalproject.Classes.Pharm;
import com.twins.osama.finalproject.Classes.ToAccessPharmAdapter;
import com.twins.osama.finalproject.Helpar.SharedPrefUtil;
import com.twins.osama.finalproject.Helpar.Util;
import com.twins.osama.finalproject.MyRelam.RealmController;
import com.twins.osama.finalproject.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.realm.Realm;
import io.realm.RealmList;

import static com.twins.osama.finalproject.Helpar.Const.USER_RCN_LOGIN;

/**
 * A simple {@link Fragment} subclass.
 */
public class PharmFragment extends Fragment {
    private List<ToAccessPharmAdapter> arrToAccessPharmAdapters = new ArrayList<>();
    private PharmAdapter rvadapter;
    private RealmList<Pharm> arrPharms = new RealmList<>();
    private String timeSpend;
    private FirebaseDatabase database;
    private LinearLayout cuView;
    private SharedPrefUtil sharedPrefUtil;
    private String userRcnLogin;
    private Realm realm;
    private String newtimeSpend;

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Realm.init(getActivity());
        realm = Realm.getDefaultInstance();
        final View view = inflater.inflate(R.layout.fragment_pharm, container, false);
        database = FirebaseDatabase.getInstance();
        cuView = view.findViewById(R.id.linearLayout);
        sharedPrefUtil = new SharedPrefUtil(getActivity());
        userRcnLogin = sharedPrefUtil.getString(USER_RCN_LOGIN);
//        data = fill_with_data();
        final RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_pharm);
        /*********/
        rvadapter = new PharmAdapter(getActivity(), arrToAccessPharmAdapters);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(rvadapter);
        if (Util.hasActiveInternetConnection(getActivity())) {
            final Query patient = database.getReference().child("AddPharmacy").child(userRcnLogin);
            if (patient != null) {
                patient.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.i("Pharmacy", dataSnapshot.getValue().toString());
//                Log.i("getKeyPharmacy", dataSnapshot.getKey());
//                Log.i("getRef", dataSnapshot.getRef().toString());
                        JSONObject jsonObject = new JSONObject((Map) dataSnapshot.getValue());
//                Log.i("jsonObject  ", jsonObject.toString());
                        if (dataSnapshot.exists()) {
//                    arrToAccessPharmAdapters=new ArrayList<>();
                            arrToAccessPharmAdapters.clear();
                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                Log.e("data  ", data.getValue().toString());
                                timeSpend = data.getKey() + "";
                                Long date = Long.parseLong(timeSpend);
                                newtimeSpend = Util.getDate(date);
                                arrPharms = new RealmList<>();
                                arrPharms.clear();
//                        Log.i("timeSpend  ", timeSpend);
//                        Log.i("AllData  ", data.toString());
//                        Log.i("dataPharmTimeSpend  ", data.getChildren() + "");
                                for (DataSnapshot dataPharm : data.getChildren()) {
                                    Log.e("dataPharm  ", dataPharm.getValue().toString());
                                    JSONObject dt = new JSONObject((Map) dataPharm.getValue());
                                    if (dt.optBoolean("check")) {
                                        Pharm pharm = new Pharm(dt.optString("Qty"), dt.optString("Drug"),
                                                dt.optString("RCN"), dt.optString("time"), dt.optBoolean("check"),
                                                dt.optString("key"),
                                                dt.optString("week"));
                                        arrPharms.add(pharm);
//                            Log.i("dataPharm  ", dataPharm + "");
//                            realm.beginTransaction();
//                            realm.createOrUpdateAllFromJson(Pharm.class, dt.toString());
//                            realm.commitTransaction();
                                    }
                                }
                                ToAccessPharmAdapter toAccessPharmAdapter = new ToAccessPharmAdapter(newtimeSpend, arrPharms);
                                arrToAccessPharmAdapters.add(toAccessPharmAdapter);
                            }
                            rvadapter = new PharmAdapter(getActivity(), arrToAccessPharmAdapters);
                            recyclerView.setAdapter(rvadapter);
                            rvadapter.notifyDataSetChanged();
                            for (ToAccessPharmAdapter b : arrToAccessPharmAdapters) {
                                realm.beginTransaction();
                                realm.copyToRealmOrUpdate(b);
                                realm.commitTransaction();
                            }
                        } else {
                            if (getView() != null)
                                Snackbar.make(cuView, getString(R.string.acc_not_found), Snackbar.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                    }
                });
            }
        } else {

            arrToAccessPharmAdapters = RealmController.with(getActivity()).getPharmList();
            if (arrToAccessPharmAdapters != null && arrToAccessPharmAdapters.size() != 0
                    && !(arrToAccessPharmAdapters.isEmpty()))
                rvadapter = new PharmAdapter(getActivity(), arrToAccessPharmAdapters);
            recyclerView.setAdapter(rvadapter);
            rvadapter.notifyDataSetChanged();
        }
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}

