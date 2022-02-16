package cn.wit.serviceImpl;

import cn.wit.dao.UserRegisterDao;
import cn.wit.daoImpl.UserRegisterDaoImpl;
import cn.wit.pojo.CommunityInfo;
import cn.wit.pojo.HouseHold;
import cn.wit.pojo.User;
import cn.wit.service.UserRegisterService;

public class UserRegisterServiceImpl implements UserRegisterService {
	UserRegisterDao userRegisterDao = new UserRegisterDaoImpl();

	@Override
	public void userRegister(User user) {
		userRegisterDao.insertUser(user);
	}

}
