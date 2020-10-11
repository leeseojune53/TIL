package com.example.chat;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

@Log
@Component
@ServerEndpoint(value = "/websocket")
public class Socket {
    private Session session;
    public static Set<Socket> listeners = new CopyOnWriteArraySet<>();
    private static int onlineCnt = 0;

    @OnOpen
    public void onOpen(Session session){
        onlineCnt++;
        this.session = session;
        listeners.add(this);
        log.info("onOpen, UserCount : " + onlineCnt);
    }

    @OnClose
    public void onClose(Session session){
        onlineCnt--;
        listeners.remove(this);
        log.info("onClose called, userCount:" + onlineCnt);
    }

    @OnMessage
    public void onMessage(String message){
        log.info("onMessage called, message:" + message);
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable){
        log.warning("onClose called, error:" + throwable.getMessage());
        listeners.remove(this);
        onlineCnt--;
    }

    public void broadcast(String message){
        for(Socket listener : listeners){
            listener.sendmessage(message);
        }
    }

    private void sendmessage(String message){
        try{
            this.session.getBasicRemote().sendText(message);
        }catch (IOException e){
            log.warning("asdf");
        }
    }
}
