package cn.wit.serviceImpl;

import cn.wit.dao.TemperatureDao;
import cn.wit.daoImpl.TemperatureDaoImpl;
import cn.wit.pojo.Temperature;
import cn.wit.service.TemperatureService;

public class TemperatureServiceImpl implements TemperatureService {
	private TemperatureDao tempetatureDao = new TemperatureDaoImpl();

	@Override
	public void addUserTemperature(Temperature temperature) {
		tempetatureDao.addUserTemperature(temperature);
	}

}
