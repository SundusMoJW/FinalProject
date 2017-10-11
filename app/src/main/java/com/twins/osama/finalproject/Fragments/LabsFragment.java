package com.twins.osama.finalproject.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twins.osama.finalproject.Activities.MainActivity;
import com.twins.osama.finalproject.Adapters.LabAdapter;
import com.twins.osama.finalproject.Class.RvLabs;
import com.twins.osama.finalproject.R;

import java.util.ArrayList;


public class LabsFragment extends Fragment {
    ArrayList<RvLabs> data;


    public static LabsFragment newInstance() {
        LabsFragment fragment = new LabsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_labs, container, false);
        data = fill_with_data();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rv_labss);
       LabAdapter rvadapter = new LabAdapter((MainActivity)getActivity(), data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(rvadapter);

        return view;

    }
    public ArrayList<RvLabs> fill_with_data() {

        ArrayList<RvLabs> data = new ArrayList<>();

        data.add(new RvLabs("222","56468" ,"446"));
        data.add(new RvLabs("222","56468" ,"446"));
        data.add(new RvLabs("222","56468" ,"446"));
        data.add(new RvLabs("222","56468" ,"446"));
        return data;
    }
}