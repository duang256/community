package cn.wit.service;

import java.util.Date;

public interface UpdateVaccineService {
	public void updateVaccine(int uid, Date firstVaccine, Date secondVaccine, Date thirdVaccine);
}
