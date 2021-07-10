package io.github.leeseojune53.userservice.dto;

import io.github.leeseojune53.proto.PostEntry;
import lombok.Getter;

@Getter
public class PostResponse {

    public PostResponse(PostEntry postEntry) {
        this.userId = postEntry.getUserId();
        this.userName = postEntry.getUserName();
        this.value = postEntry.getValue();
    }

    private Integer userId;
    private String userName;
    private String value;
}
