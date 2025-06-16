package org.skypro.skyshop.product;

import java.util.*;

public class SearchEngine {
    private final Set<Searchable> searchableArray;

    public SearchEngine() {
        searchableArray = new HashSet<>();
    }

    public void add(Searchable item) {
        searchableArray.add(item);
    }

    public Set<Searchable> search(String term) {
         Set<Searchable> results = new TreeSet<>(new ReverseComparator());
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

    public static class ReverseComparator implements Comparator<Searchable> {
        @Override
        public int compare(Searchable s1, Searchable s2) {
            int lengthCompare = Integer.compare(s2.getName().length(), s1.getName().length());
            if (lengthCompare == 0) {
                return s1.getName().compareToIgnoreCase(s2.getName());
            }
            return lengthCompare;
        }
    }
    @Override
    public String toString() {
        return "SearchEngine{" +
                "searchableArray=" + searchableArray +
                ", count=" +
                '}';
    }
}