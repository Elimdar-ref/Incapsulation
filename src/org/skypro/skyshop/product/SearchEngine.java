package org.skypro.skyshop.product;

import java.util.Arrays;

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

    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchableArray=" + Arrays.toString(searchableArray) +
                ", count=" + count +
                '}';
    }
}
