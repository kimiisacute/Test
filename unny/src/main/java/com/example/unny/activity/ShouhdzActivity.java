package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unny.R;

public class ShouhdzActivity extends AppCompatActivity {
    ImageView dz_xg;
    TextView tjdz;
    ImageView iv_fh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouhdz);

        dz_xg=findViewById(R.id.dz_xg);
        tjdz=findViewById(R.id.tjdz);
        iv_fh=findViewById(R.id.iv_fh);

        //跳转修改地址
        dz_xg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(ShouhdzActivity.this,XgdizActivity.class);
                startActivityForResult(intent1,1);
            }
        });
        //跳转添加地址
        tjdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(ShouhdzActivity.this,TjdzhiActivity.class);
                startActivityForResult(intent1,1);
            }
        });

        //返回上一页面
        iv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                finish();
            }
        });
    }
}