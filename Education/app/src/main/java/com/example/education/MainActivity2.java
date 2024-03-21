package com.example.education;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.education.dialogBox.DialogBox;

public class MainActivity2 extends AppCompatActivity {

    private Button button1, button2, button3, button4, button5, button6, button7,button8,button9,button10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        final DialogBox dialogBox=new DialogBox();
        //绑定控件并为按钮设置监听器
        button1=findViewById(R.id.button1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox.ordinaryDialogBox(MainActivity2.this);
            }
        });
        button2=findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox.radioDialogBox(MainActivity2.this);
            }
        });
        button3=findViewById(R.id.button3);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox.multipleDialogBox(MainActivity2.this);
            }
        });
        button4=findViewById(R.id.button4);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox.listDialogBox(MainActivity2.this);
            }
        });
        button5=findViewById(R.id.button5);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox.noProgressDialogBox(MainActivity2.this);
            }
        });
        button6=findViewById(R.id.button6);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox.progressDialogBox(MainActivity2.this);
            }
        });
        button7=findViewById(R.id.button7);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox.customLayoutDialogBox(MainActivity2.this);
            }
        });
        button8=findViewById(R.id.button8);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialogBox.customDialogBox(MainActivity2.this);
            }
        });
        button9=findViewById(R.id.button9);
        button9.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                dialogBox.dateDialogBox(MainActivity2.this);
            }
        });
        button10=findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View v) {
                dialogBox.timeDialogBox(MainActivity2.this);
            }
        });
    }

}