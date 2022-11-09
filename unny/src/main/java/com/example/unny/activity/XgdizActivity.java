package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.unny.R;
import com.example.unny.activity.entity.Tjdz;
import com.example.unny.util.DizhiDBService;

public class XgdizActivity extends AppCompatActivity {
    ImageView iv_fh;
    EditText xgdz_ku,xgdz_ku1,xgdz_ku2,xgdz_ku3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xgdiz);

        iv_fh=findViewById(R.id.iv_fh);
        xgdz_ku=findViewById(R.id.xgdz_ku);
        xgdz_ku1=findViewById(R.id.xgdz_ku1);
        xgdz_ku2=findViewById(R.id.xgdz_ku2);
        xgdz_ku3=findViewById(R.id.xgdz_ku3);
        Button qrj=findViewById(R.id.qrj);
        Intent intent=getIntent();
        int id1=intent.getIntExtra("id",0);
        xgdz_ku.setText(intent.getStringExtra("renm"));
        xgdz_ku1.setText(intent.getStringExtra("phone"));
        xgdz_ku2.setText(intent.getStringExtra("dizi"));
        xgdz_ku3.setText(intent.getStringExtra("xdizi"));

        qrj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tjdz tjdz=new Tjdz();
                tjdz.setId(id1);
                tjdz.setRenm(xgdz_ku.getText().toString());
                tjdz.setPhone(xgdz_ku1.getText().toString());
                tjdz.setDizi(xgdz_ku2.getText().toString());
                tjdz.setXdizi(xgdz_ku3.getText().toString());
                //将数据存入SQLite数据表
                DizhiDBService dizhiDBService=new DizhiDBService(XgdizActivity.this);
                dizhiDBService.upddate(tjdz);
                Toast.makeText(XgdizActivity.this,"修改地址成功",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(XgdizActivity.this,ShouhdzActivity.class);
                startActivity(intent);
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