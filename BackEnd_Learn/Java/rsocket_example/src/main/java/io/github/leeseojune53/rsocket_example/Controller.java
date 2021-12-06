package io.github.leeseojune53.rsocket_example;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;

@RequiredArgsConstructor
@org.springframework.stereotype.Controller
@MessageMapping("messages")
public class Controller {



}
