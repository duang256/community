package cn.wit.pojo;

public class Admin {
	private int adminid;
	private String username;
	private String password;
	private int communityid;
	
	
	
	public Admin() {
		super();
	}
	
	public Admin(int adminid, String username, String password, int communityid) {
		super();
		this.adminid = adminid;
		this.username = username;
		this.password = password;
		this.communityid = communityid;
	}
	
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCommunityid() {
		return communityid;
	}
	public void setCommunityid(int communityid) {
		this.communityid = communityid;
	}
	
}
