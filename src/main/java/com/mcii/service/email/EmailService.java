package com.mcii.service.email;

import com.mcii.entity.Account;
import com.mcii.entity.Email;
import com.mcii.service.BaseService;
import com.mcii.tools.PageRecord;

public interface EmailService extends BaseService<Email>{
	//获取收件箱邮件
	PageRecord getReceiveEmails(Account account, Integer page, Integer pageSize);
	//写邮件
	void creatEmail(Account account, Account receive, String title,
			String content);
	//获取邮件详情 
	Email getEmailById(Integer id);
	//获取发件箱邮件
	PageRecord getSendEmails(Account account, Integer page, Integer pageSize);
	//删除邮件
	void delEmail(Integer id);
	


}
