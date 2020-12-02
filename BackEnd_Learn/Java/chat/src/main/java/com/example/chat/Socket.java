package com.example.chat;

import lombok.extern.java.Log;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Log
@Component
@ServerEndpoint(value = "/websocket")
public class Socket {
    public static List<Session> sessionUsers = Collections.synchronizedList(new ArrayList<>());
    private static Pattern pattern = Pattern.compile("^\\{\\{.*?\\}\\}");
    private static int onlineCnt = 0;

    @OnOpen
    public void onOpen(Session session){
        onlineCnt++;
        sessionUsers.add(session);
        log.info("onOpen, UserCount : " + onlineCnt);
    }

    @OnClose
    public void onClose(Session session){
        onlineCnt--;
        sessionUsers.remove(session);
        log.info("onClose called, userCount:" + onlineCnt);
    }

    @OnMessage
    public void onMessage(String message, Session userSession){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
        String name = "anonymous";
        Matcher matcher = pattern.matcher(message);
        if(matcher.find()){
            name = matcher.group();
        }
        final String msg = message.replaceAll(pattern.pattern(), "");
        final String username = name.replaceFirst("^\\{\\{", "").replaceFirst("\\}\\}$", "");

        sessionUsers.forEach(session->{
            if(session == userSession)
                return;
            try{
                session.getBasicRemote().sendText(format.format(new Date()) + "\t" + username + "=>" + msg);
            }catch (IOException e){
                e.printStackTrace();
            }
        });
    }

}
