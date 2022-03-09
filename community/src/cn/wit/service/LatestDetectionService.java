package cn.wit.service;

import java.util.Date;

public interface LatestDetectionService {
	public void updateLatestDetectionDao(int uid, Date latestDetection);
}
