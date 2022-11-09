package com.example.unny.activity;


import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
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
import com.example.unny.entity.Goods;
import com.example.unny.util.CartDBService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CartActivity extends AppCompatActivity implements CartAdapter.RefreshPriceInterface{
    ListView list_cart;
    CheckBox rb_all;
    TextView tv_acount,tv_count,tv_cleanAll;
    ImageView tv_back;
    List<Goods> items;

    //申明两个变量
    private float totalCount,totalPrice;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        list_cart=findViewById(R.id.list_cart);
        rb_all=findViewById(R.id.rb_all);
        tv_acount=findViewById(R.id.tv_acount);
        tv_back=findViewById(R.id.tv_back);
        tv_count=findViewById(R.id.tv_count);
        tv_cleanAll=findViewById(R.id.tv_cleanAll);

        //查询数据库
        CartDBService cartDBService=new CartDBService(this);
        items=cartDBService.getAllCart();

        //实例化适配器
        CartAdapter cartAdapter=new CartAdapter(this,items);
        list_cart.setAdapter(cartAdapter);

        //制定当前类为接口的实现类
        cartAdapter.setRefreshPriceInterface(this);

        tv_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v) {

                finish();
            }
        });


        //实现删除功能
        //tv_cleanAll.setOnClickListener(new View.OnClickListener() {
            //@Override
            //public void onClick(View view) {
                    //Toast.makeText(CartActivity.this,"已删除选中的商品",Toast.LENGTH_LONG).show();
                    //Intent intent=new Intent(CartActivity.this,CartActivity.class);
                    //被选中的项目
                    //HashMap<Object,Integer> map=cartAdapter.getPichOnMap();
                    //int id[]=new int[items.size()];
                    //int k=0;
                    //for (int i=0;i<items.size();i++){
                    //if (map.get(items.get(i).getId())==1){
                        //id[k]=i;
                        //k--;
                    //}
                    //}
                //要求适配器重新加载数据
                //cartAdapter.setPichOnMap(map);
                //cartAdapter.notifyDataSetChanged();
                //intent.putExtra("id",id);
               // startActivity(intent);
            //}
            //});


        //实现全选功能
        rb_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                HashMap <Object,Integer> map=cartAdapter.getPichOnMap();
                boolean isCheck=false;
                boolean isUnCheck=false;
                Iterator iterator=map.entrySet().iterator();
                while (iterator.hasNext()){
                    Map.Entry entry=(Map.Entry) iterator.next();
                    if (Integer.valueOf(entry.getValue().toString())==1){
                        isCheck=true;
                    }else {
                        isUnCheck=true;
                    }
                }
                if (isCheck==true && isUnCheck==false){
                    //已经全选，做反选
                    for (int i=0;i<items.size();i++){
                        map.put(items.get(i).getId(),0);
                    }
                    rb_all.setChecked(false);
                }else if(isCheck==false && isUnCheck==true){
                    //一个没选，做全选中
                    for (int i=0;i<items.size();i++){
                        map.put(items.get(i).getId(),1);
                    }
                    rb_all.setChecked(true);
                }
                priceControl(map);
                cartAdapter.setPichOnMap(map);
                cartAdapter.notifyDataSetChanged();
            }
        });
        //实现结算
        tv_count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (totalCount<=0){
                    Toast.makeText(CartActivity.this,"请选择需要付款的商品",Toast.LENGTH_LONG).show();
                }else {
                    Intent intent=new Intent(CartActivity.this,ComfireActivity.class);
                    //被选中的项目
                    HashMap<Object,Integer> map=cartAdapter.getPichOnMap();
                    //int id[]=new int[items.size()];
                    int a=0;
                    for (int i=0;i<items.size();i++){
                        if (map.get(items.get(i).getId())==1){
                            intent.putExtra(a+"", items.get(i));
                            //id[a]=i;
                            a++;
                        }
                    }
                    intent.putExtra("id",a);
                    startActivity(intent);
                }
            }
        });
    }


    @Override
    public void refreshPrice(HashMap<Object, Integer> pitchOnMap) {
        priceControl(pitchOnMap);
    }

    public void priceControl(HashMap<Object, Integer> pitchOnMap) {
        //控制总价的显示
        totalCount=0;
        totalPrice=0;
        for (int i=0;i<items.size();i++){
            if(pitchOnMap.get(items.get(i).getId())==1){
                totalPrice=totalPrice+items.get(i).getPrice()*items.get(i).getNum();
                totalCount=totalCount+totalPrice;
            }
        }
        tv_acount.setText(totalCount+"");
    }

}