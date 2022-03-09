package cn.wit.service;

import cn.wit.common.PageInfo;

public interface AllUserPageService {
	//查询所有用户分页
	PageInfo selAllUserByPage(int communityid,String pageNumberStr,String pageSizeStr);
	
	//
	PageInfo selectQuarantineUserPage(int communityid,String pageNumberStr,String pageSizeStr);
	
	PageInfo selectVaccineUserPage(int communityid,String pageNumberStr,String pageSizeStr);
}
