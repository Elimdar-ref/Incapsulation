package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.product.*;

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

        System.out.println();
        SearchEngine searchEngine = new SearchEngine(5);

        searchEngine.add(banana);
        searchEngine.add(orange);
        searchEngine.add(watermelon);

        Article article1 = new Article("Хлеб", "Состав хлеба");
        Article article2 = new Article("Сыр", "История создание продукта");
        Article article3 = new Article("Яицо", "Полезный свойства");
//        searchEngine.add(article1);
//        searchEngine.add(article2);
        System.out.println(article2.getArticleTitle());
        System.out.println(article2.getTextTitle());

        System.out.println(Arrays.toString(searchEngine.search("Мясо")));
        System.out.println(Arrays.toString(searchEngine.search("Яицо")));
    }
}


