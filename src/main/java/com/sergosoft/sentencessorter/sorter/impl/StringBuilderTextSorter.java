package com.sergosoft.sentencessorter.sorter.impl;

import com.sergosoft.sentencessorter.sorter.TextSorter;

import java.util.Arrays;
import java.util.Comparator;

public class StringBuilderTextSorter implements TextSorter<StringBuilder> {

    @Override
    public StringBuilder sortByWordCount(StringBuilder textToSort) {
        if(textToSort == null) {
            throw new IllegalArgumentException("Input text cannot be null or empty.");
        }

        String[] sentences = textToSort.toString().split("(?<=[.!?])\\s*");
        Arrays.sort(sentences, Comparator.comparingInt(sentence -> sentence.split("\\s+").length));

        StringBuilder sortedText = new StringBuilder();
        for(String sentence : sentences) {
            sortedText.append(sentence).append(" ");
        }
        sortedText.deleteCharAt(sortedText.length() - 1);

        return sortedText;
    }
}
