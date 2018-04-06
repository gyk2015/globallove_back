package com.mcii.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.AccountDtl;
import com.mcii.service.member.account.AccountService;
import com.mcii.service.member.accountDtlInfo.AccountDtlInfoService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("dtlInfo")
public class AccountDtlInfoController {
	@Autowired
	@Qualifier("accountDtlInfoServiceImpl")
	AccountDtlInfoService accountDtlInfoService;
	
	@Autowired
	@Qualifier("accountServiceImpl")
	AccountService accountService;
	
	/**
	 * 获取详细信息
	 */
	@ResponseBody
    @RequestMapping(value = "getDtlInfo",method = RequestMethod.GET)
	public BaseResponse getDtlInfo(){
		Account account = ThisUser.get();
		AccountDtl accountDtl = accountDtlInfoService.getAccountDtlInfoById(account);
		return Tool.returnSuccess("获取信息成功",accountDtl);
	}
	
	/**
	 * 获取他人详细信息
	 */
	@ResponseBody
    @RequestMapping(value = "getOtherDtlInfo",method = RequestMethod.GET)
	public BaseResponse getOtherDtlInfo(@RequestParam(required = true)Integer id){
		Account account = accountService.getAccountById(id);
		AccountDtl accountDtl = accountDtlInfoService.getAccountDtlInfoById(account);
		return Tool.returnSuccess("获取信息成功",accountDtl);
	}
	
	/**
	 * 修改详细信息
	 */
	@ResponseBody
    @RequestMapping(value = "updateDtlInfo",method = RequestMethod.POST)
	public BaseResponse updateBaseInfo(
			@RequestParam(required = false) String bloodtype,
			@RequestParam(required = false) String constellation,
			@RequestParam(required = false) String nation,
			@RequestParam(required = false) String zodiac,
			@RequestParam(required = false) String religion,
			@RequestParam(required = false) String house){
			Account account = ThisUser.get();
			accountDtlInfoService.updateInfo(account,bloodtype,constellation,nation,zodiac,religion,house);
			return Tool.returnSuccess("修改成功", null);
	}
}
