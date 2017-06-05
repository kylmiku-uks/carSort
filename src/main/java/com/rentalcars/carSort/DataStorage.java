package com.rentalcars.carSort;

import com.rentalcars.carSort.enums.CarType;
import com.rentalcars.carSort.model.Vehicle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Nikolai on 4.06.2017.
 */
public class DataStorage {
    private static DataStorage instance = null;

    protected DataStorage() {

    }

    public static DataStorage getInstance() {
        if (instance == null) {
            instance = new DataStorage();
        }
        return instance;
    }

    private List<Vehicle> vehicles;

    public List<Vehicle> getVehicles() {
        return vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        for (Vehicle car : vehicles) {
            car.processSippData();
        }
        this.vehicles = vehicles;
    }

    public List<Vehicle> getByPrice() {
        List<Vehicle> out = new ArrayList<>(vehicles);
        out.sort(new PriceComparator());
        return out;
    }

    public List<Vehicle> getByScore() {
        List<Vehicle> out = new ArrayList<>(vehicles);
        Collections.sort(out, Collections.reverseOrder(new ScoreComparator()));
        return out;
    }

    /**
     * Loop through all available car types and see if
     * cars of each type are present in the current list of vehicles.
     * If such car is found, check if it beats the currently recorded
     * highest-ranked supplier rating. If it does, record it as a new
     * "high score".
     * @return - Highest rated supplier per car type.
     */
    public List<Vehicle> getByBestSupplier() {
        List<Vehicle> bestSuppliers = new ArrayList<>();
        for (CarType type : CarType.values()) {
            Integer bestIndex = null;
            Double bestRating = 0.0;
            List<Vehicle> out = new ArrayList<>(vehicles);
            for (int i = 0; i < out.size(); i++) {
                Vehicle car = out.get(i);
                if (car.getCarType().equals(type)) {
                    if (car.getRating() >= bestRating) {
                        if (car.getRating() == bestRating) {
                            // Use vehicles total score as a tiebreaker in case supplier ratings are equal
                            if (car.getTotalScore() > out.get(bestIndex).getTotalScore()) {
                                bestIndex = i;
                                bestRating = car.getRating();
                            }
                        } else {
                            bestIndex = i;
                            bestRating = car.getRating();
                        }
                    }
                }
            }
            if (bestIndex != null) {
                bestSuppliers.add(out.get(bestIndex));
            }
            Collections.sort(bestSuppliers, Collections.reverseOrder(new RatingComparator()));
        }
        return bestSuppliers;
    }

    static class PriceComparator implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.getPrice().compareTo(o2.getPrice());
        }
    }

    static class ScoreComparator implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.getTotalScore().compareTo(o2.getTotalScore());
        }
    }

    static class RatingComparator implements Comparator<Vehicle> {

        @Override
        public int compare(Vehicle o1, Vehicle o2) {
            return o1.getRating().compareTo(o2.getRating());
        }
    }
}
