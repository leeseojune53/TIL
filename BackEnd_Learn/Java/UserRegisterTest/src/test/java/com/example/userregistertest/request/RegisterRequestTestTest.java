package com.example.userregistertest.request;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RegisterRequestTestTest {
    @Test
    public void getname(){
        final RegisterRequest registerRequest = RegisterRequest.builder()
                .name("leeseojune")
                .password(1234L)
                .build();
        final String name = registerRequest.getName();
        assertEquals("leeseojune", name);
    }

    @Test
    public void getpassword(){
        final RegisterRequest registerRequest = RegisterRequest.builder()
                .name("leeseojune")
                .password(1234L)
                .build();
        final Long password = registerRequest.getPassword();
        assertEquals(1234L, password);
    }
}