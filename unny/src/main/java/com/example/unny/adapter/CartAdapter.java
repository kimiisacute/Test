package com.example.unny.adapter;

import android.content.Context;
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
import com.example.unny.activity.GoodsinfoActivity;
import com.example.unny.entity.Goods;
import com.example.unny.framgement.HomeFragment;

import org.json.JSONArray;

import java.util.HashMap;
import java.util.List;

public class CartAdapter extends BaseAdapter {
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
    public CartAdapter(Context context, List<Goods> items) {
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
        view = View.inflate(context, R.layout.cart_item, null);
        //实例化控件
        CheckBox rb_items;
        ImageView iv_items;
        TextView tv_items_name, tv_items_prices, tv_items_num;
        Button bu_add, bu_sub;

        rb_items = view.findViewById(R.id.rb_items);
        iv_items = view.findViewById(R.id.iv_items);
        tv_items_name = view.findViewById(R.id.tv_items_name);
        tv_items_prices = view.findViewById(R.id.tv_items_price);
        tv_items_num = view.findViewById(R.id.tv_items_num);
        bu_add = view.findViewById(R.id.bu_add);
        bu_sub = view.findViewById(R.id.bu_sub);

        //数据转载到控件
        Goods goods=items.get(i);
        iv_items.setImageResource(goods.getImg());
        tv_items_name.setText(goods.getName());
        tv_items_prices.setText(goods.getPrice()+"");
        tv_items_num.setText(goods.getNum()+"");

        //实现数据增加
        bu_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //当前项的数量
                int num = items.get(i).getNum();
                num++;
                //修改数据源
                items.get(i).setNum(num);
                //要求适配器重新加载数据
                notifyDataSetChanged();
                mrefreshPriceInterface.refreshPrice(pichOnMap);
            }
        });
        //实现数据减少
        bu_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //当前项的数量
                int num = items.get(i).getNum();
                if (num <= 1) {
                    Toast.makeText(context, "数量已经为1", Toast.LENGTH_LONG).show();
                } else {
                    num--;
                    //修改数据源
                    items.get(i).setNum(num);
                    //要求适配器重新加载数据
                    notifyDataSetChanged();
                    mrefreshPriceInterface.refreshPrice(pichOnMap);
                }
            }
        });
        //监听选择器
        rb_items.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (rb_items.isChecked()) {
                    //选择框被选中，将其状态记录为1
                    pichOnMap.put(items.get(i).getId(), 1);
                } else {
                    pichOnMap.put(items.get(i).getId(), 0);
                }
                mrefreshPriceInterface.refreshPrice(pichOnMap);
            }
        });
        //改变选择框的显示
        if (pichOnMap.get(items.get(i).getId())==0){
            rb_items.setChecked(false);
        }else {
            rb_items.setChecked(true);
        }
        return view;
    }
    //定义一个接口
    public interface RefreshPriceInterface{
        //把价格显示到总价
        void refreshPrice(HashMap<Object,Integer> pitchOnMap);
    }
    //定义一个接口对象
    private RefreshPriceInterface mrefreshPriceInterface;
    //向外部暴露一个方法——把价格显示到总价上
    public void setRefreshPriceInterface(RefreshPriceInterface refreshPriceInterface){
        mrefreshPriceInterface=refreshPriceInterface;
    }
}
