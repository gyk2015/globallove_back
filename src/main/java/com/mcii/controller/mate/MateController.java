package com.mcii.controller.mate;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.Mate;
import com.mcii.service.mate.MateService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.PageRecord;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("mate")
public class MateController {
	@Autowired
	@Qualifier("mateServiceImpl")
	MateService mateService;
	
	/**
	 * 获取择偶信息
	 */
	@ResponseBody
    @RequestMapping(value = "getMate",method = RequestMethod.GET)
	public BaseResponse getMate(){
		Account account = ThisUser.get();
		Mate mate = mateService.getMateById(account);
		return Tool.returnSuccess("获取信息成功",mate);
	}
	
	/**
	 * 修改择偶信息
	 */
	@ResponseBody
    @RequestMapping(value = "updateMate",method = RequestMethod.POST)
	public BaseResponse updateMate(
			@RequestParam(required = false) Integer startage,
			@RequestParam(required = false) Integer endage,
			@RequestParam(required = false) String place,
			@RequestParam(required = false) Integer startheight,
			@RequestParam(required = false) Integer endheight,
			@RequestParam(required = false) String marrystatus,
			@RequestParam(required = false) String education,
			@RequestParam(required = false) String house,
			@RequestParam(required = false) Integer startsalary,
			@RequestParam(required = false) Integer endsalary,
			@RequestParam(required = false) String child
			){
		Account account = ThisUser.get();
		mateService.updateMate(account,startage,endage,place,startheight,endheight,marrystatus,education,house,startsalary,endsalary,child);
		return Tool.returnSuccess("修改成功", null);
	}
	
	/**
	 * 获取匹配的推荐会员
	 */
	@ResponseBody
    @RequestMapping(value = "getMatePerson",method = RequestMethod.GET)
	public BaseResponse getMatePerson(
			@RequestParam(required = true,defaultValue = "1")Integer page,
    		@RequestParam(required = true,defaultValue = "5")Integer pageSize){
		Account account = ThisUser.get();
		PageRecord pageRecord = mateService.getMatePersons(account,page,pageSize);
		return Tool.returnSuccess("查询成功", pageRecord);
	}
}
