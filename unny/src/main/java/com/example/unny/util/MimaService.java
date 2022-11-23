package com.example.unny.util;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.unny.activity.entity.Mima;

public class MimaService {
    public static final String TABLE_NAME="user";
    private static SQLiteOpenHelper dbOpenHelpers;
    public MimaService(Context context){
        dbOpenHelpers=new DBOpenhelpers(context);
    }

    //修改地址
    public static void upddate(Mima mima){
        //打开数据库
        SQLiteDatabase sqLiteDatabase=dbOpenHelpers.getWritableDatabase();
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
