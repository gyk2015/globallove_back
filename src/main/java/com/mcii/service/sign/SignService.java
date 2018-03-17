package com.mcii.service.sign;

import com.mcii.entity.Account;
import com.mcii.entity.Sign;
import com.mcii.service.BaseService;
import com.mcii.tools.PageRecord;

public interface SignService extends BaseService<Sign>{
	//签到
	void addSign(Sign sign);
	//获取签到
	PageRecord getSignById(Account account);

}
