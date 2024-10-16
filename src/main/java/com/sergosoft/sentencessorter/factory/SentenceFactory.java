package com.sergosoft.sentencessorter.factory;

import com.sergosoft.sentencessorter.entity.sentencepart.impl.PunctuationMark;
import com.sergosoft.sentencessorter.entity.Sentence;
import com.sergosoft.sentencessorter.entity.sentencepart.SentencePart;

public class SentenceFactory {

    public static Sentence createSentence(StringBuilder rawSentence) {
        if(rawSentence == null || rawSentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence string cannot be null or empty.");
        }

        StringBuilder[] rawSentenceParts = separateRawSentence(rawSentence);
        SentencePart[] sentenceParts = new SentencePart[rawSentenceParts.length];

        for(int i = 0; i < rawSentenceParts.length; i++) {
            StringBuilder currentSentencePart = rawSentenceParts[i];
            if(currentSentencePart.length() == 1) {
                // if current sentence part is a punctuation mark
                char oneSymbolSentencePart = currentSentencePart.charAt(0);
                if(PunctuationMark.isPunctuationMark(oneSymbolSentencePart)) {
                    sentenceParts[i] = PunctuationMark.fromSymbol(oneSymbolSentencePart);
                    continue;
                }
            }
            // if current sentence is a word
            sentenceParts[i] = WordFactory.createWord(currentSentencePart);
        }
        return new Sentence(sentenceParts);
    }

    private static StringBuilder[] separateRawSentence(StringBuilder rawSentence) {
        String[] rawSentenceParts = rawSentence.toString().split("(?=[\\p{Punct}&&[^']])|(?<=[\\p{Punct}&&[^']])|\\s+");
        StringBuilder[] stringBuilders = new StringBuilder[rawSentenceParts.length];

        for (int i = 0; i < rawSentenceParts.length; i++) {
            stringBuilders[i] = new StringBuilder(rawSentenceParts[i].trim());
        }

        return stringBuilders;
    }
}
