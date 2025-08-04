package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    private final Map<String, List<Product>> basket = new TreeMap<>();

    public void addProduct(Product product) {
        List<Product> productList = basket.getOrDefault(product.getName(), new LinkedList<>());
        productList.add(product);
        basket.put(product.getName(), productList);
        }

    public List<Product> removeThisProduct(String productName) {
        List<Product> removedProducts = new LinkedList<>();
        for (List<Product> productList : basket.values()) {
            Iterator<Product> iterator = productList.iterator();
            while (iterator.hasNext()) {
                Product product = iterator.next();
                if (product.getName().equals(productName)) {
                    removedProducts.add(product);
                    iterator.remove();
                }
            }
        }
        return removedProducts;
    }

    public int totalPrice() {
        int fullprice = 0;
        fullprice = basket.values().stream().flatMap(Collection::stream)
                .mapToInt(x -> x.getPrice())
                .sum();
            return fullprice;
        }


    public void printBasket() {
        basket.values().stream().flatMap(Collection::stream).forEach(System.out::println);
            if (basket.isEmpty()) {
                System.out.println("В корзине пусто ");
            } else {
                System.out.println("Итого: " + totalPrice());
                System.out.println("Специальных товаров: " + getSpecialCount());
        }
    }

    private long getSpecialCount() {
        long countSpesial = 0;
        countSpesial = basket.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
        return countSpesial;
    }

    public boolean checkProductByName(String name) {
        for (List<Product> productList : basket.values()) {
            for (Product product : productList) {
                if (product.getProductName().equals(name)) {
                    return true;
                }
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
                '}';
    }

//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        ProductBasket that = (ProductBasket) o;
//        return counter == that.counter && Objects.equals(basket, that.basket);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(basket, counter);
//    }
}
