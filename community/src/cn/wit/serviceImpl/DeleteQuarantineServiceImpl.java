package cn.wit.serviceImpl;

import cn.wit.dao.QuarantineDao;
import cn.wit.daoImpl.QuarantineDaoImpl;
import cn.wit.service.DeleteQuarantineService;

public class DeleteQuarantineServiceImpl implements DeleteQuarantineService {
	private QuarantineDao quarantineDao = new QuarantineDaoImpl();

	@Override
	public void delHomeQuarantine(int uid, int homeid) {
		quarantineDao.delHomeQuarantine(uid, homeid);
	}

	@Override
	public void delConcentrationQuaratine(int uid, int concentrationid) {
		quarantineDao.delConcentrationQuaratine(uid, concentrationid);
	}

}
