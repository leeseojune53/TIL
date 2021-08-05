package io.github.leeseojune53.rsocket_server.data;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Data
@Document("messages")
public class Message {

    @Id
    private String id;

    private String body;

    private Instant sentAt;

    public Message(String body, Instant sentAt) {
        this.body = body;
        this.sentAt = sentAt;
    }

}
