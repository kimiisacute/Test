package com.example.unny.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unny.R;

public class GrzxActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    //页面控件
    ImageView iv_fh;
    ImageView wo_xy;
    ImageView wo_xy1;
    private Switch wo_xy2;
    ImageView wo_xy3;
    ImageView wo_xy4;
    ImageView wo_xy5;
    ImageView wo_xy6;

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
        wo_xy5=findViewById(R.id.wo_xy5);
        wo_xy6=findViewById(R.id.wo_xy6);

        wo_xy2.setOnCheckedChangeListener(this);

        iv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                finish();
            }
        });

    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){

        }else {

        }
    }
}