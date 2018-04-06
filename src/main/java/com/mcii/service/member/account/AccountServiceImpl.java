package com.mcii.service.member.account;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.AccountBase;
import com.mcii.repository.account.AccountDao;

@Service
@Transactional
public class AccountServiceImpl implements AccountService{
	@Autowired 
	@Qualifier("accountDaoImpl")
	AccountDao accountDao;
	
	@Override
	public Account get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Account entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Account entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Account getAccountById(Integer id) {
		// TODO Auto-generated method stub
		return accountDao.get(Account.class, id);
	}
	
	@Override
	public void setAccountImg(Integer accountid, String filePath) {
		// TODO Auto-generated method stub
		Account account = getAccountById(accountid);
		account.setHeadimg(filePath);
		accountDao.update(account);
	}

	@Override
	public List<Account> getAccounts() {
		String hql = "from Account where usertype=0";
		Query<Account> query = accountDao.queryByHql(hql);
		List<Account> accounts = query.getResultList();
		return accounts;
	}

//	@Override
//	public String getAccountImg(Integer accountid) {
//		Account account = getAccountById(accountid);
//		String headimg = account.getHeadimg();
//		return headimg;
//	}

}
