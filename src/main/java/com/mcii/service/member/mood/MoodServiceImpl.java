package com.mcii.service.member.mood;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.Mood;
import com.mcii.repository.mood.MoodDao;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;

@Service
@Transactional
public class MoodServiceImpl implements MoodService{
	@Autowired 
	@Qualifier("moodDaoImpl")
	MoodDao moodDao;

	@Override
	public Mood get(Integer id) {
		// TODO Auto-generated method stub
		return moodDao.get(Mood.class, id);
	}

	@Override
	public Serializable save(Mood entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Mood entity) {
		// TODO Auto-generated method stub
		moodDao.delete(entity);
	}

	@Override
	public void update(Mood entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageRecord listMood(Integer page, Integer pageSize, Account id) {
		// TODO Auto-generated method stub
		String hql = "from Mood where publishid=?0 order by time desc";
		Query<Mood> query = moodDao.queryByHql(hql);
		query.setParameter(0, id);
		return Tool.pageList(page,pageSize,query);
	}

	@Override
	public void saveMood(Account account, String content) {
		// TODO Auto-generated method stub
		Mood mood = new Mood();
		mood.setContent(content);
		mood.setPublishidid(account);
		mood.setTime(new Timestamp(new Date().getTime()));
		moodDao.save(mood);
		
	}



}
