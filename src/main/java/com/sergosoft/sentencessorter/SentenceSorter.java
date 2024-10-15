package com.sergosoft.sentencessorter;

import java.util.Arrays;
import java.util.Comparator;

public class SentenceSorter {

    public StringBuilder sortByWordCount(StringBuilder text) {
        if(text == null) {
            throw new IllegalArgumentException("Input text cannot be null or empty.");
        }

        String[] sentences = text.toString().split("(?<=[.!?])\\s*");
        Arrays.sort(sentences, Comparator.comparingInt(sentence -> sentence.split("\\s+").length));

        StringBuilder sortedText = new StringBuilder();
        for(String sentence : sentences) {
            sortedText.append(sentence).append(" ");
        }
        sortedText.deleteCharAt(sortedText.length() - 1);

        return sortedText;
    }
}
