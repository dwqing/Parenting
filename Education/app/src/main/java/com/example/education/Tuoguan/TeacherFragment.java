package com.example.education.Tuoguan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.education.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link TeacherFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class TeacherFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private TeacherAdapter mAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public TeacherFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment TeacherFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static TeacherFragment newInstance(String param1, String param2) {
        TeacherFragment fragment = new TeacherFragment();
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
        View view = inflater.inflate(R.layout.fragment_teacher, container, false);
        mRecyclerView = view.findViewById(R.id.recycler_teacher);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        update();
        // Inflate the layout for this fragment
        return view;
    }
    public void  update(){

        mAdapter = new TeacherAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }
    private class TeacherHolder extends RecyclerView.ViewHolder{
        public TeacherHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.item_teacher,parent,false));
        }
    }
    public class TeacherAdapter extends RecyclerView.Adapter<TeacherHolder> {
        public TeacherAdapter(){

        }
        public void onBindViewHolder(TeacherHolder holder, int position){

        }
        public int getItemCount(){
            return 25;
        }
        public TeacherHolder onCreateViewHolder(ViewGroup parent, int viewType){
            return new TeacherHolder(LayoutInflater.from(parent.getContext()),parent);
        }
    }
}