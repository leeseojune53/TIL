package com.example.chat.Entity.RefreshToken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "RefreshToken")
public class RefreshToken {
    @Id
    private int userCode;

    private String refreshToken;
}
