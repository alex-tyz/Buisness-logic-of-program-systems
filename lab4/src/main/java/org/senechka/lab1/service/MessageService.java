package org.senechka.lab1.service;


import com.google.gson.Gson;
import org.senechka.lab1.kafka.sender.KafkaSender;
import org.senechka.lab1.models.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {

    @Autowired
    private KafkaSender kafkaSender;

    private String configureTicketJSON(Ticket ticket){
        Gson gson = new Gson();

        return gson.toJson(ticket);
    }

    public void sendTicketToActual(Ticket ticket){
        String ticketJson = configureTicketJSON(ticket);
        kafkaSender.sendMessage(ticketJson, "actual");
    }
}
