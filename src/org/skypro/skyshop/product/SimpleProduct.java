package org.skypro.skyshop.product;

import java.util.Objects;

public class SimpleProduct extends Product {

    private int price;

    public SimpleProduct(String productName, int price) {
        super(productName);
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