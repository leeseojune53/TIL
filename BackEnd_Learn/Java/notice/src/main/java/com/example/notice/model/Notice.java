package com.example.notice.model;


import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@NoArgsConstructor
@Table(name = "Test")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String Written;


    public Notice(String title, String Written){
        this.title = title;
        this.Written = Written;
    }
}
