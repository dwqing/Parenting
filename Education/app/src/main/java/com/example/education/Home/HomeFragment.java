package com.example.education.Home;

import android.annotation.SuppressLint;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.education.R;
import com.example.education.Unit.SpaceItemDecoration;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private homeAdapter mAdapter;
    private List<Integer> mImgList;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
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

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = view.findViewById(R.id.home_rv);
        GridLayoutManager layoutManager = new GridLayoutManager(getActivity(),2);
       // mRecyclerView.addItemDecoration(new SpaceItemDecoration(2, 0, false));;
        mRecyclerView.setLayoutManager(layoutManager);
        initData();
        update();
        // Inflate the layout for this fragment
        return view;
    }
    public void update() {
        mAdapter = new homeAdapter(mImgList);
        mRecyclerView.setAdapter(mAdapter);
    }
    private class homeHolder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        public homeHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.item_home_rv,parent,false));
            mImageView = itemView.findViewById(R.id.home_iv);
        }
        public void bind(int position) {
            mImageView.setImageResource(mImgList.get(position));
        }
    }
    public class homeAdapter extends RecyclerView.Adapter<homeHolder> {
        private List<Integer> mImgList;
        public homeAdapter(List<Integer> mImgList) {
            this.mImgList = mImgList;
        }
        public homeAdapter() {
        }
        public void onBindViewHolder(homeHolder holder, int position) {
            holder.bind(position);
        }
        public int getItemCount() {
            return mImgList.size();
        }
        public homeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new homeHolder(LayoutInflater.from(parent.getContext()),parent);
        }
    }
    private void initData() {
        mImgList = new ArrayList<>();
        mImgList.add(R.drawable.item1);
        mImgList.add(R.drawable.item2);
        mImgList.add(R.drawable.item3);
        mImgList.add(R.drawable.item4);
        mImgList.add(R.drawable.item1);
        mImgList.add(R.drawable.item2);
        mImgList.add(R.drawable.item3);
        mImgList.add(R.drawable.item4);
        mImgList.add(R.drawable.item1);
        mImgList.add(R.drawable.item2);
        mImgList.add(R.drawable.item3);
        mImgList.add(R.drawable.item4);
        mImgList.add(R.drawable.item1);
        mImgList.add(R.drawable.item2);
        mImgList.add(R.drawable.item3);
        mImgList.add(R.drawable.item4);

    }
}