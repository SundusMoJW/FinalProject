package com.twins.osama.finalproject.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.twins.osama.finalproject.Adapters.PharmAdapter;
import com.twins.osama.finalproject.Classes.PersonalData;
import com.twins.osama.finalproject.Classes.Pharm;
import com.twins.osama.finalproject.Classes.RVDeadline;
import com.twins.osama.finalproject.Classes.ToAccessPharmAdapter;
import com.twins.osama.finalproject.Helpar.SharedPrefUtil;
import com.twins.osama.finalproject.Helpar.Util;
import com.twins.osama.finalproject.R;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.hdodenhof.circleimageview.CircleImageView;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;

import static com.twins.osama.finalproject.Helpar.Const.USER_RCN_LOGIN;


public class PersonalDataFragment extends Fragment {
    private TextView peronalName;
    private TextView tvaddress;
    private CircleImageView circleView;
    private TextView pluse;
    private TextView rcnUser;
    private TextView rrsnIdUser;
    private TextView teamUser;
    private FirebaseDatabase database;
    private TextView bloodTypeUser;
    private List<ToAccessPharmAdapter> arrToAccessPharmAdapters = new ArrayList<>();
    private PharmAdapter rvadapter;
    private RealmList<Pharm> arrPharms = new RealmList<>();
    private String timeSpend;
    private Realm realm;
    private String newtimeSpend;
    private RealmResults<PersonalData> realmPersonalDataResults;
    private ArrayList<PersonalData> pDataArray;
    private String userRcnLogin;
    private SharedPrefUtil sharedPrefUtil;
    private ArrayList<RVDeadline> rvDeadlines = new ArrayList<>();

    public static PersonalDataFragment newInstance() {
        PersonalDataFragment fragment = new PersonalDataFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(getActivity());
        realm = Realm.getDefaultInstance();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_data, container, false);
        findViews(view);
        realmPersonalDataResults = realm.where(PersonalData.class).findAll();
        pDataArray = (ArrayList<PersonalData>) realm.copyFromRealm(realmPersonalDataResults);
//        for (int i=0;i<pDataArray.size();i++){
//            peronalName.setText();
//        }
//PersonalData pData=new PersonalData(0 uRCN,1 uRRIS_SSN_NO,2 RrisFamilyId,3 Team,4 BloodType,5 Name,6 Address,7 Key);
        peronalName.setText(realmPersonalDataResults.first().getName());
        tvaddress.setText(realmPersonalDataResults.first().getAddress());
        rcnUser.setText(realmPersonalDataResults.first().getRCN_NO());
        rrsnIdUser.setText(realmPersonalDataResults.first().getRrisFamilyId());
        teamUser.setText(realmPersonalDataResults.first().getTeam());
        bloodTypeUser.setText(realmPersonalDataResults.first().getBloodType());
        sharedPrefUtil = new SharedPrefUtil(getActivity());
        userRcnLogin = sharedPrefUtil.getString(USER_RCN_LOGIN);

        getDedline();
        getPharm();

        return view;

    }

    private void findViews(View view) {
        peronalName = (TextView) view.findViewById(R.id.peronal_name);
        tvaddress = (TextView) view.findViewById(R.id.tvaddress);
        circleView = (CircleImageView) view.findViewById(R.id.circleView);
        pluse = (TextView) view.findViewById(R.id.pluse);
        rcnUser = (TextView) view.findViewById(R.id.rcn_user);
        rrsnIdUser = (TextView) view.findViewById(R.id.rrsn_id_user);
        teamUser = (TextView) view.findViewById(R.id.team_user);
        bloodTypeUser = (TextView) view.findViewById(R.id.blood_type_user);
        database = FirebaseDatabase.getInstance();


    }

    public void getPharm() {
        final Query patient = database.getReference().child("AddPharmacy").child(userRcnLogin);
        if (patient != null) {
            patient.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
//                Log.i("Pharmacy", dataSnapshot.getValue().toString());
//                Log.i("getKeyPharmacy", dataSnapshot.getKey());
//                Log.i("getRef", dataSnapshot.getRef().toString());
                    JSONObject jsonObject = new JSONObject((Map) dataSnapshot.getValue());
                    if (dataSnapshot.exists()) {
                        arrToAccessPharmAdapters.clear();
                        for (DataSnapshot data : dataSnapshot.getChildren()) {
                            Log.e("data  ", data.getValue().toString());
                            timeSpend = data.getKey() + "";
                            Long date = Long.parseLong(timeSpend);
                            newtimeSpend = Util.getDate(date);
                            arrPharms = new RealmList<>();
                            arrPharms.clear();
                            for (DataSnapshot dataPharm : data.getChildren()) {
                                Log.e("dataPharm  ", dataPharm.getValue().toString());
                                JSONObject dt = new JSONObject((Map) dataPharm.getValue());
                                if (dt.optBoolean("check")) {
                                    Pharm pharm = new Pharm(dt.optString("Qty"), dt.optString("Drug"),
                                            dt.optString("RCN"), dt.optString("time"), dt.optBoolean("check"),
                                            dt.optString("key"),
                                            dt.optString("week"));
                                    arrPharms.add(pharm);
                                }
                            }
                            ToAccessPharmAdapter toAccessPharmAdapter = new ToAccessPharmAdapter(newtimeSpend, arrPharms);
                            arrToAccessPharmAdapters.add(toAccessPharmAdapter);
                        }
                        for (ToAccessPharmAdapter b : arrToAccessPharmAdapters) {
                            realm.beginTransaction();
                            realm.copyToRealmOrUpdate(b);
                            realm.commitTransaction();
                        }
                    } else {
//                        if (getView() != null)
//                            Snackbar.make(cuView, getString(R.string.acc_not_found), Snackbar.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }
    }

    public void getDedline(){
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
                    } else {
//                        if (getView() != null)
//                            Snackbar.make(cuView, getString(R.string.acc_not_found), Snackbar.LENGTH_SHORT).show();
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });
        }
    }
}