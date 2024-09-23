package com.postgres.databases.service;

import com.postgres.databases.DTO.Ticket;
import com.postgres.databases.kafka.KafkaSender;
import com.postgres.databases.repos.ActualRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;



@Service
public class ScheduleService {

    private static final Logger log = LoggerFactory.getLogger(ScheduleService.class);
    @Autowired
    private ActualRepository actualRepository;

    @Autowired
    private ActualService actualService;

    @Autowired
    private KafkaSender kafkaSender;


    @Scheduled(cron = "1 * * * * *")
    public void removeExpiredTickets() {
        log.info("started removing scheduled task");
        for (Ticket ticket : actualRepository.getExpiredActuals()) {
            System.out.println("SCANED "+ticket.getTocity());
            actualService.sendTicketToArchive(ticket);
            actualRepository.deleteActualByUuid(ticket.getUuid());
        }
    }
}
