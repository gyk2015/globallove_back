package com.mcii.service.integral;

import com.mcii.entity.Account;
import com.mcii.entity.Integral;
import com.mcii.service.BaseService;

public interface IntegralService extends BaseService<Integral>{
	//加分
	void updateIntegral(Account account, int i);
	
	//获得自己的积分
	Integral getIntegralById(Account account);


	
}
