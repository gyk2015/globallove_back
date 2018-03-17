package com.mcii.service.sign;

import java.io.Serializable;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.Email;
import com.mcii.entity.Sign;
import com.mcii.repository.sign.SignDao;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;

@Service
@Transactional
public class SignServiceImpl implements SignService{
	@Autowired 
	SignDao signDao;

	@Override
	public Sign get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Sign entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Sign entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Sign entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addSign(Sign sign) {
		// TODO Auto-generated method stub
		signDao.save(sign);
	}

	@Override
	public PageRecord getSignById(Account account) {
		// TODO Auto-generated method stub
		String hql = "from Sign where accountid=?0 order by time desc";
		Query<Sign> query = signDao.queryByHql(hql);
		query.setParameter(0, account);
		return Tool.pageList(1,5,query);
	}
	
	
}
