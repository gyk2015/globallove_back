package com.mcii.service.active;

import java.sql.Timestamp;
import java.util.List;

import com.mcii.entity.Account;
import com.mcii.entity.Active;
import com.mcii.service.BaseService;
import com.mcii.tools.PageRecord;

public interface ActiveService extends BaseService<Active>{
	//通过ID获取活动
	Active getActiveById(Integer id);
	//获取活动列表
	PageRecord getActivesList(Integer page, Integer pageSize);
	//添加活动
	void addActive(Integer pay, String title, String place, String contact,
			Timestamp enddate, String intro, String requirement,
			String activeimg, Timestamp endtime, Timestamp starttime, List<Account> accounts);

}
