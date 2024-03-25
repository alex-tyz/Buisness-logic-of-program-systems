package org.senechka.lab1.controller;

import org.senechka.lab1.models.City;
import org.senechka.lab1.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class CityController {

    @Autowired
    private FlightService cityService;

    @GetMapping("/cities")
    public List<City> getAllCities() {
        return cityService.getCitiesForFlight();
    }
}