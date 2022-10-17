package com.example.unny.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unny.R;
import com.example.unny.tool.spHelper;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername;
    private EditText etPassword;
    private String strUsername;
    private String strPassword;
    private Button btnLogin;
    private spHelper sh;
    private Context mContext;
    private CheckBox cbRemember;
    private String isRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mContext = getApplicationContext();   // 获取上下文
        sh = new spHelper(mContext);  // 实例化spHelper，传入上下文参数
        bindView();
    }
    // 绑定控件，同时设置登录按钮的监听事件，实现点击按钮时，获取用户名和密码的字符串，
    // 同时使用spHelper类实例化的对象sh，存储用户名和密码到本地文件中
    private void bindView() {
        etPassword = findViewById(R.id.et_pass);
        etUsername = findViewById(R.id.et_name);
        btnLogin = findViewById(R.id.bu_login);
        cbRemember = findViewById(R.id.cb_Remember);
        // 点击登录按钮事件
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //登录操作

                // 记住密码功能，判断复选框是否勾选，若勾选，讲数据存储到SharedPreference文件中
                if(cbRemember.isChecked()){
                    strUsername = etUsername.getText().toString();
                    strPassword = etPassword.getText().toString();
                    sh.save(strUsername,strPassword,"YES");
                }else{
                    // 若记住密码的复选框未勾选，清除SP中的数据，取消记住用户名和密码
                    sh.clear();
                }
                //跳转

                Toast.makeText(LoginActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();

            }
        });
    }
    // 登录界面的Activity创建或者从后台重新回到前台时调用onStart()方法
    // 我们在此方法中读取sp文件中的“键”为isRemember的值，来确定之前用户是否勾选记住用户名和密码
    // 若之前已勾选（即isRemember的值为YES）, 在读取sp文件中的用户名和密码，获取后后，setText在文本框中
    @Override
    protected void onStart() {
        super.onStart();
        Map<String, String> data = sh.read();
        isRemember = data.get("isRemember");
        if(isRemember.equals("YES")){
            etUsername.setText(data.get("username"));
            etPassword.setText(data.get("password"));
            cbRemember.setChecked(true);
        }
    }

}