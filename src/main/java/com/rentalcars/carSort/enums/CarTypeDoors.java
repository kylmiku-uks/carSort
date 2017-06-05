package com.rentalcars.carSort.enums;

/**
 * Created by Nikolai on 3.06.2017.
 */
public enum CarTypeDoors {

    TWO('B', "2 doors"),
    FOUR('C', "4 doors"),
    FIVE('D', "5 doors"),
    ESTATE('W', "Estate"),
    CONVERTIBLE('T', "Convertible"),
    SUV('F', "SUV"),
    PICKUP('P', "Pick up"),
    VAN('V', "Passenger Van"),
    SPECIAL('X', "Special");

    private final char letter;
    private final String description;

    CarTypeDoors(char letter, String description) {
        this.letter = letter;
        this.description = description;
    }

    public String toString() {
        return this.description;
    }

    public char getLetter() {
        return this.letter;
    }

    public static CarTypeDoors findByLetter(char letter) {
        for (CarTypeDoors doors : CarTypeDoors.values()) {
            if (doors.getLetter() == letter) {
                return doors;
            }
        }
        return null;
    }
}
