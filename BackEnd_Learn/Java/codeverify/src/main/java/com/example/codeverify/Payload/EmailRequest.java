package com.example.codeverify.Payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;

@NoArgsConstructor
@Getter
@Setter
public class EmailRequest {
    @Email
    private String email;
}
