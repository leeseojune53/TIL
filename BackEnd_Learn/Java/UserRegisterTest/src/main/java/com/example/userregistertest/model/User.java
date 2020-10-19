package com.example.userregistertest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Register_Test")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long password;

    @CreationTimestamp
    private Date createtime;

    public String toString(){
        return "번호: " + id + "<br>이름: " + name + "<br>비밀번호: " + password;
    }
}
