package io.github.leeseojune53.rsocket_client;

import io.github.leeseojune53.rsocket_client.data.Message;
import io.rsocket.metadata.WellKnownMimeType;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.messaging.rsocket.RSocketStrategies;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.util.MimeType;
import org.springframework.util.MimeTypeUtils;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.UUID;

@Slf4j
@ShellComponent
public class RSocketShellClient {

    private static final String CLIENT = "Client";
    private static final String REQUEST = "Request";
    private static final String FIRE_AND_FORGET = "Fire-And-Forget";
    private static final String STREAM = "Stream";
    private static final String CLIENT_ID = UUID.randomUUID().toString();
    private static final MimeType SIMPLE_AUTH = MimeTypeUtils.parseMimeType(WellKnownMimeType.MESSAGE_RSOCKET_AUTHENTICATION.getString());
    private static Disposable disposable;

    private RSocketRequester rsocketRequester;
    private RSocketRequester.Builder rsocketRequesterBuilder;
    private RSocketStrategies rsocketStrategies;

    @Autowired
    public RSocketShellClient(RSocketRequester.Builder builder,
                              @Qualifier("rSocketStrategies") RSocketStrategies strategies) {
        this.rsocketRequesterBuilder = builder;
        this.rsocketStrategies = strategies;
    }

    @ShellMethod("Stream some settings to the server. Stream of responses will be printed.")
    public void channel() {
            log.info("\n\n***** Channel (bi-directional streams)\n***** Asking for a stream of messages.\n***** Type 's' to stop.\n\n");

            Mono<Duration> setting1 = Mono.just(Duration.ofSeconds(1));
            Mono<Duration> setting2 = Mono.just(Duration.ofSeconds(3)).delayElement(Duration.ofSeconds(5));
            Mono<Duration> setting3 = Mono.just(Duration.ofSeconds(5)).delayElement(Duration.ofSeconds(15));

            Flux<Duration> settings = Flux.concat(setting1, setting2, setting3)
                    .doOnNext(d -> log.info("\nSending setting for a {}-second interval.\n", d.getSeconds()));

            disposable = this.rsocketRequester
                    .route("channel")
                    .data(settings)
                    .retrieveFlux(Message.class)
                    .subscribe(message -> log.info("Received: {} \n(Type 's' to stop.)", message));
    }

}
