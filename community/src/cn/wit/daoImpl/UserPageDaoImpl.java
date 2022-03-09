package cn.wit.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wit.common.JdbcUtil;
import cn.wit.common.PageInfo;
import cn.wit.dao.UserLoginDao;
import cn.wit.dao.UserPageDao;
import cn.wit.pojo.Admin;
import cn.wit.pojo.User;

public class UserPageDaoImpl implements UserPageDao {

	@Override
	public List<User> selectUserPageByCommunityId(int communityid, PageInfo pi) {
		UserLoginDao userloginDao = new UserLoginDaoImpl();
		// 先遍历所有社区内用户uid，然后查询所有用户信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select uid from user where communityid = ? limit ?,?";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setInt(1, communityid);
			ps.setObject(2, pi.getStartNumber());
			ps.setObject(3, pi.getPageSize());
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("uid"));
				User u = userloginDao.selectUserInfo(user);
				userList.add(u);
			}
			conn.commit();
			JdbcUtil.closeAll(conn, null, ps);
			return userList;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public int allUsercount(int communityid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select count(*) from user where communityid = ?";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setInt(1, communityid);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			conn.commit();
			JdbcUtil.closeAll(conn, null, ps);
			return count;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<User> selectQuarantineUserPageByCommunityId(int communityid, PageInfo pi) {
		UserLoginDao userloginDao = new UserLoginDaoImpl();
		// 先遍历所有社区内用户uid，然后查询所有用户信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select uid from user where communityid = ? and ( isNull(homeid) or isNull(concentrationid)) limit ?,?";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setInt(1, communityid);
			ps.setObject(2, pi.getStartNumber());
			ps.setObject(3, pi.getPageSize());
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("uid"));
				User u = userloginDao.selectUserInfo(user);
				userList.add(u);
			}
			conn.commit();
			JdbcUtil.closeAll(conn, null, ps);
			return userList;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public int quarantineUsercount(int communityid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select count(*) from user where communityid = ? and ( isNull(homeid) or isNull(concentrationid))";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setInt(1, communityid);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			conn.commit();
			JdbcUtil.closeAll(conn, null, ps);
			return count;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public List<User> selectVaccineUserPageByCommunityId(int communityid, PageInfo pi) {
		UserLoginDao userloginDao = new UserLoginDaoImpl();
		// 先遍历所有社区内用户uid，然后查询所有用户信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;
		List<User> userList = new ArrayList<User>();
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select uid from user where communityid = ? and (ISNULL(firstVaccine) or ISNULL(secondVaccine) or ISNULL(thirdVaccine)) limit ?,?";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setInt(1, communityid);
			ps.setObject(2, pi.getStartNumber());
			ps.setObject(3, pi.getPageSize());
			rs = ps.executeQuery();
			while (rs.next()) {
				User user = new User();
				user.setUserid(rs.getInt("uid"));
				User u = userloginDao.selectUserInfo(user);
				userList.add(u);
			}
			conn.commit();
			JdbcUtil.closeAll(conn, null, ps);
			return userList;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public int vaccineUsercount(int communityid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int count = 0;
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select count(*) from user where communityid = ? and (ISNULL(firstVaccine) or ISNULL(secondVaccine) or ISNULL(thirdVaccine))";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setInt(1, communityid);
			rs = ps.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			conn.commit();
			JdbcUtil.closeAll(conn, null, ps);
			return count;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		return count;
	}

}
