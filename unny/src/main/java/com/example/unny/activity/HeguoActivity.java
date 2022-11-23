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

public class HeguoActivity extends AppCompatActivity {
    GridView gv_heguo;
    //设置
    String names[]={"正宗江苏无锡阳山水蜜桃","陕西新鲜大黄杏5斤新鲜","10斤汶川脱骨脆红李子","澳洲西梅宝宝孕妇水果","云南牛奶大青枣新鲜蜜枣",
            "陕西红富士苹果原产地","山西贡梨优质果冰糖蜜梨","正宗潮汕檀香二号甜橄榄"};
    String name1s[]={"水果新鲜桃子白凤湖\n" +"景雨花露超大超甜",
            "水果当季酸甜孕妇贵妃杏\n" +"3整箱现摘杏子",
            "半边红脆甜李5斤\n" +"当季新鲜水果整箱包邮" ,
            "新鲜5斤大西梅鲜果\n" + "鲜智利西梅李子顺丰包邮",
            "当季枣子水果甜脆5斤\n" + "现摘整箱鲜枣包邮",
            "超甜多汁新鲜水果带箱10斤\n" + "整箱包邮",
            "新鲜梨子水果原产地应季\n" + "现摘现发整箱10斤",
            "生吃酥脆甜种青橄榄\n" + "新鲜水果一斤包邮"};
    int images[]={R.drawable.taozi,R.drawable.xingzi,R.drawable.lizi,R.drawable.ximei,R.drawable.qingzao,R.drawable.pingguo,R.drawable.gongli,R.drawable.ganlan};
    String price[]={"￥39起","￥23.9起","￥29.8起","￥38.8起","￥17.8起","￥14.9起","￥22.8起","￥29.9起"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heguo);
        ImageView tv_fh=findViewById(R.id.tv_fh);
        gv_heguo=findViewById(R.id.gv_heguo);
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
        SimpleAdapter simpleAdapter=new SimpleAdapter(HeguoActivity.this,items,R.layout.fenlei_item,new  String[]{"name","name1",
                "image","price"},new int[]{R.id.tv_xg,R.id.tv_xg1,R.id.iv_xigua,R.id.tv_price,
                R.id.tv_youh,R.id.tv_num});

        gv_heguo.setAdapter(simpleAdapter);
        //事件处理
        gv_heguo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //页面跳转并传递数据
                Intent intent=new Intent(HeguoActivity.this, HeguosinfoActivity.class);
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