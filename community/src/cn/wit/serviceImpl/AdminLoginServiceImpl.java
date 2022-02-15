package cn.wit.serviceImpl;

import cn.wit.dao.AdminLoginDao;
import cn.wit.daoImpl.AdminLoginDaoImpl;
import cn.wit.exception.AdminNotFoundException;
import cn.wit.pojo.Admin;
import cn.wit.service.AdminLoginService;

public class AdminLoginServiceImpl implements AdminLoginService {
	AdminLoginDao ld = new AdminLoginDaoImpl();
	
	@Override
	public Admin adminLogin(String username, String password) {
		AdminLoginDao adminLoginDao = new AdminLoginDaoImpl();
        Admin admin = adminLoginDao.selectAdminByUserNameAndUserPwd(username, password);
        if(admin == null){
            throw new AdminNotFoundException("用户名或密码有误！");
        }
        return admin;
	}

}
