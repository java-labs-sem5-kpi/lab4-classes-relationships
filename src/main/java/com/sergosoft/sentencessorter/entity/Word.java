package com.sergosoft.sentencessorter.entity;

import com.sergosoft.sentencessorter.entity.sentencepart.impl.Letter;
import com.sergosoft.sentencessorter.entity.sentencepart.SentencePart;

public class Word implements SentencePart {

    private final Letter[] letters;

    public Word(Letter[] letters) {
        if(letters == null || letters.length == 0) {
            throw new IllegalArgumentException("Letters array cannot be null or empty.");
        }
        this.letters = letters;
    }

    public Letter[] getLetters() {
        return letters;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for(Letter letter : letters) {
            stringBuilder.append(letter);
        }
        return stringBuilder.toString();
    }
}
