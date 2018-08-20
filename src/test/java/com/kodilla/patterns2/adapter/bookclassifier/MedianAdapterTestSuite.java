package com.kodilla.patterns2.adapter.bookclassifier;

import com.kodilla.patterns2.adapter.MedianAdapter;
import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;

public class MedianAdapterTestSuite {
    @Test
    public void publicationYearMedianTest() {
        //Given
        Set<Book> bookSet = new HashSet<>();
        bookSet.add(new Book("King", "TO", 1987, "123456"));
        bookSet.add(new Book("King", "TO", 2000, "123456"));
        bookSet.add(new Book("King", "TO", 1994, "123456"));
        bookSet.add(new Book("King", "TO", 2005, "123456"));
        MedianAdapter medianAdapter = new MedianAdapter();

        //When
        int myYear = medianAdapter.publicationYearMedian(bookSet);

        //Then
        assertEquals(2000, myYear);
    }
}

