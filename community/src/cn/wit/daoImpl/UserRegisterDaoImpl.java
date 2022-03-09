package cn.wit.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.UserRegisterDao;
import cn.wit.pojo.User;

public class UserRegisterDaoImpl implements UserRegisterDao{

	@Override
	public void insertUser(User u) {
		Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
            conn= JdbcUtil.getConn();
            conn.setAutoCommit(false);
            
          //添加社区
            String communitynameSql = "select communityid from communityinfo where communityname = ?";
            ps = JdbcUtil.getPreSta(conn, communitynameSql);
            ps.setString(1, u.getCommunityInfo().getCommunityname());
            rs = ps.executeQuery();
            int communityid = -1;
            while(rs.next()){
            	communityid = rs.getInt("communityid");
            }
            
            System.out.println("communityid" + communityid);
            
            if(communityid == -1){
            	 //添加社区
                String communityinfoSql = "insert into communityinfo(communityid,communityname,location) values(default,?,?)";
                ps = JdbcUtil.getPreSta(conn, communityinfoSql);
                ps.setString(1, u.getCommunityInfo().getCommunityname());
                ps.setString(2,u.getCommunityInfo().getLocation());
                ps.execute();
                
                ps = JdbcUtil.getPreSta(conn,"select LAST_INSERT_ID()");
                rs= ps.executeQuery();
                rs.next();
                communityid = rs.getInt("LAST_INSERT_ID()");
            }
            
            
            
            
            String householdSql = "select householdid from household where unit = ? and building=? and room = ?";
            ps = JdbcUtil.getPreSta(conn, householdSql);
            ps.setString(1, u.getHousehold().getUnit());
            ps.setInt(2, u.getHousehold().getBuliding());
            ps.setInt(3, u.getHousehold().getRoom());
            rs = ps.executeQuery();
            int householdid = -1;
            while(rs.next()){
            	householdid = rs.getInt("householdid");
            }
            
            System.out.println("householdid" + householdid);
            if(householdid == -1){
            	//添加住址
                String houseHold = "insert into household(householdid,unit,building,room) values(default,?,?,?)";
                ps = JdbcUtil.getPreSta(conn, houseHold);
                ps.setString(1, u.getHousehold().getUnit());
                ps.setInt(2, u.getHousehold().getBuliding());
                ps.setInt(3, u.getHousehold().getRoom());
                ps.execute();
                
                ps = JdbcUtil.getPreSta(conn,"select LAST_INSERT_ID()");
                rs = ps.executeQuery();
                rs.next();
                householdid = rs.getInt("LAST_INSERT_ID()");
            }
            
            
            //添加用户
            
            String userSql = "insert into user(uid,username,password,name,sex,identityNumber,phoneNumber,householdid,communityid) values(default,?,?,?,?,?,?,?,?)";
            ps = JdbcUtil.getPreSta(conn, userSql);
            
            ps.setString(1,u.getUsername());
            ps.setString(2, u.getPassword());
            ps.setString(3, u.getName());
            ps.setInt(4, u.getSex());
            ps.setString(5, u.getIdentityNumber());
            ps.setString(6, u.getPhoneNumber());
            ps.setInt(7, householdid);
			ps.setInt(8, communityid);
			ps.execute();
			
            conn.commit();
            JdbcUtil.closeAll(conn,null,ps);
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
