package com.example.websocketchat.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ChatMessage {
    public enum MessageType{
        ENTER, TALK
    }
    private MessageType messageType;
    private String roomId;
    private String sender;
    private String msg;
}
