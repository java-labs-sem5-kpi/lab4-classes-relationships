package com.sergosoft.sentencessorter.factory;

import com.sergosoft.sentencessorter.entity.Sentence;
import com.sergosoft.sentencessorter.entity.Text;

public class TextFactory {
    public static Text createText(StringBuilder rawText) {
        if(rawText == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }
        if(rawText.isEmpty()) {
            return new Text();
        }

        StringBuilder[] rawSentences = separateRawTextOnSentences(rawText);
        Sentence[] sentences = new Sentence[rawSentences.length];

        for(int i = 0; i < rawSentences.length; i++) {
            sentences[i] = SentenceFactory.createSentence(rawSentences[i]);
        }
        return new Text(sentences);
    }

    private static StringBuilder[] separateRawTextOnSentences(StringBuilder rawText) {
        String[] rawSentences = rawText.toString().split("(?<=[.!?])\\s*");
        StringBuilder[] sentenceBuilders = new StringBuilder[rawSentences.length];

        for (int i = 0; i < rawSentences.length; i++) {
            sentenceBuilders[i] = new StringBuilder(rawSentences[i].trim());
        }

        return sentenceBuilders;
    }
}
