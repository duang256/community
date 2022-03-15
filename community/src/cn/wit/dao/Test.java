package cn.wit.dao;

import java.util.List;

import cn.wit.common.PageInfo;
import cn.wit.daoImpl.AdminLoginDaoImpl;
import cn.wit.pojo.Admin;
import cn.wit.pojo.User;
import cn.wit.service.AllUserPageService;
import cn.wit.serviceImpl.AllUserPageServiceImpl;

public class Test {
	public static void main(String[] args) {
//		AllUserPageService ap  = new AllUserPageServiceImpl();
//		PageInfo selectHomeQuarantineUserPage = ap.selectHomeQuarantineUserPage(1, "", "");
//		
//		List<User> list = selectHomeQuarantineUserPage.getList();
//		for(User user : list){
//			System.out.println(user.getUserid());
//		}
//		
//		
//		System.out.println("分割");
//		PageInfo selectConcentrationQuarantineUserPage = ap.selectConcentrationQuarantineUserPage(1, "", "");
//		List<User> list2 = selectConcentrationQuarantineUserPage.getList();
//		for(User user : list2){
//			System.out.println(user.getUserid());
//		}
		
		
		AllUserPageService ap  = new AllUserPageServiceImpl();
		PageInfo pi = ap.selAllUserByPage(1, "", "");
		List<User> list = pi.getList();
		for(User user : list){
			if( user.getHomeQuarantine() != null){
				System.out.println("居家隔离id："  + user.getHomeQuarantine().getHomeid());
			}else if(user.getConcentrationQuarantine() != null){
				System.out.println("集中隔离id：" + user.getConcentrationQuarantine().getConcentrationid());
			}
		}
		
	}
}
