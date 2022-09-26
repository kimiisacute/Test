package com.example.unny.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.unny.R;
import com.example.unny.framgement.FenLeiFragment;
import com.example.unny.framgement.GouWuCheFragment;
import com.example.unny.framgement.HomeFragment;
import com.example.unny.framgement.WoDeFragment;

/*
首页实现导航栏切换
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ImageView iv_shouye,iv_gouwuche,iv_fenlei,iv_wode;//导航栏四个图片
    FragmentManager fragmentManager;//管理器
    FragmentTransaction fragmentTransaction;//事务管理
    FrameLayout frame_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iv_shouye=findViewById(R.id.navigate_shouye);
        iv_fenlei=findViewById(R.id.navigate_fenlei);
        iv_gouwuche=findViewById(R.id.navigate_gouwuche);
        iv_wode=findViewById(R.id.navigate_wode);
        frame_main=findViewById(R.id.unny_main);

        //实例化碎片管理器
        fragmentManager=getSupportFragmentManager();
        //开启事务
        fragmentTransaction=fragmentManager.beginTransaction();
        //实例化碎片
        HomeFragment homeFragment=new HomeFragment();
        //将首页添加到碎片
        fragmentTransaction.add(R.id.unny_main,homeFragment);
        //提交事务
        fragmentTransaction.commit();


        //添加监听器
        iv_shouye.setOnClickListener(this);
        iv_fenlei.setOnClickListener(this);
        iv_gouwuche.setOnClickListener(this);
        iv_wode.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //实例化碎片管理器
        fragmentManager=getSupportFragmentManager();
        //开启事务
        fragmentTransaction=fragmentManager.beginTransaction();
        switch (v.getId()){
            case R.id.navigate_shouye:
                //实例化碎片
                HomeFragment homeFragment=new HomeFragment();
                //将首页添加到碎片
                fragmentTransaction.replace(R.id.unny_main,homeFragment);
                //提交事务
                fragmentTransaction.commit();
                break;
            case R.id.navigate_fenlei:
                FenLeiFragment fenleiFragment=new FenLeiFragment();
                fragmentTransaction.replace(R.id.unny_main,fenleiFragment);
                fragmentTransaction.commit();
                break;
            case R.id.navigate_gouwuche:
                GouWuCheFragment gouwucheFragment=new GouWuCheFragment();
                fragmentTransaction.replace(R.id.unny_main,gouwucheFragment);
                fragmentTransaction.commit();
                break;
            case R.id.navigate_wode:
                WoDeFragment wodeFragment=new WoDeFragment();
                fragmentTransaction.replace(R.id.unny_main,wodeFragment);
                fragmentTransaction.commit();
                break;
        }
    }
}