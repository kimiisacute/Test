package com.example.unny.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unny.R;
import com.example.unny.entity.Goods;
import com.example.unny.util.CartDBService;

public class GoodsinfoActivity extends AppCompatActivity {
    String names[]={"佐贺清香草莓","芭尔德温蓝莓","黑布朗甜李子","海沃德猕猴桃","红富士大苹果","蓬莱柿无花果"};
    int images[]={R.drawable.caomei4,R.drawable.lanm1,R.drawable.lizi1,R.drawable.miht1,R.drawable.pingg1,R.drawable.wuhg1};
    int images1[]={R.drawable.caomei3,R.drawable.lanm3,R.drawable.lizi3,R.drawable.miht3,R.drawable.pingg1,R.drawable.wuhg3};
    int images2[]={R.drawable.caomei4,R.drawable.lanm1,R.drawable.lizi1,R.drawable.miht1,R.drawable.pingg1,R.drawable.wuhg1};
    String price[]={"￥18.8","￥20.8","￥13.8","￥14.5","￥12.5","￥18.9"};
    String xq[]={"新鲜现摘佐贺清香草莓 整箱包邮到家 好吃还不贵","新鲜现摘芭尔德温蓝莓 整箱包邮到家 好吃还不贵",
            "新鲜现摘黑布朗李子 整箱包邮到家 好吃还不贵","新鲜现摘海沃德猕猴桃 整箱包邮到家 好吃还不贵",
            "新鲜现摘红富士苹果 整箱包邮到家 好吃还不贵","新鲜现摘蓬莱柿无花果 整箱包邮到家 好吃还不贵"};
    String bh[]={"100034","355533","234443","644424","454444","766554"};
    String rq[]={"2020-10-21","2020-5-3","2020-3-4","2020-7-2","2020-3-19","2020-6-4"};
    String youh[]={"买三送一","买二送一","买三送一","买三送一","买三送一","买三送一"};
    String num[]={"7102人购买","6342人购买","12343人购买","4323人购买","23123人购买","4342人购买"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goodsinfo);
        //获取上一个页面数据
        Intent intent=getIntent();
        int i=intent.getIntExtra("gid",0);
        //获取页面控件
        ImageView iv_caomei4=findViewById(R.id.iv_caomei4);
        ImageView iv_caomei3=findViewById(R.id.iv_caomei3);
        ImageView iv_caomei1=findViewById(R.id.iv_caomei1);
        TextView iv_dj=findViewById(R.id.iv_dj);
        TextView iv_jj=findViewById(R.id.iv_jj);
        TextView a_mz=findViewById(R.id.a_mz);
        TextView a_bm=findViewById(R.id.a_bm);
        TextView a_sjs=findViewById(R.id.a_sjs);
        ImageView tv_fh=findViewById(R.id.tv_fh);
        TextView tv_jgwc=findViewById(R.id.tv_jgwc);
        //将数据添加到控件
        iv_caomei4.setImageResource(images[i]);
        iv_caomei3.setImageResource(images1[i]);
        iv_caomei1.setImageResource(images2[i]);
        iv_dj.setText(price[i]);
        iv_jj.setText(xq[i]);
        a_mz.setText(names[i]);
        a_bm.setText(bh[i]);
        a_sjs.setText(rq[i]);

        tv_fh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View v) {

                finish();
            }
        });
        //加入购物车
        tv_jgwc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void  onClick(View view){
                //获取页面数据
                Goods good=new Goods();
                good.setName(names[i]);
                String s=price[i].substring(1);
                good.setPrice(Float.parseFloat(s));
                good.setNum(1);//购买的数量
                good.setImg(images[i]);
                //将数据存入数据库
                CartDBService cartDBService=new CartDBService(GoodsinfoActivity.this);
                cartDBService.addCart(good);
                Toast.makeText(GoodsinfoActivity.this,"商品已添加",Toast.LENGTH_SHORT).show();
            }
        });
    }
}