package com.rentalcars.carSort.rest;

import com.rentalcars.carSort.DataStorage;
import com.rentalcars.carSort.model.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nikolai on 4.06.2017.
 */
@org.springframework.web.bind.annotation.RestController
@RequestMapping("/search/{sortType}")
public class RestController {

    private DataStorage db;

    @Autowired
    public RestController(DataStorage db) {
        this.db = db;
    }

    @RequestMapping(method = RequestMethod.GET)
    SearchResponse getVehicleList(@PathVariable String sortType) {
        List<Vehicle> vehicles = new ArrayList<>();

        switch (sortType.toLowerCase()) {
            case "byprice":
                vehicles = db.getByPrice();
                break;
            case "byscore":
                vehicles = db.getByScore();
                break;
            case "bybestsupplier":
                vehicles = db.getByBestSupplier();
                break;
            case "fullspecs":
                vehicles = db.getVehicles();
                break;
            default:
                throw new BadRequestException(sortType);
        }

        Vehicle[] searchData = new Vehicle[vehicles.size()];
        searchData = vehicles.toArray(searchData);

        Search search = new Search(searchData);
        SearchResponse response = new SearchResponse(search);

        return response;
    }
}
