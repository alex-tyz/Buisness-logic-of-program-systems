package org.senechka.lab1.controller;

import org.senechka.lab1.models.City;
import org.senechka.lab1.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CityController {

    @Autowired
    private FlightService cityService;

    @GetMapping("/cities/top")
    //@PreAuthorize("hasRole('USER')")
    public List<City> getAllCities() {
        return cityService.getCitiesForFlight();
    }

    @GetMapping("/xyu")
    public void xyu(){
        System.out.println("P E N I S");
    }

    @GetMapping("/cities/{name}")
    public City getCityByName(@PathVariable String name) {
        return cityService.getCurrentCity(name);
    }

    @GetMapping("/cities/{ratingM}/{ratingL}")
    public List<City> getCitiesByRating(@PathVariable float ratingM, @PathVariable float ratingL) {
        return cityService.getCitiesByRating(ratingM, ratingL);
    }


}