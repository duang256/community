package cn.wit.pojo;

import java.util.Date;

public class HomeQuarantine {
	private int homeid;
	private Date starttime;

	public HomeQuarantine() {
		super();
	}

	public HomeQuarantine(int homeid, Date starttime) {
		super();
		this.homeid = homeid;
		this.starttime = starttime;
	}

	public int getHomeid() {
		return homeid;
	}

	public void setHomeid(int homeid) {
		this.homeid = homeid;
	}

	public Date getStarttime() {
		return starttime;
	}

	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
}
