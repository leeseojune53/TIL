package com.example.websocketchat.Handler;

import com.example.websocketchat.DTO.ChatMessage;
import com.example.websocketchat.DTO.ChatRoom;
import com.example.websocketchat.Service.ChatService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
@RequiredArgsConstructor
public class WebSocketHandler extends TextWebSocketHandler {
    private final ObjectMapper objectMapper;
    private final ChatService chatService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String payload = message.getPayload();
//        TextMessage textMessage = new TextMessage("Welcome");
//        session.sendMessage(textMessage);
        ChatMessage chatMessage = objectMapper.readValue(payload, ChatMessage.class);
        chatMessage.setMessageType();
        ChatRoom room = chatService.findRoomById(chatMessage.getRoomId());
        room.handleActions(session, chatMessage, chatService);
    }
}
