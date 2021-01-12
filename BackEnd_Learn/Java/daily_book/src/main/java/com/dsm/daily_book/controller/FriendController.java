package com.dsm.daily_book.controller;

import com.dsm.daily_book.dto.FriendDTO;
import com.dsm.daily_book.service.friend.FriendService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class FriendController {
    private final FriendService friendService;

    @PostMapping("/friend")
    public void addFriend(@RequestBody FriendDTO.userCode request){
        friendService.addFriend(request);
    }

    @PatchMapping("/friend")
    public void acceptFriend(@RequestBody FriendDTO.userCode request){
        friendService.acceptFriend(request);
    }
}
