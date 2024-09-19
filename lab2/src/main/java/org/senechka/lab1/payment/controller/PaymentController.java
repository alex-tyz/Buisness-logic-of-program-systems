package org.senechka.lab1.payment.controller;

import org.senechka.lab1.models.*;
import org.senechka.lab1.payment.service.PaymentService;
import org.senechka.lab1.security.jwt.UserService;
import org.senechka.lab1.service.BookingService;
import org.senechka.lab1.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @Autowired
    private MessageService messageService;

    private static final long EXPIRE_TIME_SEC = 3 * 24 * 60 * 60;
    @GetMapping("/buy/{ticketid}")
    public void setTransaction(@PathVariable UUID ticketid, @RequestParam String name, @RequestParam String surname, @RequestParam String mail) {
        paymentService.setCurrentTicket(name, surname, ticketid.toString(), mail);
        Dates ticket = bookingService.getTicketById(ticketid);
        User user = userService.getByUsername(name);
        Ticket tickettosend = new Ticket(null, user.getId(),
                ticket.getId(), ticket.getFromCity(),
                ticket.getToCity(), ticket.getCost(),
                Date.from(Instant.now().plusSeconds(EXPIRE_TIME_SEC)));
        messageService.sendTicketToActual(tickettosend);
    }

    @GetMapping("buy/start/{transationid}")
    public void addTransaction(@PathVariable UUID transationid, @RequestParam String state, @RequestParam String link) {
        paymentService.addTransaction(transationid, state, link);
    }

    @GetMapping("buy/startpay/{transactionid}")
    public String sendPaymentLink(@PathVariable String transactionid){
        return paymentService.startPaymentByLink(transactionid);
    }

    @GetMapping("buy/viewall/{userid}")
    public List<UserTickets> getAllTransactions(@PathVariable String userid){
        return paymentService.getAllUserTransactions(userid);
    }

    @GetMapping("buy/viewall/transactions/{transactionid}")
    public Transaction getCurrentTransation(@PathVariable UUID transactionid){
        return paymentService.getCurrentTransaction(transactionid);
    }

    @GetMapping("/buy/check/{transactionid}")
    public void checkTransaction(@PathVariable UUID transactionid, @RequestParam String link){
        paymentService.setTransactionStatus(transactionid, link);
    }
}