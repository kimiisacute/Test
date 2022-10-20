package com.example.unny.framgement;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import com.example.unny.R;
import com.example.unny.activity.CartActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class GouacheFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_gouwuche,container,false);
        //从视图中获得控件
        ImageView tv_back=view.findViewById(R.id.tv_back);
        RadioButton rb_all=view.findViewById(R.id.rb_all);
        TextView tv_cleanAll=view.findViewById(R.id.tv_cleanAll);
        RadioButton tv_all=view.findViewById(R.id.tv_all);
        TextView tv_cont=view.findViewById(R.id.tv_count);
        // 定义数据
        String name[]={"佐贺清香草莓","芭尔德温蓝莓","黑布朗甜李子","海沃德猕猴桃","红富士大苹果","蓬莱柿无花果"};
        int image[]={R.drawable.caomei4,R.drawable.lanm2,R.drawable.lizi2,R.drawable.miht2,R.drawable.pingg1,R.drawable.wuhg1};
        String price[]={"￥9.8","￥9.8","￥6.8","￥8.8","￥6.8","￥8.8"};
        String num[]={"2","3","2","5","2","4"};
        //封装数据
        List<Map<String,Object>> items=new ArrayList<Map<String,Object>>();
        for (int i=0;i< name.length;i++){
            Map<String,Object> data=new HashMap<String,Object>();
            data.put("name",name[i]);
            data.put("image",image[i]);
            data.put("price",price[i]);
            data.put("num",num[i]);
            items.add(data);
        }
        //定义适配器
        SimpleAdapter simpleAdapter=new SimpleAdapter(getActivity(),items,R.layout.cart_item,new  String[]{"name",
                "image","price","num"},new int[]{R.id.tv_items_name,R.id.iv_items,R.id.tv_items_price, R.id.tv_items_num});
        //实例化ListView并添加适配器
        ListView list_cart=view.findViewById(R.id.list_cart);
        list_cart.setAdapter(simpleAdapter);
        //事件处理
        list_cart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                //页面跳转并传递数据
                Intent intent=new Intent(getActivity(), CartActivity.class);
                intent.putExtra("id",i);
                startActivity(intent);
            }
        });
        return view;
    }
}