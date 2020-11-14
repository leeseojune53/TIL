package com.example.emailvalidation.Controller;

import com.example.emailvalidation.Payload.MailRequest;
import com.example.emailvalidation.Service.MailService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MailController {
    private final MailService mailService;

    @GetMapping("/mail")
    public String dispMail() {
        return "main";
    }

    @PostMapping("/mail")
    public String execMail(MailRequest request) {
        mailService.mailSend(request);
        return "Success";
    }
}
