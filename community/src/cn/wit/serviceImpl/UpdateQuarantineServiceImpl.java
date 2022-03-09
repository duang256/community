package cn.wit.serviceImpl;

import java.util.Date;

import cn.wit.dao.QuarantineDao;
import cn.wit.daoImpl.QuarantineDaoImpl;
import cn.wit.service.UpdateQuarantineService;

public class UpdateQuarantineServiceImpl implements UpdateQuarantineService {
	private QuarantineDao quarantineDao = new QuarantineDaoImpl();

	@Override
	public void updateHomeQuarantine(int uid, Date starttime, String status) {
		quarantineDao.updateHomeQuarantine(uid, starttime, status);
	}

	@Override
	public void updateConcentrationQuarantine(int uid, Date starttime, String quarantineaddress, String status) {
		quarantineDao.updateConcentrationQuarantine(uid, starttime, quarantineaddress, status);
	}

}
