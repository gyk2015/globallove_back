package com.mcii.controller.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.Email;
import com.mcii.service.email.EmailService;
import com.mcii.service.member.account.AccountService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.PageRecord;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("email")
public class EmailController {
	@Autowired
    @Qualifier("emailServiceImpl")
	EmailService emailService;
	
	@Autowired
    @Qualifier("accountServiceImpl")
	AccountService accountService;
	
	
	
	/**
	 * 获取收件箱
	 */
	@ResponseBody
    @RequestMapping(value = "getReceiveEmail",method = RequestMethod.GET)
    public BaseResponse getReceiveEmail(
    		@RequestParam(required = true,defaultValue = "1")Integer page,
            @RequestParam(required = true,defaultValue = "5")Integer pageSize){
		Account account = ThisUser.get();
		PageRecord pageRecord = emailService.getReceiveEmails(account,page,pageSize);
		return Tool.returnSuccess("查询成功",pageRecord);
	}
	
	/**
	 * 获取发件箱
	 */
	@ResponseBody
    @RequestMapping(value = "getSendEmail",method = RequestMethod.GET)
    public BaseResponse getSendEmail(
    		@RequestParam(required = true,defaultValue = "1")Integer page,
            @RequestParam(required = true,defaultValue = "5")Integer pageSize){
		Account account = ThisUser.get();
		PageRecord pageRecord = emailService.getSendEmails(account,page,pageSize);
		return Tool.returnSuccess("查询成功", pageRecord);
	}
	
	/**
	 * 发邮件
	 */
	@ResponseBody
    @RequestMapping(value = "addEmail",method = RequestMethod.POST)
	 public BaseResponse addEmail(
	            @RequestParam(required = true)Integer receiveid,
	            @RequestParam(required = true)String title,
	            @RequestParam(required = true)String content){
		Account account = ThisUser.get();
		Account receive = accountService.getAccountById(receiveid);
		emailService.creatEmail(account,receive,title,content);
		return Tool.returnSuccess("发送成功", null);
	}
	
	/**
	 * 获取详细邮件
	 */
	@ResponseBody
    @RequestMapping(value = "getEmail",method = RequestMethod.GET)
    public BaseResponse getEmail(
    		@RequestParam(required = true)Integer id){
		Email email = emailService.getEmailById(id);
		return Tool.returnSuccess("获取成功", email);
	}
	
	/**
	 * 删除收件箱
	 */
	@ResponseBody
	@RequestMapping(value = "delEmail",method = RequestMethod.POST)
	public BaseResponse delEmail(@RequestParam(required = true)Integer id){
		emailService.delEmail(id);
		return Tool.returnSuccess("删除成功", null);
	}
}
