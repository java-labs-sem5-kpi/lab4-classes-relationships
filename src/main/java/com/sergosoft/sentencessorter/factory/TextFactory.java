package com.sergosoft.sentencessorter.factory;

import com.sergosoft.sentencessorter.entity.Sentence;
import com.sergosoft.sentencessorter.entity.Text;

/**
 * The {@code TextFactory} class provides functionality for creating {@code Text}
 * objects from raw input in the form of a {@code StringBuilder}.
 * <p>
 * This class handles the process of splitting the input text into sentences
 * and then delegating the creation of each sentence to the {@code SentenceFactory}.
 * </p>
 */
public class TextFactory {

    /**
     * Creates a {@code Text} object from the given raw text string.
     * The text is split into sentences, each of which is processed to create
     * a {@code Sentence} object, and the resulting array of sentences is used
     * to construct the {@code Text} object.
     *
     * @param rawText the raw input text as a {@code StringBuilder}
     * @return a {@code Text} object constructed from the sentences in the input string
     * @throws IllegalArgumentException if the input string is {@code null}
     */
    public static Text createText(StringBuilder rawText) {
        if (rawText == null) {
            throw new IllegalArgumentException("Input string cannot be null.");
        }
        if (rawText.isEmpty()) {
            return new Text();
        }

        // Split the text into raw sentences
        StringBuilder[] rawSentences = separateRawTextOnSentences(rawText);
        Sentence[] sentences = new Sentence[rawSentences.length];

        // Process each raw sentence to create Sentence objects
        for (int i = 0; i < rawSentences.length; i++) {
            sentences[i] = SentenceFactory.createSentence(rawSentences[i]);
        }
        return new Text(sentences);
    }

    /**
     * Splits the raw input text into an array of {@code StringBuilder} objects,
     * where each {@code StringBuilder} represents a single sentence.
     * <p>
     * The method assumes that sentences are delimited by punctuation marks such as
     * '.', '!', or '?' followed by a space or newline.
     * </p>
     *
     * @param rawText the raw input text as a {@code StringBuilder}
     * @return an array of {@code StringBuilder} objects, each representing a sentence
     */
    private static StringBuilder[] separateRawTextOnSentences(StringBuilder rawText) {
        // Split the text into sentences based on punctuation and whitespace
        String[] rawSentences = rawText.toString().split("(?<=[.!?])\\s*");
        StringBuilder[] sentenceBuilders = new StringBuilder[rawSentences.length];

        // Convert each sentence into a StringBuilder and trim excess spaces
        for (int i = 0; i < rawSentences.length; i++) {
            sentenceBuilders[i] = new StringBuilder(rawSentences[i].trim());
        }

        return sentenceBuilders;
    }
}
