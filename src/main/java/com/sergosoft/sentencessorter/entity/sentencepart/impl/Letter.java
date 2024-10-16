package com.sergosoft.sentencessorter.entity.sentencepart.impl;

public class Letter {

    private char letter;

    public Letter(char letter) {
        this.letter = letter;
    }

    public char getLetter() {
        return letter;
    }

    public void setLetter(char letter) {
        this.letter = letter;
    }

    @Override
    public String toString(){
        return String.valueOf(letter);
    }
}
