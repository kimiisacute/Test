package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unny.R;
import com.example.unny.activity.entity.Mima;
import com.example.unny.util.MimaService;


/*
*修改密码
 */
public class MimaActivity extends AppCompatActivity{
    ImageView iv_fh;
    TextView tv_login;//Alice
    private EditText xz_ku;//原密码
    private EditText mm_ku1;//新密码
    private EditText mm_ku2;//再次输入新密码
    private Button qrj;//确认
    private String originalPsw, newPsw, newPswAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mima);

        xz_ku = findViewById(R.id.xz_ku);
        mm_ku1 = findViewById(R.id.mm_ku1);
        mm_ku2 = findViewById(R.id.mm_ku2);
        qrj = findViewById(R.id.qrj);
        Intent intent=getIntent();
        int id1=intent.getIntExtra("id",0);
        xz_ku.setText(intent.getStringExtra("password"));
        mm_ku1.setText(intent.getStringExtra("zpassword"));
        mm_ku2.setText(intent.getStringExtra("zcpassword"));

        iv_fh=findViewById(R.id.iv_fh);
        tv_login=findViewById(R.id.tv_login);

        qrj.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                Mima mima = new Mima();
                mima.setId(id1);
                mima.setPassword(xz_ku.getText().toString());

                getEditString();
                if (TextUtils.isEmpty(originalPsw)) {
                    Toast.makeText(MimaActivity.this, "请输入原始密码", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(originalPsw)) {
                    Toast.makeText(MimaActivity.this, "输入的密码与原始密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(newPsw)) {
                    Toast.makeText(MimaActivity.this, "输入的新密码与原始密码不能一致", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(newPsw)) {
                    Toast.makeText(MimaActivity.this, "请输入新密码", Toast.LENGTH_SHORT).show();
                    return;
                } else if (TextUtils.isEmpty(newPswAgain)) {
                    Toast.makeText(MimaActivity.this, "请再次输入新密码", Toast.LENGTH_SHORT).show();
                    return;
                } else if (!newPsw.equals(newPswAgain)) {
                    Toast.makeText(MimaActivity.this, "两次输入的新密码不一致", Toast.LENGTH_SHORT).show();
                    return;
                } else {


                    //将数据存入SQLite数据表
                    mima.setPassword(newPsw);
                    MimaService mimaService = new MimaService(MimaActivity.this);
                    mimaService.upddate(mima);
                    Toast.makeText(MimaActivity.this, "新密码设置成功", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MimaActivity.this, LoginActivity.class);
                    startActivity(intent);
                    ZhanghaoActivity.instance.finish();//关闭设置页
                    MimaActivity.this.finish();//关闭当前页面
                }

            }

            private void getEditString() {
                originalPsw = xz_ku.getText().toString().trim();
                newPsw = mm_ku1.getText().toString().trim();
                newPswAgain = mm_ku2.getText().toString().trim();

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
