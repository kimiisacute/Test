package com.example.unny.adapter;

import android.content.Context;;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unny.R;
import com.example.unny.activity.ShoucangActivity;
import com.example.unny.entity.Goods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ShoucangAdapter extends BaseAdapter {
    private Context context;//上下文
    private List<Goods> items;//数据源

    private HashMap<Object, Integer> pichOnMap;//记录子项的选择状态

    public HashMap<Object, Integer> getPichOnMap() {

        return pichOnMap;
    }

    public void setPichOnMap(HashMap<Object, Integer> pichOnMap) {

        this.pichOnMap = pichOnMap;
    }

    //构造方法
    public ShoucangAdapter(Context context, List<Goods> items) {
        this.context = context;
        this.items = items;
        pichOnMap = new HashMap<Object, Integer>();
        //初始化选择框状态为0
        for (int i = 0; i < items.size(); i++) {
            pichOnMap.put(items.get(i).getId(), 0);
        }
    }

    @Override
    public int getCount() {
        //子项的个数
        return items.size();
    }

    @Override
    public Object getItem(int i) {

        return items.get(i);
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        //根据子项布局文件获得每一项的视图
        view = View.inflate(context, R.layout.shoucang_item, null);
        //实例化控件
        CheckBox sc_items;
        ImageView iv_items;
        TextView tv_items_name, tv_items_prices;

        sc_items = view.findViewById(R.id.sc_items);
        iv_items = view.findViewById(R.id.iv_items);
        tv_items_name = view.findViewById(R.id.tv_items_name);
        tv_items_prices = view.findViewById(R.id.tv_items_price);

        //数据转载到控件
        Goods goods = items.get(i);
        iv_items.setImageResource(goods.getImg());
        tv_items_name.setText(goods.getName());
        tv_items_prices.setText(goods.getPrice() + "");

        //监听选择器
        sc_items.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (sc_items.isChecked()) {
                    //选择框被选中，将其状态记录为1
                    pichOnMap.put(items.get(i).getId(), 1);
                } else {
                    pichOnMap.put(items.get(i).getId(), 0);
                }
            }
        });
        //改变选择框的显示
        if (pichOnMap.get(items.get(i).getId()) == 0) {
            sc_items.setChecked(false);
        } else {
            sc_items.setChecked(true);
        }
        return view;
    }
}
