package com.example.codeverify.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "wasabi53535@gmail.com";

    public void mailSend(String mail, String code) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(mail);
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject("인증코드 : " + code + "입니다. 정확히 입력해 주세요.");
        message.setText(code);
        System.out.println(mail + "  " + MailService.FROM_ADDRESS + "  " + code);
        mailSender.send(message);
    }
}
