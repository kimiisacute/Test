package com.example.unny.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBOpenhelpers extends SQLiteOpenHelper {
    private static final String DB_NAME="db";
    public DBOpenhelpers(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
    }

    //初始化数据库
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //创建数据表
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS user(_id integer primary key autoincrement,"+
                "username text,password text)");
        //可继续建表
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }
}
