package com.mcii.controller.login;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.AccountBase;
import com.mcii.service.integral.IntegralService;
import com.mcii.service.login.LoginService;
import com.mcii.service.member.accountDtlInfo.AccountDtlInfoService;
import com.mcii.service.member.accountInfo.AccountInfoService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("login")
public class LoginController {
	@Autowired
	@Qualifier("loginServiceImpl")
	LoginService loginService;
	
	@Autowired
	@Qualifier("accountInfoServiceImpl")
	AccountInfoService accountInfoService;
	
	@Autowired
	@Qualifier("integralServiceImpl")
	IntegralService integralService;
	
	@Autowired
	HttpSession session;
	
    /**
     * 注册
     * @param username
     * @param password
     * @param userphone
     * @param useremail
     * @param usertype 0、普通用户 1、管理员 2、情感专家
     * @param emailcode 邮箱验证码。随机数、未激活 null 已激活
     * @param userstate 用户激活标志 0、未激活 1 已激活
     * @return
     * @throws Exception
     */
	@ResponseBody
    @RequestMapping(value = "register",method = RequestMethod.POST)
	public BaseResponse regin(
			@RequestParam(required = true)String username,
            @RequestParam(required = true)String password,
            @RequestParam(required = true,defaultValue = "0")String userphone,
            @RequestParam(required = true)String useremail,
            @RequestParam(required = true,defaultValue = "0")Integer usertype)
	{
		if(loginService.getAccountByUsername(username)!=null)
			return Tool.returnFail("该用户名已被注册", null);
		 loginService.regist(username,password,userphone,useremail,usertype);
	        return Tool.returnSuccess("注册成功",null);
	}
	
	/**
     * 登录
     * @param username
     * @param password
     * @return
     * @throws Exception
     */
	@ResponseBody
    @RequestMapping(value = "log",method = RequestMethod.POST)
    public BaseResponse log(@RequestParam(required = true)String username,
                              @RequestParam(required = true)String password){
		if (session.getAttribute("account_id")!=null)
            return Tool.returnFail("请先注销当前用户",null);
		Account account = loginService.getAccountByUsername(username);
		if (account==null)
            return Tool.returnFail("账号错误",null);
        if (!account.getPassword().equals(Tool.md5Encode(password)))
            return Tool.returnFail("密码错误",null);
        if(account.getUserstate()==0)
        	return Tool.returnFail("您尚未激活", null);
        session.setAttribute("account_id",account.getId());
        session.setAttribute("role",account.getUsertype());
        return Tool.returnSuccess("登录成功",account);
	}
	
	/**
	 * 激活
	 */
	@ResponseBody
    @RequestMapping(value = "activeUser",method = RequestMethod.POST)
	public BaseResponse activeUser(@RequestParam(required = true)String emailcode){
		loginService.activeUser(emailcode);
		return Tool.returnSuccess("激活成功",null);
	}
	
	/**
	 * 认证
	 */
	@ResponseBody
    @RequestMapping(value = "identyUser",method = RequestMethod.POST)
	public BaseResponse identyUser(
			@RequestParam(required = true)String realname,
			@RequestParam(required = true)String idcode){
		Account account = ThisUser.get();
		AccountBase accountBase = accountInfoService.getAccountInfoById(account);
		loginService.identyUser(account,accountBase,realname,idcode);
		integralService.updateIntegral(account,10);
		return Tool.returnSuccess("认证成功",null);
	}
}
