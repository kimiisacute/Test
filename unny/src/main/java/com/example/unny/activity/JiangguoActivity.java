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

public class JiangguoActivity extends AppCompatActivity {
    GridView gv_jiangguo;
    //设置
    String names[]={"怡颗莓新鲜红树莓鲜果4","12盒秘鲁蓝莓鲜果新鲜","现摘四季草莓新鲜","正宗广西桂林巨峰葡萄","阳光玫瑰葡萄新鲜整箱", "礼盒装 美国车厘子大樱桃\n" +
                    "2/5斤新鲜水果当季整箱","陕西周至猕猴桃9斤整箱","番石榴红心芭乐5斤水果\n" +
            "新鲜应当季软糯胭脂红"};
    String name1s[]={"盒装 覆盆子稀有水果","水果孕妇当季现水果","大草莓新鲜草莓坏果\n" +
            "包赔包邮" ,"软甜水果现摘现发新鲜\n" +
            "水果带箱5斤包邮","同城晴王无籽葡萄青提\n" +
            "当季特产水果","包邮孕妇黑珍珠4J",
            "亚特大果当季新鲜","广西巴乐整箱包邮"};
    int images[]={R.drawable.shumei,R.drawable.lanmei,R.drawable.caomei,R.drawable.putao,R.drawable.yangguang,R.drawable.chelizi,R.drawable.mihoutao,R.drawable.bale};
    String price[]={"￥108起","￥55起","￥50.8起","￥13.9起","￥14.8起","￥17.9起","￥228起","￥19.9起"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiangguo);
        ImageView tv_fh=findViewById(R.id.tv_fh);
        gv_jiangguo=findViewById(R.id.gv_jiangguo);
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
        SimpleAdapter simpleAdapter=new SimpleAdapter(JiangguoActivity.this,items,R.layout.fenlei_item,new  String[]{"name","name1",
                "image","price"},new int[]{R.id.tv_xg,R.id.tv_xg1,R.id.iv_xigua,R.id.tv_price,
                R.id.tv_youh,R.id.tv_num});

        gv_jiangguo.setAdapter(simpleAdapter);
        //事件处理
        gv_jiangguo.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //页面跳转并传递数据
                Intent intent=new Intent(JiangguoActivity.this, JiangguosinfoActivity.class);
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