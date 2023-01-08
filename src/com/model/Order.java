package com.model;

import java.util.List;

//TODO: replase version to 17 and replace class to records???
public class Order {

    public final Integer buyerId;
    public final List<Product> products;

    public Order(Integer buyerId, List<Product> products) {
        this.buyerId = buyerId;
        this.products = products;
    }

}
