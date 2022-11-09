package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unny.R;
import com.example.unny.activity.entity.Tjdz;
import com.example.unny.adapter.DizhiAdapter;
import com.example.unny.util.DizhiDBService;

import java.util.List;

public class ShouhdzActivity extends AppCompatActivity {
    ImageView iv_fh;
    ListView list_tj;
    ImageView dz_xg;
    ImageView sh_cc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shouhdz);

        iv_fh = findViewById(R.id.iv_fh);
        Button tjdz=findViewById(R.id.tjdz);
        list_tj=findViewById(R.id.list_tj);
        dz_xg=findViewById(R.id.dz_xg);
        sh_cc=findViewById(R.id.sh_cc);


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

        //修改地址
        list_tj.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Tjdz tjdz= (Tjdz) parent.getItemAtPosition(position);
                Intent intent1=null;
                intent1=new Intent(ShouhdzActivity.this,XgdizActivity.class);
                int id1=tjdz.getId();
                String renm=tjdz.getRenm();
                String phone=tjdz.getPhone();
                String dizi=tjdz.getDizi();
                String xdizi=tjdz.getXdizi();
                intent1.putExtra("id",id1);
                intent1.putExtra("renm",renm);
                intent1.putExtra("phone",phone);
                intent1.putExtra("dizi",dizi);
                intent1.putExtra("xdizi",xdizi);
                startActivity(intent1);

            }
        });
        //删除
        /*
        sh_cc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "删除成功",Toast.LENGTH_SHORT).show();

            }
        });

         */



    }

}