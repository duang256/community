package cn.wit.serviceImpl;

import cn.wit.service.UserLoginService;

import cn.wit.dao.UserLoginDao;
import cn.wit.daoImpl.UserLoginDaoImpl;
import cn.wit.exception.UserNotFoundException;
import cn.wit.pojo.User;

public class UserLoginServiceImpl implements UserLoginService{
	UserLoginDao ld = new UserLoginDaoImpl();
	
	@Override
	public User userLogin(String username, String password) {
		UserLoginDao userLoginDao = new UserLoginDaoImpl();
        User user = userLoginDao.selectUsersByUserNameAndUserPwd(username, password);
        if(user == null){
            throw new UserNotFoundException("用户名或密码有误！");
        }
        return user;
	}
}
