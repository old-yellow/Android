package com.example.administrator.litepaltest;

import org.litepal.crud.DataSupport;
import org.litepal.crud.LitePalSupport;

/**
 * Created by Administrator on 2018/11/6.
 */

public class Book extends LitePalSupport{

    private int id;

    //控制版本
    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    private String press;

    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private String name;

    private int pages;

    private double price;

}
