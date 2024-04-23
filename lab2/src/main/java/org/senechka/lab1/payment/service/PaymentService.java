package org.senechka.lab1.payment.service;

import org.apache.catalina.User;
import org.senechka.lab1.models.City;
import org.senechka.lab1.models.Transaction;
import org.senechka.lab1.models.UserTickets;
import org.senechka.lab1.repos.CityRepository;
import org.senechka.lab1.repos.TransanctionRepository;
import org.senechka.lab1.repos.UserticktesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.senechka.lab1.repos.UserticktesRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final UserticktesRepository userticktesRepository;
    private final TransanctionRepository transanctionRepository;

    @Autowired
    public PaymentService(UserticktesRepository userticktesRepository, TransanctionRepository transanctionRepository) {
        this.userticktesRepository = userticktesRepository;
        this.transanctionRepository = transanctionRepository;
    }



    public void setCurrentTicket(String name, String surname, String userid, String ticketid, String email){
        userticktesRepository.setTransaction(name, surname, ticketid, userid, email);
    }

    public void addTransaction(UUID id, String state, String link){
        userticktesRepository.addTransaction(id, state, link);
    }

    public String startPaymentByLink(String transactionid) {
        return "https://cringebank.ru/pinus/payment/"+transactionid;
    }

    public List<UserTickets> getAllUserTransactions(String id){
        return userticktesRepository.getTransactionByUser(id);
    }

    public void setTransactionStatus(UUID transactionid, String link){
        if (Math.random() * 100 < 70){
            transanctionRepository.setTransactionStatusToProvided(transactionid);
            transanctionRepository.setTransactionLink(transactionid, link);
        } else {
            transanctionRepository.setTransactionStatusToFailed(transactionid);
        }
    }
    public UserTickets getCurrentTransactionByTicketId(String id){
        return userticktesRepository.getTransactionById(id);
    }
    public Transaction getCurrentTransaction(UUID transactionid){
        return transanctionRepository.getTransaction(transactionid);
    }
}
