package cn.wit.dao;

import java.util.Date;

public interface VaccineDao {
	//�޸��û�������Ϣ
	public void updateVaccine(int uid,Date firstVaccine,Date secondVaccine,Date thirdVaccine);
}
