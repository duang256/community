package cn.wit.dao;

import cn.wit.common.PageInfo;
import cn.wit.daoImpl.AdminLoginDaoImpl;
import cn.wit.pojo.Admin;
import cn.wit.pojo.User;
import cn.wit.service.AllUserPageService;
import cn.wit.serviceImpl.AllUserPageServiceImpl;

public class Test {
	public static void main(String[] args) {
		AllUserPageService aps = new AllUserPageServiceImpl();
		PageInfo<User> pi = aps.selectQuarantineUserPage(1, null, null);
		System.out.println(pi.getList().size());
	}
}
