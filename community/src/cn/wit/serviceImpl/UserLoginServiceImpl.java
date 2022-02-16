package cn.wit.serviceImpl;

import cn.wit.service.UserLoginService;

import cn.wit.dao.UserLoginDao;
import cn.wit.daoImpl.UserLoginDaoImpl;
import cn.wit.exception.UserNotFoundException;
import cn.wit.pojo.User;

public class UserLoginServiceImpl implements UserLoginService{
	UserLoginDao userLoginDao = new UserLoginDaoImpl();
	
	@Override
	public User userLogin(String username, String password) {
        User user = userLoginDao.selectUsersByUserNameAndUserPwd(username, password);
        if(user == null){
            throw new UserNotFoundException("用户名或密码有误！");
        }
        return user;
	}

	@Override
	public User selectUserInfo(User user) {
		User userinfo = userLoginDao.selectUserInfo(user);
		return userinfo;
	}
}
