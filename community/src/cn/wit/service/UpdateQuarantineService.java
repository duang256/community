package cn.wit.service;

import java.util.Date;

public interface UpdateQuarantineService {
	
	public void updateHomeQuarantine(int uid, Date starttime, String status);
	
	public void updateConcentrationQuarantine(int uid, Date starttime, String quarantineaddress, String status);
}
