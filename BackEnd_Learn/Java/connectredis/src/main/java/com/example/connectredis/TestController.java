package com.example.connectredis;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {
    private final RedisUtil redisUtil;

    @PostMapping("/test")
    public String setData(@RequestBody TestRequest request){
        redisUtil.setDataExpire(request.getKey(), request.getValue(), request.getDuration());
        return "Success";
    }
}
