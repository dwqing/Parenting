package com.example.education.Yuer;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.education.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link YuerFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class YuerFragment extends Fragment implements RadioGroup.OnCheckedChangeListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RadioButton babyACt_rb,  babyOder_rb;
    private  int position = 0;
    private List<Fragment> fragments;

    private RadioGroup mRadioGroup;
    private static final String TAG = "YuerF";
    public YuerFragment() {
        // Required empty public constructor
    }
    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment YuerFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static YuerFragment newInstance(String param1, String param2) {
        YuerFragment fragment = new YuerFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    private void defaultFragment() {
        FragmentManager fm = getParentFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_container_yuer,fragments.get(0));
        ft.commit();
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(0, new BabyActFragment());
        fragments.add(1, new BabyOderFragment());
    }
    private void setSelected() {
        babyACt_rb.setChecked(false);
        babyOder_rb.setChecked(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_yuer, container, false);
        babyACt_rb = v.findViewById(R.id.baby_act_rb);
        babyOder_rb = v.findViewById(R.id.baby_oder_rb);
        mRadioGroup = v.findViewById(R.id.yuer_rg);

        //babyACt.setSelected(true);

        babyACt_rb.setSelected(true);
        mRadioGroup.setOnCheckedChangeListener(this);
        initFragments();
        defaultFragment();

        FragmentManager fm = getParentFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        return v;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager fm = getParentFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
       if (i == R.id.baby_act_rb) {
           position = 0;
           ft.replace(R.id.fragment_container_yuer,fragments.get(position));
           setSelected();
           babyACt_rb.setChecked(true);

       } else if (i == R.id.baby_oder_rb) {
           position = 1;
           ft.replace(R.id.fragment_container_yuer,fragments.get(position));
           setSelected();
           babyOder_rb.setChecked(true);
       }
       ft.commit();

    }
}