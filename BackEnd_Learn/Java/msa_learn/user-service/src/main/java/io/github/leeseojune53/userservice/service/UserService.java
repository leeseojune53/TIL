package io.github.leeseojune53.userservice.service;

import io.github.leeseojune53.proto.PostEntry;
import io.github.leeseojune53.userservice.dto.PostResponse;

import java.util.List;

public interface UserService {
    void register(String name);
    List<PostResponse> getUserPost(Integer id);
}
