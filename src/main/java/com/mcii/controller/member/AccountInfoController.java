package com.mcii.controller.member;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mcii.entity.Account;
import com.mcii.entity.AccountBase;
import com.mcii.service.member.account.AccountService;
import com.mcii.service.member.accountInfo.AccountInfoService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("baseInfo")
public class AccountInfoController {
	@Autowired
	@Qualifier("accountInfoServiceImpl")
	AccountInfoService accountInfoService;
	
	@Autowired
	@Qualifier("accountServiceImpl")
	AccountService accountService;
	
	 @Autowired  
	 private HttpServletRequest request;
	
	/**
	 * 获取基础信息
	 */
	@ResponseBody
    @RequestMapping(value = "getBaseInfo",method = RequestMethod.GET)
	public BaseResponse getBaseInfo()
	{
		Account account = ThisUser.get();
		AccountBase accountbase = accountInfoService.getAccountInfoById(account);
		return Tool.returnSuccess("获取信息成功",accountbase);
	}
	
	/**
	 * 获取他人基础信息
	 */
	@ResponseBody
    @RequestMapping(value = "getOtherBaseInfo",method = RequestMethod.GET)
	public BaseResponse getOtherBaseInfo(
			@RequestParam(required = true)Integer id)
	{
		Account account = accountService.getAccountById(id);
		AccountBase accountbase = accountInfoService.getAccountInfoById(account);
		return Tool.returnSuccess("获取信息成功",accountbase);
	}
	
	/**
	 * 修改基础信息
	 */
	@ResponseBody
    @RequestMapping(value = "updateBaseInfo",method = RequestMethod.POST)
	public BaseResponse updateBaseInfo(
			@RequestParam(required = false) String realname,
			@RequestParam(required = false) String sex,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) Integer height,
			@RequestParam(required = false) Integer weight,
			@RequestParam(required = false) Integer salary,
			@RequestParam(required = false) String education,
			@RequestParam(required = false) String workplace,
			@RequestParam(required = false) String marrystatus,
			@RequestParam(required = false) String nativeplace){
		Account account = ThisUser.get();
		accountInfoService.updateInfo(account,realname,sex,age,height,weight,salary,education,workplace,marrystatus,nativeplace);
		return Tool.returnSuccess("修改成功", null);
	}
	
	
}
