package com.mcii.controller.active;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.Active;
import com.mcii.entity.Enroll;
import com.mcii.service.active.ActiveService;
import com.mcii.service.activeEnroll.ActiveEnrollService;
import com.mcii.service.member.account.AccountService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.PageRecord;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("activeEnroll")
public class ActiveEnroll {
	@Autowired
    @Qualifier("activeEnrollServiceImpl")
	ActiveEnrollService activeEnrollService;
	
	@Autowired
    @Qualifier("activeServiceImpl")
    ActiveService activeService;
	
	@Autowired
	@Qualifier("accountServiceImpl")
	AccountService accountService;
    
	/**
	 * 报名活动
	 */
	@ResponseBody
    @RequestMapping(value = "addActiveEnroll",method = RequestMethod.POST)
    public BaseResponse addActiveEnroll(
            @RequestParam(required = true)Integer activeid,
            @RequestParam(required = true)String phone,
            @RequestParam(required = true)String intro){
		Account account = ThisUser.get();
		Enroll enroll = new Enroll();
		Active active = activeService.getActiveById(activeid);
		enroll.setActiveid(active);
		enroll.setIntro(intro);
		enroll.setPhone(phone);
		enroll.setAccountid(account);
		activeEnrollService.add(enroll);
		return Tool.returnSuccess("报名成功",null);
	}
	
	/**
	 * 获取报名某活动人员列表
	 */
	@ResponseBody
    @RequestMapping(value = "getEnrollUser",method = RequestMethod.GET)
    public BaseResponse getEnrollUser(
    		@RequestParam(required = true,defaultValue = "1")Integer activeid,
    		@RequestParam(required = true,defaultValue = "1")Integer page,
            @RequestParam(required = true,defaultValue = "5")Integer pageSize){
		Active active = activeService.getActiveById(activeid);
		PageRecord pageRecord = activeEnrollService.getActiveEnrollUser(active,page,pageSize);
		 return Tool.returnSuccess("查询成功",pageRecord);
	}
	
	/**
	 * 检查某人是否参加了该活动
	 */
	@ResponseBody
    @RequestMapping(value = "getIsEnroll",method = RequestMethod.GET)
    public BaseResponse getIsEnroll(
    		@RequestParam(required = true,defaultValue = "1")Integer activeid){
		Account account = ThisUser.get();
		Active active = activeService.getActiveById(activeid);
		Enroll enroll = activeEnrollService.getIsEnroll(account,active);
		return Tool.returnSuccess("查询成功", enroll);
	}
	
	/**
	 * 获取报名的活动
	 */
	@ResponseBody
    @RequestMapping(value = "getEnrollActive",method = RequestMethod.GET)
    public BaseResponse getEnrollActive(
    		@RequestParam(required = true,defaultValue = "1")Integer page,
    		@RequestParam(required = true,defaultValue = "5")Integer pageSize){
		Account account = ThisUser.get();
		PageRecord pageRecord = activeEnrollService.getEnrollActive(account,page,pageSize);
		return Tool.returnSuccess("查询成功", pageRecord);
	}
	
	/**
	 * 获取他人报名的活动
	 */
	@ResponseBody
    @RequestMapping(value = "getOtherEnrollActive",method = RequestMethod.GET)
    public BaseResponse getOtherEnrollActive(
    		@RequestParam(required = true,defaultValue = "1")Integer id,
    		@RequestParam(required = true,defaultValue = "1")Integer page,
    		@RequestParam(required = true,defaultValue = "5")Integer pageSize){
		Account account = accountService.getAccountById(id);
		PageRecord pageRecord = activeEnrollService.getEnrollActive(account,page,pageSize);
		return Tool.returnSuccess("查询成功", pageRecord);
	}
}
