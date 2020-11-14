package com.example.board.Entity.Board;

import com.example.board.Entity.Comment.Comment;
import com.example.board.Payload.Response.ShowResponse;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.sun.istack.Nullable;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "Board")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String contents;
    // jwt와 연계해서 jwtToken parse해서나온 id값으로 user이름 찾기.
    private String author;

    @CreationTimestamp
    private Date createAt;

    private Date modifyAt;

    private int views;

    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<Comment> comments;

}
