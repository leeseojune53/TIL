package io.github.leeseojune53.rsocket_server;

import io.github.leeseojune53.rsocket_server.data.Message;
import io.github.leeseojune53.rsocket_server.data.MessageRepository;
import io.github.leeseojune53.rsocket_server.dto.PayloadDto;
import io.github.leeseojune53.rsocket_server.dto.RoomName;
import io.rsocket.frame.RequestFireAndForgetFrameCodec;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.stereotype.Controller;
import org.springframework.util.MimeType;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RSocketController {

    private final MessageRepository messages;


    @MessageMapping("send")
    public Mono<Void> sendMessage(RSocketRequester requester) {
        Mono<Message> data = this.messages.save(new Message("test message", "test", Instant.now()));
        MimeType mimeType = MimeType.valueOf("message/x.rsocket.authentication.bearer.v0");
        System.out.println(requester.metadataMimeType());
        return requester.route("asdf")
//                .metadata("asdf", mimeType)
                .data(data)
                .retrieveFlux(Message.class)
                .then();
    }

    @MessageMapping("messages")
    public Flux<Message> messageStream() {
        return this.messages.getMessageByRoomName("test").log();
    }

}