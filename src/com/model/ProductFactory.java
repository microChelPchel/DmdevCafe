package com.model;

public final class ProductFactory {

    private ProductFactory() {

    }

    public static Product get(ProductType type) {
        switch (type) {
            case STEAK:
                return new Product(ProductType.STEAK, 500, 10);
            case SALAD:
                return new Product(ProductType.SALAD, 50, 5);
            case POTATO:
                return new Product(ProductType.POTATO, 300, 3);
            case COLA:
                return new Product(ProductType.COLA, 25, 2);
            case ICE_CREAM:
                return new Product(ProductType.ICE_CREAM, 150, 4);
        }
        return null;
    }


}
