package com.example.emailvalidation.Service;

import com.example.emailvalidation.Payload.MailRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "wasabi53535@gmail.com";

    public void mailSend(MailRequest request) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(request.getAddress());
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject(request.getTitle());
        message.setText(request.getMessage());
        System.out.println(request.getAddress() + "  " + MailService.FROM_ADDRESS + "  " + request.getTitle() + "  " + request.getMessage());
        mailSender.send(message);
    }
}
