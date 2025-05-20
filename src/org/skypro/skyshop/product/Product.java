package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product {
    private String productName;

    public Product(String productName) {
        this.productName = productName;

    }

    public String getProductName() {
        return this.productName;
    }

    public abstract int getPrice();

    @Override
    public String toString() {
        return getProductName() + " : " + getPrice();
    }

    public boolean isSpecial() {
        return false;
    }
}
