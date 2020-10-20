package com.example.lightning_talk_source.service;

import com.example.lightning_talk_source.repository.testRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor

@Service
public class TestService {
    private final testRepository testRepository;

    public TestService(testRepository testRepository){
        this.testRepository = testRepository;
    }
}

