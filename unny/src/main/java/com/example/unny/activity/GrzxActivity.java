package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.unny.R;

public class GrzxActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    //页面控件
    ImageView iv_fh;
    ImageView wo_xy;
    ImageView wo_xy1;
    private Switch wo_xy2;
    ImageView wo_xy3;
    ImageView wo_xy4;
    ImageView wo_xy6;
    TextView wo_tcdl;
    TextView tv_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grzx);
        //获取控件
        iv_fh=findViewById(R.id.iv_fh);
        wo_xy=findViewById(R.id.wo_xy);
        wo_xy1=findViewById(R.id.wo_xy1);
        wo_xy2=(Switch) findViewById(R.id.wo_xy2);
        wo_xy3=findViewById(R.id.wo_xy3);
        wo_xy4=findViewById(R.id.wo_xy4);
        wo_xy6=findViewById(R.id.wo_xy6);
        wo_tcdl=findViewById(R.id.wo_tcdl);
        tv_login=findViewById(R.id.tv_login);

        wo_xy2.setOnCheckedChangeListener(this);
        //返回上一页面
        iv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                finish();
            }
        });
        //设置点击事件
        //activity跳转activity，帐号与安全
        wo_xy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(GrzxActivity.this,ZhanghaoActivity.class);
                startActivityForResult(intent1,1);
            }
        });
        //跳转收货地址
        wo_xy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(GrzxActivity.this,ShouhdzActivity.class);
                startActivityForResult(intent1,1);
            }
        });
        //跳转支付
        wo_xy3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(GrzxActivity.this,ZhifActivity.class);
                startActivityForResult(intent1,1);
            }
        });
        //跳转关于
        wo_xy4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(GrzxActivity.this,GuanyActivity.class);
                startActivityForResult(intent1,1);
            }
        });
        //隐私
        wo_xy6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(GrzxActivity.this,BzfkActivity.class);
                startActivityForResult(intent1,1);
            }
        });
        //退出登录
        wo_tcdl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(GrzxActivity.this,LoginActivity.class);
                startActivityForResult(intent1,1);
            }
        });

    }
    //开关按钮
    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){

        }else {

        }
    }
}