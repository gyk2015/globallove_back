package com.mcii.service.active;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

import javax.mail.MessagingException;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.Active;
import com.mcii.repository.active.ActiveDao;
import com.mcii.tools.MailUtil;
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
		String hql = "from Active";
		Query<Active> query = activeDao.queryByHql(hql);
		return Tool.pageList(page,pageSize,query);
	}

	@Override
	public void addActive(Integer pay, String title, String place,
			String contact, Timestamp enddate, String intro,
			String requirement, String activeimg, Timestamp endtime,
			Timestamp starttime,List<Account> accounts) {
		Active active = new Active();
		active.setActiveimg(activeimg);
		active.setContact(contact);
		active.setEnddate(enddate);
		active.setEndtime(endtime);
		active.setIntro(intro);
		active.setPay(pay);
		active.setRequirement(requirement);
		active.setPlace(place);
		active.setStarttime(starttime);
		active.setTitle(title);
		activeDao.save(active);
		try {
			String[] to = new String[accounts.size()];
			for (int i = 0;i<accounts.size();i++){
				to[i] = accounts.get(i).getUseremail();
			}
        	String[] fileList = new String[0];
        	String mailtitle = "GlobalLove有新活动了";
        	String mailcontent = "GlobalLove有最新活动："+active.getTitle()+"，赶紧回来看看吧！";
			MailUtil.sendMail(to,mailtitle,mailcontent,fileList);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
	}

}
