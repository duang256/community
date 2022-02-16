package cn.wit.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.CommunityQuarantimeCountDao;
import cn.wit.pojo.Admin;
import cn.wit.pojo.CommunityInfo;

public class CommunityQuarantimeCountDaoImpl implements CommunityQuarantimeCountDao{

	@Override
	public int[] selectCountOfQuarantime(CommunityInfo communityInfo) {
		Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        Admin admin = null;
        
        int[] arr = new int[3];
        try {
            conn= JdbcUtil.getConn();
            conn.setAutoCommit(false);
            String homeSql = "select count(*) from user where communityid = ? and status = '“…À∆'";  
            ps = JdbcUtil.getPreSta(conn, homeSql);
            ps.setInt(1, communityInfo.getCommunityid());
            rs = ps.executeQuery();
            while(rs.next()){
            	arr[0] = rs.getInt(1);
            }
            
            String concentrationSql = "select count(*) from user where communityid = ? and status = '√‹Ω”'";  
            ps = JdbcUtil.getPreSta(conn, concentrationSql);
            ps.setInt(1, communityInfo.getCommunityid());
            rs = ps.executeQuery();
            while(rs.next()){
            	arr[1] = rs.getInt(1);
            }
            
            
            String concentrationSql2 = "select count(*) from user where communityid = ? and status = '»∑’Ô'";  
            ps = JdbcUtil.getPreSta(conn, concentrationSql2);
            ps.setInt(1, communityInfo.getCommunityid());
            rs = ps.executeQuery();
            while(rs.next()){
            	arr[2] = rs.getInt(1);
            }
            
            
            conn.commit();
            JdbcUtil.closeAll(conn,null,ps);
            return arr;
        }catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return arr;
	}

}
