package cn.wit.pojo;

import java.util.Date;

public class Temperature {
	private int tid;
	private double temperature;
	private Date date;
	private int uid;
	
	public Temperature() {
		super();
	}
	public Temperature(int tid, double temperature, Date date, int uid) {
		super();
		this.tid = tid;
		this.temperature = temperature;
		this.date = date;
		this.uid = uid;
	}
	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public double getTemperature() {
		return temperature;
	}
	public void setTemperature(double temperature) {
		this.temperature = temperature;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
}
