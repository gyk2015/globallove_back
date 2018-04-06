package com.mcii.service.member.accountInfo;

import java.io.Serializable;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.AccountBase;
import com.mcii.repository.accountBase.AccountBaseDao;

@Service
@Transactional
public class AccountInfoServiceImpl implements AccountInfoService{
	@Autowired 
	@Qualifier("accountBaseDaoImpl")
	AccountBaseDao accountBaseDao;	
	
	public AccountBase getAccountInfoById(Account account){
		String hql = "from AccountBase where accountid=?0";
		Query<AccountBase> query = accountBaseDao.queryByHql(hql);
        query.setParameter(0,account);
        return query.uniqueResult();
	}
	
	public void updateInfo(Account account, String realname, String sex, Integer age,
			Integer height, Integer weight, Integer salary, String education,
			String workplace, String marrystatus, String nativeplace){
		AccountBase accountbase = getAccountInfoById(account);
		accountbase.setRealname(realname);
		accountbase.setSex(sex);
		accountbase.setAge(age);
		accountbase.setHeight(height);
		accountbase.setWeight(weight);
		accountbase.setSalary(salary);
		accountbase.setEducation(education);
		accountbase.setWorkplace(workplace);
		accountbase.setMarrystatus(marrystatus);
		accountbase.setNativeplace(nativeplace);
		accountBaseDao.update(accountbase);
	}

	@Override
	public AccountBase get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(AccountBase entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AccountBase entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AccountBase entity) {
		// TODO Auto-generated method stub
		
	}

	

}
