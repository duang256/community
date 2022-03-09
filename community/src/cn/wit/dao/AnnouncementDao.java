package cn.wit.dao;

import java.util.List;

import cn.wit.pojo.Announcement;

public interface AnnouncementDao {
	public List<Announcement> selectAnnouncement(int communityid);
	public void insertAnnouncement(Announcement announcement);
}
