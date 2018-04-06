package com.mcii.service.member.mood;

import com.mcii.entity.Account;
import com.mcii.entity.Mood;
import com.mcii.service.BaseService;
import com.mcii.tools.PageRecord;

public interface MoodService  extends BaseService<Mood>{
	//获取心情
	PageRecord listMood(Integer page, Integer pageSize, Account id);
	//添加心情
	void saveMood(Account account, String content);

}
