package com.mcii.service.member.account;

import java.util.ArrayList;
import java.util.List;

import com.mcii.entity.Account;
import com.mcii.service.BaseService;

public interface AccountService extends BaseService<Account>{

	Account getAccountById(Integer id);
	
	void setAccountImg(Integer accountid,String filePath);

//	String getAccountImg(Integer account);
	
	List<Account> getAccounts();
}
