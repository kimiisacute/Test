package com.example.unny.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unny.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuaActivity extends AppCompatActivity {
    GridView gv_gua;
    //设置
    String names[]={"新鲜现摘8424麒麟西瓜","新疆哈密瓜正宗西州蜜","现摘树上熟 海南红心木","绿宝甜瓜5斤新鲜水果新","甘肃敦煌沙漠戈壁蜜瓜","心想水果包邮当季时令",
            "山东羊角蜜瓜5斤包邮","爆甜现摘正宗黄河蜜瓜"};
    String name1s[]={"美都薄皮脆甜瓜当季","25号薄皮新鲜瓜","瓜牛奶木瓜5斤/10斤","鲜包邮当季","西州蜜兰州白兰瓜","小香瓜包邮",
            "当季现摘孕妇水果","斤整箱新鲜水果"};
    int images[]={R.drawable.xigua,R.drawable.xianggua,R.drawable.mugua,R.drawable.tiangua,R.drawable.migua,R.drawable.xiaoxg,R.drawable.yangjiaomi,R.drawable.huangmigua};
    String price[]={"￥18.8起","￥69.9起","￥57起","￥16.9起","￥28.8起","￥16.9起","￥31.8起","￥19.9起"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gua);
        gv_gua=findViewById(R.id.gv_gua);
        //封装数据
        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();
        for (int i=0;i< names.length;i++){
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("name",names[i]);
            data.put("image",images[i]);
            data.put("price",price[i]);
            items.add(data);
        }
        //定义适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(GuaActivity.this,items,R.layout.fenlei_item,new  String[]{"name","name1",
                "image","price"},new int[]{R.id.tv_xg,R.id.tv_xg1,R.id.iv_xigua,R.id.tv_price,
                R.id.tv_youh,R.id.tv_num});

        gv_gua.setAdapter(simpleAdapter);
        //事件处理
        gv_gua.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //页面跳转并传递数据
                Intent intent=new Intent(GuaActivity.this, GuasinfoActivity.class);
                intent.putExtra("gid",i);
                startActivity(intent);
            }
        });
    }
}