package com.example.education;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements  RadioGroup.OnCheckedChangeListener {

    private RadioButton rbHome,rbMine,rbYuer,rbTuoguan,rbXiaoxi;
    private RadioGroup mRadioGroup;
    private List<Fragment> fragments;
    private int position =0;
    private static final String TAG = "MainAC";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // this.getSupportActionBar().hide(); //去除标题栏
        rbHome = findViewById(R.id.rd_home);
        rbMine = findViewById(R.id.rd_mine);
        rbYuer = findViewById(R.id.rb_yuer);
        rbTuoguan = findViewById(R.id.rb_tuoguan);
        rbXiaoxi = findViewById(R.id.rb_xiaoxi);
        mRadioGroup = findViewById(R.id.rd_group);
        //默认第一个
        rbHome.setSelected(true);

        mRadioGroup.setOnCheckedChangeListener(this);
        initFragments();
        defaultFragment();
    }

    private void initFragments() {
        fragments = new ArrayList<>();
        fragments.add(0,new HomeFragment());
        fragments.add(1,new YuerFragment());
        fragments.add(2,new TuoguanFragment());
        fragments.add(3,new XiaoxiFragment());
        fragments.add(4,new MineFragment());
    }

    private void defaultFragment() {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragment_layout,fragments.get(0));
        ft.commit();
    }
    private void setSelected() {
        rbHome.setChecked(false);
        rbMine.setChecked(false);
        rbYuer.setChecked(false);
        rbTuoguan.setChecked(false);
        rbXiaoxi.setChecked(false);
    }
    

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
       // Log.i(TAG,"onCheckedChanged: "+i);

        if (i == R.id.rd_home) {
            position = 0;
           // Log.i(TAG,"onCheckedChanged: "+position);
            ft.replace(R.id.fragment_layout,fragments.get(position));
            setSelected();
            rbHome.setChecked(true);

        }
        else if (i == R.id.rb_yuer) {
            position = 1;
           // Log.i(TAG,"onCheckedChanged: "+position);
            ft.replace(R.id.fragment_layout,fragments.get(position));
            setSelected();
            rbYuer.setChecked(true);
        } else if (i == R.id.rb_tuoguan) {
            position = 2;
          //  Log.i(TAG,"onCheckedChanged: "+position);
            ft.replace(R.id.fragment_layout,fragments.get(position));
            setSelected();
            rbTuoguan.setChecked(true);
        }
        else if (i == R.id.rb_xiaoxi) {
            position = 3;
           // Log.i(TAG,"onCheckedChanged: "+position);
            ft.replace(R.id.fragment_layout,fragments.get(position));
            setSelected();
            rbXiaoxi.setChecked(true);
        }
        else if (i == R.id.rd_mine) {
            position = 4;
           // Log.i(TAG,"onCheckedChanged: "+position);
            ft.replace(R.id.fragment_layout,fragments.get(position));
            setSelected();
            rbMine.setChecked(true);
        }
        ft.commit();
    }
}