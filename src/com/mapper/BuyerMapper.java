package com.mapper;

import com.csv.BuyerRow;
import com.model.Order;
import com.model.Product;
import com.service.Buyer;

import java.util.List;

public class BuyerMapper implements Mapper<Buyer, BuyerRow> {

    @Override
    public BuyerRow map(Buyer buyer) {
        return new BuyerRow(
                buyer.getId(),
                buyer.getOrders().size(),
                getCaloriesAvg(buyer.getOrders()),
                getOrderPriceAvg(buyer.getOrders())
        );
    }

    private Double getOrderPriceAvg(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.products.stream())
                .mapToInt(Product::getCalories)
                .average()
                .orElse(0.0);
    }

    private Double getCaloriesAvg(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.products.stream())
                .mapToInt(Product::getPrice)
                .average()
                .orElse(0.0);
    }
}
