package cn.wit.serviceImpl;

import cn.wit.dao.UserDao;
import cn.wit.daoImpl.UserDaoImpl;
import cn.wit.pojo.User;
import cn.wit.service.UpdateUserService;

public class UpdateUserServiceImpl implements UpdateUserService {
	private UserDao userDao = new UserDaoImpl();

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

}
