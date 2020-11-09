package com.example.jwt.Entity.RefreshToken;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
@Table(name = "RefreshToken")

public class RefreshToken {
    @Id
    private Integer id;

    private String RefreshToken;
}
