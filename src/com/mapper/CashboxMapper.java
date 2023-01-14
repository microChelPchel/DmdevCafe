package com.mapper;

import com.csv.CashboxRow;
import com.model.Order;
import com.model.Product;
import com.service.CashBox;

import java.util.List;

public class CashboxMapper implements Mapper<CashBox, CashboxRow> {

    @Override
    public CashboxRow map(CashBox cashBox) {
        return new CashboxRow(
                cashBox.getId(),
                cashBox.getOrders().size(),
                getOrderPriceSum(cashBox.getOrders())
        );
    }

    private Integer getOrderPriceSum(List<Order> orders) {
        return orders.stream()
                .flatMap(order -> order.products.stream())
                .mapToInt(Product::getPrice)
                .sum();
    }
}
