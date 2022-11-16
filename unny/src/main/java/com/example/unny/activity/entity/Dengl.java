package com.example.unny.activity.entity;

import java.io.Serializable;

/*
登录类
 */
public class Dengl implements Serializable {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public String getZpassword() {
        return zpassword;
    }

    public void setZpassword(String zpassword) {
        this.zpassword = zpassword;
    }

    private String zpassword;
}
