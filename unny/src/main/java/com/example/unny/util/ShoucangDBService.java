package com.example.unny.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.unny.activity.CartActivity;
import com.example.unny.activity.GoodsinfoActivity;
import com.example.unny.entity.Goods;

import java.util.ArrayList;
import java.util.List;

public class ShoucangDBService {
    private DBOpenHelp dbOpenHelp;
    private static final String TABLE_NAME="shoucang_db";

    public ShoucangDBService(Context context) {

        dbOpenHelp=new DBOpenHelp(context);
    }

    //添加商品到购物车
    public void addShoucang(Goods goods) {
        //打开数据库
        SQLiteDatabase sqLiteDatabase = dbOpenHelp.getWritableDatabase();
        //把对象封装为键值对
        ContentValues contentvalues = new ContentValues();
        contentvalues.put("name",goods.getName());
        contentvalues.put("price",goods.getPrice());
        contentvalues.put("img",goods.getImg());
        //存入数据
        sqLiteDatabase.insert(TABLE_NAME,null,contentvalues);
        //关闭数据库
        sqLiteDatabase.close();
    }
    //查询所有商品
    public List<Goods> getAllShoucang(){
        SQLiteDatabase database=dbOpenHelp.getWritableDatabase();
        Cursor cursor=database.query(TABLE_NAME,null,null,null,null,null,null);
        List<Goods> goodsItems=new ArrayList<Goods>();
        while(cursor.moveToNext()){
            Goods goods=new Goods();
            goods.setId(cursor.getInt(0));
            goods.setName(cursor.getString(1));
            goods.setPrice(cursor.getFloat(2));
            goods.setImg(cursor.getInt(3));
            goodsItems.add(goods);
        }
        return goodsItems;
    }
}