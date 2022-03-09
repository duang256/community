package cn.wit.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.AdminLoginDao;
import cn.wit.dao.UserLoginDao;
import cn.wit.pojo.Admin;
import cn.wit.pojo.CommunityInfo;
import cn.wit.pojo.User;

/**
 * π‹¿Ì‘±µ«¬Ω
 * 
 * @author Administrator
 *
 */
public class AdminLoginDaoImpl implements AdminLoginDao {

	@Override
	public Admin selectAdminByUserNameAndUserPwd(String uesrname, String password) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select id,username,password,communityinfo.*"
					+ "from admin,communityinfo where admin.communityid = communityinfo.communityid and username=? and password=?";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setString(1, uesrname);
			ps.setString(2, password);
			rs = ps.executeQuery();

			while (rs.next()) {
				admin = new Admin();
				CommunityInfo ci = new CommunityInfo();
				admin.setAdminid(rs.getInt("id"));
				admin.setUsername(rs.getString("username"));
				admin.setPassword(rs.getString("password"));
				
				ci.setCommunityid(rs.getInt("communityid"));
				ci.setCommunityname(rs.getString("communityname"));
				ci.setLocation(rs.getString("location"));
				
				admin.setCommunityInfo(ci);
			}
			conn.commit();
			JdbcUtil.closeAll(conn, null, ps);
			return admin;
		} catch (SQLException e) {
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
