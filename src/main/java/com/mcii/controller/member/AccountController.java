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
import com.mcii.service.member.account.AccountService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.ThisUser;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("account")
public class AccountController {
	@Autowired
	@Qualifier("accountServiceImpl")
	AccountService accountService;
	
	
	 @Autowired  
	 private HttpServletRequest request;
	 
	/**
	 * 获取用户信息
	 */
	@ResponseBody
    @RequestMapping(value = "getAccount",method = RequestMethod.GET)
	public BaseResponse getAccount(){
		Account account = ThisUser.get();
		return Tool.returnSuccess("获取信息成功",account);
	}
	
	/**
	 * 获取他人用户信息
	 */
	@ResponseBody
    @RequestMapping(value = "getOtherAccount",method = RequestMethod.GET)
	public BaseResponse getOtherAccount(
			@RequestParam(required = false) Integer id){
		Account account = accountService.getAccountById(id);
		return Tool.returnSuccess("获取信息成功",account);
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
                accountService.setAccountImg(account.getId(),filePath);
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
//	@ResponseBody
//    @RequestMapping(value = "getHeadImg",method = RequestMethod.GET)
//	public BaseResponse getHeadImg(){
//		Account account = ThisUser.get();
//		String headimg = accountService.getAccountImg(account.getId());
//		return Tool.returnSuccess("获取成功", headimg);
//	}
}
