package org.senechka.lab1.controller;

import org.senechka.lab1.models.Dates;
import org.senechka.lab1.repos.TicketRepositiry;
import org.senechka.lab1.service.BookingService;
import org.senechka.lab1.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class BookingController {

    @Autowired
    private BookingService bookingService;
    @GetMapping("/booking/{city}")
    public List<Dates> getAvailableDates(@PathVariable String city) {
        return bookingService.getTicketsFromCity(city);
    }
}
