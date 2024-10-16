package com.sergosoft.sentencessorter.sorter.impl;

import com.sergosoft.sentencessorter.sorter.TextSorter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The {@code StringBuilderTextSorter} class implements the {@code TextSorter} interface
 * to provide sorting functionality for {@code StringBuilder} objects based on the word count
 * in each sentence.
 * <p>
 * This class sorts sentences contained in a {@code StringBuilder} instance. The sentences
 * are sorted in ascending order based on the number of words they contain.
 * </p>
 */
public class StringBuilderTextSorter implements TextSorter<StringBuilder> {

    /**
     * Sorts the sentences in the given {@code StringBuilder} object by the number of words
     * in each sentence.
     * <p>
     * Sentences are assumed to be separated by punctuation marks such as '.', '!', or '?'.
     * After sorting, the sentences are combined back into a single {@code StringBuilder}
     * object, with one space between each sentence.
     * </p>
     *
     * @param textToSort the {@code StringBuilder} object containing the text to be sorted
     * @return a new {@code StringBuilder} with sentences sorted by word count
     * @throws IllegalArgumentException if the input {@code StringBuilder} object is null
     */
    @Override
    public StringBuilder sortByWordCount(StringBuilder textToSort) {
        if (textToSort == null) {
            throw new IllegalArgumentException("Input text cannot be null or empty.");
        }

        // Split the input into sentences based on punctuation marks
        String[] sentences = textToSort.toString().split("(?<=[.!?])\\s*");

        // Sort sentences based on the number of words
        Arrays.sort(sentences, Comparator.comparingInt(sentence -> sentence.split("\\s+").length));

        // Build a new StringBuilder with sorted sentences
        StringBuilder sortedText = new StringBuilder();
        for (String sentence : sentences) {
            sortedText.append(sentence).append(" ");
        }

        // Remove the trailing space
        sortedText.deleteCharAt(sortedText.length() - 1);

        return sortedText;
    }
}