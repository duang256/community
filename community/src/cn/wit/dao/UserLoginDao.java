package cn.wit.dao;

import cn.wit.pojo.User;

public interface UserLoginDao {
	User selectUsersByUserNameAndUserPwd(String uname,String pwd);
}
