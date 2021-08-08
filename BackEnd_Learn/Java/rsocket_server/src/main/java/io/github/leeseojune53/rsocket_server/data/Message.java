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

    private String roomName;

    private Instant sentAt;

    public Message(String body, String roomName, Instant sentAt) {
        this.body = body;
        this.roomName = roomName;
        this.sentAt = sentAt;
    }

}
