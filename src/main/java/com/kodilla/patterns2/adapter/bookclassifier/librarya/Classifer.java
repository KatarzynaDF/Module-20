package com.kodilla.patterns2.adapter.bookclassifier.librarya;


import java.util.Set;

public interface Classifer {
    int publicationYearMedian(Set<Book> bookSet);
}