package com.mcii.service.activeEnroll;

import com.mcii.entity.Account;
import com.mcii.entity.Active;
import com.mcii.entity.Enroll;
import com.mcii.service.BaseService;
import com.mcii.tools.PageRecord;

public interface ActiveEnrollService extends BaseService<Enroll>{
	//	活动报名
	void add(Enroll enroll);
	//获取报名人员列表
//	PageRecord getActiveEnrollUser(Integer activeid, Integer page,
//			Integer pageSize);
	//获取已报名活动
	PageRecord getEnrollActive(Account account, Integer page, Integer pageSize);
	//检查某人是否参加了活动
	Enroll getIsEnroll(Account account, Active active);

}
