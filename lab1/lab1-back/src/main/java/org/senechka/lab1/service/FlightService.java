package org.senechka.lab1.service;

import org.senechka.lab1.models.City;
import org.senechka.lab1.models.Dates;
import org.senechka.lab1.repos.CityRepository;
import org.senechka.lab1.repos.TicketRepositiry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {

    private final CityRepository cityRepository;

    @Autowired
    public FlightService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> getCitiesForFlight() {
        return cityRepository.findAll();
    }

    public City getCurrentCity(String name){
        return cityRepository.findByName(name);
    }

    public List<City> getCitiesByRating(float raitingM, float ratingL) {
        return cityRepository.findByRating(ratingL, raitingM);
    }
}

