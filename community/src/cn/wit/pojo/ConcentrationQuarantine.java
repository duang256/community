package cn.wit.pojo;

import java.util.Date;

public class ConcentrationQuarantine {
	private int concentrationid;
	private Date starttime;
	private String quarantineaddress;
	
	
	
	public ConcentrationQuarantine() {
		super();
	}
	public ConcentrationQuarantine(int concentrationid, Date starttime, String quarantineaddress) {
		super();
		this.concentrationid = concentrationid;
		this.starttime = starttime;
		this.quarantineaddress = quarantineaddress;
	}
	public int getConcentrationid() {
		return concentrationid;
	}
	public void setConcentrationid(int concentrationid) {
		this.concentrationid = concentrationid;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public String getQuarantineaddress() {
		return quarantineaddress;
	}
	public void setQuarantineaddress(String quarantineaddress) {
		this.quarantineaddress = quarantineaddress;
	}
}
