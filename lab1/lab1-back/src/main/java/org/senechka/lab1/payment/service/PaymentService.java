package org.senechka.lab1.payment.service;

import org.apache.catalina.User;
import org.senechka.lab1.models.City;
import org.senechka.lab1.models.UserTickets;
import org.senechka.lab1.repos.CityRepository;
import org.senechka.lab1.repos.UserticktesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.senechka.lab1.repos.UserticktesRepository;

import java.util.List;
import java.util.UUID;

@Service
public class PaymentService {

    private final UserticktesRepository userticktesRepository;

    @Autowired
    public PaymentService(UserticktesRepository userticktesRepository) {
        this.userticktesRepository = userticktesRepository;
    }

    public void setCurrentTicket(String name, String surname, String userid, String ticketid, String verify){
        userticktesRepository.setTransaction(name, surname, ticketid, userid, verify);
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

    public UserTickets getCurrentTransaction(UUID transactionid){
        return userticktesRepository.getTransaction(transactionid);
    }
}
