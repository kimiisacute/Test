package com.example.unny.util;

import android.content.ContentValues;
import android.content.Context;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.unny.activity.entity.Tjdz;

import java.util.ArrayList;
import java.util.List;

/*
地址的增删改查
 */
public class DizhiDBService {
    public static final String TABLE_NAME="diz_db";
    private DBOpenHelper dbOpenHelper;
    public DizhiDBService(Context context){
        dbOpenHelper=new DBOpenHelper(context);
    }
    //添加地址到地址
    public void addDizhi(Tjdz tjdz){
        //打开数据库
        SQLiteDatabase sqLiteDatabase=dbOpenHelper.getWritableDatabase();
        //把对象封装成键值对
        ContentValues values=new ContentValues();
        //建为表里的列的名字
        values.put("renm",tjdz.getRenm());
        values.put("phone",tjdz.getPhone());
        values.put("dizi",tjdz.getDizi());
        values.put("xdizi",tjdz.getXdizi());
        //存入数据
        sqLiteDatabase.insert(TABLE_NAME,null,values);
        //关闭数据库
        sqLiteDatabase.close();
    }
    //查询所有地址
    public List<Tjdz> getAllDizhi(){
        //打开数据库
        SQLiteDatabase sqLiteDatabase=dbOpenHelper.getWritableDatabase();
        Cursor cursor=sqLiteDatabase.query(TABLE_NAME,null,null,null,null,null,null);
        List<Tjdz> tjdzItems=new ArrayList<Tjdz>();
        while (cursor.moveToNext()){
            Tjdz tjdz=new Tjdz();
            tjdz.setId(cursor.getInt(0));
            tjdz.setRenm(cursor.getString(1));
            tjdz.setPhone(cursor.getString(2));
            tjdz.setDizi(cursor.getString(3));
            tjdz.setXdizi(cursor.getString(4));
            tjdzItems.add(tjdz);
        }
        return tjdzItems;
    }
    //修改地址
    public void upddate(Tjdz tjdz){
        //打开数据库
        SQLiteDatabase sqLiteDatabase=dbOpenHelper.getWritableDatabase();
        //把对象封装成键值对
        ContentValues values=new ContentValues();
        //建为表里的列的名字
        values.put("renm",tjdz.getRenm());
        values.put("phone",tjdz.getPhone());
        values.put("dizi",tjdz.getDizi());
        values.put("xdizi",tjdz.getXdizi());
        int a=sqLiteDatabase.update("diz_db",values,"_id=?",new String[]{tjdz.getId()+""});
        Log.v("","a="+a);
        Log.v("","id="+tjdz.getId());
        //关闭数据库
        sqLiteDatabase.close();
    }
    //删除
    /*
    public void delete(Tjdz tjdz){
        //打开数据库
        SQLiteDatabase sqLiteDatabase=dbOpenHelper.getWritableDatabase();
        int a1 = sqLiteDatabase.delete("diz_db", "_id=?", new String[]{tjdz.getId()+""});
        sqLiteDatabase.close();

    }
     */
}
