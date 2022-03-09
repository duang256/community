package cn.wit.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.VaccineDao;

public class VaccineDaoImpl implements VaccineDao{

	@Override
	public void updateVaccine(int uid, Date firstVaccine, Date secondVaccine, Date thirdVaccine) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "update user set firstVaccine=?,secondVaccine=?,thirdVaccine=? where uid=?";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setDate(1, new java.sql.Date(firstVaccine.getTime()));
			ps.setDate(2, new java.sql.Date(secondVaccine.getTime()));
			ps.setDate(3, new java.sql.Date(thirdVaccine.getTime()));
			ps.setInt(4, uid);
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
