package com.leeseojune53.citylife.Entity;


import lombok.Builder;

import javax.persistence.*;

@Entity
@Table(name = "User")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String userId;

    @Column
    private String userPw;

    @Column(unique = true)
    private String nickname;

    @Column
    private int chatacter;

}
