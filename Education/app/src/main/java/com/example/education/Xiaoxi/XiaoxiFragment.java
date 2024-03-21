package com.example.education.Xiaoxi;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.education.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link XiaoxiFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class XiaoxiFragment extends Fragment {
    private RecyclerView recyclerView;
    private XiaoxiAdapter adapter;//填数据

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public XiaoxiFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment XiaoxiFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static XiaoxiFragment newInstance(String param1, String param2) {
        XiaoxiFragment fragment = new XiaoxiFragment();
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
        View view = inflater.inflate(R.layout.fragment_xiaoxi, container, false);
        // Inflate the layout for this fragment
        recyclerView = view.findViewById(R.id.recycler_xiaoxi);
//        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateData();
        return view;
    }

    private void updateData() {
        adapter = new XiaoxiAdapter();
        recyclerView.setAdapter(adapter);
    }


    private class XiaoxiHolder extends RecyclerView.ViewHolder{
        public XiaoxiHolder(LayoutInflater inflater,ViewGroup parent) {
            super(inflater.inflate(R.layout.item_recyclerview_xiaoxi, parent, false));
        }
        public void bind(String text){
            //

        }
    }
    private class XiaoxiAdapter extends RecyclerView.Adapter<XiaoxiHolder> {
        @Override
        public XiaoxiHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new XiaoxiHolder(LayoutInflater.from(parent.getContext()),parent);
        }

        @Override
        public void onBindViewHolder(XiaoxiHolder holder, int position) {

        }

        @Override
        public int getItemCount() {
            return 25;
        }
    }

}