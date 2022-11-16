package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.unny.R;

public class ZhanghaoActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    private Switch zh_xy2;
    private Switch zh_xy3;
    private Switch zh_xy4;
    TextView zh_zxzh;
    ImageView zh_xy1;
    ImageView iv_fh;
    public static ZhanghaoActivity instance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhanghao);
        instance = this;
        init();


        zh_xy2=(Switch) findViewById(R.id.zh_xy2);
        zh_xy3=(Switch) findViewById(R.id.zh_xy3);
        zh_xy4=(Switch) findViewById(R.id.zh_xy4);
        iv_fh=findViewById(R.id.iv_fh);
        zh_zxzh=findViewById(R.id.zh_zxzh);
        zh_xy1=findViewById(R.id.zh_xy1);

        zh_xy2.setOnCheckedChangeListener(this);
        zh_xy3.setOnCheckedChangeListener(this);
        zh_xy4.setOnCheckedChangeListener(this);

        //返回上一页面
        iv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                finish();
            }
        });
        //activity跳转activity，密码
        zh_xy1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(ZhanghaoActivity.this,MimaActivity.class);
                startActivityForResult(intent1,1);
            }
        });
        //activity跳转activity，密码
        zh_zxzh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(ZhanghaoActivity.this,LoginActivity.class);
                startActivityForResult(intent1,1);
            }
        });

    }

    private void init() {
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){

        }else {

        }
    }
}