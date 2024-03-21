package com.example.education.Tuoguan;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.education.DoubleSeekBar;
import com.example.education.MyElongScaleSeekBar;
import com.example.education.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TuoguanFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TuoguanFragment extends Fragment {
    private SeekBar mSeekBar;
    private TextView mTextView, mTextView2,mTextView3;
    private DoubleSeekBar mDoubleSeekBar;
    private MyElongScaleSeekBar mMyElongScaleSeekBar;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TuoguanFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TuoguanFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TuoguanFragment newInstance(String param1, String param2) {
        TuoguanFragment fragment = new TuoguanFragment();
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

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tuoguan, container, false);
        mSeekBar = view.findViewById(R.id.seekBar_t);
        mTextView = view.findViewById(R.id.tuoguan_tv);
        mTextView2 = view.findViewById(R.id.tuoguan_tv2);
        mTextView3 = view.findViewById(R.id.tuoguan_tv3);
        mDoubleSeekBar = view.findViewById(R.id.double_sb);
        mMyElongScaleSeekBar = view.findViewById(R.id.double_sb2);
        mDoubleSeekBar.setMinValue(0);
        mDoubleSeekBar.setMaxValue(100);
        mDoubleSeekBar.setOnChanged(new DoubleSeekBar.OnChanged() {
            @Override
            public void onChange(int leftValue, int rightValue) {
                mTextView2.setText(leftValue + " /100" + "  " + rightValue + " /100");
            }
        });

        mSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                mTextView.setText(progress + " /100");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "触碰SeekBar", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(getContext(), "松开SeekBar", Toast.LENGTH_SHORT).show();

            }
        });
        return view;
    }
}