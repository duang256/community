package cn.wit.serviceImpl;

import java.util.List;

import cn.wit.dao.CommunityQuarantimeCountDao;
import cn.wit.daoImpl.CommunityQuarantimeCountDaoImpl;
import cn.wit.pojo.CommunityInfo;
import cn.wit.service.TodayEpidemicService;

public class TodayEpidemicServiceImpl implements TodayEpidemicService {
	//´´½¨service
	private CommunityQuarantimeCountDao communityQuarantimeCountDao = new CommunityQuarantimeCountDaoImpl();

	@Override
	public int[] TodayEpidemic(CommunityInfo community) {
		// TODO Auto-generated method stub
		int[] count = communityQuarantimeCountDao.selectCountOfQuarantime(community);
		return count;
	}
	

}
