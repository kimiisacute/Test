package com.example.unny.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.unny.activity.entity.Mima;

/*
密码的修改
 */
public class MimaService {
    public static final String TABLE_NAME="user";
    private DBOpenhelpers dbOpenhelpers;
    public MimaService(Context context){
        dbOpenhelpers=new DBOpenhelpers(context);
    }
    //修改密码
    public void upddate(Mima mima){
        //打开数据库
        SQLiteDatabase sqLiteDatabase=dbOpenhelpers.getWritableDatabase();
        //把对象封装成键值对
        ContentValues values=new ContentValues();
        //建为表里的列的名字
        values.put("password",mima.getPassword());

        int a=sqLiteDatabase.update("user",values,"_id=?",new String[]{mima.getId()+""});
        Log.v("","a="+a);
        Log.v("","id="+mima.getId());
        //关闭数据库
        sqLiteDatabase.close();
    }

    
    
}