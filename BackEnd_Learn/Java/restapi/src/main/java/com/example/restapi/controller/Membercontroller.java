package com.example.restapi.controller;

import com.example.restapi.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;


@RequestMapping("/member")
@RestController
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;
    
    @GetMapping("/test2")
    public ArrayList<Member> memberTest2(){
        return new ArrayList(Arrays.asList(
                new Member(1L,"leeseojune",17,"busan",new Date())
        ));
    }

    @PostMapping("/insert") // CREATE
    public Member insert(){
        
    }
}