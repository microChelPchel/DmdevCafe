package com.csv;

import java.util.List;

public class BuyerRow implements CsvRow {

    private Integer id;
    private Integer orderNumber;
    private Double caloriesAvg;
    private Double orderPriceAvg;

    public BuyerRow(Integer id, Integer orderNumber, Double caloriesAvg, Double orderPriceAvg) {

        this.id = id;
        this.orderNumber = orderNumber;
        this.caloriesAvg = caloriesAvg;
        this.orderPriceAvg = orderPriceAvg;
    }

    public BuyerRow(String[] columns) {
        this(Integer.valueOf(columns[0]),
                Integer.valueOf(columns[1]),
                Double.valueOf(columns[2]),
                Double.valueOf(columns[3]));
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

    public Double getCaloriesAvg() {
        return caloriesAvg;
    }

    public void setCaloriesAvg(Double caloriesAvg) {
        this.caloriesAvg = caloriesAvg;
    }

    public Double getOrderPriceAvg() {
        return orderPriceAvg;
    }

    public void setOrderPriceAvg(Double orderPriceAvg) {
        this.orderPriceAvg = orderPriceAvg;
    }

    @Override
    public List<Object> values() {
        return List.of(id, orderNumber, caloriesAvg, orderPriceAvg);
    }
}
