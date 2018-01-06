package com.twins.osama.finalproject.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twins.osama.finalproject.Adapters.LabAdapter;
import com.twins.osama.finalproject.Classes.RvLabs;
import com.twins.osama.finalproject.Helpar.Util;
import com.twins.osama.finalproject.MyRelam.RealmController;
import com.twins.osama.finalproject.R;

import java.util.ArrayList;


public class LabsFragment extends Fragment {
    ArrayList<RvLabs> data;
    private ArrayList<RvLabs> labsArrayList=new ArrayList<>();
    private LabAdapter rvadapter;

    public static LabsFragment newInstance() {
        LabsFragment fragment = new LabsFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Util.setLangSettings(getActivity());
        View view = inflater.inflate(R.layout.fragment_labs, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_labss);
//        LabAdapter rvadapter = new LabAdapter(getActivity(), data);


        labsArrayList = RealmController.with(getActivity()).getLabList();
        Log.e("labsArrayList", labsArrayList.size() + "");
        if (labsArrayList != null && labsArrayList.size() != 0
                && !(labsArrayList.isEmpty())){
            rvadapter = new LabAdapter(getActivity(), labsArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(rvadapter);}
        return view;

    }

}