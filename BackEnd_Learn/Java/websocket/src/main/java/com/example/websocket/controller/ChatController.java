package com.example.websocket.controller;

import io.socket.emitter.Emitter;
import io.socket.engineio.server.EngineIoServer;
import io.socket.engineio.server.EngineIoSocket;
import io.socket.engineio.server.EngineIoWebSocket;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    private EngineIoServer engineIoServer;
    private EngineIoWebSocket engineIoWebSocket;

    @RequestMapping("/join")
    public void join(){
        engineIoServer.on("connection", new Emitter.Listener() {
            @Override
            public void call(Object... args) {
                EngineIoSocket socket = (EngineIoSocket) args[0];
                socket.on("join",)
            }
        })
    }

}
