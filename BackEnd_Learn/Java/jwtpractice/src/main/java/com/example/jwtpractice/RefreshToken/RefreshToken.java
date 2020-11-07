package com.example.jwtpractice.RefreshToken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Entity
@Table(name = "refreshtoken")
@AllArgsConstructor
@NoArgsConstructor
public class RefreshToken {

    @Id
    private Integer usercode;

    private String refreshToken;


}
