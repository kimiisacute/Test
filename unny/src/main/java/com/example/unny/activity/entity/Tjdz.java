package com.example.unny.activity.entity;

import java.io.Serializable;
/*
地址类
 */
public class Tjdz implements Serializable {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;
    private String renm;
    private String phone;
    private String dizi;
    private String xdizi;

    public String getRenm() {
        return renm;
    }

    public void setRenm(String renm) {
        this.renm = renm;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDizi() {
        return dizi;
    }

    public void setDizi(String dizi) {
        this.dizi = dizi;
    }

    public String getXdizi() {
        return xdizi;
    }

    public void setXdizi(String xdizi) {
        this.xdizi = xdizi;
    }
}
