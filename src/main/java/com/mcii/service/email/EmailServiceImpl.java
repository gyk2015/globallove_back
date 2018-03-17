package com.mcii.service.email;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.Email;
import com.mcii.repository.email.EmailDao;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;

@Service
@Transactional
public class EmailServiceImpl implements EmailService {

	@Autowired 
	@Qualifier("emailDaoImpl")
	EmailDao emailDao;
	
	@Override
	public Email get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Email entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Email entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Email entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PageRecord getReceiveEmails(Account account, Integer page,
			Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Email where receiveid=?0 or receiveid=0";
		Query<Email> query = emailDao.queryByHql(hql);
		query.setParameter(0, account);
		return Tool.pageList(page,pageSize,query);
	}

	@Override
	public void creatEmail(Account account, Account receive, String title,
			String content) {
		// TODO Auto-generated method stub
		Email email = new Email();
		email.setContent(content);
		email.setReceiveid(receive);
		email.setStatus(0);
		email.setTitle(title);
		email.setSendid(account);
		email.setTime(new Timestamp(new Date().getTime()));
		emailDao.save(email);
	}

	@Override
	public Email getEmailById(Integer id) {
		// TODO Auto-generated method stub
		return emailDao.get(Email.class, id);
	}

	@Override
	public PageRecord getSendEmails(Account account, Integer page,
			Integer pageSize) {
		// TODO Auto-generated method stub
		String hql = "from Email where sendid=?0";
		Query<Email> query = emailDao.queryByHql(hql);
		query.setParameter(0, account);
		return Tool.pageList(page,pageSize,query);
	}

	@Override
	public void delEmail(Integer id) {
		// TODO Auto-generated method stub
		Email email = emailDao.get(Email.class, id);
		emailDao.delete(email);
	}



}
