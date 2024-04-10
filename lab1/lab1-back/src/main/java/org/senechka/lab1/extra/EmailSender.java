package org.senechka.lab1.extra;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class EmailSender {

    public static void sendEmailWithAttachment(String recipientEmail, byte[] attachmentData) throws MessagingException {
        // Настройки SMTP-сервера
        Properties properties = System.getProperties();
        properties.setProperty("mail.smtp.host", "smtp.example.com");
        properties.setProperty("mail.smtp.port", "587"); // Порт SMTP-сервера
        properties.setProperty("mail.smtp.auth", "true");
        properties.setProperty("mail.smtp.starttls.enable", "true");

        // Получение сессии почты
        Session session = Session.getDefaultInstance(properties);

        // Создание сообщения
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("your-email@example.com"));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(recipientEmail));
        message.setSubject("Your Ticket");

        // Создание вложения
        MimeBodyPart attachmentPart = new MimeBodyPart();
        DataSource source = new ByteArrayDataSource(attachmentData, "application/pdf");
        attachmentPart.setDataHandler(new DataHandler(source));
        attachmentPart.setFileName("ticket.pdf");

        // Создание текстовой части сообщения
        MimeBodyPart textPart = new MimeBodyPart();
        textPart.setText("Dear Customer,\n\nPlease find attached your ticket.\n\nBest regards,\nTicketing Service");

        // Создание многочастного сообщения
        MimeMultipart multipart = new MimeMultipart();
        multipart.addBodyPart(textPart);
        multipart.addBodyPart(attachmentPart);

        // Установка многочастного сообщения в качестве контента сообщения
        message.setContent(multipart);

        // Отправка сообщения
        Transport transport = session.getTransport("smtp");
        transport.connect("smtp.example.com", "your-username", "your-password"); // Учетные данные SMTP-сервера
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }

    // Вспомогательный класс для создания источника данных из массива байтов
    static class ByteArrayDataSource implements DataSource {
        private final byte[] data;
        private final String type;

        public ByteArrayDataSource(byte[] data, String type) {
            this.data = data;
            this.type = type;
        }

        @Override
        public InputStream getInputStream() {
            return new ByteArrayInputStream(data);
        }

        @Override
        public OutputStream getOutputStream() {
            throw new UnsupportedOperationException("Not supported");
        }

        @Override
        public String getContentType() {
            return type;
        }

        @Override
        public String getName() {
            return "ByteArrayDataSource";
        }
    }
}
