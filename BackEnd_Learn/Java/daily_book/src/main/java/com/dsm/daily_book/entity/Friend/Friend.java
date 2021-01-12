package com.dsm.daily_book.entity.Friend;

import com.dsm.daily_book.entity.user.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.ValueGenerationType;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Friend {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer friendCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_code")
    @JsonBackReference
    private User user;

    private int friendUserCode;

    @CreationTimestamp
    private Date friendDate;

    public Friend(User user, int friendUserCode){
        this.user = user;
        this.friendUserCode = friendUserCode;
    }

}
