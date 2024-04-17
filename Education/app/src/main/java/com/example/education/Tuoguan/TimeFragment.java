package com.example.education.Tuoguan;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.education.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TimeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TimeFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecyclerView;
    private TimeAdapter mTimeAdapter;
    private RecyclerView mRecyclerView2;
    private TimeOderAdapter mTimeOderAdapter;
    private List<String> mList;
    private List<DataMouth> mListMouth;
    private List<TextView> mDayList;
    private int dayNumber,startDay;
    private TextView
            day11,day12, day13, day14, day15, day16,day17,
            day21,day22,day23,day24,day25,day26,day27,
            day31,day32,day33,day34,day35,day36,day37,
            day41,day42,day43,day44,day45,day46,day47,
            day51,day52,day53,day54,day55,day56,day57,
            day61,day62,day63,day64,day65,day66,day67;


    public TimeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TimeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TimeFragment newInstance(String param1, String param2) {
        TimeFragment fragment = new TimeFragment();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_time, container, false);
        mRecyclerView=view.findViewById(R.id.time_mouth_rv);
        LinearLayoutManager mLinearLayoutManager=new LinearLayoutManager(getActivity());
        mLinearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mLinearLayoutManager);

        mRecyclerView2 = view.findViewById(R.id.time_teacher_rv);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        initView(view);

        initData();
        update();

        return view;
    }

    private void initView(View view) {
        day11=view.findViewById(R.id.day11_tv);
        day12=view.findViewById(R.id.day12_tv);
        day13=view.findViewById(R.id.day13_tv);
        day14=view.findViewById(R.id.day14_tv);
        day15=view.findViewById(R.id.day15_tv);
        day16=view.findViewById(R.id.day16_tv);
        day17=view.findViewById(R.id.day17_tv);
        day21=view.findViewById(R.id.day21_tv);
        day22=view.findViewById(R.id.day22_tv);
        day23=view.findViewById(R.id.day23_tv);
        day24=view.findViewById(R.id.day24_tv);
        day25=view.findViewById(R.id.day25_tv);
        day26=view.findViewById(R.id.day26_tv);
        day27=view.findViewById(R.id.day27_tv);
        day31=view.findViewById(R.id.day31_tv);
        day32=view.findViewById(R.id.day32_tv);
        day33=view.findViewById(R.id.day33_tv);
        day34=view.findViewById(R.id.day34_tv);
        day35=view.findViewById(R.id.day35_tv);
        day36=view.findViewById(R.id.day36_tv);
        day37=view.findViewById(R.id.day37_tv);
        day41=view.findViewById(R.id.day41_tv);
        day42=view.findViewById(R.id.day42_tv);
        day43=view.findViewById(R.id.day43_tv);
        day44=view.findViewById(R.id.day44_tv);
        day45=view.findViewById(R.id.day45_tv);
        day46=view.findViewById(R.id.day46_tv);
        day47=view.findViewById(R.id.day47_tv);
        day51=view.findViewById(R.id.day51_tv);
        day52=view.findViewById(R.id.day52_tv);
        day53=view.findViewById(R.id.day53_tv);
        day54=view.findViewById(R.id.day54_tv);
        day55=view.findViewById(R.id.day55_tv);
        day56=view.findViewById(R.id.day56_tv);
        day57=view.findViewById(R.id.day57_tv);
        day61=view.findViewById(R.id.day61_tv);
        day62=view.findViewById(R.id.day62_tv);
        day63=view.findViewById(R.id.day63_tv);
        day64=view.findViewById(R.id.day64_tv);
        day65=view.findViewById(R.id.day65_tv);
        day66=view.findViewById(R.id.day66_tv);
        day67=view.findViewById(R.id.day67_tv);
        mDayList=new ArrayList<>();
        mDayList.add(day11);
        mDayList.add(day12);
        mDayList.add(day13);
        mDayList.add(day14);
        mDayList.add(day15);
        mDayList.add(day16);
        mDayList.add(day17);

        mDayList.add(day21);
        mDayList.add(day22);
        mDayList.add(day23);
        mDayList.add(day24);
        mDayList.add(day25);
        mDayList.add(day26);
        mDayList.add(day27);

        mDayList.add(day31);
        mDayList.add(day32);
        mDayList.add(day33);
        mDayList.add(day34);
        mDayList.add(day35);
        mDayList.add(day36);
        mDayList.add(day37);

        mDayList.add(day41);
        mDayList.add(day42);
        mDayList.add(day43);
        mDayList.add(day44);
        mDayList.add(day45);
        mDayList.add(day46);
        mDayList.add(day47);

        mDayList.add(day51);
        mDayList.add(day52);
        mDayList.add(day53);
        mDayList.add(day54);
        mDayList.add(day55);
        mDayList.add(day56);
        mDayList.add(day57);

        mDayList.add(day61);
        mDayList.add(day62);
        mDayList.add(day63);
        mDayList.add(day64);
        mDayList.add(day65);
        mDayList.add(day66);
        mDayList.add(day67);
    }


    public void initData() {
        mListMouth=new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        int  year = cal.get(Calendar.YEAR);
        cal.set(year, Calendar.JANUARY, 1);
        DataMouth data1=new DataMouth("Jan",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        cal.set(year, Calendar.FEBRUARY, 1);
        DataMouth data2=new DataMouth("Feb",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        cal.set(year, Calendar.MARCH, 1);
        DataMouth data3=new DataMouth("Mar",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        cal.set(year, Calendar.APRIL, 1);
        DataMouth data4=new DataMouth("Apr",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        cal.set(year, Calendar.MAY, 1);
        DataMouth data5=new DataMouth("May",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        cal.set(year, Calendar.JUNE, 1);
        DataMouth data6=new DataMouth("Jun",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        cal.set(year, Calendar.JULY, 1);
        DataMouth data7=new DataMouth("Jul",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        cal.set(year, Calendar.AUGUST, 1);
        DataMouth data8=new DataMouth("Aug",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        cal.set(year, Calendar.SEPTEMBER, 1);
        DataMouth data9=new DataMouth("Sep",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        cal.set(year, Calendar.OCTOBER, 1);
        DataMouth data10=new DataMouth("Oct",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        cal.set(year, Calendar.NOVEMBER, 1);
        DataMouth data11=new DataMouth("Nov",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        cal.set(year, Calendar.DECEMBER, 1);
        DataMouth data12=new DataMouth("Dec",cal.getActualMaximum(Calendar.DAY_OF_MONTH),cal.get(Calendar.DAY_OF_WEEK));
        mListMouth.add(data1);
        mListMouth.add(data2);
        mListMouth.add(data3);
        mListMouth.add(data4);
        mListMouth.add(data5);
        mListMouth.add(data6);
        mListMouth.add(data7);
        mListMouth.add(data8);
        mListMouth.add(data9);
        mListMouth.add(data10);
        mListMouth.add(data11);
        mListMouth.add(data12);

        mList= new ArrayList<>();
        mList.add("Jan");
        mList.add("Feb");
        mList.add("Mar");
        mList.add("Apr");
        mList.add("May");
        mList.add("Jun");
        mList.add("Jul");
        mList.add("Aug");
        mList.add("Sep");
        mList.add("Oct");
        mList.add("Nov");
        mList.add("Dec");

    }
    public void update() {
        mTimeAdapter=new TimeAdapter(mListMouth);
        mRecyclerView.setAdapter(mTimeAdapter);
        mTimeOderAdapter = new TimeOderAdapter();
        mRecyclerView2.setAdapter(mTimeOderAdapter);

    }
    private class TimeHolder extends RecyclerView.ViewHolder{
        private TextView mTextView;
        public TimeHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.item_time_mouth,parent,false));
            mTextView=itemView.findViewById(R.id.tv_time);
        }
        public void bind(int position) {

            //mTextView.setText(mList.get(position));
            mTextView.setText(mListMouth.get(position).getMouth());
            mDayList.get(0).setText("af");

//            mTextView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {

//                }
//            });

        }

    }
    public class TimeAdapter extends RecyclerView.Adapter<TimeHolder> {
        private List<String> mList;
        private List<DataMouth> mListMouth;
        public TimeAdapter(List<String> list, List<DataMouth> list2){
            mList=list;
            mListMouth=list2;
        }
        public TimeAdapter(List<DataMouth> list){
            mListMouth=list;
        }
        public TimeAdapter(){

        }
        public void onBindViewHolder(TimeHolder holder, @SuppressLint("RecyclerView") int position){
            holder.bind(position);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
//                    for (int i =1;i<mListMouth.get(position).getMouthDayNumber()+1;i++){
//                        int startday = mListMouth.get(position).getFirstdayWeek();
//                        mDayList.get(startday+i-1).setText(String.valueOf(i));
//                    }
                    //Toast.makeText(getContext(), mListMouth.get(position).getMouth().toString(), Toast.LENGTH_SHORT).show();
                    Toast.makeText(getContext(), String.valueOf(mListMouth.get(position).getMouthDayNumber()), Toast.LENGTH_SHORT).show();
                     startDay = mListMouth.get(position).getFirstdayWeek();
                     dayNumber = mListMouth.get(position).getMouthDayNumber();
                    Log.i("ffff", String.valueOf(startDay));
                    Log.i("ffff", String.valueOf(dayNumber));
                    for (int i = 1;i<=dayNumber;i++){
                        mDayList.get(startDay+i-1).setText(String.valueOf(i));
                    }
                    //mDayList.get(startDay).setText("ws");
                }
            });

        }
        public int getItemCount(){
            return mListMouth.size();
        }
        public TimeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new TimeHolder(LayoutInflater.from(parent.getContext()),parent);
        }
    }
    private class TimeOderHolder extends RecyclerView.ViewHolder {
        private TextView mTextView;
        public TimeOderHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.item_time_teacher,parent,false));
            mTextView=itemView.findViewById(R.id.item_time_teacher_start);
        }
        public void bind(){
            //专挑到双滑动
        }
    }
    public class TimeOderAdapter extends RecyclerView.Adapter<TimeOderHolder>{

        @NonNull
        @Override
        public TimeOderHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new TimeOderHolder(LayoutInflater.from(parent.getContext()),parent);
        }

        @Override
        public void onBindViewHolder(@NonNull TimeOderHolder holder, int position) {
            holder.bind();
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(getContext(), "点击了", Toast.LENGTH_SHORT).show();
                }
            });

        }

        @Override
        public int getItemCount() {
            return 25;
        }
    }
}