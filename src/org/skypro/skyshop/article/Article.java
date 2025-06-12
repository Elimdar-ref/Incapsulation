package org.skypro.skyshop.article;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.Searchable;

public class Article {

    public String articleTitle;
    public String textTitle;

    public Article(String articleTitle, String textTitle) {
        this.articleTitle = articleTitle;
        this.textTitle = textTitle;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public String getTextTitle() {
        return textTitle;
    }

    @Override
    public String toString() {
        return articleTitle + textTitle;
    }
}