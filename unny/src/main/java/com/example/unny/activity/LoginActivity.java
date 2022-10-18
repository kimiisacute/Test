package com.example.unny.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unny.R;

public class LoginActivity extends AppCompatActivity {

    TextView tv_zc;
    EditText lg_name,lg_psw;
    Button btn_login;
    SQLiteDatabase db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        lg_name=findViewById(R.id.et_name);
        lg_psw=findViewById(R.id.et_pass);
        btn_login=findViewById(R.id.bu_login);
        //登录注册部分数据库
        db=SQLiteDatabase.openOrCreateDatabase(getCacheDir()+"/note",null);
        try {
            db.execSQL("create table user(username varchar(100),password varchar(100))");
        } catch (Exception e){
            e.printStackTrace();
        }
        SharedPreferences sharedPreferences=getSharedPreferences("user",0);
        lg_name.setText(sharedPreferences.getString("lg_name",""));
        lg_psw.setText(sharedPreferences.getString("lg_psw",""));
        btn_login.setOnClickListener(view -> {
            if (lg_name.getText().toString().equals("") || lg_psw.getText().toString().equals("")){
                Toast.makeText(LoginActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            @SuppressLint("Recycle") Cursor cursor=db.rawQuery("select * from user where username='"+lg_name.getText().toString()+"'",null);
            if (cursor.moveToNext()){
                if (cursor.getString(1).equals(lg_psw.getText().toString())){
                    SharedPreferences.Editor editor=getSharedPreferences("lg_name",0).edit();
                    Toast.makeText(LoginActivity.this,"登录成功",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    editor.apply();
                }else {
                    Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(LoginActivity.this, "账号不存在", Toast.LENGTH_SHORT).show();
            }
        });
        //注册部分
        tv_zc=findViewById(R.id.tv_zc);
        tv_zc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
}