package com.sergosoft.sentencessorter;

import com.sergosoft.sentencessorter.entity.Text;
import com.sergosoft.sentencessorter.factory.TextFactory;
import com.sergosoft.sentencessorter.sorter.TextSorter;
import com.sergosoft.sentencessorter.sorter.impl.CustomTextSorter;
import com.sergosoft.sentencessorter.sorter.impl.StringBuilderTextSorter;

public class Main {
    public static void main(String[] args) {
        StringBuilder textToSortBuilder = new StringBuilder("Sample text to sort. Just try in out here! See ya. Ok?");
        System.out.println("=> StringBuilder text sorter (lab2)");
        textSortExample(textToSortBuilder, new StringBuilderTextSorter());

        Text customTextToSort = TextFactory.createText(textToSortBuilder);
        System.out.println("\n=> Custom text sorter");
        textSortExample(customTextToSort, new CustomTextSorter());
    }

    public static <T> void textSortExample(T textToSort, TextSorter<T> textSorter) {
        // processing the text
        try {
            System.out.println(textSorter.sortByWordCount(textToSort));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}