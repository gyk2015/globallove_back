package com.mcii.service.active;

import java.io.Serializable;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Active;
import com.mcii.repository.active.ActiveDao;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;

@Service
@Transactional
public class ActiveServiceImpl implements ActiveService{
	
	@Autowired 
	ActiveDao activeDao;

	@Override
	public Active get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Active entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Active entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Active entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Active getActiveById(Integer id) {
		// TODO Auto-generated method stub
		return activeDao.get(Active.class,id);
	}

	@Override
	public PageRecord getActivesList(Integer page, Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Active";
		Query<Active> query = activeDao.queryByHql(hql);
		return Tool.pageList(page,pageSize,query);
	}

}
