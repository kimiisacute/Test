package com.example.unny.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.unny.entity.Goods;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//操作数据订单信息
public class OrderDBService {
    int order_id;//订单编号
    private DBOpenHelp dbOpenHelp;
    public OrderDBService(Context context){
        dbOpenHelp=new DBOpenHelp(context);
        order_id=0;
    }
    public void addOrder(ArrayList<Goods> goodsList,float totalPrice){
        //打开数据库
        SQLiteDatabase sqLiteDatabase = dbOpenHelp.getWritableDatabase();

        //存入订单
        for (int i=0;i<goodsList.size();i++){
            order_id++;
            ContentValues values=new ContentValues();
            values.put("totalPrice",totalPrice);
            values.put("oid",order_id);
            values.put("name",goodsList.get(i).getName());
            values.put("img",goodsList.get(i).getImg());
            values.put("price",goodsList.get(i).getPrice());
            values.put("num",goodsList.get(i).getNum());
            sqLiteDatabase.insert("order_db",null,values);
        }
        //关闭数据库
        sqLiteDatabase.close();
    }
    //查询所有商品
    public List<Goods> getAllOrder(){
        SQLiteDatabase database=dbOpenHelp.getWritableDatabase();
        Cursor cursor=database.query("order_db",null,null,null,null,null,null);
        List<Goods> goodsItems=new ArrayList<Goods>();
        while(cursor.moveToNext()){
            Goods goods=new Goods();
            goods.setId(cursor.getInt(0));
            goods.setName(cursor.getString(1));
            goods.setPrice(cursor.getFloat(2));
            goods.setNum(cursor.getInt(3));
            goods.setImg(cursor.getInt(4));
            goodsItems.add(goods);
        }
        return goodsItems;
    }

    public void addOrder(Goods good) {
    }
}
