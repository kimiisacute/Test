package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;

import com.example.unny.R;

public class BzfkActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener{
    ImageView iv_fh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bzfk);

        iv_fh=findViewById(R.id.iv_fh);

        //返回上一页
        iv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                finish();
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