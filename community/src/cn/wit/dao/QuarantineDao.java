package cn.wit.dao;

import java.util.Date;

public interface QuarantineDao {
	//¾Ó¼Ò¸ôÀë     
	public void updateHomeQuarantine(int uid,Date starttime,String status);
	//¼¯ÖĞ¸ôÀë
	public void updateConcentrationQuarantine(int uid,Date starttime,String quarantineaddress,String status);
	//É¾³ı¾Ó¼Ò¸ôÀë
	public void delHomeQuarantine(int uid,int homeid);
	//É¾³ı¼¯ÖĞ¸ôÀë
	public void delConcentrationQuaratine(int uid,int concentrationid);
}
