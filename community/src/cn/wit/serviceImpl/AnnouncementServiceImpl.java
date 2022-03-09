package cn.wit.serviceImpl;

import java.util.List;

import cn.wit.dao.AnnouncementDao;
import cn.wit.daoImpl.AnnouncementDaoImpl;
import cn.wit.pojo.Announcement;
import cn.wit.pojo.CommunityInfo;
import cn.wit.service.AnnouncementService;

public class AnnouncementServiceImpl implements AnnouncementService{
	private AnnouncementDao announcementDao = new AnnouncementDaoImpl();

	@Override
	public List<Announcement> selectAnnouncement(int communityid) {
		
		List<Announcement> announcement = announcementDao.selectAnnouncement(communityid);
		
		return announcement;
	}

	@Override
	public void addAnnouncement(Announcement announcement) {
		announcementDao.insertAnnouncement(announcement);
	}

}
