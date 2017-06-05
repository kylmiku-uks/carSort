package com.rentalcars.carSort.enums;

/**
 * Created by Nikolai on 3.06.2017.
 */
public enum AirConditioner {

    NOAC('N', "no AC", 0),
    AC('R', "AC", 2);

    private final char letter;
    private final String description;
    private final int score;

    AirConditioner(char letter, String description, int score) {
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

    public static AirConditioner findByLetter(char letter) {
        for (AirConditioner ac : AirConditioner.values()) {
            if (ac.getLetter() == letter) {
                return ac;
            }
        }
        return null;
    }
}
