package cn.wit.pojo;

public class HouseHold {
	private int householdid;
	private String unit;
	private int buliding;
	private int room;
	
	
	public HouseHold() {
		super();
	}
	public HouseHold(int householdid, String unit, int buliding, int room) {
		super();
		this.householdid = householdid;
		this.unit = unit;
		this.buliding = buliding;
		this.room = room;
	}
	public int getHouseholdid() {
		return householdid;
	}
	public void setHouseholdid(int householdid) {
		this.householdid = householdid;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public int getBuliding() {
		return buliding;
	}
	public void setBuliding(int buliding) {
		this.buliding = buliding;
	}
	public int getRoom() {
		return room;
	}
	public void setRoom(int room) {
		this.room = room;
	}
}
