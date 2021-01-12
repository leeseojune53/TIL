package com.dsm.daily_book.service.friend;

import com.dsm.daily_book.dto.FriendDTO;

public interface FriendService {
    void addFriend(FriendDTO.userCode request);
    void deleteFriend(FriendDTO.userCode request);
    void cancelFriend(FriendDTO.userCode request);
    void acceptFriend(FriendDTO.userCode request);
}
