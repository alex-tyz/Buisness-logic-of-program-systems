package org.senechka.lab1.controller;

import org.senechka.lab1.models.Dates;
import org.senechka.lab1.models.UserTickets;
import org.senechka.lab1.payment.service.PaymentService;
import org.senechka.lab1.security.jwt.UserService;
import org.senechka.lab1.service.BookingService;
import org.senechka.lab1.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TicketController {

    @Autowired
    private PdfService pdfService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private UserService userService;

    @PostMapping("/payment/{ticketid}")
    public ResponseEntity<byte[]> processPayment(@PathVariable UUID ticketid) {


        //UUID _ticketid = paymentService.getCurrentTicketById(ticketid).getTicketid();
        String fromcity = bookingService.getTicketById(ticketid).getFromCity();
        String tocity = bookingService.getTicketById(ticketid).getToCity();
        String name = paymentService.getCurrentTransactionByTicketId(ticketid.toString()).getName();
        String surname = paymentService.getCurrentTransactionByTicketId(ticketid.toString()).getSurname();
        String date = bookingService.getTicketById(ticketid).getDate().toString();
        int cost = bookingService.getTicketById(ticketid).getCost();


        // Генерируем PDF-билет
        byte[] pdfBytes = pdfService.generateTicket(fromcity, tocity, name, surname, date, cost);

        // Устанавливаем заголовки ответа
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "ticket.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

    @PostMapping("/setAdmin")
    public void setAdminForUser(){
        userService.getAdmin();
    }
}
