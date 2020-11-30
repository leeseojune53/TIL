package com.example.websocketchat.Service;

import com.example.websocketchat.DTO.ChatRoom;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.*;

@RequiredArgsConstructor
@Service
public class ChatService {
    private final ObjectMapper objectMapper;
    private Map<String, ChatRoom> chatRooms;

    @PostConstruct
    private void init(){
        chatRooms = new LinkedHashMap<>();
    }

    public List<ChatRoom> findAllRoom(){
        return new ArrayList<>(chatRooms.values());
    }

    public ChatRoom findRoomById(String roomId){
        return chatRooms.get(roomId);
    }

    public ChatRoom createRoom(String name){
        String randomId = UUID.randomUUID().toString();
        ChatRoom chatroom = ChatRoom.builder()
                .roomId(randomId)
                .name(name)
                .build();
        chatRooms.put(randomId, chatroom);
        return chatroom;
    }

    public <T> void sendMessage(WebSocketSession session, T message){
        try{
            session.sendMessage(new TextMessage(objectMapper.writeValueAsString(message)));
        }catch(IOException e){
            throw new RuntimeException();
        }
    }
}
