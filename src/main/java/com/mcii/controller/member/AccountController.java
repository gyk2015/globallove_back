package com.mcii.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.service.member.account.AccountService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	@Qualifier("accountServiceImpl")
	AccountService accountService;
	
	/**
	 * 获取用户信息
	 */
	@ResponseBody
    @RequestMapping(value = "getAccount",method = RequestMethod.GET)
	public BaseResponse getAccount(){
		Account account = ThisUser.get();
		return Tool.returnSuccess("获取信息成功",account);
	}
}
