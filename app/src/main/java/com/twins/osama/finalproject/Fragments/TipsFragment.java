package com.twins.osama.finalproject.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twins.osama.finalproject.Activities.sugarInfoActivity;
import com.twins.osama.finalproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TipsFragment extends Fragment {

    private LinearLayout linearHeart;
    private LinearLayout linearHtn;
    private LinearLayout linearPregnant;
    private LinearLayout linearSugar;
    private TextView textView;
    public TipsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
                View view=inflater.inflate(R.layout.fragment_tips, container, false);
        findViews(view);
        linearSugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),sugarInfoActivity.class);
                startActivity(intent);
            }
        });
        linearHtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),sugarInfoActivity.class);
                startActivity(intent);
            }
        });
        linearPregnant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),sugarInfoActivity.class);
                startActivity(intent);
            }
        });
        linearHeart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getActivity(),sugarInfoActivity.class);
                startActivity(intent);

            }
        });


        return view;
    }

  
     private void findViews(View view) {
        linearHeart = (LinearLayout)view.findViewById( R.id.linear_heart );
        linearHtn = (LinearLayout)view.findViewById( R.id.linear_htn );
        linearPregnant = (LinearLayout)view.findViewById( R.id.linear_pregnant );
        linearSugar = (LinearLayout)view.findViewById( R.id.linear_sugar );
        textView = (TextView)view.findViewById( R.id.textView );
    }

}
