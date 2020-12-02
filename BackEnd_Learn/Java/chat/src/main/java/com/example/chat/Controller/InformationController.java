package com.example.chat.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/info")
public class InformationController {
    SimpleDateFormat format = new SimpleDateFormat("hh:mm:ss");

    @GetMapping("date")
    public String getDate(){
        return format.format(new Date());
    }
}
