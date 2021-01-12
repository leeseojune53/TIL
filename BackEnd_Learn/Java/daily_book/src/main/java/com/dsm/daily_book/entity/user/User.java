package com.dsm.daily_book.entity.user;

import com.dsm.daily_book.entity.Friend.Friend;
import com.dsm.daily_book.entity.Friend.FriendReceive;
import com.dsm.daily_book.entity.Friend.FriendSend;
import com.dsm.daily_book.entity.diary.Diary;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<Friend> friends = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<FriendSend> friends_request_send = new HashSet<>();

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    @JsonManagedReference
    private Set<FriendReceive> friends_request_receive = new HashSet<>();

    @OneToMany(mappedBy = "writer", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Diary> diaries;
}
