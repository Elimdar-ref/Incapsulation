package org.skypro.skyshop.product;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String productName;

    public Product(String productName) {
     if(productName == null || productName.isBlank()) {
        throw new IllegalArgumentException("Неправильное имя для продукта ");
    }
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

    @Override
    public String getSearchTerm() {
        return productName;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    @Override
    public String getName() {
        return productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(productName);
    }
}

