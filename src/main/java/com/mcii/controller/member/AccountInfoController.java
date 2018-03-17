package com.mcii.controller.member;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.mcii.entity.Account;
import com.mcii.entity.AccountBase;
import com.mcii.service.member.accountInfo.AccountInfoService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("baseInfo")
public class AccountInfoController {
	@Autowired
	@Qualifier("accountInfoServiceImpl")
	AccountInfoService accountInfoService;
	
	 @Autowired  
	 private HttpServletRequest request;
	
	/**
	 * 获取基础信息
	 */
	@ResponseBody
    @RequestMapping(value = "getBaseInfo",method = RequestMethod.GET)
	public BaseResponse getBaseInfo()
//			@RequestParam(required = true)Integer accountId)
	{
		Account account = ThisUser.get();
		AccountBase accountbase = accountInfoService.getAccountInfoById(account);
		return Tool.returnSuccess("获取信息成功",accountbase);
	}
	
	/**
	 * 修改基础信息
	 */
	@ResponseBody
    @RequestMapping(value = "updateBaseInfo",method = RequestMethod.POST)
	public BaseResponse updateBaseInfo(
			@RequestParam(required = false) String realname,
			@RequestParam(required = false) String sex,
			@RequestParam(required = false) Integer age,
			@RequestParam(required = false) Integer height,
			@RequestParam(required = false) Integer weight,
			@RequestParam(required = false) String salary,
			@RequestParam(required = false) String education,
			@RequestParam(required = false) String workplace,
			@RequestParam(required = false) String marrystatus,
			@RequestParam(required = false) String nativeplace){
		Account account = ThisUser.get();
		accountInfoService.updateInfo(account,realname,sex,age,height,weight,salary,education,workplace,marrystatus,nativeplace);
		return Tool.returnSuccess("修改成功", null);
	}
	
	/**
	 * 设置头像
	 */
	@ResponseBody
    @RequestMapping(value = "setHeadImg",method = RequestMethod.POST)
	public BaseResponse setHeadImg(
			@RequestParam("file") MultipartFile file){
		Account account = ThisUser.get();
//		File folder = new File(basePath+prefix+account.getId());
		if (!file.isEmpty()) {  
            try {  
                // 文件保存路径  
                String filePath = request.getSession().getServletContext().getRealPath("/") + "upload/"  
                        + file.getOriginalFilename();  
                // 转存文件  
                file.transferTo(new File(filePath)); 
                accountInfoService.setAccountImg(account,filePath);
                return Tool.returnSuccess("上传成功", null);
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
		return Tool.returnFail("上传失败", null);
	}
	
	/**
	 * 获取头像信息
	 */
	@ResponseBody
    @RequestMapping(value = "getHeadImg",method = RequestMethod.GET)
	public BaseResponse getHeadImg(){
		Account account = ThisUser.get();
		String headimg = accountInfoService.getAccountImg(account);
		return Tool.returnSuccess("获取成功", headimg);
	}
}
