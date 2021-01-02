package com.example.codeverify.mail;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender mailSender;
    private static final String FROM_ADDRESS = "wasabi53535@gmail.com";
    private final AmazonSimpleEmailServiceAsync amazonSimpleEmailServiceAsync;

    public void mailSend(String mail, String code) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo(mail);
        message.setFrom(MailService.FROM_ADDRESS);
        message.setSubject("인증코드 : " + code + "입니다. 정확히 입력해 주세요.");
        message.setText(code);
        System.out.println(mail + "  " + MailService.FROM_ADDRESS + "  " + code);
        mailSender.send(message);
    }

    public void sendMail(String TO, String code){
        final String FROM = "wasabi53535@gmail.com";
        final String SUBJECT = "CodeVerify 인증코드 : " + code;
        final String HTMLBODY = "<h1>귀하의 인증코드는 " + code + " 입니다.</h1>";

        SendEmailRequest request = new SendEmailRequest()
                .withDestination(
                        new Destination().withToAddresses(TO)
                )
                .withMessage(new Message()
                .withBody(new Body()
                .withHtml(new Content()
                .withCharset("UTF-8").withData(HTMLBODY)))
                .withSubject(new Content()
                .withCharset("UTF-8").withData(SUBJECT)))
                .withSource(FROM);

        amazonSimpleEmailServiceAsync.sendEmailAsync(request);
    }
}
