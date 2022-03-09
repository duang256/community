package cn.wit.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.AnnouncementDao;
import cn.wit.pojo.Admin;
import cn.wit.pojo.Announcement;

public class AnnouncementDaoImpl implements AnnouncementDao {

	@Override
	public List<Announcement> selectAnnouncement(int communityid) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Admin admin = null;
		List<Announcement> announList = new ArrayList<Announcement>();
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select announceid,title,announcetime,content,communityid from announcement where communityid=?";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setInt(1, communityid);
			rs = ps.executeQuery();

			while (rs.next()) {
				Announcement announcement = new Announcement();
				announcement.setAnnounceid(rs.getInt("announceid"));
				announcement.setTitle(rs.getString("title"));
				announcement.setAnnouncetime(rs.getDate("announcetime"));
				announcement.setContent(rs.getString("content"));
				announcement.setCommunityid(rs.getInt("communityid"));
				announList.add(announcement);
			}
			conn.commit();
			JdbcUtil.closeAll(conn, null, ps);
			return announList;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
			e.printStackTrace();
		}
		return announList;
	}

	@Override
	public void insertAnnouncement(Announcement announcement) {
		Connection conn = null;
		PreparedStatement ps = null;
		Admin admin = null;
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "insert into announcement(announceid,title,announcetime,content,communityid) values(default,?,?,?,?)";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setString(1, announcement.getTitle());
			//util.Dateתsql.Date
			ps.setDate(2, new java.sql.Date(announcement.getAnnouncetime().getTime()));
			ps.setString(3, announcement.getContent());
			ps.setInt(4, announcement.getCommunityid());
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
