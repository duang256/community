package cn.wit.service;

import cn.wit.pojo.User;

public interface UserLoginService {
	User userLogin(String uname,String pwd);
}
