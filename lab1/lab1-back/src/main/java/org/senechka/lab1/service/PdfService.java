package org.senechka.lab1.service;

import com.itextpdf.kernel.colors.Color;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.Date;

@Service
public class PdfService {

    public byte[] generateTicket(String fromcity, String tocity, String name, String surname, String date, int cost) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = new PdfWriter(outputStream);
        PdfDocument pdf = new PdfDocument(writer);
        Document document = new Document(pdf);

        Paragraph header = new Paragraph("Your Ticket");
        header.setFontSize(20);
        header.setFontColor(new DeviceRgb(0, 0, 255));
        document.add(header);

        Paragraph ticketInfo = new Paragraph("From City: " + fromcity +"\n"+  "To City: " + tocity +"\n" +"For: " + name +" " + surname + "\n" + "\nDate: " + date + "\nCost: " + cost);
        document.add(ticketInfo);

        document.close();

        return outputStream.toByteArray();
    }
}
