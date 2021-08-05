package io.github.leeseojune53.rsocket_server;

import io.github.leeseojune53.rsocket_server.data.Message;
import io.github.leeseojune53.rsocket_server.data.MessageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RSocketController {

    private final MessageRepository messages;

    @MessageMapping("send")
    public Mono<Void> sendMessage(String p) {
        return this.messages.save(new Message(p, Instant.now())).log().then();
    }

    @MessageMapping("messages")
    public Flux<Message> messageStream() {
        return this.messages.getMessageBy().log();
    }

}