package cn.wit.pojo;

import java.util.Date;

public class Route {
	private int routeid;
	private String place;
	private Date arrivaltime;
	
	public Route() {
		super();
	}
	
	public Route(int routeid, String place, Date arrivaltime) {
		super();
		this.routeid = routeid;
		this.place = place;
		this.arrivaltime = arrivaltime;
	}
	
	public int getRouteid() {
		return routeid;
	}
	
	public void setRouteid(int routeid) {
		this.routeid = routeid;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public Date getArrivaltime() {
		return arrivaltime;
	}
	
	public void setArrivaltime(Date arrivaltime) {
		this.arrivaltime = arrivaltime;
	}
}
