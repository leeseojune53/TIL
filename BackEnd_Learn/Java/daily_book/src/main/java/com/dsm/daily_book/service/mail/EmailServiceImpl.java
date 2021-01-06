package com.dsm.daily_book.service.mail;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.model.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.text.html.HTML;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService{

    private final AmazonSimpleEmailServiceAsync amazonSimpleEmailServiceAsync;

    private static final String SUBJECT = "Daily Book 인증코드";
    private static final String HTMLBODY = "<h1> Daily Book <h1><br><p>이 코드를 입력해 주세요 : ";

    @Override
    public void sendEmail(String email, String code) {
        try{
            SendEmailRequest request = new SendEmailRequest()
                    .withDestination(new Destination().withToAddresses(email))
                    .withMessage(new Message().withBody(new Body().withHtml(new Content().withCharset("UTF-8").withData(HTMLBODY.concat(code))))
                            .withSubject(new Content().withCharset("UTF-8").withData(SUBJECT)))
                    .withSource("wasabi53535@gmail.com");
            amazonSimpleEmailServiceAsync.sendEmailAsync(request);
        }catch (Exception e){
            log.error("Send Email ERROR");
        }
        log.info("Send Email Success");
    }
}
