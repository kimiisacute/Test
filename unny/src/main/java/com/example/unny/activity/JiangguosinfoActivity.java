package com.example.unny.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unny.R;

public class JiangguosinfoActivity extends AppCompatActivity {
    String names[]={"怡颗莓新鲜红树莓","12盒秘鲁蓝莓","现摘四季草莓","正宗广西桂林巨峰葡萄","阳光玫瑰葡萄","美国车厘子大樱桃","陕西周至猕猴桃","番石榴红心芭乐"};
    int images[]={R.drawable.shumei,R.drawable.lanmei,R.drawable.caomei,R.drawable.putao,R.drawable.yangguang,R.drawable.chelizi,R.drawable.mihoutao,R.drawable.bale};
    int images1[]={R.drawable.shumei1,R.drawable.lanmei1,R.drawable.caomei2,R.drawable.putao1,R.drawable.yangguang1,R.drawable.chelizi1,R.drawable.miht1,R.drawable.bale1};
    int images2[]={R.drawable.shumei2,R.drawable.lanmei2,R.drawable.caomei3,R.drawable.putao2,R.drawable.yangguang2,R.drawable.chelizi2,R.drawable.miht2,R.drawable.bale2};
    String price[]={"￥108起","￥55起","￥50.8起","￥13.9起","￥14.8起","￥17.9起","￥228起","￥19.9起"};
    String xq[]={"怡颗莓新鲜红树莓 整箱包邮到家 好吃还不贵","12盒秘鲁蓝莓 整箱包邮到家 好吃还不贵",
            "现摘四季草莓 整箱包邮到家 好吃还不贵","正宗广西桂林巨峰葡萄 整箱包邮到家 好吃还不贵",
            "阳光玫瑰葡萄 整箱包邮到家 好吃还不贵","美国车厘子大樱桃 整箱包邮到家 好吃还不贵",
            "陕西周至猕猴桃 整箱包邮到家 好吃还不贵","番石榴红心芭乐 整箱包邮到家 好吃还不贵"};
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