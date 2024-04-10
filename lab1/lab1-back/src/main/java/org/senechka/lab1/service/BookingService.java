package org.senechka.lab1.service;

import org.senechka.lab1.exceptions.EmptyTownListException;
import org.senechka.lab1.models.Dates;
import org.senechka.lab1.repos.TicketRepositiry;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingService {
    private final TicketRepositiry ticketRepositiry;

    public BookingService(TicketRepositiry ticketRepositiry) {
        this.ticketRepositiry = ticketRepositiry;
    }

    public List<Dates> getTicketsFromCity(String city){
        if (ticketRepositiry.findByName(city).isEmpty()){
            throw new EmptyTownListException("There are no tickets from this city");
        }
        return ticketRepositiry.findByName(city);
    }

    public void setTicketUnavaible(UUID id){ ticketRepositiry.setUnableToBuyTicket(id);}

    public List<Dates> getTicketsToCity(String city) {return ticketRepositiry.findByDest(city); }

    public Dates getTicketById(UUID id) {return ticketRepositiry.findById(id); }

    public List<Dates> getTicketsByCost(int costMax, int costMin) {return ticketRepositiry.findByCost(costMin, costMax); }
}
