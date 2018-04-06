package com.mcii.service.member.accountInfo;

import com.mcii.entity.Account;
import com.mcii.entity.AccountBase;
import com.mcii.service.BaseService;

public interface AccountInfoService   extends BaseService<AccountBase>{
	//获取基本资料
	AccountBase getAccountInfoById(Account account);

	//修改基本资料
	void updateInfo(Account account, String realname, String sex, Integer age,
			Integer height, Integer weight, Integer salary, String education,
			String workplace, String marrystatus, String nativeplace);
	
}
