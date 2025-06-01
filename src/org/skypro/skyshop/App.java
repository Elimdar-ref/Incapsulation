package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;

import java.util.List;

public class App {
    public static void main(String[] args) {
        SimpleProduct apple = new SimpleProduct("Яблоко", 50);
        SimpleProduct banana = new SimpleProduct("Банан", 70);
        SimpleProduct orange = new SimpleProduct("Апельсин", 100);
        SimpleProduct grape = new SimpleProduct("Виноград", 30);
        SimpleProduct watermelon = new SimpleProduct("Арбуз", 300);
        DiscountedProduct fish = new DiscountedProduct("Рыба", 80, 10);
        DiscountedProduct meat = new DiscountedProduct("Мясо", 100, 20);
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

        System.out.println();
        SearchEngine searchEngine = new SearchEngine();

        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(watermelon);
        searchEngine.add(meat);
        searchEngine.add(fish);
        basket.printBasket();

        Article article1 = new Article("Хлеб", "Состав хлеб");
        Article article2 = new Article("Сыр", "История создание продукта");
        Article article3 = new Article("Яицо", "Полезный свойства");

        System.out.println(article2.getArticleTitle());
        System.out.println(article2.getTextTitle());

        System.out.println(searchEngine.search("Банан"));
        System.out.println(searchEngine.search("Арбуз"));

///Исключения

        try {
            basket.addProduct(new SimpleProduct("    ", 75));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basket.addProduct(new SimpleProduct("Помидор", 0));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            basket.addProduct(new DiscountedProduct("Помидор", 1, 101));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        searchEngine.add(watermelon);
        searchEngine.add(meat);
        searchEngine.add(fish);

        System.out.println("Поиск :");
        try {
            System.out.println(searchEngine.searchElement("Арбуз"));
            System.out.println(searchEngine.searchElement("Банан"));
        } catch (BestResultNotFoundException e) {
            throw new BestResultNotFoundException(e.getMessage());
        } finally {
            System.out.println("Поиск завершен");
        }
//////
        System.out.println("List");
        System.out.println("Корзина");
        basket.addProduct(banana);
        basket.addProduct(orange);
        basket.addProduct(watermelon);
        basket.printBasket();

        List<Product> removed = basket.removeThisProduct(banana.getProductName());
        System.out.println(removed);

        System.out.println("Корзина");
        basket.printBasket();

        List<Product> removed1 = basket.removeThisProduct(grape.getProductName());

        List<Product> removed2 = basket.removeThisProduct(banana.getProductName());

        System.out.println("Корзина");
        basket.printBasket();

        System.out.println("Поиск :");
        try {
            System.out.println(searchEngine.searchElement("Арбуз"));
            System.out.println(searchEngine.searchElement("Банан"));
        } catch (BestResultNotFoundException e) {
            throw new BestResultNotFoundException(e.getMessage());
        } finally {
            System.out.println("Поиск завершен");
        }
        searchEngine.add(banana);
        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(watermelon);

        System.out.println(searchEngine.search("Банан"));
        System.out.println(searchEngine.search("Апельсин"));
    }
}