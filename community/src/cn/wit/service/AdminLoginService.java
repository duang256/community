package cn.wit.service;

import cn.wit.pojo.Admin;

public interface AdminLoginService {
	Admin adminLogin(String username, String password);
}
