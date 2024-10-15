package com.sergosoft.sentencessorter;

public class Main {
    public static void main(String[] args) {
        // Provide text to sort here
        StringBuilder inputText = new StringBuilder("Sample text to sort. Just try in out here! See ya. Ok?");

        // processing the text
        SentenceSorter sentenceSorter = new SentenceSorter();
        try {
            System.out.println(sentenceSorter.sortByWordCount(inputText));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}