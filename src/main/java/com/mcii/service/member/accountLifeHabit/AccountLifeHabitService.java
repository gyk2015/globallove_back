package com.mcii.service.member.accountLifeHabit;

import com.mcii.entity.Account;
import com.mcii.entity.AccountLifeHabit;
import com.mcii.service.BaseService;

public interface AccountLifeHabitService  extends BaseService<AccountLifeHabit>{

	AccountLifeHabit getAccountLifeHabitById(Account account);

	void updateInfo(Account account, String smoking, String drink, String life,
			String housework, String pet, String deposit);

}
