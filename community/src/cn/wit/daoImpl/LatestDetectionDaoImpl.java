package cn.wit.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.LatestDetectionDao;

public class LatestDetectionDaoImpl implements LatestDetectionDao{

	@Override
	public void updateLatestDetectionDao(int uid, Date latestDetection) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "update user set latestDetection=? where uid=?";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setDate(1, new java.sql.Date(latestDetection.getTime()));
			ps.setInt(2, uid);
			ps.executeUpdate();
			conn.commit();
			JdbcUtil.closeAll(conn, null, ps);
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
	}

}
