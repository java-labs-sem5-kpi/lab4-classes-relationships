package com.sergosoft.sentencessorter.entity.sentencepart.impl;

import com.sergosoft.sentencessorter.entity.sentencepart.SentencePart;

/**
 * Enum representing different types of punctuation marks.
 * Each enum constant is associated with a specific character mark.
 */
public enum PunctuationMark implements SentencePart {

    DOT('.'),
    COMMA(','),
    DASH('-'),
    EXCLAMATION('!'),
    QUESTION('?');

    private final char mark;

    /**
     * Private constructor for the enum to assign the corresponding character to each punctuation mark.
     *
     * @param mark the character associated with the punctuation mark
     */
    PunctuationMark(char mark) {
        this.mark = mark;
    }

    /**
     * Returns the character representation of the punctuation mark.
     *
     * @return the character of the punctuation mark
     */
    public char getMark() {
        return mark;
    }

    public static PunctuationMark fromSymbol(char symbol) {
        for (PunctuationMark punctuation : PunctuationMark.values()) {
            if (punctuation.mark == symbol) {
                return punctuation;
            }
        }
        throw new IllegalArgumentException("No enum constant for symbol: " + symbol);
    }

    /**
     * Checks if the given character is a punctuation mark defined in the enum.
     *
     * @param character the character to check
     * @return true if the character is a punctuation mark, false otherwise
     */
    public static boolean isPunctuationMark(char character) {
        for (PunctuationMark pm : PunctuationMark.values()) {
            if (pm.getMark() == character) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(mark);
    }
}