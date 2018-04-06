package com.mcii.controller.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.Mood;
import com.mcii.service.member.account.AccountService;
import com.mcii.service.member.mood.MoodService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.PageRecord;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("mood")
public class MoodController {
	@Autowired
	@Qualifier("moodServiceImpl")
	MoodService moodService;
	
	@Autowired
	@Qualifier("accountServiceImpl")
	AccountService accountService;
	
	/**
	 * 获取自己心情
	 */
	@ResponseBody
    @RequestMapping(value = "getMyMood",method = RequestMethod.GET)
	public BaseResponse getMyMood(
			@RequestParam(required = true,defaultValue = "1")Integer page,
            @RequestParam(required = true,defaultValue = "5")Integer pageSize){
		Account account = ThisUser.get();
		PageRecord pageRecord = moodService.listMood(page, pageSize, account);
		if (pageRecord.getCurrentPage()==0||pageRecord.getObjects().size()==0)
            return Tool.returnFail("没有信息",null);
        return Tool.returnSuccess("查询成功",pageRecord);
	}
	
	/**
	 * 提交心情
	 * @param content
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "addMood",method = RequestMethod.POST)
	public BaseResponse addMood(@RequestParam(required = true)String content){
		Account account = ThisUser.get();
		if (content==null)
			return Tool.returnFail("内容不可为空",null);
		moodService.saveMood(account,content);
		return Tool.returnSuccess("提交成功",moodService.listMood(1,5,account));
	}
	
	/**
	 * 获取他人心情
	 */
	@ResponseBody
    @RequestMapping(value = "getMood",method = RequestMethod.GET)
	public BaseResponse getMood(
			@RequestParam(required = true,defaultValue = "1")Integer page,
            @RequestParam(required = true,defaultValue = "5")Integer pageSize,
            @RequestParam(required = true)Integer id){
		Account account = accountService.getAccountById(id);
		PageRecord pageRecord = moodService.listMood(page, pageSize,account);
		if (pageRecord.getCurrentPage()==0||pageRecord.getObjects().size()==0)
            return Tool.returnFail("没有信息",null);
        return Tool.returnSuccess("查询成功",pageRecord);
	}
	
	/**
	 * 删除心情
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "delMood",method = RequestMethod.POST)
	public BaseResponse delMood(@RequestParam(required = true)Integer id){
		Account account = ThisUser.get();
		Mood mood = moodService.get(id);
		moodService.delete(mood);
		return Tool.returnSuccess("删除成功",moodService.listMood(1,5,account));
	}
}
