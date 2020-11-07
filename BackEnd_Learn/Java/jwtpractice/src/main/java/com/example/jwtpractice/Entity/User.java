package com.example.jwtpractice.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import javax.persistence.*;

@Entity
@Table(name = "User")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usercode;

    @Column(unique = true)
    private String userId;

    private String userPw;

    public Integer getUsercode(){
        System.out.println("asdf");
        return usercode;
    }



}
