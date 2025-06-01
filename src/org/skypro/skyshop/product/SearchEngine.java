package org.skypro.skyshop.product;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.skypro.skyshop.product.BestResultNotFoundException;

public class SearchEngine {
    private final List<Searchable> searchableArray;

    public SearchEngine() {
        searchableArray = new LinkedList<>();
    }

    public void add(Searchable item) {
        searchableArray.add(item);
    }

    public List<Searchable> search(String term) {
        List<Searchable> results = new LinkedList<>();

        for (Searchable item : searchableArray) {
            if (item != null && item.getSearchTerm().contains(term)) {
                    results.add(item);
                }
        }
        return results;
    }

    public Searchable searchElement(String term) {
        Searchable bestResult = null;
        int found = 0;
        int score;
        for (Searchable item : searchableArray) {
            if (item != null) {
                String str = item.getSearchTerm().toLowerCase();
                String subStr = term.toLowerCase();
                score = resultMax(str, subStr);
                if (score > found) {
                    found = score;
                    bestResult = item;
                }
            }
        }
        if (bestResult == null) {
            throw new BestResultNotFoundException( "Для поискового запроса: <" + term + ">, не нашлось подходящего результата");
        }
        return bestResult;
    }


    private int resultMax(String str, String subStr) {
        int score = 0;
        int index = 0;
        int indexSubstr = str.indexOf(subStr, index);
        while (indexSubstr != -1) {
            score++;
            index = indexSubstr + subStr.length();
            indexSubstr = str.indexOf(subStr, index);
        }
        return score;
    }

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchableArray=" + searchableArray +
                ", count=" +
                '}';
    }
}
