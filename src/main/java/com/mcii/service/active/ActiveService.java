package com.mcii.service.active;

import com.mcii.entity.Active;
import com.mcii.service.BaseService;
import com.mcii.tools.PageRecord;

public interface ActiveService extends BaseService<Active>{
	//通过ID获取活动
	Active getActiveById(Integer id);
	//获取活动列表
	PageRecord getActivesList(Integer page, Integer pageSize);

}
