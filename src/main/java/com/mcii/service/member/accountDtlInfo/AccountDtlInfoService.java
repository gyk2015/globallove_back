package com.mcii.service.member.accountDtlInfo;

import com.mcii.entity.Account;
import com.mcii.entity.AccountBase;
import com.mcii.entity.AccountDtl;
import com.mcii.service.BaseService;

public interface AccountDtlInfoService  extends BaseService<AccountDtl>{
	//获取基本资料
	AccountDtl getAccountDtlInfoById(Account account);
	
	//修改基本资料
	void updateInfo(Account account, String bloodtype, String constellation,
			String nation, String zodiac, String religion, String house);
	
}
