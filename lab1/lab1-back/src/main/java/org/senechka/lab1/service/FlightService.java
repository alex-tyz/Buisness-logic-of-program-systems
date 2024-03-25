package org.senechka.lab1.service;

import org.senechka.lab1.models.City;
import org.senechka.lab1.repos.CityRepository;
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
        // Здесь может быть логика для получения списка городов для полета из базы данных
        return cityRepository.findAll();
    }
}

