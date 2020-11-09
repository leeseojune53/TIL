package com.example.connection_with_rds.controller;

import com.example.connection_with_rds.model.Member;
import com.example.connection_with_rds.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/member")
@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberRepository memberRepository;

    @PostMapping("/insert") // CREATE
    public Member insert(){
        return memberRepository.save(
                new Member("Wickies", 20, "제주")
        );
    }
}
