package cn.wit.dao;

import java.util.Date;

public interface QuarantineDao {
	//�ӼҸ���     
	public void updateHomeQuarantine(int uid,Date starttime,String status);
	//���и���
	public void updateConcentrationQuarantine(int uid,Date starttime,String quarantineaddress,String status);
	//ɾ���ӼҸ���
	public void delHomeQuarantine(int uid,int homeid);
	//ɾ�����и���
	public void delConcentrationQuaratine(int uid,int concentrationid);
}
