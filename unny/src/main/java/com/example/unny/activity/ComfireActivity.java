package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unny.R;
import com.example.unny.entity.Goods;
import com.example.unny.util.CartDBService;
import com.example.unny.util.OrderDBService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComfireActivity extends AppCompatActivity {
    ImageView tv_back_comfire,tv_comfire_img;
    TextView tv_comfire_acount,tv_comfire_count,tv_comfire_name,tv_comfire_num,tv_comfire_price;
    TextView tv_comfire;
    ListView list_comfire;
    float totalprice;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comfire);

        tv_back_comfire=findViewById(R.id.tv_back_comfire);
        tv_comfire_acount=findViewById(R.id.tv_comfire_acount);
        tv_comfire_count=findViewById(R.id.tv_comfire_count);
        list_comfire=findViewById(R.id.list_comfire);
        tv_comfire=findViewById(R.id.tv_comfire);
        tv_comfire_num=findViewById(R.id.tv_comfire_num);
        tv_comfire_img=findViewById(R.id.tv_comfire_img);
        tv_comfire_name=findViewById(R.id.tv_comfire_name);
        tv_comfire_price=findViewById(R.id.tv_comfire_price);

        tv_back_comfire.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v) {

                finish();
            }
        });


        //获取Intent中的数据，初始化页面
        Intent intent=getIntent();
        int a=intent.getIntExtra("id",0);
        ArrayList<Goods> goodsList=new ArrayList<Goods>();
        for(int i=0;i<a;i++){
            Goods goods=new Goods();
            goods= (Goods) intent.getSerializableExtra(i+"");
            goodsList.add(goods);
        }
        //封装数据
        List<Map<String,Object>> lists=new ArrayList<Map<String,Object>>();
        for (int i=0;i<goodsList.size();i++){
            Goods goods=goodsList.get(i);
            Map<String ,Object> item=new HashMap<String ,Object>();
            item.put("img",goods.getImg());
            item.put("name",goods.getName());
            item.put("price",goods.getPrice());
            item.put("num",goods.getNum());
            item.put("count",goods.getPrice()*goods.getNum());
            totalprice=totalprice+goods.getPrice()*goods.getNum();
            lists.add(item);
        }
        SimpleAdapter simpleAdapter=new SimpleAdapter(this,lists,R.layout.comfire_item,new String[]{"img","name","price","num","count","acount"},
                new int[]{R.id.tv_comfire_img,R.id.tv_comfire_name,R.id.tv_comfire_price,R.id.tv_comfire_num,R.id.tv_comfire_count,R.id.tv_comfire_acount});
        list_comfire.setAdapter(simpleAdapter);
        //设置总价
        tv_comfire_acount.setText(totalprice+"");
        tv_comfire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                OrderDBService orderDBService=new OrderDBService(ComfireActivity.this);
                orderDBService.addOrder(goodsList,totalprice);
                Intent intent1=new Intent(ComfireActivity.this,OrderSuccessActivity.class);
                startActivity(intent);
            }
        });
    }

}