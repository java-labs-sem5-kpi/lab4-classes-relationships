package com.sergosoft.sentencessorter.factory;

import com.sergosoft.sentencessorter.entity.sentencepart.impl.PunctuationMark;
import com.sergosoft.sentencessorter.entity.Sentence;
import com.sergosoft.sentencessorter.entity.sentencepart.SentencePart;

/**
 * The {@code SentenceFactory} class provides functionality for creating {@code Sentence}
 * objects from raw input in the form of a {@code StringBuilder}.
 * <p>
 * The factory separates the input text into its components, distinguishing between
 * punctuation marks and words, and then creates a sentence consisting of these elements.
 * </p>
 */
public class SentenceFactory {

    /**
     * Creates a {@code Sentence} object from the given raw sentence string.
     * The sentence is split into words and punctuation marks, which are then used
     * to construct the {@code Sentence} object.
     *
     * @param rawSentence the raw input sentence as a {@code StringBuilder}
     * @return a {@code Sentence} object constructed from the words and punctuation marks
     *         of the input string
     * @throws IllegalArgumentException if the input string is null or empty
     */
    public static Sentence createSentence(StringBuilder rawSentence) {
        if (rawSentence == null || rawSentence.isEmpty()) {
            throw new IllegalArgumentException("Sentence string cannot be null or empty.");
        }

        StringBuilder[] rawSentenceParts = separateRawSentence(rawSentence);
        SentencePart[] sentenceParts = new SentencePart[rawSentenceParts.length];

        for (int i = 0; i < rawSentenceParts.length; i++) {
            StringBuilder currentSentencePart = rawSentenceParts[i];
            if (currentSentencePart.length() == 1) {
                // Check if the current part is a punctuation mark
                char oneSymbolSentencePart = currentSentencePart.charAt(0);
                if (PunctuationMark.isPunctuationMark(oneSymbolSentencePart)) {
                    sentenceParts[i] = PunctuationMark.fromSymbol(oneSymbolSentencePart);
                    continue;
                }
            }
            // If not punctuation, treat the part as a word
            sentenceParts[i] = WordFactory.createWord(currentSentencePart);
        }
        return new Sentence(sentenceParts);
    }

    /**
     * Splits the raw sentence string into an array of {@code StringBuilder} objects,
     * separating words and punctuation marks while preserving the structure of contractions.
     *
     * @param rawSentence the raw sentence input as a {@code StringBuilder}
     * @return an array of {@code StringBuilder} objects, each representing a word
     *         or a punctuation mark
     */
    private static StringBuilder[] separateRawSentence(StringBuilder rawSentence) {
        // Regular expression to split sentence into parts by punctuation or spaces
        String[] rawSentenceParts = rawSentence.toString()
                .split("(?=[\\p{Punct}&&[^']])|(?<=[\\p{Punct}&&[^']])|\\s+");
        StringBuilder[] stringBuilders = new StringBuilder[rawSentenceParts.length];

        for (int i = 0; i < rawSentenceParts.length; i++) {
            stringBuilders[i] = new StringBuilder(rawSentenceParts[i].trim());
        }

        return stringBuilders;
    }
}
