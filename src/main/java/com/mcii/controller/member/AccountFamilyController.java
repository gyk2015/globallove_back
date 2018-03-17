package com.mcii.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.AccountFamily;
import com.mcii.service.accountFamily.AccountFamilyService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("familyInfo")
public class AccountFamilyController {
	@Autowired
	@Qualifier("accountFamilyServiceImpl")
	AccountFamilyService accountFamilyService;
	
	/**
	 * 获取家庭信息
	 */
	@ResponseBody
    @RequestMapping(value = "getFamilyInfo",method = RequestMethod.GET)
	public BaseResponse getFamilyInfo()
	{
		Account account = ThisUser.get();
		AccountFamily accountFamily = accountFamilyService.getAccountFamilyById(account);
		return Tool.returnSuccess("获取信息成功",accountFamily);
	}
	
	/**
	 * 修改家庭信息
	 */
	@ResponseBody
    @RequestMapping(value = "updateFamilyInfo",method = RequestMethod.POST)
	public BaseResponse updateBaseInfo(
			@RequestParam(required = false) String parents,
			@RequestParam(required = false) String onlychild,
			@RequestParam(required = false) String child){
		Account account = ThisUser.get();
		accountFamilyService.updateInfo(account,parents,onlychild,child);
		return Tool.returnSuccess("修改成功", null);
	}
}
