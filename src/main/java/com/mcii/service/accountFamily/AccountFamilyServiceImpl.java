package com.mcii.service.accountFamily;

import java.io.Serializable;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.AccountDtl;
import com.mcii.entity.AccountFamily;
import com.mcii.repository.accountFamily.AccountFamilyDao;

@Service
@Transactional
public class AccountFamilyServiceImpl implements AccountFamilyService{
	@Autowired 
	@Qualifier("accountFamilyDaoImpl")
	AccountFamilyDao accountFamilyDao;
	
	@Override
	public AccountFamily getAccountFamilyById(Account account){
		String hql = "from AccountFamily where accountid=?0";
		Query<AccountFamily> query = accountFamilyDao.queryByHql(hql);
        query.setParameter(0,account);
        return query.uniqueResult();
	}
	
	@Override
	public void updateInfo(Account account, String parents, String onlychild,
			String child){
		AccountFamily accountFamily = getAccountFamilyById(account);
		accountFamily.setChild(child);
		accountFamily.setOnlychild(onlychild);
		accountFamily.setParents(parents);
		accountFamilyDao.update(accountFamily);
	}
	
	@Override
	public AccountFamily get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(AccountFamily entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AccountFamily entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AccountFamily entity) {
		// TODO Auto-generated method stub
		
	}
}
