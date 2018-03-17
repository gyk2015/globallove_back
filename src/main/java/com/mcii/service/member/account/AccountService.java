package com.mcii.service.member.account;

import com.mcii.entity.Account;
import com.mcii.service.BaseService;

public interface AccountService extends BaseService<Account>{

	Account getAccountById(Integer id);
	

}
