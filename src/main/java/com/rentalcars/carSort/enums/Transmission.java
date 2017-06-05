package com.rentalcars.carSort.enums;

/**
 * Created by Nikolai on 3.06.2017.
 */
public enum Transmission {

    MANUAL('M', "Manual", 1),
    AUTOMATIC('A', "Automatic", 5);

    private final char letter;
    private final String description;
    private final int score;

    Transmission(char letter, String description, int score) {
        this.letter = letter;
        this.description = description;
        this.score = score;
    }

    public String toString() {
        return this.description;
    }

    public char getLetter() {
        return this.letter;
    }

    public int getScore() {
        return this.score;
    }

    public static Transmission findByLetter(char letter) {
        for (Transmission tm : Transmission.values()) {
            if (tm.getLetter() == letter) {
                return tm;
            }
        }
        return null;
    }
}
