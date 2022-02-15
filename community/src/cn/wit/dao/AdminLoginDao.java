package cn.wit.dao;

import cn.wit.pojo.Admin;

public interface AdminLoginDao {
	Admin selectAdminByUserNameAndUserPwd(String uesrname,String password);
}
