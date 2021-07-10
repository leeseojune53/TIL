package io.github.leeseojune53.postservice.controller;

import io.github.leeseojune53.postservice.dto.WriteRequest;
import io.github.leeseojune53.postservice.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

    @PostMapping("/write")
    @ResponseStatus(HttpStatus.CREATED)
    public void writePost(@RequestBody WriteRequest request) {
        postService.writeRequest(request);
    }

}
