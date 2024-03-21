package com.example.education.Yuer;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

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
 * Use the {@link BabyActFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class BabyActFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<Integer> mImgList;
    private BabyActAdapter babyActAdapter;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public BabyActFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment BabyActFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static BabyActFragment newInstance(String param1, String param2) {
        BabyActFragment fragment = new BabyActFragment();
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
        View view = inflater.inflate(R.layout.fragment_baby_act, container, false);
        recyclerView = view.findViewById(R.id.baby_act_rv);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        initData();
        update();

        // Inflate the layout for this fragment
        return view;
    }
    public void update() {
        babyActAdapter = new BabyActAdapter(mImgList);
        recyclerView.setAdapter(babyActAdapter);
    }
    public void initData() {
        mImgList = new ArrayList<>();
        mImgList.add(R.drawable.act1);
        mImgList.add(R.drawable.act2);
        mImgList.add(R.drawable.act3);
        mImgList.add(R.drawable.act4);
        mImgList.add(R.drawable.act5);
        mImgList.add(R.drawable.act1);
        mImgList.add(R.drawable.act2);
        mImgList.add(R.drawable.act3);
        mImgList.add(R.drawable.act4);
        mImgList.add(R.drawable.act5);
        mImgList.add(R.drawable.act1);
        mImgList.add(R.drawable.act2);
        mImgList.add(R.drawable.act3);
        mImgList.add(R.drawable.act4);
        mImgList.add(R.drawable.act5);
        mImgList.add(R.drawable.act1);
        mImgList.add(R.drawable.act2);
        mImgList.add(R.drawable.act3);
        mImgList.add(R.drawable.act4);
        mImgList.add(R.drawable.act5);

    }
    private class BabyActHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        public BabyActHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.item_baby_act,parent,false));
            imageView = itemView.findViewById(R.id.baby_act_iv);
        }
        public void bind(int position) {
            imageView.setImageResource(mImgList.get(position));

       }
   }
    public class BabyActAdapter extends RecyclerView.Adapter<BabyActHolder> {
        private List<Integer> mImgList;
        public BabyActAdapter(List<Integer> mImgList) {
            this.mImgList = mImgList;
        }
        public void onBindViewHolder(BabyActHolder holder, int position) {
            holder.bind(position);
        }
        public int getItemCount() {
            return mImgList.size();
        }
        public BabyActHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new BabyActHolder(LayoutInflater.from(parent.getContext()),parent);
        }
    }
}