package cn.wit.service;

import java.util.List;

import cn.wit.pojo.Admin;
import cn.wit.pojo.User;

public interface AdminLoginService {
	//��¼
	Admin adminLogin(String username, String password);
	
}
