package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class Test {
    @Value("${asdf}")
    private String asdf;

    public void asdf(){
        System.out.println(asdf);
    }
}
