package com.sergosoft.sentencessorter.sorter.impl;

import com.sergosoft.sentencessorter.entity.Sentence;
import com.sergosoft.sentencessorter.entity.Text;
import com.sergosoft.sentencessorter.sorter.TextSorter;

import java.util.Arrays;
import java.util.Comparator;

public class CustomTextSorter implements TextSorter<Text> {

    @Override
    public Text sortByWordCount(Text textToSort) {
        if(textToSort == null) {
            throw new IllegalArgumentException("Input text cannot be null or empty.");
        }

        Sentence[] sentences = textToSort.getSentences();
        Arrays.sort(sentences, Comparator.comparingInt(sentence -> sentence.getSentenceElements().length));
        return new Text(sentences);
    }
}
