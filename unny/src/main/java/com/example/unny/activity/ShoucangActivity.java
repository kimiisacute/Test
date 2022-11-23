package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unny.R;
import com.example.unny.adapter.CartAdapter;
import com.example.unny.adapter.ShoucangAdapter;
import com.example.unny.entity.Goods;
import com.example.unny.util.CartDBService;
import com.example.unny.util.ShoucangDBService;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ShoucangActivity extends AppCompatActivity{
    ListView list_shoucang;
    CheckBox rb_all,rb_items;
    TextView tv_cleanAll;
    ImageView tv_back;
    List<Goods> items;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shoucang);


        list_shoucang= findViewById(R.id.list_shoucang);
        rb_all = findViewById(R.id.rb_all);
        tv_back = findViewById(R.id.tv_back);
        tv_cleanAll = findViewById(R.id.tv_cleanAll);
        rb_items = findViewById(R.id.rb_items);


        //查询数据库
        ShoucangDBService shoucangDBService = new ShoucangDBService(this);
        items = shoucangDBService.getAllShoucang();

        //实例化适配器
        ShoucangAdapter shoucangAdapter = new ShoucangAdapter(this, items);
        list_shoucang.setAdapter(shoucangAdapter);

        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });
        //实现全选功能
        rb_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap<Object, Integer> map = shoucangAdapter.getPichOnMap();
                boolean isCheck = false;
                boolean isUnCheck = false;
                Iterator iterator = map.entrySet().iterator();
                while (iterator.hasNext()) {
                    Map.Entry entry = (Map.Entry) iterator.next();
                    if (Integer.valueOf(entry.getValue().toString()) == 1) {
                        isCheck = true;
                    } else {
                        isUnCheck = true;
                    }
                }
                if (isCheck == true && isUnCheck == false) {
                    //已经全选，做反选
                    for (int i = 0; i < items.size(); i++) {
                        map.put(items.get(i).getId(), 0);
                    }
                    rb_all.setChecked(false);
                } else if (isCheck == false && isUnCheck == true) {
                    //一个没选，做全选中
                    for (int i = 0; i < items.size(); i++) {
                        map.put(items.get(i).getId(), 1);
                    }
                    rb_all.setChecked(true);
                }
                shoucangAdapter.setPichOnMap(map);
                shoucangAdapter.notifyDataSetChanged();
            }
        });
    }
}