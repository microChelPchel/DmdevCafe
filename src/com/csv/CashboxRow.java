package com.csv;

import java.util.List;

public class CashboxRow implements CsvRow {

    private Integer id;
    private Integer orderNumber;
    private Integer orderPriceSum;

    public CashboxRow(Integer id, Integer orderNumber, Integer orderPriceSum) {
        this.id = id;
        this.orderNumber = orderNumber;
        this.orderPriceSum = orderPriceSum;
    }


    public CashboxRow(String[] columns) {
        this(Integer.valueOf(columns[0]),
                Integer.valueOf(columns[1]),
                Integer.valueOf(columns[2]));
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getOrderPriceSum() {
        return orderPriceSum;
    }

    public void setOrderPriceSum(Integer orderPriceSum) {
        this.orderPriceSum = orderPriceSum;
    }

    @Override
    public List<Object> values() {
        return List.of(id,orderNumber, orderPriceSum);
    }
}

