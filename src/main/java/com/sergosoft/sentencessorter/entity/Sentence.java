package com.sergosoft.sentencessorter.entity;

import com.sergosoft.sentencessorter.entity.sentencepart.SentencePart;
import com.sergosoft.sentencessorter.entity.sentencepart.impl.PunctuationMark;

import java.util.Arrays;

public class Sentence {

    private final SentencePart[] sentenceParts;

    public Sentence(SentencePart[] sentenceParts) {
        if(sentenceParts == null || Arrays.asList(sentenceParts).contains(null)) {
            throw new IllegalArgumentException("SentenceElement array cannot be null and contain nulls.");
        }
        if (sentenceParts.length < 2) {
            throw new IllegalArgumentException("SentenceElement array with length less than 2 does not represent a sentence.");
        }

        this.sentenceParts = sentenceParts;
    }

    public SentencePart[] getSentenceElements() {
        return sentenceParts;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < sentenceParts.length; i++) {
            SentencePart part = sentenceParts[i];

            if (part instanceof PunctuationMark) {
                stringBuilder.append(part).append(" ");
            } else {
                stringBuilder.append(part);
                if (i+1 < sentenceParts.length && !(sentenceParts[i+1] instanceof PunctuationMark)) {
                    stringBuilder.append(" ");
                }
            }
        }

        if (!stringBuilder.isEmpty() && stringBuilder.charAt(stringBuilder.length() - 1) == ' ') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
