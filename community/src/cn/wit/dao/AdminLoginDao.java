package cn.wit.dao;

import java.util.List;

import cn.wit.pojo.Admin;
import cn.wit.pojo.User;

public interface AdminLoginDao {
	//��¼
	Admin selectAdminByUserNameAndUserPwd(String uesrname,String password);
}
