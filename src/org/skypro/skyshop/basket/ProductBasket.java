package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final List<Product> basket = new LinkedList<>();
    private int counter = 0;

    public void addProduct(Product product) {
        basket.add(product);
        counter++;
    }

    public List<Product> removeThisProduct(String productName) {
        List<Product> removedProducts = new LinkedList<>();
        Iterator<Product> iterator = basket.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getName().equals(productName)) {
                removedProducts.add(product);
                iterator.remove();
            }
        }

        if (removedProducts.isEmpty()) {
            System.out.println("Список пуст");
        }
        return removedProducts;
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
        basket.clear();
    }

    @Override
    public String toString() {
        return "ProductBasket{" +
                "basket=" + basket +
                ", counter=" + counter +
                '}';
    }
}
