package com.example.education.dialogBox;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.example.education.R;

public class CustomDialogBox extends Dialog {
    private TextView title, content;
    private Button confirm, cancel;
    private String titleStr, contentStr, confirmStr, cancelStr;
    private Context mContext;
    // 按钮监听器
    private OnNoClickListener onNoClickListener;
    private OnYesClickListener onYesClickListener;
    public CustomDialogBox(Context context) {
        super(context);
        this.mContext = context;
    }
    public CustomDialogBox(Context context, int theme) {
        super(context, theme);
        this.mContext = context;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        //使用自定义的布局
        setContentView(R.layout.custom_dialog);
        init();
        title.setText(titleStr);
        content.setText(contentStr);
        confirm.setText(confirmStr);
        cancel.setText(cancelStr);
        // 确认按钮
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (onYesClickListener != null) {
                    onYesClickListener.confirm();
                }
            }
        });
        // 取消按钮
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                if (onNoClickListener != null) {
                    onNoClickListener.cancel();
                }
            }
        });
    }
    /*
     * 初始化控件
     */
    private void init() {
        title = (TextView) findViewById(R.id.title);
        content = (TextView) findViewById(R.id.content);
        confirm = (Button) findViewById(R.id.confirm);
        cancel = (Button) findViewById(R.id.cancel);
    }
    /*
     * 设置取消对话框的点击事件的监听接口
     */
    public interface OnNoClickListener {
        public void cancel();
    }
    /*
     * 设置确认对话框的点击事件的监听接口
     */
    public interface OnYesClickListener {
        public void confirm();
    }
    /*
     * 为外部设置监听部分
     */
    public void setOnYesClick(String str, OnYesClickListener onYesClickListener) {
        if (str != null) {
            this.confirmStr = str;
        }
        this.onYesClickListener = onYesClickListener;
    }
    public void setOnNoClick(String str, OnNoClickListener onNoClickListener) {
        if (str != null) {
            this.cancelStr = str;
        }
        this.onNoClickListener = onNoClickListener;
    }
    /**
     * 为外界暴露方法，设置标题内容等
     */
    public void setTitle(String str) {
        this.titleStr = str == null ? "" : str;
    }
    public void setContent(String str) {
        this.contentStr = str == null ? "" : str;
    }
}

