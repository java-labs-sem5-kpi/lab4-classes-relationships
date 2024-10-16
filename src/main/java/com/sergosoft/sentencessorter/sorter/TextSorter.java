package com.sergosoft.sentencessorter.sorter;

public interface TextSorter<T> {
    T sortByWordCount(T textToSort);
}
