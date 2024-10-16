package com.sergosoft.sentencessorter.sorter.impl;

import com.sergosoft.sentencessorter.entity.Sentence;
import com.sergosoft.sentencessorter.entity.Text;
import com.sergosoft.sentencessorter.sorter.TextSorter;

import java.util.Arrays;
import java.util.Comparator;

/**
 * The {@code CustomTextSorter} class implements the {@code TextSorter} interface
 * to provide sorting functionality for {@code Text} objects based on the word count
 * in each sentence.
 * <p>
 * This class sorts the sentences of the {@code Text} object in ascending order
 * of the number of sentence elements (words and punctuation marks) contained in each sentence.
 * </p>
 */
public class CustomTextSorter implements TextSorter<Text> {

    /**
     * Sorts the sentences of the given {@code Text} object based on the number of
     * elements (words and punctuation marks) in each sentence.
     *
     * @param textToSort the {@code Text} object whose sentences need to be sorted
     * @return a new {@code Text} object with sentences sorted by the word count
     * @throws IllegalArgumentException if the input {@code Text} object is null
     */
    @Override
    public Text sortByWordCount(Text textToSort) {
        if (textToSort == null) {
            throw new IllegalArgumentException("Input text cannot be null or empty.");
        }

        Sentence[] sentences = textToSort.getSentences();
        // Sort sentences based on the length of sentence elements
        Arrays.sort(sentences, Comparator.comparingInt(sentence -> sentence.getSentenceElements().length));
        return new Text(sentences);
    }
}
