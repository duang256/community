package cn.wit.service;

import java.util.List;

import cn.wit.pojo.Admin;
import cn.wit.pojo.User;

public interface AdminLoginService {
	//µÇÂ¼
	Admin adminLogin(String username, String password);
	
}
