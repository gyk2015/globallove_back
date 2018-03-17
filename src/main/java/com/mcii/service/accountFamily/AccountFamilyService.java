package com.mcii.service.accountFamily;

import com.mcii.entity.Account;
import com.mcii.entity.AccountFamily;
import com.mcii.service.BaseService;

public interface AccountFamilyService extends BaseService<AccountFamily>{
	//获取家庭资料
	AccountFamily getAccountFamilyById(Account account);
	//修改家庭资料
	void updateInfo(Account account, String parents, String onlychild,
			String child);

}
