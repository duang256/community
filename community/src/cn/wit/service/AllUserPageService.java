package cn.wit.service;

import cn.wit.common.PageInfo;

public interface AllUserPageService {
	//��ѯ�����û���ҳ
	PageInfo selAllUserByPage(int communityid,String pageNumberStr,String pageSizeStr);
	
	PageInfo selectHomeQuarantineUserPage(int communityid,String pageNumberStr,String pageSizeStr);
	
	PageInfo selectConcentrationQuarantineUserPage(int communityid,String pageNumberStr,String pageSizeStr);
	
	PageInfo selectVaccineUserPage(int communityid,String pageNumberStr,String pageSizeStr);

	PageInfo selAllVaccineUserPage(int communityid, String pageNumberStr, String pageSizeStr);
}
