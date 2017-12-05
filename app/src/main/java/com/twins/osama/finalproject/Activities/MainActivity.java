package com.twins.osama.finalproject.Activities;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.google.firebase.database.FirebaseDatabase;
import com.twins.osama.finalproject.Adapters.TabsPagerAdapter;
import com.twins.osama.finalproject.Fragments.FragmentDeadLine;
import com.twins.osama.finalproject.Fragments.LabsFragment;
import com.twins.osama.finalproject.Fragments.PersonalDataFragment;
import com.twins.osama.finalproject.Fragments.PharmFragment;
import com.twins.osama.finalproject.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private FirebaseDatabase database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        database = FirebaseDatabase.getInstance();
        Log.d("$$$", database.getReference().child("AddPatient").getKey());

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

    }

    private void setupViewPager(ViewPager viewPager) {
        TabsPagerAdapter adapter = new TabsPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new PersonalDataFragment(), getResources().getString(R.string.Personal_data));
        adapter.addFragment(new FragmentDeadLine(), getResources().getString(R.string.Deadlines));
        adapter.addFragment(new LabsFragment(), getResources().getString(R.string.Labs));
        adapter.addFragment(new PharmFragment(), getResources().getString(R.string.Pharm));


        viewPager.setAdapter(adapter);
    }

}
