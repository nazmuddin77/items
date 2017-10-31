package com.example.data.network.models;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class ItemDO {

    private final String name;
    private final String price;
    private final String imgUri;

    public ItemDO(String name, String price, String imgUri) {
        this.name = name;
        this.price = price;
        this.imgUri = imgUri;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getImgUri() {
        return imgUri;
    }
}
