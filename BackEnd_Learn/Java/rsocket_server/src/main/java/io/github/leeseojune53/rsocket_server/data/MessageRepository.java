package io.github.leeseojune53.rsocket_server.data;


import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;
import reactor.core.publisher.Flux;

public interface MessageRepository extends ReactiveMongoRepository<Message, Integer> {
    @Tailable
    Flux<Message> getMessageBy();
}
