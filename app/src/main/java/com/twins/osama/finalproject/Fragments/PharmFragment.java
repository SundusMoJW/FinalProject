package com.twins.osama.finalproject.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.twins.osama.finalproject.Adapters.PharmAdapter;
import com.twins.osama.finalproject.Classes.RvLabs;
import com.twins.osama.finalproject.R;

import java.util.ArrayList;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class PharmFragment extends Fragment {
    ArrayList<RvLabs> data;
    private FirebaseDatabase database;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pharm, container, false);
        database = FirebaseDatabase.getInstance();

//        data = fill_with_data();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_pharm);
        /*********/
        PharmAdapter rvadapter = new PharmAdapter(getActivity(), data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(rvadapter);
        final Query patient = database.getReference().child("BooKApp").child("12");
        patient.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Map<String, String> map = (Map<String, String>) dataSnapshot.getValue();
                Log.i("aaaa", "//" + map.toString());
                String uRCN = map.get("RCN");
                map.get("");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return view;

    }
}

