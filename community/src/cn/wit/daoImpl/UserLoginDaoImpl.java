package cn.wit.daoImpl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.UserLoginDao;
import cn.wit.pojo.User;

public class UserLoginDaoImpl implements UserLoginDao{

	@Override
	public User selectUsersByUserNameAndUserPwd(String uname, String pwd) {
		 Connection conn=null;
         PreparedStatement ps=null;
         ResultSet rs = null;
         User u = null;
         try {
             conn= JdbcUtil.getConn();
             conn.setAutoCommit(false);
             String sql = "select uid,username,password,age,sex,birthday from user where username=? and password=?";
             ps = JdbcUtil.getPreSta(conn, sql);
             ps.setString(1, uname);
 			 ps.setString(2, pwd);
             rs = ps.executeQuery();
             while(rs.next()){
            	 u = new User();
            	 u.setUserid(rs.getInt("uid"));
            	 u.setUsername(rs.getString("username"));
            	 u.setPassword(rs.getString("password"));
            	 u.setAge(rs.getInt("age"));
            	 u.setSex(rs.getString("sex"));
            	 u.setBirthday(rs.getDate("birthday"));
             }
             conn.commit();
             JdbcUtil.closeAll(conn,null,ps);
             return u;
         } catch (SQLException e) {
             try {
                 conn.rollback();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
             e.printStackTrace();
         }
         return u;
	}
}
