package com.mcii.repository.friend;

import org.springframework.stereotype.Repository;

import com.mcii.entity.Friend;
import com.mcii.repository.DomainRepositoryImpl;
@Repository
public class FriendDaoImpl extends DomainRepositoryImpl<Friend> implements FriendDao {

}
