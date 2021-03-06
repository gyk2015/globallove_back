package com.mcii.service.login;

import java.io.Serializable;

import javax.mail.MessagingException;

import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mcii.entity.Account;
import com.mcii.entity.AccountBase;
import com.mcii.entity.AccountDtl;
import com.mcii.entity.AccountFamily;
import com.mcii.entity.AccountLifeHabit;
import com.mcii.entity.Integral;
import com.mcii.entity.Mate;
import com.mcii.repository.account.AccountDao;
import com.mcii.repository.accountBase.AccountBaseDao;
import com.mcii.repository.accountDtlInfo.AccountDtlInfoDao;
import com.mcii.repository.accountFamily.AccountFamilyDao;
import com.mcii.repository.accountLifeHabit.AccountLifeHabitDao;
import com.mcii.repository.integral.IntegralDao;
import com.mcii.repository.mate.MateDao;
import com.mcii.tools.MailUtil;
import com.mcii.tools.Tool;
import com.mcii.tools.UUIDutil;

@Service
@Transactional
public class LoginServiceImpl implements LoginService{
	
	@Autowired 
	@Qualifier("accountDaoImpl")
	AccountDao accountDao;
	
	@Autowired 
	@Qualifier("accountBaseDaoImpl")
	AccountBaseDao accountBaseDao;
	
	@Autowired 
	@Qualifier("accountDtlInfoDaoImpl")
	AccountDtlInfoDao accountDtlInfoDao;
	
	@Autowired 
	@Qualifier("accountFamilyDaoImpl")
	AccountFamilyDao accountFamilyDao;
	
	@Autowired 
	@Qualifier("accountLifeHabitDaoImpl")
	AccountLifeHabitDao accountLifeHabitDao;
	
	@Autowired 
	@Qualifier("integralDaoImpl")
	IntegralDao integralDao;
	
	@Autowired 
	@Qualifier("mateDaoImpl")
	MateDao mateDao;
	
	@Override
    public void regist(String username,String password,String userphone,String useremail,int usertype){
		Account account = new Account();
        account.setUsername(username);
        account.setPassword(Tool.md5Encode(password));
        account.setUserphone(userphone);
        account.setUseremail(useremail);
        account.setUsertype(usertype);
        String code = UUIDutil.getUUID()+UUIDutil.getUUID();
        account.setEmailcode(code);
        account.setUserstate(0);
        account.setUserlevel(0);
        accountDao.save(account);
        
        AccountBase accountbase = new AccountBase();
        accountbase.setAccountid(account);
        accountBaseDao.save(accountbase);
        
        AccountDtl accountDtl = new AccountDtl();
        accountDtl.setAccountid(account);
        accountDtlInfoDao.save(accountDtl);
        
        AccountFamily accountFamily = new AccountFamily();
        accountFamily.setAccountid(account);
        accountFamilyDao.save(accountFamily);
        
        AccountLifeHabit accountLifeHabit = new AccountLifeHabit();
        accountLifeHabit.setAccountid(account);
        accountLifeHabitDao.save(accountLifeHabit);
        
        Integral integral = new Integral();
        integral.setAccountid(account);
        integral.setIntegral(5);
        integralDao.save(integral);
        
        Mate mate = new Mate();
        mate.setAccountid(account);
        mate.setChild("无");
        mate.setEducation("本科");
        mate.setEndage(35);
        mate.setEndheight(180);
        mate.setEndsalary(15000);
        mate.setHouse("租房");
        mate.setMarrystatus("未婚");
        mate.setPlace("广州市");
        mate.setStartage(18);
        mate.setStartheight(150);
        mate.setStartsalary(5000);
        mateDao.save(mate);
        
        try {
        	String[] to = {useremail};
        	String[] fileList = new String[0];
        	String title = "欢迎注册";
        	String content = "<h1>尊敬的用户您好，欢迎注册globallove，激活请点击:</h1><h3><a href='http://localhost:8080/#/regist?code="+code+"'>http://localhost:8080/#/regist?code="+code+"</a></h3>";
			MailUtil.sendMail(to,title,content,fileList);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
    public Account getAccountByUsername(String username) {
		String hql = "from Account where username=?0";
		Query query = accountDao.queryByHql(hql);
        query.setParameter(0,username);
        Account account = (Account) query.uniqueResult();
        return account;
	}
	
	@Override
	public void activeUser(String emailcode) {
		String hql = "from Account where emailcode=?0";
		Query query = accountDao.queryByHql(hql);
        query.setParameter(0,emailcode);
        Account account = (Account) query.uniqueResult();
		account.setUserstate(1);
		account.setEmailcode(null);
		accountDao.update(account);
	}
	
	@Override
	public Account getUser(int id) {
		return accountDao.get(Account.class, id);
	}
	
	@Override
	public Account get(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Serializable save(Account entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Account entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Account entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void identyUser(Account account, AccountBase accountBase,
			String realname, String idcode) {
		// TODO Auto-generated method stub
		accountBase.setRealname(realname);
		account.setUserlevel(1);
		accountDao.update(account);
		accountBaseDao.update(accountBase);
	}


}
