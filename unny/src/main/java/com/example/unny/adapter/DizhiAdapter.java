package com.example.unny.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.unny.R;
import com.example.unny.activity.entity.Tjdz;

import java.util.List;

/*
地址数据适配器
 */
public class DizhiAdapter extends BaseAdapter {
    private Context context;//上下文
    private List<Tjdz> items;//数据源
    //构造方法
    public DizhiAdapter(Context context,List<Tjdz> items){
        this.context=context;
        this.items=items;
    }
    @Override
    public int getCount() {
        //子项个数
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
        //根据子项的布局文件获得每一项的视图
        view=View.inflate(context, R.layout.tjdz_item,null);
        //实例化子项的控件
        ImageView sh_cc;
        TextView dz_mz;
        TextView dz_hm;
        TextView dz_mc;
        TextView dz_xx;
        ImageView dz_xg;
        //实例化控件
        sh_cc=view.findViewById(R.id.sh_cc);
        dz_mz=view.findViewById(R.id.dz_mz);
        dz_hm=view.findViewById(R.id.dz_hm);
        dz_mc=view.findViewById(R.id.dz_mc);
        dz_xx=view.findViewById(R.id.dz_xx);
        dz_xg=view.findViewById(R.id.dz_xg);
        //数据装载到控件
        Tjdz tjdz=items.get(i);
        dz_mz.setText(tjdz.getRenm());
        dz_hm.setText(tjdz.getPhone());
        dz_mc.setText(tjdz.getDizi());
        dz_xx.setText(tjdz.getXdizi());

        return view;
    }
}
