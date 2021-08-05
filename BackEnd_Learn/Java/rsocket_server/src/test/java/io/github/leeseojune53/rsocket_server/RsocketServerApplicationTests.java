package io.github.leeseojune53.rsocket_server;

import io.github.leeseojune53.rsocket_server.data.Message;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.util.MimeTypeUtils;

import java.net.URI;

@SpringBootTest
class RsocketServerApplicationTests {

    @Autowired
    private RSocketRequester rSocketRequester;

    @Test
    void contextLoads() {

        rSocketRequester.route("messages")
                .retrieveFlux(Message.class)
                .log();

    }

    @TestConfiguration
    class TestConfig {
        @Bean
        public RSocketRequester rSocketRequester(RSocketRequester.Builder builder){
            return builder.dataMimeType(MimeTypeUtils.APPLICATION_JSON)
                    .websocket(URI.create("ws://localhost:8081/rsocket"));
        }
    }

}
