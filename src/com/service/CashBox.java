package com.service;

import com.model.Order;
import com.util.CafeConst;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class CashBox implements Runnable {

    private static int idGenerator = 1;

    private Integer id;
    private List<Order> orders = new ArrayList<>();
    private BlockingQueue<Order> allOrders;

    public CashBox(BlockingQueue<Order> allOrders) {
        this.id = idGenerator + 1;
        this.allOrders = allOrders;
    }

    @Override
    public void run() {
        while (true) {
            try {
                var order = allOrders.take();
                Thread.sleep(order.products.size() * CafeConst.PRODUCT_TIME_COST * 1000L);
                orders.add(order);
            } catch (InterruptedException e) {

            }
        }
    }

    public Integer getId() {
        return id;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
