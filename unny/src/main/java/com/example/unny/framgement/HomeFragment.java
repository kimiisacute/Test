package com.example.unny.framgement;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.unny.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 首页
 */
public class HomeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view=inflater.inflate(R.layout.fragment_home,container,false);
       //商品推荐
        // 定义数据
        String names[]={"佐贺清香草莓","芭尔德温蓝莓","黑布朗李子","海沃德猕猴桃","红富士苹果","蓬莱柿无花果"};
        int images[]={R.drawable.caomei2,R.drawable.lanm2,R.drawable.lizi2,R.drawable.miht2,R.drawable.pingg2,R.drawable.wuhg2};
        String price[]={"￥18.8","￥20.8","￥3.8","￥4.5","￥2.58","￥8.89"};
        String youh[]={"买三送一","买二送一","买三送一","买三送一","买三送一","买三送一"};
        String num[]={"7102人购买","6342人购买","12343人购买","4323人购买","23123人购买","4342人购买"};
        //封装数据
        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();
        for (int i=0;i< names.length;i++){
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("name",names[i]);
            data.put("image",images[i]);
            data.put("price",price[i]);
            data.put("youh",youh[i]);
            data.put("num",num[i]);
            items.add(data);
        }
        //定义适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(getActivity(),items,R.layout.home_item,new  String[]{"name",
                "image","price","youh","num"},new int[]{R.id.tv_caom,R.id.iv_caom,R.id.tv_price,
                R.id.tv_youh,R.id.tv_num});
        //实例化GridView并添加适配器
        GridView gv_home=view.findViewById(R.id.gv_home);
        gv_home.setAdapter(simpleAdapter);

        return view;
    }
}