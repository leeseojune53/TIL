package io.github.leeseojune53.rsocket_example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import reactor.util.retry.Retry;

import java.net.URI;
import java.time.Duration;

@Configuration
public class RsocketConfig {


    RSocketRequester requester(RSocketRequester.Builder builder, RSocketStrategies strategies) {
        return builder.rsocketStrategies(strategies)
                .rsocketConnector(rSocketConnector -> rSocketConnector.reconnect(Retry.fixedDelay(2, Duration.ofSeconds(2))))
                .websocket(URI.create("ws://localhost:8081/rsocket"));
    }

}
