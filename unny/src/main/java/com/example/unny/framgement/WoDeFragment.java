package com.example.unny.framgement;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.unny.R;
import com.example.unny.activity.AddressActivity;
import com.example.unny.activity.CartActivity;
import com.example.unny.activity.LoginActivity;
import com.example.unny.activity.MyinfoActivity;
import com.example.unny.activity.OrderActivity;
import com.example.unny.activity.OutActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我的
 */
public class WoDeFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_wo_de, container, false);
        //从视图中获得了控件
        ImageView myTitle=view.findViewById(R.id.iv_title);
        TextView myName=view.findViewById(R.id.tv_login);
        GridView myList=view.findViewById(R.id.mylist);
        //判断当前用户的状态，如果有用户信息，就自动登录，显示用户头像和姓名；
        //如果没有用户信息，即显示请登录。
        //跳转到登录页面
        myTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
            }
        });
        //设置listview
        String[] names={"待付款","待发货","待收货","待评价","退款/售后"};
        int[]imgs={R.drawable.daifukuan,R.drawable.daifahuo,R.drawable.daishouhuo,R.drawable.daipingjia,R.drawable.tuikuan};
        //定义数据
        List<Map<String,Object>> data=new ArrayList<Map<String,Object>>();
        for (int i=0;i< names.length;i++){
            Map<String,Object> items=new HashMap<String,Object>();
            items.put("name",names[i]);
            items.put("imgs",imgs[i]);
            data.add(items);
        }
        //实例化适配器(当前容器，数据，单项布局文件，map中的键的名称，单项布局文件中控件的id)
        SimpleAdapter simpleAdapter=new SimpleAdapter(getActivity(),data,R.layout.shezhi_layout,new String[]{"name","imgs"},new int[]{R.id.tv_shezhi,R.id.iv_shezhi});
        //将适配器添加到ListView
        myList.setAdapter(simpleAdapter);
        //ListView事件处理
        myList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position){
                    case 0:
                        Intent intent=new Intent(getActivity(), OrderActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        Intent intent1=new Intent(getActivity(), CartActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        Intent intent2=new Intent(getActivity(), AddressActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        Intent intent3=new Intent(getActivity(), MyinfoActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        Intent intent4=new Intent(getActivity(), OutActivity.class);
                        startActivity(intent4);
                        break;

                }
            }
        });
        return view;
    }
}