package org.skypro.skyshop.product;

import java.util.TreeMap;

public interface Searchable {

    public String getSearchTerm();

    public String getContentType();

    public String getName();

    default String getStringRepresentation() {
        return getName() + " - " + getContentType();
    }
}