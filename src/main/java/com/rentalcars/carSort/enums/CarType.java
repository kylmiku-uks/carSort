package com.rentalcars.carSort.enums;

/**
 * Created by Nikolai on 3.06.2017.
 */
public enum CarType {

    MINI('M', "Mini"),
    ECONOMY('E', "Economy"),
    COMPACT('C', "Compact"),
    INTERMEDIATE('I', "Intermediate"),
    STANDARD('S', "Standard"),
    FULL('F', "Full size"),
    PREMIUM('P', "Premium"),
    LUXURY('L', "Luxury"),
    SPECIAL('X', "Special");

    private final char letter;
    private final String description;

    CarType(char letter, String description) {
        this.letter = letter;
        this.description = description;
    }

    public String toString() {
        return this.description;
    }

    public char getLetter() {
        return this.letter;
    }

    public static CarType findByLetter(char letter) {
        for (CarType car : CarType.values()) {
            if (car.getLetter() == letter) {
                return car;
            }
        }
        return null;
    }
}
