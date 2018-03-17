package com.mcii.service.member.accountLifeHabit;

import java.io.Serializable;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.AccountFamily;
import com.mcii.entity.AccountLifeHabit;
import com.mcii.repository.accountLifeHabit.AccountLifeHabitDao;

@Service
@Transactional
public class AccountLifeHabitServiceImpl  implements AccountLifeHabitService{

	@Autowired 
	@Qualifier("accountLifeHabitDaoImpl")
	AccountLifeHabitDao accountLifeHabitDao;
	
	@Override
	public AccountLifeHabit get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(AccountLifeHabit entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AccountLifeHabit entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AccountLifeHabit entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AccountLifeHabit getAccountLifeHabitById(Account account) {
		String hql = "from AccountLifeHabit where accountid=?0";
		Query<AccountLifeHabit> query = accountLifeHabitDao.queryByHql(hql);
        query.setParameter(0,account);
        return query.uniqueResult();
	}

	@Override
	public void updateInfo(Account account, String smoking, String drink,
			String life, String housework, String pet, String deposit) {
		AccountLifeHabit accountLifeHabit = getAccountLifeHabitById(account);
		accountLifeHabit.setDeposit(deposit);
		accountLifeHabit.setDrink(drink);
		accountLifeHabit.setHousework(housework);
		accountLifeHabit.setLife(life);
		accountLifeHabit.setSmoking(smoking);
		accountLifeHabit.setPet(pet);
		accountLifeHabitDao.update(accountLifeHabit);
	}

}
