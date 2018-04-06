package com.mcii.controller.integral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.Integral;
import com.mcii.service.integral.IntegralService;
import com.mcii.service.member.account.AccountService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("integral")
public class IntegralController {
	
	@Autowired
	@Qualifier("integralServiceImpl")
	IntegralService integralService;
	
	@Autowired
	@Qualifier("accountServiceImpl")
	AccountService accountService;
	
	/**
	 * 获得已获积分
	 */
	@ResponseBody
    @RequestMapping(value = "getIntegral",method = RequestMethod.GET)
	public BaseResponse getIntegral() {
		Account account = ThisUser.get();
		Integral integral = integralService.getIntegralById(account);
		return Tool.returnSuccess("查询成功", integral);
	}
	
	/**
	 * 获得他人已获积分
	 */
	@ResponseBody
    @RequestMapping(value = "getOtherIntegral",method = RequestMethod.GET)
	public BaseResponse getOtherIntegral(
			@RequestParam(required = false) Integer id) {
		Account account = accountService.getAccountById(id);
		Integral integral = integralService.getIntegralById(account);
		return Tool.returnSuccess("查询成功", integral);
	}
}
