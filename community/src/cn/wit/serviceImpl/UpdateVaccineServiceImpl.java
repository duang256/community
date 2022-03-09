package cn.wit.serviceImpl;

import java.util.Date;

import cn.wit.dao.VaccineDao;
import cn.wit.daoImpl.VaccineDaoImpl;
import cn.wit.service.UpdateVaccineService;

public class UpdateVaccineServiceImpl implements UpdateVaccineService {
	private VaccineDao vaccineDao = new VaccineDaoImpl();

	@Override
	public void updateVaccine(int uid, Date firstVaccine, Date secondVaccine, Date thirdVaccine) {
		vaccineDao.updateVaccine(uid, firstVaccine, secondVaccine, thirdVaccine);
	}

}
