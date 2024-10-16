package com.sergosoft.sentencessorter.factory;

import com.sergosoft.sentencessorter.entity.sentencepart.impl.Letter;
import com.sergosoft.sentencessorter.entity.sentencepart.impl.PunctuationMark;
import com.sergosoft.sentencessorter.entity.Word;

/**
 * The {@code WordFactory} class provides functionality for creating {@code Word}
 * objects from raw input in the form of a {@code StringBuilder}.
 * <p>
 * This factory ensures that the input consists only of valid letters, and it
 * rejects any input that contains spaces or punctuation marks.
 * </p>
 */
public class WordFactory {

    /**
     * Creates a {@code Word} object from the given raw word string.
     * The method validates the input to ensure it contains only letters,
     * and constructs a {@code Word} object consisting of {@code Letter} objects
     * representing each character in the word.
     *
     * @param rawWord the raw input word as a {@code StringBuilder}
     * @return a {@code Word} object constructed from the letters of the input string
     * @throws IllegalArgumentException if the input string is {@code null}, empty,
     *                                  or contains invalid characters (spaces or punctuation)
     */
    public static Word createWord(StringBuilder rawWord) {
        if (rawWord == null || rawWord.isEmpty()) {
            throw new IllegalArgumentException("Raw word cannot be null or empty.");
        }

        Letter[] letters = new Letter[rawWord.length()];

        // Process each character in the raw word
        for (int i = 0; i < rawWord.length(); i++) {
            char currentLetter = rawWord.charAt(i);

            // Validate that the current character is a valid letter
            if (currentLetter == ' ' || PunctuationMark.isPunctuationMark(currentLetter)) {
                throw new IllegalArgumentException("Word must contain only letters, spaces and punctuation marks are not allowed. Symbol [" + currentLetter + "] was used.");
            }
            letters[i] = new Letter(currentLetter);
        }
        return new Word(letters);
    }
}
