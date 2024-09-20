package com.postgres.databases.service;

import com.google.gson.Gson;
import com.postgres.databases.DTO.Ticket;
import com.postgres.databases.kafka.KafkaSender;
import com.postgres.databases.repos.ActualRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

@Service
public class ActualService {

    private static final Logger log = LoggerFactory.getLogger(ActualService.class);
    @Autowired
    private ActualRepository actualRepository;

    @Autowired
    private KafkaSender kafkaSender;

    private String configureTicketJSON(Ticket ticket){
        Gson gson = new Gson();

        return gson.toJson(ticket);
    }

    public void sendTicketToArchive(Ticket ticket){
        String ticketJson = configureTicketJSON(ticket);
        log.info(ticketJson);
        kafkaSender.sendMessage(ticketJson, "archive");
    }

    public void setTicket(String data){
        Ticket ticket = new Gson().fromJson(data, Ticket.class);
        actualRepository.setTicket(ticket.getUserid(), ticket.getTicketid(),
                ticket.getFromcity(), ticket.getTocity(), ticket.getCost(),
                ticket.getExpiredate());
        log.info("got ticket "+ ticket.getTicketid().toString() + ticket.getFromcity()+ ticket.getExpiredate().toString());
    }


}
