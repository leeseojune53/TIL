package com.dsm.daily_book.service.friend;

import com.dsm.daily_book.dto.FriendDTO;
import com.dsm.daily_book.entity.Friend.*;
import com.dsm.daily_book.entity.user.User;
import com.dsm.daily_book.entity.user.UserRepository;
import com.dsm.daily_book.exception.user.UserNotFoundException;
import com.dsm.daily_book.security.jwt.AuthenticationFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class FriendServiceImpl implements FriendService{
    private final UserRepository userRepository;
    private final FriendRepository friendRepository;
    private final FriendSendRepository friendSendRepository;
    private final FriendReceiveRepository friendReceiveRepository;
    private final AuthenticationFacade authenticationFacade;

    @Override
    @Transactional
    public void addFriend(FriendDTO.userCode request) {
        User sendUser = authenticationFacade.getUser();
        friendSendRepository.save(new FriendSend(sendUser, request.getUserCode()));
        userRepository.findById(request.getUserCode())
                .map(user -> friendReceiveRepository.save(new FriendReceive(user, sendUser.getUser_code())))
                .orElseThrow(UserNotFoundException::new);
    }

    @Override
    public void deleteFriend(FriendDTO.userCode request) {

    }

    @Override
    public void cancelFriend(FriendDTO.userCode request) {

    }

    @Override
    public void acceptFriend(FriendDTO.userCode request) {
        User acceptUser = authenticationFacade.getUser();
        Iterator<FriendReceive> list = acceptUser.getFriends_request_receive().iterator();
        boolean receiveExist = false;
        while(list.hasNext()){
            if(list.next().getFriendUserCode() == request.getUserCode()){
                receiveExist = true;
                break;
            }
        }
        if(!receiveExist)
            throw new UserNotFoundException();
        friendRepository.save(new Friend(acceptUser, request.getUserCode()));
        friendReceiveRepository.delete(new FriendReceive(acceptUser, request.getUserCode()));
        userRepository.findById(request.getUserCode())
                .map(user->{
                    friendRepository.save(new Friend(user, acceptUser.getUser_code()));
                    friendSendRepository.delete(new FriendSend(user, acceptUser.getUser_code()));
                    return user;
                })
                .orElseThrow(UserNotFoundException::new);

    }
}
