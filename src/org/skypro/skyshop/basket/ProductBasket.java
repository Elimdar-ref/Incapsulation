package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.Arrays;

import static org.skypro.skyshop.product.FixPriceProduct.fixedPrice;

public class ProductBasket {
    private final Product[] basket = new Product[5];

    public void addProduct(Product product) {
        for (int i = 0; i < basket.length; i++) {
            if (basket[i] == null) {
                basket[i] = product;
                return;
            }
        }
        System.out.println("Невозможно добавить продукт");
    }

    public int totalPrice() {
        int fullprice = 0;
        for (Product product : basket) {
            if (product != null) {
                fullprice += product.getPrice();
            }
        }
        return fullprice;
    }

    public void printBasket() {
        boolean isEmpty = true;
        int count = 0;
        for (Product product : basket) {
            if (product != null) {
                System.out.println(product);
                if (product.isSpecial()) {
                    count++;
                }
                isEmpty = false;
            }
        }
        if (isEmpty) {
            System.out.println("В корзине пусто ");
        } else {
            System.out.println("Итого: " + totalPrice());
            System.out.println("Специальных товаров: " + count);
        }
    }

    public boolean checkProductByName(String name) {
        for (Product product : basket) {
            if (product != null && product.getProductName().equals(name)) {
                return true;
            }
        }
        return false;
    }
        public void clearBasket() {
            Arrays.fill(basket, null);
        }
}