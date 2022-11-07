package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.example.unny.R;
/*
*修改密码
 */
public class MimaActivity extends AppCompatActivity{
    ImageView iv_fh;
    private EditText xz_ku;//原密码
    private EditText mm_ku1;//新密码
    private EditText mm_ku2;//再次输入新密码
    private Button qrj;//确认
    public static RequestQueue queue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mima);

        iv_fh=findViewById(R.id.iv_fh);

        //返回上一页面
        iv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                finish();
            }
        });
    }
}