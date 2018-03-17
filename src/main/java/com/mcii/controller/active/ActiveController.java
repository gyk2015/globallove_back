package com.mcii.controller.active;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mcii.entity.Active;
import com.mcii.service.active.ActiveService;
import com.mcii.tools.BaseResponse;
import com.mcii.tools.PageRecord;
import com.mcii.tools.Tool;

@Controller
@RequestMapping("active")
public class ActiveController {
	
	@Autowired
	ActiveService activeService;
	
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
}
