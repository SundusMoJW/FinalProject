package com.twins.osama.finalproject.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twins.osama.finalproject.Activities.MainActivity;
import com.twins.osama.finalproject.Adapters.DeadLineAdapter;
import com.twins.osama.finalproject.Classes.RVDeadline;
import com.twins.osama.finalproject.R;

import java.util.ArrayList;

/**
 */
public class FragmentDeadLine extends Fragment {
    ArrayList<RVDeadline> data;


    public static FragmentDeadLine newInstance() {
        FragmentDeadLine fragment = new FragmentDeadLine();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dead_line, container, false);
        data = fill_with_data();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.rv_deadline);
        DeadLineAdapter rvadapter = new DeadLineAdapter((MainActivity)getActivity(), data);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(rvadapter);

        return view;

    }
    public ArrayList<RVDeadline> fill_with_data() {

        ArrayList<RVDeadline> data = new ArrayList<>();

        data.add(new RVDeadline("222","56468" ,"446"));
        data.add(new RVDeadline("222","56468" ,"446"));
        data.add(new RVDeadline("222","56468" ,"446"));
        data.add(new RVDeadline("222","56468" ,"446"));
        return data;
    }
}