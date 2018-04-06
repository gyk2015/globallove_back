package com.mcii.service.mate;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.Mate;
import com.mcii.repository.account.AccountDao;
import com.mcii.repository.mate.MateDao;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;

@Service
@Transactional
public class MateServiceImpl implements MateService {
	@Autowired 
	@Qualifier("mateDaoImpl")
	MateDao mateDao;
	
	@Autowired 
	@Qualifier("accountDaoImpl")
	AccountDao accountDao;

	@Override
	public Mate get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Mate entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Mate entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Mate entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Mate getMateById(Account account) {
		String hql = "from Mate where accountid=?0";
		Query<Mate> query = mateDao.queryByHql(hql);
        query.setParameter(0,account);
        return query.uniqueResult();
	}

	@Override
	public void updateMate(Account account, Integer startage, Integer endage,
			String place, Integer startheight, Integer endheight,
			String marrystatus, String education, String house,
			Integer startsalary, Integer endsalary, String child) {
		Mate mate = getMateById(account);
		mate.setChild(child);
		mate.setEducation(education);
		mate.setEndage(endage);
		mate.setEndheight(endheight);
		mate.setEndsalary(endsalary);
		mate.setHouse(house);
		mate.setMarrystatus(marrystatus);
		mate.setPlace(place);
		mate.setStartage(startage);
		mate.setStartheight(startheight);
		mate.setStartsalary(startsalary);
		mateDao.update(mate);
		
	}

	@Override
	public PageRecord getMatePersons(Account account, Integer page, Integer pageSize) {
		Mate mate = getMateById(account);
		String hql = "from AccountBase ab,AccountFamily af,AccountDtl ad where ab.accountid=af.accountid and ab.accountid=ad.accountid and child=?0 and education=?1 and age>?2 and age<?3 and height>?4 and height<?5 and salary>?6 and salary<?7 and house=?8 and marrystatus=?9 and workplace=?10";
		Query query = accountDao.queryByHql2(hql);
		query.setParameter(0, mate.getChild());
		query.setParameter(1, mate.getEducation());
		query.setParameter(2, mate.getStartage());
		query.setParameter(3, mate.getEndage());
		query.setParameter(4, mate.getStartheight());
		query.setParameter(5, mate.getEndheight());
		query.setParameter(6, mate.getStartsalary());
		query.setParameter(7, mate.getEndsalary());
		query.setParameter(8, mate.getHouse());
		query.setParameter(9, mate.getMarrystatus());
		query.setParameter(10, mate.getPlace());
		return Tool.pageList(page,pageSize,query);
//		List<Object> ids = query.getResultList();
		
//		ArrayList<Account> accounts = new ArrayList<>();
//		String hql2 = "from Account where id=?0";
//		Query<Account> query2 = accountDao.queryByHql(hql2);
//		for (Object id : ids) {
//			query2.setParameter(0, id);
//			Account a = query2.uniqueResult();
//			if(a != null) {
//				accounts.add(a);
//			}
//
//		}
//		return accounts;
	}	
}
