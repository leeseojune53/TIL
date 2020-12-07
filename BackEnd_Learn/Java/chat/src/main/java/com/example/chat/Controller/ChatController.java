package com.example.chat.Controller;

import com.example.chat.Security.Jwt.Auth.AuthDetails;
import com.example.chat.Security.Jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ChatController {
    private final JwtTokenProvider jwtTokenProvider;

    @RequestMapping("/chat")
    public String chat(String token){//chat 에 parm으로 token을 받기
        jwtTokenProvider.checkToken(token);
        System.out.println(((AuthDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getUserId());
        return "view";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }
}
