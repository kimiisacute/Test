package com.example.unny.util;
//操作SQLite数据库基础类
import static java.nio.file.StandardOpenOption.CREATE;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBOpenHelp extends SQLiteOpenHelper {
    private  static final String DB_NAME="fruits.db";
    public DBOpenHelp(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建购物车数据表
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS cart_db(_id integer primary key autoincrement,"+
                "name text,price float,num integer,img long)");//执行创建数据表的语句
        //创建收藏夹数据表
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS sc_db(_id integer primary key autoincrement,"+
                "name text,price float,num integer,img long)");//执行创建数据表的语句
        //订单表
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS order_db(_id integer primary key autoincrement,oTime text,totalPrice float,onum integer)");
        //订单详情表
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS orderDetail_db(_id integer primary key autoincrement,oid integer,pid integer,num integer)");
        //执行创建数据表的语句
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
