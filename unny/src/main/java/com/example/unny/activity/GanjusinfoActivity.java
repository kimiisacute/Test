package com.example.unny.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.unny.R;
import com.example.unny.entity.Goods;
import com.example.unny.util.CartDBService;

public class GanjusinfoActivity extends AppCompatActivity {
    String names[]={"四川红心柚","云南绿色柑橘","四川安岳黄金柠檬","海南青金桔","夏橙新鲜橙子","血橙9斤现摘","广西武鸣沃柑正宗新鲜","现摘耙耙柑当季水果新"};
    int images[]={R.drawable.xiyou,R.drawable.qingju1,R.drawable.ningmeng,R.drawable.qingju,R.drawable.xiacheng,R.drawable.xuecheng,R.drawable.wogan,R.drawable.papa};
    int images1[]={R.drawable.xiyou1,R.drawable.qingju1,R.drawable.ningmeng1,R.drawable.jingju1,R.drawable.xiacheng1,R.drawable.xuecheng1,R.drawable.wogan1,R.drawable.papa1};
    int images2[]={R.drawable.xiyou2,R.drawable.qingju2,R.drawable.nengmeng2,R.drawable.jingju2,R.drawable.xiacheng2,R.drawable.xuecheng2,R.drawable.wogan2,R.drawable.papa2};
    String price[]={"￥12.8起","￥9.9起","￥10.8起","￥13.9起","￥18.8起","￥14.9起","￥11.8起","￥17.9起"};
    String xq[]={"四川红心柚 整箱包邮到家 好吃还不贵","云南绿色柑橘 整箱包邮到家 好吃还不贵",
            "四川安岳黄金柠檬 整箱包邮到家 好吃还不贵","海南青金桔 整箱包邮到家 好吃还不贵",
            "夏橙新鲜橙子 整箱包邮到家 好吃还不贵","血橙9斤现摘 整箱包邮到家 好吃还不贵",
            "广西武鸣沃柑正宗新鲜 整箱包邮到家 好吃还不贵","现摘耙耙柑当季水果新 整箱包邮到家 好吃还不贵"};
    String bh[]={"100034","355533","234443","644424","454444","766554","873321","382213"};
    String rq[]={"2020-10-21","2020-5-3","2020-3-4","2020-7-2","2020-3-19","2020-6-4","2020-9-10","2020-8-12"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ganjusinfo);
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
        Button tv_shoucang=findViewById(R.id.tv_shoucang);
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
        //加入收藏夹
        tv_shoucang.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                //获取页面数据
                Goods good=new Goods();
                good.setName(names[i]);
                String s=price[i].substring(1);
                good.setPrice(Float.parseFloat(s));
                good.setImg(images[i]);
                //将数据存入数据库
                CartDBService cartDBService=new CartDBService(GanjusinfoActivity.this);
                cartDBService.addCart(good);
                Toast.makeText(GanjusinfoActivity.this,"商品已收藏",Toast.LENGTH_SHORT).show();
            }
        });
    }
}