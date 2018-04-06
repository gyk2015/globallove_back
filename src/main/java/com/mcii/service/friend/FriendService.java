package com.mcii.service.friend;

import com.mcii.entity.Account;
import com.mcii.entity.Friend;
import com.mcii.service.BaseService;
import com.mcii.tools.PageRecord;

public interface FriendService extends BaseService<Friend>{
	//关注
	void addFollow(Account account, Account baccount);
	//检查对方是否已关注我
	Friend isFollow(Account account, Account baccount);
	//检查是否已关注对方
	Friend hasFollow(Account account, Account baccount);
	//取消关注
	void removeFollow(Account account, Account baccount);
	//获取关注列表
	PageRecord getFollow(Integer page,
			Integer pageSize,Account account);
	//获取粉丝列表
	PageRecord getFan(Integer page, Integer pageSize, Account account);
}
