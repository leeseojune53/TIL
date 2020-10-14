package com.example.clocky_user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class ClockyUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClockyUserApplication.class, args);
    }

    @RequestMapping("/")
    public String mainmenu(){
        return "helloworld";
    }
}
