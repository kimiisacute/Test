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

public class TjdzhiActivity extends AppCompatActivity {
    ImageView iv_fh;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tjdzhi);

        iv_fh=findViewById(R.id.iv_fh);
        EditText diz_ku=findViewById(R.id.diz_ku);
        EditText diz_ku1=findViewById(R.id.diz_ku1);
        EditText diz_ku2=findViewById(R.id.diz_ku2);
        EditText diz_ku3=findViewById(R.id.diz_ku3);
        Button dz_qrj=findViewById(R.id.dz_qrj);

        //返回上一页面
        iv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                finish();
            }
        });

        //将数据添加到控件
        dz_qrj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取页面数据
                Tjdz tjdz=new Tjdz();
                tjdz.setRenm(diz_ku.getText().toString());
                tjdz.setPhone(diz_ku1.getText().toString());
                tjdz.setDizi(diz_ku2.getText().toString());
                tjdz.setXdizi(diz_ku3.getText().toString());
                //将数据存到sqlite数据表中
                DizhiDBService dizhiDBService=new DizhiDBService(TjdzhiActivity.this);
                dizhiDBService.addDizhi(tjdz);
                Toast.makeText(TjdzhiActivity.this,"地址已添加",Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(TjdzhiActivity.this,ShouhdzActivity.class);
                startActivity(intent);

            }
        });
    }
}