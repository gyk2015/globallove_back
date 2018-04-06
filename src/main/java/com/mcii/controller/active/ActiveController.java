package com.mcii.controller.active;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.Active;
import com.mcii.service.active.ActiveService;
import com.mcii.service.member.account.AccountService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("active")
public class ActiveController {
	
	@Autowired
	ActiveService activeService;
	
	@Autowired
	AccountService accountService;
	
	/**
     * 获取活动
     * @
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getActive",method = RequestMethod.GET)
    public BaseResponse getActive(
    		@RequestParam(required = true,defaultValue = "1")Integer id){
    	Active active = activeService.getActiveById(id);
    	return Tool.returnSuccess("查询成功", active);
    }
    /**
     * 获取活动列表
     */
    @ResponseBody
    @RequestMapping(value = "getActives",method = RequestMethod.GET)
    public BaseResponse getActives(
    		@RequestParam(required = true,defaultValue = "1")Integer page,
            @RequestParam(required = true,defaultValue = "5")Integer pageSize){
    	PageRecord pageRecord = activeService.getActivesList(page,pageSize);
    	return Tool.returnSuccess("查询成功",pageRecord);
    }
    
    /**
     * 添加活动
     */
    @ResponseBody
    @RequestMapping(value = "addActive",method = RequestMethod.POST)
	public BaseResponse addActive(
			@RequestParam(required = true)Integer pay,
			@RequestParam(required = true)String title,
			@RequestParam(required = true)String place,
			@RequestParam(required = true)String contact,
			@RequestParam(required = true)Timestamp enddate,
			@RequestParam(required = true)String intro,
			@RequestParam(required = true)String requirement,
			@RequestParam(required = true)String activeimg,
			@RequestParam(required = true)Timestamp endtime,
			@RequestParam(required = true)Timestamp starttime){
    	List<Account> accounts = accountService.getAccounts();
    	activeService.addActive(pay,title,place,contact,enddate,intro,requirement,activeimg,endtime,starttime,accounts);
    	return Tool.returnSuccess("添加成功",null);
    }
}
