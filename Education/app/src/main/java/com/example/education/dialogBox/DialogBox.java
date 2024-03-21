package com.example.education.dialogBox;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.icu.util.Calendar;
import android.os.Build;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;
import androidx.annotation.RequiresApi;

import com.example.education.R;

public class DialogBox {
    /**
     * 1.普通对话框
     */
    public void ordinaryDialogBox(final Activity activity){
        AlertDialog.Builder dialogBox = new AlertDialog.Builder(activity);
        dialogBox.setTitle("普通对话框");
        dialogBox.setMessage("你要离开吗？");
        dialogBox.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity,"我要离开！",Toast.LENGTH_SHORT).show();
            }
        });
        dialogBox.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity,"我不想离开！",Toast.LENGTH_SHORT).show();
            }
        });
        dialogBox.create().show();
    }
    /**
     * 2.单选对话框
     */
    public void radioDialogBox(final Activity activity){
        final AlertDialog.Builder dialogBox = new AlertDialog.Builder(activity);
        dialogBox.setTitle("你最喜欢的科目是？");
        /*
         *因为setMessage和setSingleChoiceItems的显示区域互相冲突，
         *所以它们不能被同时使用，在这里我们必须注释掉掉这下面这行代码，
         * 但是，我们仍然可以使用setTitle()来设置标题或消息
         */
        //dialogBox.setMessage("");
        final String[] items = {"物理","化学","生物","历史"};
        dialogBox.setSingleChoiceItems(items,-1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity,"你最喜欢的科目是"+items[which],Toast.LENGTH_SHORT).show();
                //选择一个选项之后，就立即关闭对话框
                dialog.dismiss();
            }
        });
        dialogBox.create().show();
    }
    /**
     * 3.多选对话框
     */
    public void multipleDialogBox(final Activity activity){
        AlertDialog.Builder dialogBox = new AlertDialog.Builder(activity);
        dialogBox.setTitle("你喜欢哪些食物？");
        final String[] items = {"胡萝卜","白菜","菠菜","土豆","黄瓜","西红柿"};
        //标识选项的状态，false为未选中，true为选中
        final boolean[] check = {false,false,false,false,false,false};
        dialogBox.setMultiChoiceItems(items, check, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                //当被选中时，选项的状态为true,否则为false
                if (isChecked){
                    check[which] = true;
                    Toast.makeText(activity,"你选中了"+items[which],Toast.LENGTH_SHORT).show();
                }else {
                    check[which] = false;
                    Toast.makeText(activity,"你取消了"+items[which],Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialogBox.setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String str = "";
                for (int i = 0; i < check.length; i++) {
                    if (check[i]){
                        str = str + "," + items[i];
                    }
                }
                //显示被选中的内容
                if(str!="") {
                    Toast.makeText(activity, "你喜欢" + str, Toast.LENGTH_SHORT).show();
                }
            }
        });
        dialogBox.create().show();
    }
    /**
     * 4.列表对话框
     */
    public void listDialogBox(final Activity activity){
        AlertDialog.Builder dialogBox = new AlertDialog.Builder(activity);
        dialogBox.setTitle("课程安排：");
        final String[] items = {"第一节（数学）","第二节（地理）","第三节（历史）","第四节（美术）"};
        dialogBox.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(activity,items[which],Toast.LENGTH_SHORT).show();
            }
        });
        dialogBox.create().show();
    }
    /**
     * 5.不带进度条对话框
     */
    public void noProgressDialogBox(Activity activity){
        ProgressDialog dialogBox = new ProgressDialog(activity);
        dialogBox.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialogBox.setTitle("不带进度条对话框");
        dialogBox.setMessage("加载中~");
        dialogBox.show();
    }
    /**
     * 6.带进度条对话框
     */
    public void progressDialogBox(Activity activity){
        final ProgressDialog dialogBox = new ProgressDialog(activity);
        //水平样式
        dialogBox.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialogBox.setTitle("进度条对话框");
        dialogBox.setMessage("加载中~");
        dialogBox.show();
        //显示进度条进度
        new Thread(new Runnable() {
            @Override
            public void run() {
                // TODO Auto-generated method stub
                for (int j = 0; j <= 100; j++) {
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                    dialogBox.setProgress(j);
                }
                //加载完毕，退出对话框
                dialogBox.dismiss();
            }
        }).start();
    }
    /**
     * 7.自定义布局对话框
     */
    public void customLayoutDialogBox(final Activity activity){
        final AlertDialog.Builder dialogBox = new AlertDialog.Builder(activity);
        //创建一个view，并且将自定义布局对话框的布局加入view中
        View view = View.inflate(activity,R.layout.fragment_tuoguan,null);
        dialogBox.setView(view);
        final Dialog dialog = dialogBox.create();
//        final EditText editText1 = view.findViewById(R.id.editText1);
//        final EditText editText2 = view.findViewById(R.id.editText2);
//        Button button1 = view.findViewById(R.id.button1);
//        Button button2 = view.findViewById(R.id.button2);
//        //设置监听器
//        button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(activity,"退出",Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });
//        button2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(activity,"用户名："+editText1.getText().toString()+" 密码："+
//                        editText2.getText().toString(),Toast.LENGTH_SHORT).show();
//                dialog.dismiss();
//            }
//        });
        dialog.show();
    }
    /**
     * 8.自定义对话框
     */
    public void customDialogBox(final Activity activity){
        final CustomDialogBox dialogBox = new CustomDialogBox(activity);
        dialogBox.setTitle("自定义对话框");
        dialogBox.setContent("你要离开吗？");
        dialogBox.setOnYesClick("确定", new CustomDialogBox.OnYesClickListener() {
            @Override
            public void confirm() {
                Toast.makeText(activity,"点击了--确定--按钮",Toast.LENGTH_LONG).show();
                dialogBox.dismiss();
            }
        });
        dialogBox.setOnNoClick("取消", new CustomDialogBox.OnNoClickListener() {
            @Override
            public void cancel() {
                Toast.makeText(activity,"点击了--取消--按钮",Toast.LENGTH_LONG).show();
                dialogBox.dismiss();
            }
        });
        dialogBox.show();
    }
    /**
     * 9.日期对话框
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void dateDialogBox(final Activity activity){
        //创建Calendar对象
        Calendar calendar = Calendar.getInstance();
        DatePickerDialog dialogBox = new DatePickerDialog(activity, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                //显示选择的日期
                /*
                这里请大家注意，为什么月份是(month+1),因为month代表的是上年底与现在相差的月份数，
                比如选择日期：1月15日，它与上年底相差的月份没有1个月，只有15天，那么month=0,
                当日期：2月15，它与上年底相差的日子为1个月15天，那么month=1。
                */
                Toast.makeText(activity,year+"年 "+(month+1)+"月 "+dayOfMonth+"日",Toast.LENGTH_SHORT).show();
            }
            //刚打开日期对话框，默认选择当前日期
        }, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        //显示日期对话框
        dialogBox.show();
    }
    /**
     * 10.时间对话框
     */
    @RequiresApi(api = Build.VERSION_CODES.N)
    public void timeDialogBox(final Activity activity){
        //创建Calendar对象
        final Calendar calendar = Calendar.getInstance();
        TimePickerDialog dialogBox = new TimePickerDialog(activity, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                //显示选择的时间
                Toast.makeText(activity,hourOfDay+"点 "+minute+"分",Toast.LENGTH_SHORT).show();
            }
        },calendar.get(Calendar.HOUR),
                calendar.get(Calendar.MINUTE),true);
        //显示时间对话框
        dialogBox.show();
    }
}

