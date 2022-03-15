package cn.wit.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
			
			try {  
				SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
			    String dateStringParse = sdf2.format(latestDetection);  
			    System.out.println("Ê±¼ä×ª»»dao£º" + dateStringParse);  
			} catch (Exception e) {  
			    e.printStackTrace();  
			}  
			Timestamp t = new Timestamp(latestDetection.getTime());
			ps.setObject(1, t);
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
