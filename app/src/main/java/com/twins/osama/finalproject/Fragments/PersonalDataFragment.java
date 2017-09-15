package com.twins.osama.finalproject.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.twins.osama.finalproject.R;


public class PersonalDataFragment extends Fragment {
    public static PersonalDataFragment newInstance() {
        PersonalDataFragment fragment = new PersonalDataFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_data, container, false);

        return view;

    }
}