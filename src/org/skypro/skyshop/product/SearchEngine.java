package org.skypro.skyshop.product;

import java.util.Arrays;

import org.skypro.skyshop.product.BestResultNotFound;

public class SearchEngine {
    private final Searchable[] searchableArray;
    private int count = 0;

    public SearchEngine(int size) {
        searchableArray = new Searchable[size];
    }

    public void add(Searchable item) {
        if (count < searchableArray.length) {
            searchableArray[count++] = item;
        }
    }

    public Searchable[] search(String term) {
        Searchable[] results = new Searchable[5];
        int resultCount = 0;
        for (Searchable item : searchableArray) {
            if (item != null && resultCount < 5) {
                if (item.getSearchTerm().contains(term)) {
                    results[resultCount++] = item;
                }
            } else {
                break;
            }
        }
        return results;
    }

    public Searchable[] searchElement(String term) {
        Searchable[] bestResult = null;
        int found = 0;
        int score;
        for (Searchable item : searchableArray) {
            String str = item.getSearchTerm().toLowerCase();
            String subStr = term.toLowerCase();
            score = resultMax(str, subStr);
            if (score > found) {
                found = score;
                bestResult = searchableArray;
            }
            if (bestResult == null) {
                throw new BestResultNotFound("Для поискового запроса: <" + term + ">, " +
                        "не нашлось подходящего результата");
            }
        }
        return bestResult;
    }


    public int resultMax(String str, String subStr) {
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
                "searchableArray=" + Arrays.toString(searchableArray) +
                ", count=" + count +
                '}';
    }
}
