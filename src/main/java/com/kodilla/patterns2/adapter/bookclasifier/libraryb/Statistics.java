package com.kodilla.patterns2.adapter.bookclasifier.libraryb;

import java.util.Arrays;
import java.util.Map;

public class Statistics implements BookStatistics {
    @Override
    public int averagePublicationYear(Map<BookSignature, Book> books) {
        if (books.size() == 0) return 0;
        long suma = books.values().stream()
                .map(o -> o.getYearOfPublication())
                .count();
        return (int) suma / books.size();
    }

    @Override
    public int medianPublicationYear(Map<BookSignature, Book> books) {
        if (books.size() == 0) return 0;
        int[] years = new int[books.size()];
        int n = 0;
        for (Book book : books.values()) {
            years[n] = book.getYearOfPublication();
            n++;
        }
        Arrays.sort(years);
        if (years.length % 2 == 0) {
            return years[(int) (years.length / 2 + 0.5)];
        } else {
            return years[years.length / 2];
        }
    }
}