package cn.wit.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.QuarantineDao;
import cn.wit.pojo.Admin;
import cn.wit.pojo.Announcement;

public class QuarantineDaoImpl implements QuarantineDao{

	@Override
	public void updateHomeQuarantine(int uid,Date starttime,String status) {
		//先插入居家隔离表，然后返回自增id，更新user中居家隔离外键，下面集中隔离同
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "insert into homequarantine values(default,?);";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setDate(1, new java.sql.Date(starttime.getTime()));
			ps.executeUpdate();
			
			
			ps = JdbcUtil.getPreSta(conn, "select LAST_INSERT_ID()");
			rs = ps.executeQuery();
			rs.next();
			int homeid = rs.getInt("LAST_INSERT_ID()");
			
			String updateUserSql = "update user set homeid=?,status=? where uid=?";
			ps = JdbcUtil.getPreSta(conn, updateUserSql);
			ps.setInt(1, homeid);
			ps.setString(2, status);
			ps.setInt(3, uid);
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

	@Override
	public void updateConcentrationQuarantine(int uid,Date starttime,String quarantineaddress,String status) {
		//先插入居家隔离表，然后返回自增id，更新user中居家隔离外键，下面集中隔离同
				Connection conn = null;
				PreparedStatement ps = null;
				ResultSet rs = null;
				try {
					conn = JdbcUtil.getConn();
					conn.setAutoCommit(false);
					String sql = "insert into concentrationquarantine values(default,?,?);";
					ps = JdbcUtil.getPreSta(conn, sql);
					ps.setDate(1, new java.sql.Date(starttime.getTime()));
					ps.setString(2, quarantineaddress);
					ps.executeUpdate();
					
					
					ps = JdbcUtil.getPreSta(conn, "select LAST_INSERT_ID()");
					rs = ps.executeQuery();
					rs.next();
					int concentrationid = rs.getInt("LAST_INSERT_ID()");
					
					String updateUserSql = "update user set concentrationid=?,status=? where uid=?";
					ps = JdbcUtil.getPreSta(conn, updateUserSql);
					ps.setInt(1, concentrationid);
					ps.setString(2, status);
					ps.setInt(3, uid);
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

	@Override
	public void delHomeQuarantine(int uid,int homeid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//更新用户外键
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			
			String sql = "update user set homeid = null,status=? where uid=?";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setString(1, "正常");
			ps.setInt(2, uid);
			ps.executeUpdate();
			
			//删除居家隔离表信息
			String delSql = "delete from homequarantine where homeid=?";
			ps = JdbcUtil.getPreSta(conn, delSql);
			ps.setInt(1, homeid);
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

	@Override
	public void delConcentrationQuaratine(int uid,int concentrationid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			//更新用户外键
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			
			String sql = "update user set concentrationid = null,status=? where uid=?";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setString(1, "正常");
			ps.setInt(2, uid);
			ps.executeUpdate();
			
			//删除居家隔离表信息
			String delSql = "delete from concentrationquarantine where concentrationid=?";
			ps = JdbcUtil.getPreSta(conn, delSql);
			ps.setInt(1, concentrationid);
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
