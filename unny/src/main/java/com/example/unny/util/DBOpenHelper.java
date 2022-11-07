package com.example.unny.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

/*
操纵SQLlite数据库基础类
 */
public class DBOpenHelper extends SQLiteOpenHelper {
    private static final String DB_NAME="dizhi.db";
    public DBOpenHelper(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    //初始化数据库
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建数据表
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS diz_db(_id integer primary key autoincrement,"+
                "renm text ,phone text,dizi text,xdizi text)");
        //可继续建表
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
