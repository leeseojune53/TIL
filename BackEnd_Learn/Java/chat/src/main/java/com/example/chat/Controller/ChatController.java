package com.example.chat.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ChatController {
    @RequestMapping("/chat")
    public String chat(){
        return "view";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
