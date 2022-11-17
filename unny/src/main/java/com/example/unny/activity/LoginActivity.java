package com.example.unny.activity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unny.R;
import com.example.unny.tool.spHelper;

import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    TextView tv_zc;
    EditText lg_name,lg_psw;
    Button btn_login;
    SQLiteDatabase db;
    String putStringGender;
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
        lg_name=findViewById(R.id.et_name);
        lg_psw=findViewById(R.id.et_pass);
        btn_login=findViewById(R.id.bu_login);

        //登录注册部分数据库
        db=SQLiteDatabase.openOrCreateDatabase(getCacheDir()+"/note",null);
        try {
            db.execSQL("create table user(id int(100),username varchar(100),password varchar(100),zpassword varchar(100))");
        } catch (Exception e){
            e.printStackTrace();
        }
        SharedPreferences sharedPreferences=getSharedPreferences("lg_name",MODE_PRIVATE);//MODE_PRIVATE模式表示访问权限为本应用

        lg_name.setText(sharedPreferences.getString("lg_name",""));
        lg_psw.setText(sharedPreferences.getString("lg_psw",""));
        //登录按钮
        btn_login.setOnClickListener(view -> {
            if (lg_name.getText().toString().equals("") || lg_psw.getText().toString().equals("")){
                Toast.makeText(LoginActivity.this, "账号或密码不能为空", Toast.LENGTH_SHORT).show();
                return;
            }
            @SuppressLint("Recycle") Cursor cursor=db.rawQuery("select * from user where username='"+lg_name.getText().toString()+"'",null);
            if (cursor.moveToNext()){
                if (cursor.getString(1).equals(lg_psw.getText().toString())){
                    SharedPreferences.Editor editor=getSharedPreferences("lg_name",MODE_PRIVATE).edit();
                    SharedPreferences.Editor user_editor = sharedPreferences.edit();
                    putStringGender = lg_name.getText().toString();
                    user_editor.putString("name", putStringGender);
                    user_editor.commit();//最后提交保存
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
                startActivityForResult(intent, 0);
            }
        });
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data == null) {
            return;
        }
        if (0 == requestCode){
            if (0 ==resultCode){
                String s =data.getStringExtra("mes");

            }
        }
    }

    /**
     *保存登录状态和登录用户名到SharedPreferences中
     */
    private void saveLoginStatus(boolean status,String putStringGender){
        //loginInfo表示文件名
        SharedPreferences sp=getSharedPreferences("lg_psw", MODE_PRIVATE);
        SharedPreferences.Editor editor=sp.edit();//获取编辑器
        editor.putBoolean("isLogin", status);//存入boolean类型的登录状态
        editor.putString("loginUserName", putStringGender);//存入登录状态时的用户名
        editor.commit();//提交修改
    }
}