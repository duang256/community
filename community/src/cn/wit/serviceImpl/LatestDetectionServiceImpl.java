package cn.wit.serviceImpl;

import java.util.Date;

import cn.wit.dao.LatestDetectionDao;
import cn.wit.daoImpl.LatestDetectionDaoImpl;
import cn.wit.service.LatestDetectionService;

public class LatestDetectionServiceImpl implements LatestDetectionService {
	private LatestDetectionDao latestDetectionDao = new LatestDetectionDaoImpl();

	@Override
	public void updateLatestDetectionDao(int uid, Date latestDetection) {
		latestDetectionDao.updateLatestDetectionDao(uid, latestDetection);
	}

}
