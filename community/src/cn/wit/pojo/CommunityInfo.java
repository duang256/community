package cn.wit.pojo;

public class CommunityInfo {
	private int communityid;
	private String communityname;
	private String location;
	
	
	public CommunityInfo() {
		super();
	}
	public CommunityInfo(int communityid, String communityname, String location) {
		super();
		this.communityid = communityid;
		this.communityname = communityname;
		this.location = location;
	}
	public int getCommunityid() {
		return communityid;
	}
	public void setCommunityid(int communityid) {
		this.communityid = communityid;
	}
	public String getCommunityname() {
		return communityname;
	}
	public void setCommunityname(String communityname) {
		this.communityname = communityname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
