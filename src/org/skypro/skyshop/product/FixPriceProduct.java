package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final String SCREAMING_SNAKE_CASE = "Цена";
    public static final int fixedPrice = 30;

    public FixPriceProduct(String productName) {
        super(productName);
    }

    @Override
    public int getPrice() {
        return fixedPrice;
    }

    @Override
    public String toString() {
        return getProductName() + " c фиксированной ценой " + getPrice();
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
