package cn.wit.pojo;

import java.util.Date;

public class Announcement {
	private int announceid;
	private String title;
	private Date announcetime;
	private String content;
	private int communityid;
	
	
	public Announcement() {
		super();
	}
	public Announcement(int announceid, String title, Date announcetime, String content, int communityid) {
		super();
		this.announceid = announceid;
		this.title = title;
		this.announcetime = announcetime;
		this.content = content;
		this.communityid = communityid;
	}
	public int getAnnounceid() {
		return announceid;
	}
	public void setAnnounceid(int announceid) {
		this.announceid = announceid;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getAnnouncetime() {
		return announcetime;
	}
	public void setAnnouncetime(Date announcetime) {
		this.announcetime = announcetime;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getCommunityid() {
		return communityid;
	}
	public void setCommunityid(int communityid) {
		this.communityid = communityid;
	}
}
