package org.skypro.skyshop.product;

import java.util.Objects;

public class Product {
    private String productName;
    private int price;

    public Product(String productName, int price) {
        this.productName = productName;
        this.price = price;

    }

    public String getProductName() {
        return this.productName;
    }

    public int getPrice() {
        return this.price;
    }

//    public boolean productName(String nameToCheck) {
//        return this.name.equals(nameToCheck);
//    }

    public String toString() {
        return "Product" + this.productName + " price=" + this.price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName, price);
    }
}
