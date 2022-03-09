package cn.wit.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.UserDao;
import cn.wit.pojo.User;

public class UserDaoImpl implements UserDao{

	@Override
	public void updateUser(User user) {
		Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "update user set username = ?,password=?,name=?"
            		+ ",sex=?,identityNumber=?,phonenumber=? where uid=?";
            ps = JdbcUtil.getPreSta(conn, sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getName());
            ps.setInt(4, user.getSex());
            ps.setString(5, user.getIdentityNumber());
            ps.setString(6, user.getPhoneNumber());
            ps.setInt(7, user.getUserid());
            ps.executeUpdate();
            conn.commit();
            JdbcUtil.closeAll(conn,null,ps);
        }catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
	}

}
