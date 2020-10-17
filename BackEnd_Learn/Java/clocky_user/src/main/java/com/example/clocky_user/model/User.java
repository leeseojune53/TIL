package com.example.clocky_user.model;

import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "name_test")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private int password;
    @Column
    private String name;
    @CreationTimestamp
    @Column
    private Date create_time;

    public User(String name, int password){
        this.password = password;
        this.name = name;
    }


    public String toString(){
        return id + " " + name + " " + password;
    }
}
