package cn.wit.serviceImpl;

import java.util.List;

import cn.wit.dao.AdminLoginDao;
import cn.wit.daoImpl.AdminLoginDaoImpl;
import cn.wit.exception.AdminNotFoundException;
import cn.wit.pojo.Admin;
import cn.wit.pojo.User;
import cn.wit.service.AdminLoginService;

public class AdminLoginServiceImpl implements AdminLoginService {
	AdminLoginDao adminLoginDao = new AdminLoginDaoImpl();
	
	@Override
	public Admin adminLogin(String username, String password) {
        Admin admin = adminLoginDao.selectAdminByUserNameAndUserPwd(username, password);
        if(admin == null){
            throw new AdminNotFoundException("用户名或密码有误！");
        }
        return admin;
	}
}
