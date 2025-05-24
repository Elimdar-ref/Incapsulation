package org.skypro.skyshop.product;

public interface Searchable {

    public String getSearchTerm();

    public String getContentType();

    public String getName();

    default String getStringRepresentation() {
        return getName() + " - " + getContentType();

    }
}
