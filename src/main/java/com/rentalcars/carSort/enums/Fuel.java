package com.rentalcars.carSort.enums;

/**
 * Created by Nikolai on 3.06.2017.
 *
 * Although this class has a few use right now,
 * it can be extended in the future with more options
 * (e.g. electric cars or hybrids)
 */
public enum Fuel {

    PETROL('N', "Petrol");

    private final char letter;
    private final String description;

    Fuel(char letter, String description) {
        this.letter = letter;
        this.description = description;
    }

    public String toString() {
        return this.description;
    }

    // Refactor once more options are added
    public static Fuel findByLetter(char letter) {
        if (letter == 'N' || letter == 'R') {
            return PETROL;
        }
        return null;
    }
}
