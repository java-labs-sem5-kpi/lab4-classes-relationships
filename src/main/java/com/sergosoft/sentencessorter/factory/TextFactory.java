package com.sergosoft.sentencessorter.factory;

import com.sergosoft.sentencessorter.entity.Sentence;
import com.sergosoft.sentencessorter.entity.Text;

public class TextFactory {
    public static Text createText(String rawText) {
        if(rawText == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }
        if(rawText.isEmpty()) {
            return new Text();
        }

        String[] rawSentences = split(rawText);
        Sentence[] sentences = new Sentence[rawSentences.length];

        for(int i = 0; i < rawSentences.length; i++) {
            sentences[i] = SentenceFactory.createSentence(rawSentences[i]);
        }
        return new Text(sentences);
    }

    private static String[] split(String rawText) {
        String[] rawSentences = rawText.split("(?<=[.!?])\\s*");
        for (int i = 0; i < rawSentences.length; i++) {
            rawSentences[i] = rawSentences[i].trim();
        }
        return rawSentences;
    }
}
