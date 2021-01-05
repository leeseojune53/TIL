package com.dsm.daily_book.entity.diary;

import com.dsm.daily_book.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "diary")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Diary {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long diaryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_id")
    @JsonBackReference
    private User writer;

    @CreationTimestamp
    private Date writeDate;

    @Column(length = 50, nullable = false)
    private String subject;

    @NonNull
    @Length(max = 1000)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Mood mood;
}
