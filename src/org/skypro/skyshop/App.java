package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        Product apple = new Product("Яблоко", 50);
        Product banana = new Product("Банан", 70);
        Product orange = new Product("Апельсин", 100);
        Product grape = new Product("Виноград", 200);
        Product watermelon = new Product("Арбуз", 300);

        ProductBasket basket = new ProductBasket();

        basket.addProduct(apple);
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(grape);
        basket.addProduct(watermelon);
        basket.addProduct(watermelon);

        basket.printBasket();

        System.out.println(basket.checkProductByName(banana.getProductName()));

        basket.clearBasket();

        basket.printBasket();

        System.out.println(basket.checkProductByName(banana.getProductName()));
    }
}


