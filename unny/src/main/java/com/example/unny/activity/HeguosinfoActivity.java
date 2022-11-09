package com.example.unny.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unny.R;

public class HeguosinfoActivity extends AppCompatActivity {
    String names[]={"江苏无锡阳山水蜜桃","陕西新鲜大黄杏","汶川脱骨脆红李子","澳洲西梅","云南牛奶大青枣","陕西红富士苹果","山西贡梨","潮汕檀香二号甜橄榄"};
    int images[]={R.drawable.taozi,R.drawable.xingzi,R.drawable.lizi,R.drawable.ximei,R.drawable.qingzao,R.drawable.pingguo,R.drawable.gongli,R.drawable.ganlan};
    int images1[]={R.drawable.taozi1,R.drawable.xingzi1,R.drawable.lizi1,R.drawable.ximei1,R.drawable.qingzao1,R.drawable.pingg1,R.drawable.gongli1,R.drawable.ganlan1};
    int images2[]={R.drawable.taozi2,R.drawable.xingzi2,R.drawable.lizi2,R.drawable.ximei2,R.drawable.qingzao2,R.drawable.pingg2,R.drawable.gongli2,R.drawable.ganlan2};
    String price[]={"￥39起","￥23.9起","￥29.8起","￥38.8起","￥17.8起","￥14.9起","￥22.8起","￥29.9起"};
    String xq[]={"江苏无锡阳山水蜜桃 整箱包邮到家 好吃还不贵","陕西新鲜大黄杏 整箱包邮到家 好吃还不贵",
            "汶川脱骨脆红李子 整箱包邮到家 好吃还不贵","澳洲西梅 整箱包邮到家 好吃还不贵",
            "云南牛奶大青枣 整箱包邮到家 好吃还不贵","陕西红富士苹果 整箱包邮到家 好吃还不贵",
            "山西贡梨 整箱包邮到家 好吃还不贵","潮汕檀香二号甜橄榄 整箱包邮到家 好吃还不贵"};
    String bh[]={"100034","355533","234443","644424","454444","766554","873321","382213"};
    String rq[]={"2020-10-21","2020-5-3","2020-3-4","2020-7-2","2020-3-19","2020-6-4","2020-9-10","2020-8-12"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiangguosinfo);
        //获取上一个页面数据
        Intent intent=getIntent();
        int i=intent.getIntExtra("gid",0);
        //获取页面控件
        ImageView iv_ganju=findViewById(R.id.iv_ganju);
        ImageView iv_ganju1=findViewById(R.id.iv_ganju3);
        ImageView iv_ganju3=findViewById(R.id.iv_ganju1);
        TextView iv_dj=findViewById(R.id.iv_dj);
        TextView iv_jj=findViewById(R.id.iv_jj);
        TextView a_mz=findViewById(R.id.a_mz);
        TextView a_bm=findViewById(R.id.a_bm);
        TextView a_sjs=findViewById(R.id.a_sjs);
        ImageView tv_fh=findViewById(R.id.tv_fh);
        //将数据添加到控件
        iv_ganju.setImageResource(images[i]);
        iv_ganju1.setImageResource(images1[i]);
        iv_ganju3.setImageResource(images2[i]);
        iv_dj.setText(price[i]);
        iv_jj.setText(xq[i]);
        a_mz.setText(names[i]);
        a_bm.setText(bh[i]);
        a_sjs.setText(rq[i]);

        tv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v){
                finish();
            }
        });
    }
}