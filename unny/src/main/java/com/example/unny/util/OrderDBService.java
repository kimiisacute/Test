package com.example.unny.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.unny.entity.Goods;

import java.util.ArrayList;
import java.util.Date;

//操作数据订单信息
public class OrderDBService {
    public static final String TABLE_NAME="cart_db";
    int order_id;
    private DBOpenHelp dbOpenHelp;
    public OrderDBService(Context context){
        dbOpenHelp=new DBOpenHelp(context);
        order_id=0;
    }
    public void addOrder(ArrayList<Goods> goodsList,float totalPrice){
        //打开数据库
        SQLiteDatabase sqLiteDatabase = dbOpenHelp.getWritableDatabase();
        //存入订单表
        ContentValues values=new ContentValues();
        values.put("oTime",new Date()+"");
        values.put("totalPrice",totalPrice);
        values.put("onum",goodsList.size());
        //存入数据
        sqLiteDatabase.insert(TABLE_NAME,null,values);
        //存入订单详情
        for (int i=0;i<goodsList.size();i++){
            ContentValues values1=new ContentValues();
            values1.put("oid",order_id);
            values1.put("name",goodsList.get(i).getName());
            values1.put("img",goodsList.get(i).getImg());
            values1.put("price",goodsList.get(i).getPrice());
            values1.put("num",goodsList.get(i).getNum());
            sqLiteDatabase.insert(TABLE_NAME,null,values1);
        }

        //关闭数据库
        sqLiteDatabase.close();
    }
}
