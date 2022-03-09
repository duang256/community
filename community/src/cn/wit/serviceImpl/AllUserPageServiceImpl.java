package cn.wit.serviceImpl;

import cn.wit.common.PageInfo;
import cn.wit.dao.UserPageDao;
import cn.wit.daoImpl.UserPageDaoImpl;
import cn.wit.service.AllUserPageService;

public class AllUserPageServiceImpl implements AllUserPageService{

	@Override
	public PageInfo selAllUserByPage(int communityid,String pageNumberStr, String pageSizeStr) {
		int pageNumber=1;
		int pageSize=3;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber=Integer.parseInt(pageNumberStr);
		}
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		PageInfo pi=new PageInfo();
		UserPageDao up = new UserPageDaoImpl();
		int count = up.allUsercount(communityid);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		pi.setPageSize(pageSize);
		pi.setStartNumber((pageNumber-1)*pageSize);
		pi.setPageNumber(pageNumber);
		pi.setList(up.selectUserPageByCommunityId(communityid, pi));
		return pi;
	}

	@Override
	public PageInfo selectQuarantineUserPage(int communityid, String pageNumberStr, String pageSizeStr) {
		int pageNumber=1;
		int pageSize=3;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber=Integer.parseInt(pageNumberStr);
		}
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		PageInfo pi=new PageInfo();
		UserPageDao up = new UserPageDaoImpl();
		int count = up.allUsercount(communityid);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		pi.setPageSize(pageSize);
		pi.setStartNumber((pageNumber-1)*pageSize);
		pi.setPageNumber(pageNumber);
		pi.setList(up.selectQuarantineUserPageByCommunityId(communityid, pi));
		return pi;
	}

	@Override
	public PageInfo selectVaccineUserPage(int communityid, String pageNumberStr, String pageSizeStr) {
		int pageNumber=1;
		int pageSize=3;
		if(pageNumberStr!=null&&!pageNumberStr.equals("")){
			pageNumber=Integer.parseInt(pageNumberStr);
		}
		if(pageSizeStr!=null&&!pageSizeStr.equals("")){
			pageSize=Integer.parseInt(pageSizeStr);
		}
		PageInfo pi=new PageInfo();
		UserPageDao up = new UserPageDaoImpl();
		int count = up.allUsercount(communityid);
		pi.setTotal(count%pageSize==0?count/pageSize:count/pageSize+1);
		pi.setPageSize(pageSize);
		pi.setStartNumber((pageNumber-1)*pageSize);
		pi.setPageNumber(pageNumber);
		pi.setList(up.selectVaccineUserPageByCommunityId(communityid, pi));
		return pi;
	}

}
