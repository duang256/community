package cn.wit.pojo;

import java.util.Date;
import java.util.List;

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
	private List<Route> routeid;
	private ConcentrationQuarantine	concentrationQuarantine;
	private HomeQuarantime homeQuarantime;
	private HouseHold household;
	private CommunityInfo communityInfo;
	private List<Temperature> temperatureList;
	public User(int userid, String username, String password, String name, int sex, String identityNumber,
			String phoneNumber, String status, Date firstVaccine, Date secondVaccine, Date thirdVaccine,
			Date latestDetection, List<Route> routeid, ConcentrationQuarantine concentrationQuarantine,
			HomeQuarantime homeQuarantime, HouseHold household, CommunityInfo communityInfo,
			List<Temperature> temperatureList) {
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
		this.concentrationQuarantine = concentrationQuarantine;
		this.homeQuarantime = homeQuarantime;
		this.household = household;
		this.communityInfo = communityInfo;
		this.temperatureList = temperatureList;
	}
	public User() {
		super();
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getIdentityNumber() {
		return identityNumber;
	}
	public void setIdentityNumber(String identityNumber) {
		this.identityNumber = identityNumber;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getFirstVaccine() {
		return firstVaccine;
	}
	public void setFirstVaccine(Date firstVaccine) {
		this.firstVaccine = firstVaccine;
	}
	public Date getSecondVaccine() {
		return secondVaccine;
	}
	public void setSecondVaccine(Date secondVaccine) {
		this.secondVaccine = secondVaccine;
	}
	public Date getThirdVaccine() {
		return thirdVaccine;
	}
	public void setThirdVaccine(Date thirdVaccine) {
		this.thirdVaccine = thirdVaccine;
	}
	public Date getLatestDetection() {
		return latestDetection;
	}
	public void setLatestDetection(Date latestDetection) {
		this.latestDetection = latestDetection;
	}
	public List<Route> getRouteid() {
		return routeid;
	}
	public void setRouteid(List<Route> routeid) {
		this.routeid = routeid;
	}
	public ConcentrationQuarantine getConcentrationQuarantine() {
		return concentrationQuarantine;
	}
	public void setConcentrationQuarantine(ConcentrationQuarantine concentrationQuarantine) {
		this.concentrationQuarantine = concentrationQuarantine;
	}
	public HomeQuarantime getHomeQuarantime() {
		return homeQuarantime;
	}
	public void setHomeQuarantime(HomeQuarantime homeQuarantime) {
		this.homeQuarantime = homeQuarantime;
	}
	public HouseHold getHousehold() {
		return household;
	}
	public void setHousehold(HouseHold household) {
		this.household = household;
	}
	public CommunityInfo getCommunityInfo() {
		return communityInfo;
	}
	public void setCommunityInfo(CommunityInfo communityInfo) {
		this.communityInfo = communityInfo;
	}
	public List<Temperature> getTemperatureList() {
		return temperatureList;
	}
	public void setTemperatureList(List<Temperature> temperatureList) {
		this.temperatureList = temperatureList;
	}
	
	
	
	

	
}
