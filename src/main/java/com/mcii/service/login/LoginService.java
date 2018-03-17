package com.mcii.service.login;

import com.mcii.entity.Account;
import com.mcii.entity.AccountBase;
import com.mcii.service.BaseService;

public interface LoginService  extends BaseService<Account>{
	//注册	
	void regist(String username,String password,String userphone,String useremail,int usertype);
	
	//通过用户名获取账号
    Account getAccountByUsername(String username);
    
    //通过激活码激活账号
    void activeUser(String emailcode);
    
    //根据ID获取用户
    Account getUser(int id);

    //认证用户
	void identyUser(Account account, AccountBase accountBase, String realname, String idcode);
}
