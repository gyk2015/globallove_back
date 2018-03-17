package com.mcii.controller.sign;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Account;
import com.mcii.entity.Sign;
import com.mcii.service.integral.IntegralService;
import com.mcii.service.sign.SignService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.PageRecord;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("sign")
public class SignController {
	@Autowired
    @Qualifier("signServiceImpl")
	SignService signService;
	
	@Autowired
    @Qualifier("integralServiceImpl")
	IntegralService integralService;
	
	/**
	 * 签到
	 */
	@ResponseBody
    @RequestMapping(value = "addSign",method = RequestMethod.POST)
	 public BaseResponse addSign(){
		Account account = ThisUser.get();
		Sign sign = new Sign();
		sign.setAccountid(account);
		sign.setTime(new Timestamp(new Date().getTime()));
		signService.addSign(sign);
		integralService.updateIntegral(account,1);
		return Tool.returnSuccess("签到成功，积分+1", null);
	}
	
	/**
	 * 获取签到
	 */
	@ResponseBody
    @RequestMapping(value = "getSign",method = RequestMethod.GET)
	 public BaseResponse getSign(){
		Account account = ThisUser.get();
		PageRecord pageRecord = signService.getSignById(account);
		return Tool.returnSuccess("查询成功",pageRecord);
	}
}
