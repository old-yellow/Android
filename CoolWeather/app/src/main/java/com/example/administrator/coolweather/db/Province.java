package com.example.administrator.coolweather.db;

import org.litepal.crud.LitePalSupport;


/**
 * Created by Administrator on 2019/3/20.
 */

public class Province extends LitePalSupport {

    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }

    private String provinceName;

    private int provinceCode;

}
