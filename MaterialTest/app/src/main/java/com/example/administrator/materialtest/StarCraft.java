package com.example.administrator.materialtest;

/**
 * Created by Administrator on 2019/3/15.
 */

public class StarCraft {

    private String name;

    private int imageId;

    public StarCraft(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public String getName(){
        return name;
    }

    public int getImageId() {
        return imageId;
    }
}
