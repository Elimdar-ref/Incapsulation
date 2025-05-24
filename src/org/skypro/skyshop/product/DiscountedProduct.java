package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {

    private int basePrice;
    private double discount;

    public DiscountedProduct(String productName, int basePrice, double discount) {
        super(productName);
        this.basePrice = basePrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return (int) (basePrice * (1 - discount / 100.00));
    }

    @Override
    public String toString() {
        return getProductName() + " со скидкой " + getPrice() + " : " + basePrice + " (скидка " + discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }

//    @Override
//    public String getSearchTerm() {
//        return super.getSearchTerm();
//    }
}