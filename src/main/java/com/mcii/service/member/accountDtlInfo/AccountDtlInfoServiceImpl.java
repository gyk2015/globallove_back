package com.mcii.service.member.accountDtlInfo;

import java.io.Serializable;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.AccountDtl;
import com.mcii.repository.accountDtlInfo.AccountDtlInfoDao;

@Service
@Transactional
public class AccountDtlInfoServiceImpl implements AccountDtlInfoService {
	@Autowired 
	@Qualifier("accountDtlInfoDaoImpl")
	AccountDtlInfoDao accountDtlInfoDao;
	
	@Override
	public AccountDtl getAccountDtlInfoById(Account account){
		String hql = "from AccountDtl where accountid=?0";
		Query<AccountDtl> query = accountDtlInfoDao.queryByHql(hql);
        query.setParameter(0,account);
        return query.uniqueResult();
	}
	
	@Override
	public void updateInfo(Account account, String bloodtype, String constellation,
			String nation, String zodiac, String religion, String house){
		AccountDtl accountDtl = getAccountDtlInfoById(account);
		accountDtl.setBloodtype(bloodtype);
		accountDtl.setConstellation(constellation);
		accountDtl.setHouse(house);
		accountDtl.setNation(nation);
		accountDtl.setReligion(religion);
		accountDtl.setZodiac(zodiac);
		accountDtlInfoDao.update(accountDtl);
	}

	@Override
	public AccountDtl get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(AccountDtl entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(AccountDtl entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AccountDtl entity) {
		// TODO Auto-generated method stub
		
	}
}
