package com.example.unny.tool;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

public class spHelper{
        private Context mContext;

        public spHelper(){
        }

        public spHelper(Context mContext){
            this.mContext = mContext;
        }

        // 定义一个保存数据的方法
        public void save(String username, String password, String isRemember){
            SharedPreferences sp = mContext.getSharedPreferences("my_sp", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString("username",username);
            editor.putString("password",password);
            editor.putString("isRemember",isRemember);
            editor.apply();
            Toast.makeText(mContext,"信息已写入SharedPreference文件中",Toast.LENGTH_SHORT).show();

        }

        //定义一个读取SP文件的方法
        public Map<String, String> read(){
            // 创建一个Map来存储取出来的数据
            Map<String, String> data = new HashMap<String, String>();
            SharedPreferences sp = mContext.getSharedPreferences("my_sp",Context.MODE_PRIVATE);
            data.put("username",sp.getString("username",""));
            data.put("password",sp.getString("password",""));
            data.put("isRemember",sp.getString("isRemember","NO"));
            return data;
        }

        // 清除SP文件里的数据，取消记住用户名和密码功能
        public void clear(){
            SharedPreferences sp = mContext.getSharedPreferences("my_sp", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.clear();
            editor.apply();
        }

}
