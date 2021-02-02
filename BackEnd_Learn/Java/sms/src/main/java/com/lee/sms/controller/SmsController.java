package com.lee.sms.controller;

import com.lee.sms.dto.UserDTO;
import com.lee.sms.service.SmsService;
import com.lee.sms.dto.PhoneDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequiredArgsConstructor
@Slf4j
public class SmsController {

    private final SmsService smsService;

    @PostMapping("/sms")
    public void send(@RequestBody PhoneDTO.PhoneNumber request){
        Random random = new Random();
        String numStr = "";

        for(int i=0;i<4;i++)
            numStr += Integer.toString(random.nextInt(10));

        log.info("Phone : " + request.getPhone() + ", num : " + numStr);
        smsService.send(request.getPhone(), numStr);

    }

    @PutMapping("/sms")
    public void verify(@RequestBody PhoneDTO.Verify request){
        smsService.verify(request);
    }

    @PostMapping("/register")
    public void register(@RequestBody UserDTO.UserInfo request){
        smsService.register(request);
    }
}
