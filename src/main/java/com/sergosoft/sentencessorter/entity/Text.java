package com.sergosoft.sentencessorter.entity;

public class Text {

    private final Sentence[] sentences;

    public Text() {
        this.sentences = new Sentence[0];
    }

    public Text(Sentence[] sentences) {
        if(sentences == null) {
            throw new IllegalArgumentException("Sentences array cannot be null.");
        }
        this.sentences = sentences;
    }

    public Sentence[] getSentences() {
        return sentences;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if(sentences.length > 0) {
            for(Sentence sentence : sentences) {
                stringBuilder.append(sentence.toString()).append(" ");
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }
}
