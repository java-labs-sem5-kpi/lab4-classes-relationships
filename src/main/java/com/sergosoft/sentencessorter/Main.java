package com.sergosoft.sentencessorter;

import com.sergosoft.sentencessorter.entity.Text;
import com.sergosoft.sentencessorter.factory.TextFactory;
import com.sergosoft.sentencessorter.sorter.TextSorter;
import com.sergosoft.sentencessorter.sorter.impl.CustomTextSorter;

public class Main {
    public static void main(String[] args) {
        // Provide text to sort here
        Text text = TextFactory.createText("Sample text to sort. Just try in out here! See ya. Ok?");

        // processing the text
        TextSorter<Text> textSorter = new CustomTextSorter();
        try {
            System.out.println(textSorter.sortByWordCount(text));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}