package com.rentalcars.carSort.rest;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.rentalcars.carSort.model.Vehicle;

/**
 * Created by Nikolai on 3.06.2017.
 */
public class Search {

    public Search () {}

    public Search (Vehicle[] vehicleList) {
        this.vehicleList = vehicleList;
    }

    @JsonProperty(value = "VehicleList")
    private Vehicle[] vehicleList;

    public Vehicle[] getVehicleList() {
        return vehicleList;
    }
    public void setVehicleList(Vehicle[] vehicleList) {
        this.vehicleList = vehicleList;
    }

    public String toString() {
        String out = "";

        for (Vehicle car : vehicleList) {
            car.processSippData();
            out += car.getVehicleSpecs();
            out += "\n";
        }

        return out;
    }
}
