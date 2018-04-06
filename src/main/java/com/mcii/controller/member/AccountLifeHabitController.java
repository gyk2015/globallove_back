package com.mcii.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.AccountBase;
import com.mcii.entity.AccountLifeHabit;
import com.mcii.service.member.account.AccountService;
import com.mcii.service.member.accountLifeHabit.AccountLifeHabitService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("lifeHabit")
public class AccountLifeHabitController {
	@Autowired
	@Qualifier("accountLifeHabitServiceImpl")
	AccountLifeHabitService accountLifeHabitService;
	
	@Autowired
	@Qualifier("accountServiceImpl")
	AccountService accountService;
	
	/**
	 * 获取生活习惯信息
	 */
	@ResponseBody
    @RequestMapping(value = "getLifeHabit",method = RequestMethod.GET)
	public BaseResponse getLifeHabit()
	{
		Account account = ThisUser.get();
		AccountLifeHabit accountLifeHabit = accountLifeHabitService.getAccountLifeHabitById(account);
		return Tool.returnSuccess("获取信息成功",accountLifeHabit);
	}
	
	/**
	 * 获取他人生活习惯信息
	 */
	@ResponseBody
    @RequestMapping(value = "getOtherLifeHabit",method = RequestMethod.GET)
	public BaseResponse getOtherLifeHabit(
			@RequestParam(required = true)Integer id)
	{
		Account account = accountService.getAccountById(id);
		AccountLifeHabit accountLifeHabit = accountLifeHabitService.getAccountLifeHabitById(account);
		return Tool.returnSuccess("获取信息成功",accountLifeHabit);
	}
	
	/**
	 * 修改生活习惯信息
	 */
	@ResponseBody
    @RequestMapping(value = "updateLifeHaibit",method = RequestMethod.POST)
	public BaseResponse updateLifeHaibit(
			@RequestParam(required = false) String smoking,
			@RequestParam(required = false) String drink,
			@RequestParam(required = false) String life,
			@RequestParam(required = false) String housework,
			@RequestParam(required = false) String pet,
			@RequestParam(required = false) String deposit){
		Account account = ThisUser.get();
		accountLifeHabitService.updateInfo(account,smoking,drink,life,housework,pet,deposit);
		return Tool.returnSuccess("修改成功", null);
	}
}
