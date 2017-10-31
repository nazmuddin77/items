package com.example.domain.models;

/**
 * Created by nazmuddinmavliwala on 31/10/2017.
 */

public class Item {

    private final String name;
    private final String imgUri;
    private final String price;

    public String getName() {
        return name;
    }

    public String getImgUri() {
        return imgUri;
    }

    public String getPrice() {
        return price;
    }

    public Item(String name, String imgUri, String price) {

        this.name = name;
        this.imgUri = imgUri;
        this.price = price;
    }
}
