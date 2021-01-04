package com.example.awsses;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.model.*;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final AmazonSimpleEmailServiceAsync amazonSimpleEmailServiceAsync;

    public void sendMail(){
        final String TO = "sung07288346@gmail.com";
        final String code = "ABCDE";
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

        amazonSimpleEmailServiceAsync.sendEmailAsync(request);System.out.println("send email");
    }
}
