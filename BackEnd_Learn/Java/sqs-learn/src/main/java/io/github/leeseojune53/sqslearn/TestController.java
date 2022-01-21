package io.github.leeseojune53.sqslearn;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class TestController {

    private final Sender sender;

    @GetMapping("/test")
    public void test(@RequestParam("message") String message) {
        sender.send(message);
    }

}
