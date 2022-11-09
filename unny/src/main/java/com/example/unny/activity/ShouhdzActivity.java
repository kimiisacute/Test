package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.unny.R;
import com.example.unny.activity.entity.Tjdz;
import com.example.unny.adapter.DizhiAdapter;
import com.example.unny.util.DizhiDBService;

import java.util.List;

public class ShouhdzActivity extends AppCompatActivity {
    ImageView iv_fh;
    final int CODE = 0x11;//定义一个校验码
    ListView list_tj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouhdz);

        iv_fh = findViewById(R.id.iv_fh);
        Button tjdz=findViewById(R.id.tjdz);
        list_tj=findViewById(R.id.list_tj);


        //查询数据库
        DizhiDBService dizhiDBService=new DizhiDBService(this);
        List<Tjdz> itmes = dizhiDBService.getAllDizhi();
        //实例化适配器
        DizhiAdapter dizhiAdapter=new DizhiAdapter(this,itmes);
        list_tj.setAdapter(dizhiAdapter);
        //跳转
       tjdz.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent intent=new Intent(ShouhdzActivity.this,TjdzhiActivity.class);
               startActivity(intent);
           }
       });




        //返回上一页面
        iv_fh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }


}