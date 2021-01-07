package com.dsm.daily_book.entity.user;

import com.dsm.daily_book.entity.diary.Diary;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "user")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer user_code;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 100, nullable = false)
    private String password;

    @Column(length = 100, nullable = false)
    private String nickname;

    @ElementCollection
    @CollectionTable(name = "friends")
    private List<Integer> friends;

    @ElementCollection
    @CollectionTable(name = "friends_request_send")
    private List<Integer> friends_request_send;

    @ElementCollection
    @CollectionTable(name = "friends_request_receive")
    private List<Integer> friends_request_receive;

    @OneToMany(mappedBy = "writer", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Diary> diaries;
}
