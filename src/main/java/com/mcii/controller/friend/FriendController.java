package com.mcii.controller.friend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.Friend;
import com.mcii.service.friend.FriendService;
import com.mcii.service.member.account.AccountService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.PageRecord;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("friend")
public class FriendController {
	@Autowired
    @Qualifier("friendServiceImpl")
	FriendService friendService;
	
	@Autowired
    @Qualifier("accountServiceImpl")
	AccountService accountService;
	
	@ResponseBody
    @RequestMapping(value = "addFollow",method = RequestMethod.POST)
	 public BaseResponse addFollow(@RequestParam(required = true)Integer id){
		Account account = ThisUser.get();
		Account baccount = accountService.getAccountById(id);
		friendService.addFollow(account,baccount);
		return Tool.returnSuccess("关注成功", null);
	}
	
	@ResponseBody
    @RequestMapping(value = "hasFollow",method = RequestMethod.GET)
	 public BaseResponse hasFollow(@RequestParam(required = true)Integer id){
		Account account = ThisUser.get();
		Account baccount = accountService.getAccountById(id);
		Friend friend = friendService.hasFollow(account,baccount);
		return Tool.returnSuccess("查询成功", friend);
	}
	
	@ResponseBody
    @RequestMapping(value = "removeFollow",method = RequestMethod.POST)
	 public BaseResponse removeFollow(@RequestParam(required = true)Integer id){
		Account account = ThisUser.get();
		Account baccount = accountService.getAccountById(id);
		friendService.removeFollow(account,baccount);
		return Tool.returnSuccess("取消关注成功", null);
	}
	
	@ResponseBody
    @RequestMapping(value = "getFollow",method = RequestMethod.GET)
	 public BaseResponse getFollow(
				@RequestParam(required = true,defaultValue = "1")Integer page,
	            @RequestParam(required = true,defaultValue = "5")Integer pageSize){
		Account account = ThisUser.get();
		PageRecord pageRecord = friendService.getFollow(page,pageSize,account);
		return Tool.returnSuccess("查询成功", pageRecord);
	}
	
	@ResponseBody
    @RequestMapping(value = "getFan",method = RequestMethod.GET)
	 public BaseResponse getFan(
				@RequestParam(required = true,defaultValue = "1")Integer page,
	            @RequestParam(required = true,defaultValue = "5")Integer pageSize){
		Account account = ThisUser.get();
		PageRecord pageRecord = friendService.getFan(page,pageSize,account);
		return Tool.returnSuccess("查询成功", pageRecord);
	}
}
