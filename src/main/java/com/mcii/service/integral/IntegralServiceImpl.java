package com.mcii.service.integral;

import java.io.Serializable;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.Integral;
import com.mcii.repository.integral.IntegralDao;

@Service
@Transactional
public class IntegralServiceImpl implements IntegralService {
	@Autowired 
	IntegralDao integralDao;

	@Override
	public Integral get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Integral entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Integral entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Integral entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateIntegral(Account account, int i) {
		// TODO Auto-generated method stub
		String hql = "from Integral where accountid=?0";
		Query<Integral> query = integralDao.queryByHql(hql);
		query.setParameter(0, account);
		Integral integral = (Integral)query.uniqueResult();
		int mark = integral.getIntegral() + i;
		integral.setIntegral(mark);
		integralDao.update(integral);
	}

	@Override
	public Integral getIntegralById(Account account) {
		// TODO Auto-generated method stub
		String hql = "from Integral where accountid=?0";
		Query<Integral> query = integralDao.queryByHql(hql);
		query.setParameter(0, account);
		return query.uniqueResult();
	}

}
