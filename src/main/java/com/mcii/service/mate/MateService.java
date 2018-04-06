package com.mcii.service.mate;

import java.util.ArrayList;

import com.mcii.entity.Account;
import com.mcii.entity.Mate;
import com.mcii.service.BaseService;
import com.mcii.tools.PageRecord;

public interface MateService  extends BaseService<Mate>{
	//获取择偶信息
	Mate getMateById(Account account);
	//修改择偶信息
	void updateMate(Account account, Integer startage, Integer endage,
			String place, Integer startheight, Integer endheight,
			String marrystatus, String education, String house,
			Integer startsalary, Integer endsalary, String child);
	//获取推荐对象
	PageRecord getMatePersons(Account account, Integer page, Integer pageSize);

}
