package cn.wit.dao;

import java.util.Date;

public interface VaccineDao {
	//修改用户疫苗信息
	public void updateVaccine(int uid,Date firstVaccine,Date secondVaccine,Date thirdVaccine);
}
