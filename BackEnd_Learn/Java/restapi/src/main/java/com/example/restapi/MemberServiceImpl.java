package com.example.restapi;

import com.example.restapi.model.Member;
import com.example.restapi.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
    private final MemberRepository memberRepository;
    
    @Override
    public void memberSave() {
        memberRepository.save(
                Member.builder()
                .id("asdf")
                .password("asdf")
                .build()
        );
    }
}
