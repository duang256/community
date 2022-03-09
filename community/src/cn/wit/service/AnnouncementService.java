package cn.wit.service;

import java.util.List;

import cn.wit.pojo.Announcement;
import cn.wit.pojo.CommunityInfo;

public interface AnnouncementService {
	
	//查询社区公告信息
	public List<Announcement> selectAnnouncement(int communityid);
	
	//增加社区公告信息
	public void addAnnouncement(Announcement announcement);
}
