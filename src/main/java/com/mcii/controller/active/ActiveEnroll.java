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
//	@ResponseBody
//    @RequestMapping(value = "getEnrollUser",method = RequestMethod.GET)
//    public BaseResponse getEnrollUser(
//    		@RequestParam(required = true,defaultValue = "1")Integer activeid,
//    		@RequestParam(required = true,defaultValue = "1")Integer page,
//            @RequestParam(required = true,defaultValue = "5")Integer pageSize){
//		PageRecord pageRecord = activeEnrollService.getActiveEnrollUser(activeid,page,pageSize);
//		 return Tool.returnSuccess("查询成功",pageRecord);
//	}
}