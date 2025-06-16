package org.skypro.skyshop.article;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.Searchable;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(articleTitle, article.articleTitle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(articleTitle);
    }
}