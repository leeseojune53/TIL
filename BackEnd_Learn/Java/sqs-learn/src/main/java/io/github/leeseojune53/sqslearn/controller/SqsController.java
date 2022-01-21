package io.github.leeseojune53.sqslearn.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.aws.messaging.listener.SqsMessageDeletionPolicy;
import org.springframework.cloud.aws.messaging.listener.annotation.SqsListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Slf4j
@Component
public class SqsController {

    @SqsListener(value = "test", deletionPolicy = SqsMessageDeletionPolicy.ALWAYS)
    public void receiveMessage(String message) {
        log.info(message);
    }

}
