package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.product.DiscountedProduct;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 50);
        SimpleProduct banana = new SimpleProduct("Банан", 70);
        SimpleProduct orange = new SimpleProduct("Апельсин", 100);
        SimpleProduct grape = new SimpleProduct("Виноград", 200);
        SimpleProduct watermelon = new SimpleProduct("Арбуз", 300);
        DiscountedProduct fish = new DiscountedProduct("Рыба", 80, 10);
        DiscountedProduct meat = new DiscountedProduct("Мясо", 100, 27);
        FixPriceProduct egg = new FixPriceProduct("Яйцо");
        FixPriceProduct tea = new FixPriceProduct("Чай");

        ProductBasket basket = new ProductBasket();

        System.out.println("Корзина");
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(fish);
        basket.addProduct(tea);
        basket.printBasket();

        System.out.println(basket.checkProductByName(banana.getProductName()));

        basket.clearBasket();

        basket.printBasket();

        System.out.println(basket.checkProductByName(banana.getProductName()));
    }
}


