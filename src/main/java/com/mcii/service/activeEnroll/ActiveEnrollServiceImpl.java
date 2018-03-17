package com.mcii.service.activeEnroll;

import java.io.Serializable;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Active;
import com.mcii.entity.Enroll;
import com.mcii.repository.activeEnroll.ActiveEnrollDao;
import com.mcii.service.active.ActiveService;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;

@Service
@Transactional
public class ActiveEnrollServiceImpl implements ActiveEnrollService{
	
	@Autowired 
	@Qualifier("activeEnrollDaoImpl")
	ActiveEnrollDao activeEnrollDao;
	
//	@Autowired 
//	@Qualifier("activeServiceImpl ")
//	ActiveService activeService;

	@Override
	public Enroll get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Enroll entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Enroll entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Enroll entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Enroll enroll) {
		// TODO Auto-generated method stub
		activeEnrollDao.save(enroll);
	}

//	@Override
//	public PageRecord getActiveEnrollUser(Integer activeid, Integer page,
//			Integer pageSize) {
//		// TODO Auto-generated method stub
//		Active active = activeService.getActiveById(activeid);
//		String hql = "from Enroll where activeid=?0";
//		Query<Enroll> query = activeEnrollDao.queryByHql(hql);
//		query.setParameter(0, active);
//		return Tool.pageList(page,pageSize,query);
//	}

}
