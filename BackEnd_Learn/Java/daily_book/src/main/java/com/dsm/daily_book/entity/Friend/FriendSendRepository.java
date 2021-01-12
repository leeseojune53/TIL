package com.dsm.daily_book.entity.Friend;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendSendRepository extends CrudRepository<FriendSend, Integer> {
}
