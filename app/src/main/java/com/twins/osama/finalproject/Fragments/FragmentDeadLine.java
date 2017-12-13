package com.twins.osama.finalproject.Fragments;

import android.os.Bundle;
import android.os.StrictMode;
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
import com.twins.osama.finalproject.Adapters.DeadLineAdapter;
import com.twins.osama.finalproject.Classes.RVDeadline;
import com.twins.osama.finalproject.Helpar.SharedPrefUtil;
import com.twins.osama.finalproject.Helpar.Util;
import com.twins.osama.finalproject.MyRelam.RealmController;
import com.twins.osama.finalproject.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

import io.realm.Realm;

import static com.twins.osama.finalproject.Helpar.Const.USER_RCN_LOGIN;

/**
 */
public class FragmentDeadLine extends Fragment {
    private ArrayList<RVDeadline> data;
    private FirebaseDatabase database;
    private SharedPrefUtil sharedPrefUtil;
    private String userRcnLogin;
    private Realm realm;
    private ArrayList<RVDeadline> rvDeadlines = new ArrayList<>();
    private LinearLayout cuView;
    private RecyclerView recyclerView;
    private DeadLineAdapter rvadapter;

    public static FragmentDeadLine newInstance() {
        FragmentDeadLine fragment = new FragmentDeadLine();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        this.realm = RealmController.with(getActivity()).getRealm();
//        Realm.init(getActivity());
//        realm = Realm.getDefaultInstance();
        View view = inflater.inflate(R.layout.fragment_dead_line, container, false);
        cuView = view.findViewById(R.id.linearLayout);
        database = FirebaseDatabase.getInstance();
        sharedPrefUtil = new SharedPrefUtil(getActivity());
        userRcnLogin = sharedPrefUtil.getString(USER_RCN_LOGIN);
        recyclerView = (RecyclerView) view.findViewById(R.id.rv_deadline);
        rvadapter = new DeadLineAdapter(getActivity(), rvDeadlines);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(rvadapter);
        Log.i("userRcnLogin", userRcnLogin);

        if (Util.hasActiveInternetConnection(getActivity())) {
            final Query patient = database.getReference().child("BooKApp").child(userRcnLogin);
            if (patient != null) {
                patient.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.i("patient", dataSnapshot.getValue().toString());
//                Log.i("getKeyPatient", dataSnapshot.getKey());
//                Log.i("getRef", dataSnapshot.getRef().toString());
//                JSONObject jsonObject = new JSONObject((Map) dataSnapshot.getValue());
//                Log.i("jsonObject  ", jsonObject.toString());

                        if (dataSnapshot.exists()) {
//                                JSONObject dt1 = new JSONObject((Map) dataSnapshot.getValue());
//                            RealmController.with(getActivity()).putDeadlineList(dt1);

                            for (DataSnapshot data : dataSnapshot.getChildren()) {
                                JSONObject dt = new JSONObject((Map) data.getValue());


                                Log.i("getKey  ", data.getKey());

//                                RealmController.with(getActivity()).putDeadlineList(dt);
//                                rvDeadlines= RealmController.with(getActivity()).getDeadlineList();
//                                rvadapter.notifyDataSetChanged();
//                                String ApId = dt.optString("ApId");
//                                Log.i("ApId  ", ApId);
//
//                                realm.beginTransaction();
//                                RealmResults<RVDeadline> result = realm.where(RVDeadline.class).findAll();
//                                if (!(result.isEmpty())) {
//                                    result.deleteAllFromRealm();
//                                    realm.commitTransaction();
//                                } else realm.cancelTransaction();
//
                                String Resone = dt.optString("note");
                                String Date = dt.optString("date");
                                String houer = dt.optString("clock");
                                int ApId = dt.optInt("ApId");

                                Log.i("Resone  ", Resone);
                                Log.i("Date  ", Date);
                                Log.i("houer  ", houer);

                                RVDeadline pData = new RVDeadline(Resone, ApId,Date, houer);
                                rvDeadlines.add(pData);
                            }
                                for (RVDeadline b : rvDeadlines) {
                                    realm.beginTransaction();
                                    realm.copyToRealmOrUpdate(b);
                                    realm.commitTransaction();
                                }
                                rvadapter = new DeadLineAdapter(getActivity(), rvDeadlines);
                                recyclerView.setAdapter(rvadapter);
                                rvadapter.notifyDataSetChanged();
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

           rvDeadlines= RealmController.with(getActivity()).getDeadlineList();
           if(rvDeadlines!=null&&rvDeadlines.size()!=0&&!(rvDeadlines.isEmpty()))
               rvadapter = new DeadLineAdapter(getActivity(), rvDeadlines);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            recyclerView.setAdapter(rvadapter);
            rvadapter.notifyDataSetChanged();
        }
        return view;
    }
}