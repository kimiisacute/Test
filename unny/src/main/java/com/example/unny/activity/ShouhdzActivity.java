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

        //跳转
        tjdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(ShouhdzActivity.this,TjdzhiActivity.class);
                startActivity(intent1);
            }
        });


        //查询数据库
        DizhiDBService dizhiDBService=new DizhiDBService(this);
        List<Tjdz> itmes =dizhiDBService.getAllDizhi();
        //实例化适配器
        DizhiAdapter dizhiAdapter=new DizhiAdapter(this,itmes);
        list_tj.setAdapter(dizhiAdapter);




        //修改地址
        ImageView button = (ImageView) findViewById(R.id.dz_xg);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                TextView l1 = (TextView) findViewById(R.id.dz_mz);
                TextView l2 = (TextView) findViewById(R.id.dz_hm);
                TextView l3 = (TextView) findViewById(R.id.dz_mc);
                TextView l4 = (TextView) findViewById(R.id.dz_xx);

                //读取编辑框的内容保存到bundle中
                Bundle bundle = new Bundle();
                bundle.putCharSequence("u_name", l1.getText().toString());
                bundle.putCharSequence("p_name", l2.getText().toString());
                bundle.putCharSequence("d_name", l3.getText().toString());
                bundle.putCharSequence("z_name", l4.getText().toString());
                //跳转
                intent.setClass(ShouhdzActivity.this, XgdizActivity.class);
                intent.putExtras(bundle);
                startActivityForResult(intent, 0x11);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(resultCode, requestCode, data);
        //判断requestCode和resultCode是否符合条件
        if (requestCode == CODE && resultCode == CODE) {
            //将第二个activity保存的数据填写到编辑框中
            TextView e1 = (TextView) findViewById(R.id.dz_mz);
            TextView e2 = (TextView) findViewById(R.id.dz_hm);
            TextView e3 = (TextView) findViewById(R.id.dz_mc);
            TextView e4 = (TextView) findViewById(R.id.dz_xx);
            //Intent intent=getIntent();
            Bundle bundle = data.getExtras();
            e1.setText(bundle.getString("uname"));                       //将第二个activity保存的数据填写到编辑框中
            e2.setText(bundle.getString("phone"));
            e3.setText(bundle.getString("di"));
            e4.setText(bundle.getString("zhi"));
        }
    }
}