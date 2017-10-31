package com.example.nazmuddinmavliwala.credr.ui.items.models;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class ItemVO {
    private final String name;
    private final String imgUri;
    private final String price;

    public ItemVO(String name, String imgUri, String price) {

        this.name = name;
        this.imgUri = imgUri;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getImgUri() {
        return imgUri;
    }

    public String getPrice() {
        return price;
    }
}
