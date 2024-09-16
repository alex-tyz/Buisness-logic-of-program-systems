package org.senechka.lab1.payment.controller;

import org.senechka.lab1.models.Dates;
import org.senechka.lab1.models.Transaction;
import org.senechka.lab1.models.UserTickets;
import org.senechka.lab1.payment.service.PaymentService;
import org.senechka.lab1.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/buy/{ticketid}")
    public void setTransaction(@PathVariable String ticketid, @RequestParam String name, @RequestParam String surname, @RequestParam String mail) {
        paymentService.setCurrentTicket(name, surname, ticketid, mail);
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