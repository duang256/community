package cn.wit.service;

import java.util.List;

import cn.wit.pojo.Announcement;
import cn.wit.pojo.CommunityInfo;

public interface AnnouncementService {
	
	//��ѯ����������Ϣ
	public List<Announcement> selectAnnouncement(int communityid);
	
	//��������������Ϣ
	public void addAnnouncement(Announcement announcement);
}
