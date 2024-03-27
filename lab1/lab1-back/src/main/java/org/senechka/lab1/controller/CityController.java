package org.senechka.lab1.controller;

import org.senechka.lab1.models.City;
import org.senechka.lab1.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CityController {

    @Autowired
    private FlightService cityService;

    @GetMapping("/cities/top")
    public List<City> getAllCities() {
        return cityService.getCitiesForFlight();
    }

    @GetMapping("/cities/{name}")
    public City getCityByName(@PathVariable String name) {
        return cityService.getCurrentCity(name);
    }
}