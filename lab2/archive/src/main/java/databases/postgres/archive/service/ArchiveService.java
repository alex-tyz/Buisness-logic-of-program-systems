package databases.postgres.archive.service;

import com.google.gson.Gson;
import databases.postgres.archive.DTO.Ticket;
import databases.postgres.archive.repos.ArchiveRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArchiveService {

    private static final Logger log = LogManager.getLogger(ArchiveService.class);
    @Autowired
    private ArchiveRepository archiveRepository;

    public void setTicket(String data){
        Ticket ticket = new Gson().fromJson(data, Ticket.class);
        archiveRepository.setTicket(ticket.getUserid(), ticket.getTicketid(),
                ticket.getFromcity(), ticket.getTocity(), ticket.getCost(),
                ticket.getExpiredate());
        log.info("got ticket "+ ticket.getTicketid().toString());
    }


}
