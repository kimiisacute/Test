package com.example.unny.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unny.R;

public class GuasinfoActivity extends AppCompatActivity {
    String names[]={"8424麒麟西瓜","新疆哈密瓜","海南红心木瓜","绿宝甜瓜","甘肃敦煌蜜瓜","小香瓜","山东羊角蜜","黄河蜜瓜"};
    int images[]={R.drawable.xigua,R.drawable.xianggua,R.drawable.mugua,R.drawable.tiangua,R.drawable.migua,R.drawable.xiaoxg,R.drawable.yangjiaomi,R.drawable.huangmigua};
    int images1[]={R.drawable.xigua1,R.drawable.xianggua1,R.drawable.mugua1,R.drawable.tiangua1,R.drawable.migua1,R.drawable.xiaoxg1,R.drawable.yangjiaomi1,R.drawable.huangmigua1};
    int images2[]={R.drawable.xigua2,R.drawable.xianggua2,R.drawable.mugua2,R.drawable.tiangua2,R.drawable.migua2,R.drawable.xiaoxg2,R.drawable.yangjiaomi2,R.drawable.huangmigua2};
    String price[]={"￥18.8起","￥69.9起","￥57起","￥16.9起","￥28.8起","￥16.9起","￥31.8起","￥19.9起"};
    String xq[]={"新鲜现摘8424麒麟西瓜 整箱包邮到家 好吃还不贵","新疆哈密瓜正宗西州蜜 整箱包邮到家 好吃还不贵",
            "现摘树上熟 海南红心木 整箱包邮到家 好吃还不贵","绿宝甜瓜5斤新鲜水果新 整箱包邮到家 好吃还不贵",
            "心想水果包邮当季时令 整箱包邮到家 好吃还不贵","甘肃敦煌沙漠戈壁蜜瓜 整箱包邮到家 好吃还不贵",
    "山东羊角蜜瓜5斤包邮 整箱包邮到家 好吃还不贵","爆甜现摘正宗黄河蜜瓜 整箱包邮到家 好吃还不贵"};
    String bh[]={"100034","355533","234443","644424","454444","766554","873321","382213"};
    String rq[]={"2020-10-21","2020-5-3","2020-3-4","2020-7-2","2020-3-19","2020-6-4","2020-9-10","2020-8-12"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guasinfo);
        //获取上一个页面数据
        Intent intent=getIntent();
        int i=intent.getIntExtra("gid",0);
        //获取页面控件
        ImageView iv_xigua=findViewById(R.id.iv_xigua);
        ImageView iv_xigua1=findViewById(R.id.iv_xigua3);
        ImageView iv_xigua3=findViewById(R.id.iv_xigua1);
        TextView iv_dj=findViewById(R.id.iv_dj);
        TextView iv_jj=findViewById(R.id.iv_jj);
        TextView a_mz=findViewById(R.id.a_mz);
        TextView a_bm=findViewById(R.id.a_bm);
        TextView a_sjs=findViewById(R.id.a_sjs);
        ImageView tv_fh=findViewById(R.id.tv_fh);
        //将数据添加到控件
        iv_xigua.setImageResource(images[i]);
        iv_xigua1.setImageResource(images1[i]);
        iv_xigua3.setImageResource(images2[i]);
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