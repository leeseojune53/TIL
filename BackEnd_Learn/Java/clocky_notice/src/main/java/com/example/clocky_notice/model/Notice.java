package com.example.clocky_notice.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Table(name = "test")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String written;

    public Notice(String title, String written){
        this.title = title;
        this.written = written;
    }
}
