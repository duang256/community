package cn.wit.daoImpl;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.UserLoginDao;
import cn.wit.pojo.CommunityInfo;
import cn.wit.pojo.ConcentrationQuarantine;
import cn.wit.pojo.HomeQuarantime;
import cn.wit.pojo.HouseHold;
import cn.wit.pojo.User;

public class UserLoginDaoImpl implements UserLoginDao{
	@Override
	public User selectUsersByUserNameAndUserPwd(String uname, String pwd) {
		 Connection conn=null;
         PreparedStatement ps=null;
         ResultSet rs = null;
         User u = null;
         try {
             conn= JdbcUtil.getConn();
             conn.setAutoCommit(false);
             String sql = "select uid,username,password from user where username=? and password=?";
             ps = JdbcUtil.getPreSta(conn, sql);
             ps.setString(1, uname);
 			 ps.setString(2, pwd);
             rs = ps.executeQuery();
             while(rs.next()){
            	 u = new User();
            	 u.setUserid(rs.getInt("uid"));
            	 u.setUsername(rs.getString("username"));
            	 u.setPassword(rs.getString("password"));
             }
             conn.commit();
             JdbcUtil.closeAll(conn,null,ps);
             return u;
         } catch (SQLException e) {
             try {
                 conn.rollback();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
             e.printStackTrace();
         }
         return u;
	}

	@Override
	public User selectUserInfo(User user) {
		Connection conn=null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        User u = null;
        try {
            conn= JdbcUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "select user.*,unit,building,room,communityname,location   "
            		+ "from user,communityinfo,household where uid = ? and user.communityid = communityinfo.communityid and  user.householdid = household.householdid;";
            ps = JdbcUtil.getPreSta(conn, sql);
            ps.setInt(1, user.getUserid());
            
            u = new User();
          	CommunityInfo communityInfo = new CommunityInfo();
          	HouseHold hold = new HouseHold();
          	
          	
            rs = ps.executeQuery();
            
            while(rs.next()){
            	System.out.println(rs);
               	u.setUserid(rs.getInt("uid"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
               	u.setName(rs.getString("name"));
               	u.setSex(rs.getInt("sex"));
               	u.setIdentityNumber(rs.getString("identityNumber"));
               	u.setPhoneNumber(rs.getString("phoneNumber"));
               	u.setStatus(rs.getString("status"));
                u.setFirstVaccine(rs.getDate("firstVaccine"));
                u.setSecondVaccine(rs.getDate("secondVaccine"));
               	u.setThirdVaccine(rs.getDate("thirdVaccine"));
               	u.setLatestDetection(rs.getDate("latestDetection"));
               	communityInfo.setCommunityid(rs.getInt("communityid"));
               	communityInfo.setCommunityname(rs.getString("communityname"));
               	 communityInfo.setLocation("location");
               	 u.setCommunityInfo(communityInfo);
               	 
               	 hold.setHouseholdid(rs.getInt("householdid"));
               	 hold.setUnit(rs.getString("unit"));
               	 hold.setBuliding(rs.getInt("building"));
               	 hold.setRoom(rs.getInt("room"));
               	 u.setHousehold(hold);
               	 
               	int homeid = rs.getInt("homeid");
               	int concentrationid = rs.getInt("concentrationid");
               	
               	if(rs.getObject("homeid") != null){
               		System.out.println("homeid");
               		HomeQuarantime homeQuarantime = new HomeQuarantime();
               		
                    String homeSql = "select homeid,starttime from homequarantine where homeid=?";
                    ps = JdbcUtil.getPreSta(conn, homeSql);
                    ps.setInt(1, homeid);
                    rs = ps.executeQuery();
                    rs.next();
                    homeQuarantime.setHomeid(rs.getInt("homeid"));
                    homeQuarantime.setStarttime(rs.getDate("starttime"));
                    u.setHomeQuarantime(homeQuarantime);
                    
               	 }else if(rs.getObject("concentrationid") != null){
               		System.out.println("concentrationid");
               		ConcentrationQuarantine  concentrationQuarantine = new ConcentrationQuarantine();
                    String concentrationSql = "select concentrationid,starttime,quarantineaddress from concentrationquarantine where concentrationid=?";
                    ps = JdbcUtil.getPreSta(conn, concentrationSql);
                    ps.setInt(1, concentrationid);
                    rs = ps.executeQuery();
                    rs.next();
                    concentrationQuarantine.setConcentrationid(rs.getInt(concentrationid));
                    concentrationQuarantine.setStarttime(rs.getDate("starttime"));
                    concentrationQuarantine.setQuarantineaddress(rs.getString("quarantineaddress"));
                    u.setConcentrationQuarantine(concentrationQuarantine);
               	 }
            }
            
            
            conn.commit();
            JdbcUtil.closeAll(conn,null,ps);
            return u;
        } catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return u;
	}
}
