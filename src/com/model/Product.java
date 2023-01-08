package com.model;

public class Product {

    public final ProductType type;
    public final int calories;
    public final int price;

    public Product(ProductType type, int calories, int price) {
        this.type = type;
        this.calories = calories;
        this.price = price;
    }

}



