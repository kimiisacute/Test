package com.example.unny.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unny.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GanjuActivity extends AppCompatActivity {
    GridView gv_ganju;
    //设置
    String names[]={"四川红心柚子红心蜜柚","云南绿色新鲜迷局果园","四川安岳黄金柠檬5斤新","新鲜海南青金桔小金桔酸","爆汁夏橙新鲜橙子9斤装","血橙9斤现摘现发红橙子",
            "广西武鸣沃柑正宗新鲜","现摘耙耙柑当季水果新"};
    String name1s[]={"整箱10斤送礼水果","现摘无籽柑橘水果","鲜水果皮薄香水鲜甜柠\n" +
            "檬包邮","柠檬小青柠1/3/5斤装整件\n" +
            "免邮\n","当季水果整箱脐橙现摘","新鲜水果当季整箱",
            "当季水果","鲜丑八怪橘子10斤"};
    int images[]={R.drawable.xiyou,R.drawable.juzi,R.drawable.ningmeng,R.drawable.qingju,R.drawable.xiacheng,R.drawable.xuecheng,R.drawable.wogan,R.drawable.papa};
    String price[]={"￥12.8起","￥9.9起","￥10.8起","￥13.9起","￥18.8起","￥14.9起","￥11.8起","￥17.9起"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganju);
        ImageView tv_fh=findViewById(R.id.tv_fh);
        gv_ganju=findViewById(R.id.gv_ganju);
        //封装数据
        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();
        for (int i=0;i< names.length;i++){
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("name",names[i]);
            data.put("name1",name1s[i]);
            data.put("image",images[i]);
            data.put("price",price[i]);
            items.add(data);
        }
        //定义适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(GanjuActivity.this,items,R.layout.fenlei_item,new  String[]{"name","name1",
                "image","price"},new int[]{R.id.tv_xg,R.id.tv_xg1,R.id.iv_xigua,R.id.tv_price,
                R.id.tv_youh,R.id.tv_num});

        gv_ganju.setAdapter(simpleAdapter);
        //事件处理
        gv_ganju.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //页面跳转并传递数据
                Intent intent=new Intent(GanjuActivity.this, GanjusinfoActivity.class);
                intent.putExtra("gid",i);
                startActivity(intent);
            }
        });
        tv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                finish();
            }
        });
    }
}