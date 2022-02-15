package cn.wit.pojo;

import java.util.Date;

public class User {
	private int userid;
	private String username;
	private String password;
	private String name;
	private int sex;
	private String identityNumber;
	private String phoneNumber;
	private String status;
	private Date firstVaccine;
	private Date secondVaccine;
	private Date thirdVaccine;
	private Date latestDetection;
	private int routeid;
	private int	concentrationid;
	private int	homeid;
	private int householdid;
	private int communityid;
	
	public User() {
		super();
	}
	public User(int userid, String username, String password, String name, int sex, String identityNumber,
			String phoneNumber, String status, Date firstVaccine, Date secondVaccine, Date thirdVaccine,
			Date latestDetection, int routeid, int concentrationid, int homeid, int householdid, int communityid) {
		super();
		this.userid = userid;
		this.username = username;
		this.password = password;
		this.name = name;
		this.sex = sex;
		this.identityNumber = identityNumber;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.firstVaccine = firstVaccine;
		this.secondVaccine = secondVaccine;
		this.thirdVaccine = thirdVaccine;
		this.latestDetection = latestDetection;
		this.routeid = routeid;
		this.concentrationid = concentrationid;
		this.homeid = homeid;
		this.householdid = householdid;
		this.communityid = communityid;
	}
	public int getUserid() {
		return userid;
	}
	public String getUsername() {
		return username;
	}
	public String getPassword() {
		return password;
	}
	public String getName() {
		return name;
	}
	public int getSex() {
		return sex;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public Date getFirstVaccine() {
		return firstVaccine;
	}
	public Date getSecondVaccine() {
		return secondVaccine;
	}
	public Date getThirdVaccine() {
		return thirdVaccine;
	}
	public Date getLatestDetection() {
		return latestDetection;
	}
	public int getRouteid() {
		return routeid;
	}
	public int getConcentrationid() {
		return concentrationid;
	}
	public int getHomeid() {
		return homeid;
	}
	public int getHouseholdid() {
		return householdid;
	}
	public int getCommunityid() {
		return communityid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public void setFirstVaccine(Date firstVaccine) {
		this.firstVaccine = firstVaccine;
	}
	public void setSecondVaccine(Date secondVaccine) {
		this.secondVaccine = secondVaccine;
	}
	public void setThirdVaccine(Date thirdVaccine) {
		this.thirdVaccine = thirdVaccine;
	}
	public void setLatestDetection(Date latestDetection) {
		this.latestDetection = latestDetection;
	}
	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
	public void setConcentrationid(int concentrationid) {
		this.concentrationid = concentrationid;
	}
	public void setHomeid(int homeid) {
		this.homeid = homeid;
	}
	public void setHouseholdid(int householdid) {
		this.householdid = householdid;
	}
	public void setCommunityid(int communityid) {
		this.communityid = communityid;
	}
}
