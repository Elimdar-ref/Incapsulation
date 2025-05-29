package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product {

    private int price;

//    public void dfhv() {
//        throw new IllegalArgumentException();
////        }
//    }

    public SimpleProduct(String productName, int price) {
        super(productName);
        if(price <= 0) {
            throw new IllegalArgumentException("Цена продукта ноль");
        }
        this.price = price;
    }

    @Override
    public int getPrice() {
         return this.price;
    }

    @Override
    public boolean isSpecial() {
        return false;
    }
}