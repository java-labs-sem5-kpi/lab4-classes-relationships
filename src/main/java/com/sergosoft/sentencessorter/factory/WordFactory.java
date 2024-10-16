package com.sergosoft.sentencessorter.factory;

import com.sergosoft.sentencessorter.entity.sentencepart.impl.Letter;
import com.sergosoft.sentencessorter.entity.sentencepart.impl.PunctuationMark;
import com.sergosoft.sentencessorter.entity.Word;

public class WordFactory {
    public static Word createWord(StringBuilder rawWord) {
        if(rawWord == null || rawWord.isEmpty()) {
            throw new IllegalArgumentException("Raw word cannot be null or empty.");
        }

        Letter[] letters = new Letter[rawWord.length()];

        for(int i = 0; i < rawWord.length(); i++) {
            char currentLetter = rawWord.charAt(i);

            if(currentLetter == ' ' || PunctuationMark.isPunctuationMark(currentLetter)) {
                throw new IllegalArgumentException("Word must contain only letters, spaces and punctuation marks are not allowed. Symbol [" + currentLetter + "] was used.");
            }
            letters[i] = new Letter(currentLetter);
        }
        return new Word(letters);
    }
}
