package org.senechka.lab1.service;

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
        return ticketRepositiry.findByName(city);
    }

    public void setTicketUnavaible(UUID id){ ticketRepositiry.setUnableToBuyTicket(id);}
}
