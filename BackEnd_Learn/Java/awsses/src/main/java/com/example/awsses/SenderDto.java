package com.example.awsses;

import com.amazonaws.services.simpleemail.model.*;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class SenderDto {
    private String from;
    private List<String> to = new ArrayList<>();
    private String subject;
    private String content;

    @Builder
    public SenderDto(String from, List<String> to, String subject, String content) {
        this.from = from;
        this.to = to;
        this.subject = subject;
        this.content = content;
    }

    public void addTo(String email){
        this.to.add(email);
    }

    public SendEmailRequest toSendRequestDto(){
        Destination destination = new Destination()
                .withToAddresses(this.to);

        Message message = new Message()
                .withSubject(createContent(this.subject))
                .withBody(new Body()
                        .withHtml(createContent(this.content))); // content body는 HTML 형식으로 보내기 때문에 withHtml을 사용합니다.

        return new SendEmailRequest()
                .withSource(this.from)
                .withDestination(destination)
                .withMessage(message);
    }

    private Content createContent(String text) {
        return new Content()
                .withCharset("UTF-8")
                .withData(text);
    }
}
