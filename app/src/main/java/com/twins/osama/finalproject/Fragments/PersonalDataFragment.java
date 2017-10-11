package com.twins.osama.finalproject.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twins.osama.finalproject.Classes.PersonalData;
import com.twins.osama.finalproject.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import io.realm.Realm;
import io.realm.RealmResults;


public class PersonalDataFragment extends Fragment {
    Realm realm;
    private TextView peronalName;
    private TextView tvaddress;
    private CircleImageView circleView;
    private TextView pluse;
    private TextView rcnUser;
    private TextView rrsnIdUser;
    private TextView teamUser;
    private TextView bloodTypeUser;

    private RealmResults<PersonalData> realmPersonalDataResults;
    private ArrayList<PersonalData> pDataArray;

    public static PersonalDataFragment newInstance() {
        PersonalDataFragment fragment = new PersonalDataFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Realm.init(getActivity());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_personal_data, container, false);
        findViews(view);
        realm = Realm.getDefaultInstance();
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


        return view;

    }
  private void findViews(View view) {
        peronalName = (TextView)view.findViewById( R.id.peronal_name );
        tvaddress = (TextView)view.findViewById( R.id.tvaddress );
        circleView = (CircleImageView)view.findViewById( R.id.circleView );
        pluse = (TextView)view.findViewById( R.id.pluse );
        rcnUser = (TextView)view.findViewById( R.id.rcn_user );
        rrsnIdUser = (TextView)view.findViewById( R.id.rrsn_id_user );
        teamUser = (TextView)view.findViewById( R.id.team_user );
        bloodTypeUser = (TextView)view.findViewById( R.id.blood_type_user );
    }

}