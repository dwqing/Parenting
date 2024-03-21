package com.example.education.Yuer;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.education.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link BabyOderFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BabyOderFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private OderAdapter mAdapter;
    private List<Integer> mImgList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BabyOderFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BabyOderFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BabyOderFragment newInstance(String param1, String param2) {
        BabyOderFragment fragment = new BabyOderFragment();
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
        View view = inflater.inflate(R.layout.fragment_baby_oder, container, false);

        mRecyclerView = view.findViewById(R.id.baby_oder_rv);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        initData();
        update();
        return view;
    }
    public void update() {
        mAdapter = new OderAdapter(mImgList);
        mRecyclerView.setAdapter(mAdapter);
    }
    public void initData() {
        mImgList = new ArrayList<>();
        mImgList.add(R.drawable.dt1);
        mImgList.add(R.drawable.dt2);
        mImgList.add(R.drawable.dt3);
        mImgList.add(R.drawable.dt1);
        mImgList.add(R.drawable.dt2);
        mImgList.add(R.drawable.dt3);
        mImgList.add(R.drawable.dt1);
        mImgList.add(R.drawable.dt2);
        mImgList.add(R.drawable.dt3);
        mImgList.add(R.drawable.dt1);
        mImgList.add(R.drawable.dt2);
        mImgList.add(R.drawable.dt3);
        mImgList.add(R.drawable.dt1);
        mImgList.add(R.drawable.dt2);
        mImgList.add(R.drawable.dt3);
    }
    private class OderHolder extends RecyclerView.ViewHolder{
        private ImageView mImageView;
        public OderHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.item_recyclerview_oder,parent,false));
            mImageView = itemView.findViewById(R.id.oder_imageView);
        }
        public void bind(int position){
            mImageView.setImageResource(mImgList.get(position));
        }
    }
    public class OderAdapter extends RecyclerView.Adapter<OderHolder> {

        private List<Integer> mImgList;
        public OderAdapter(List<Integer> mImgList) {
            this.mImgList = mImgList;
        }
        @Override
        public OderHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new OderHolder(LayoutInflater.from(parent.getContext()),parent);
        }

        @Override
        public void onBindViewHolder(OderHolder holder, int position) {

            holder.bind(position);

        }

        @Override
        public int getItemCount() {
            return mImgList.size();
        }
    }
}