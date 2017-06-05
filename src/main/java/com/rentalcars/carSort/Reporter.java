package com.rentalcars.carSort;

import com.rentalcars.carSort.model.Vehicle;

import java.util.List;

/**
 * Created by Nikolai on 4.06.2017.
 */
public class Reporter {

    public static void reportByPrice(List<Vehicle> vehicles) {
        System.out.println("Cars listed by price (asc):");
        for (Vehicle car : vehicles) {
            System.out.println(car.getName() + "-" + car.getPrice());
        }
        System.out.println("\n");
    }

    public static void reportByScore(List<Vehicle> vehicles) {
        System.out.println("Cars listed by total score (desc):");
        for (Vehicle car : vehicles) {
            System.out.println(car.getName() + "-" + car.getFeatureScore().intValue() + "-" +
                    car.getRating() + "-" + car.getTotalScore());
        }
        System.out.println("\n");
    }

    public static void reportByBestSupplier(List<Vehicle> vehicles) {
        System.out.println("Best rated supplier per car type (desc): ");
        for (Vehicle car : vehicles) {
            System.out.println(car.getName() + "-" + car.getType() + "-" + car.getSupplier() + "-" + car.getRating());
        }
        System.out.println("\n");
    }

    public static void reportFullSpecs(List<Vehicle> vehicles) {
        System.out.println("Full list of vehicles: ");
        StringBuilder sb = new StringBuilder();

        for (Vehicle car : vehicles) {
            sb.append(car.getVehicleSpecs()).append("\n");
        }

        System.out.println(sb.toString());
    }
}
