package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.unny.R;


/*
*修改密码
 */
public class MimaActivity extends AppCompatActivity{
    ImageView iv_fh;
    private EditText et_name;
    private EditText et_pass;
    private EditText xz_ku;//原密码
    private EditText mm_ku1;//新密码
    private EditText mm_ku2;//再次输入新密码
    private Button qrj;//确认
    private String originalPsw, newPsw, newPswAgain;
    private String   putStringGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mima);
        //设置此界面为竖屏
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        init();
        putStringGender = AnalysisUtils.readLoginUserName(this);

        iv_fh=findViewById(R.id.iv_fh);


        //返回上一页面
        iv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                finish();
            }
        });
    }

    private void init() {
        xz_ku = (EditText) findViewById(R.id.xz_ku);
        mm_ku1 = (EditText) findViewById(R.id.mm_ku1);
        mm_ku2 = (EditText) findViewById(R.id.mm_ku2);
        qrj = (Button) findViewById(R.id.qrj);


        qrj.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
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
                    Toast.makeText(MimaActivity.this, "新密码设置成功", Toast.LENGTH_SHORT).show();
                    //修改登录成功时保存在SharedPreferences中的密码
                    modifyPsw(newPsw);
                    Intent intent = new Intent(MimaActivity.this, LoginActivity.class);
                    startActivity(intent);
                    ZhanghaoActivity.instance.finish();//关闭设置页
                    MimaActivity.this.finish();//关闭当前页面
                }
            }

            /**
             * 修改登录成功时保存在SharedPreferences中的密码
             */
            private void modifyPsw(String newPsw) {
                String md5Psw = MD5Utils.md5(newPsw);//把密码用MD5加密
                SharedPreferences sp = getSharedPreferences("lg_name", MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();//获取编辑器
                editor.putString(  putStringGender, md5Psw);//保存新密码
                editor.commit();//提交修改
            }
            /**
             * 获取控件上的字符串
             */
            private void getEditString() {
                originalPsw = xz_ku.getText().toString().trim();
                newPsw = mm_ku1.getText().toString().trim();
                newPswAgain = mm_ku2.getText().toString().trim();
            }
        });
    }

}
