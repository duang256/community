package cn.wit.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.AdminLoginDao;
import cn.wit.pojo.Admin;

public class AdminLoginDaoImpl implements AdminLoginDao{

	@Override
	public Admin selectAdminByUserNameAndUserPwd(String uesrname, String password) {
		Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        Admin admin = null;
        try {
            conn= JdbcUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "select id,username,password,communityid from admin where username=? and password=?";
            ps = JdbcUtil.getPreSta(conn, sql);
            ps.setString(1, uesrname);
			ps.setString(2, password);
            rs = ps.executeQuery();
            
            while(rs.next()){
           	 admin = new Admin();
           	 admin.setAdminid(rs.getInt("id"));
           	 admin.setUsername(rs.getString("username"));
           	 admin.setPassword(rs.getString("password"));
           	 admin.setCommunityid(rs.getInt("communityid"));
            }
            conn.commit();
            JdbcUtil.closeAll(conn,null,ps);
            return admin;
        }catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return admin;
	}

}
