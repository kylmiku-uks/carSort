package com.rentalcars.carSort.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.rentalcars.carSort.enums.*;

/**
 * Created by Nikolai on 3.06.2017.
 */
public class Vehicle {

    // Printout delimiter
    private char dl = '-';

    public void processSippData() {
        if (sipp != null) {
            type = CarType.findByLetter(sipp.charAt(0));
            doorsType = CarTypeDoors.findByLetter(sipp.charAt(1));
            transmission = Transmission.findByLetter(sipp.charAt(2));
            fuel = Fuel.findByLetter(sipp.charAt(3));
            ac = AirConditioner.findByLetter(sipp.charAt(3));
            featureScore = (double) (transmission.getScore() + ac.getScore());
        }
    }

    // Original rest fields
    private String sipp;
    private String name;
    private Double price;
    private String supplier;
    private Double rating;

    // Generated from sipp
    private CarType type;
    private CarTypeDoors doorsType;
    private Transmission transmission;
    private Fuel fuel;
    private AirConditioner ac;

    private Double featureScore;

    public String getSipp() {
        return sipp;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getSupplier() {
        return supplier;
    }

    public Double getRating() {
        return rating;
    }


    public String getType() {
        return type.toString();
    }

    @JsonIgnore
    public CarType getCarType() {
        return type;
    }

    public String getDoorsType() {
        return doorsType.toString();
    }

    public String getTransmission() {
        return transmission.toString();
    }

    public String getFuel() {
        return fuel.toString();
    }

    public String getAc() {
        return ac.toString();
    }

    public Double getFeatureScore() {
        return featureScore;
    }

    public Double getTotalScore() {
        return featureScore + rating;
    }

    @JsonIgnore
    public String getVehicleSpecs() {
        StringBuilder sb = new StringBuilder();

        sb.append(name).append(dl);
        sb.append(type.toString()).append(dl);
        sb.append(doorsType.toString()).append(dl);
        sb.append(transmission.toString()).append(dl);
        sb.append(fuel.toString()).append(dl);
        sb.append(ac.toString());

        return sb.toString();
    }
}
