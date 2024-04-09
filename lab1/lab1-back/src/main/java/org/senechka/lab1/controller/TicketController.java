package org.senechka.lab1.controller;

import org.senechka.lab1.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*", maxAge = 3600)
public class TicketController {

    @Autowired
    private PdfService pdfService;

    @PostMapping("/payment")
    public ResponseEntity<byte[]> processPayment(@RequestParam String city, @RequestParam String date, @RequestParam int cost) {
        // Генерируем PDF-билет
        byte[] pdfBytes = pdfService.generateTicket(city, date, cost);

        // Устанавливаем заголовки ответа
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDispositionFormData("attachment", "ticket.pdf");

        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }
}
