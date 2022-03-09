package cn.wit.pojo;

public class Admin {
	private int adminid;
	private String username;
	private String password;
	private CommunityInfo communityInfo;

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

	public CommunityInfo getCommunityInfo() {
		return communityInfo;
	}

	public void setCommunityInfo(CommunityInfo communityInfo) {
		this.communityInfo = communityInfo;
	}

	public Admin(int adminid, String username, String password, CommunityInfo communityInfo) {
		super();
		this.adminid = adminid;
		this.username = username;
		this.password = password;
		this.communityInfo = communityInfo;
	}

	public Admin() {
		super();
	}

}
