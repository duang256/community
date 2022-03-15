package cn.wit.daoImpl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.UserLoginDao;
import cn.wit.pojo.CommunityInfo;
import cn.wit.pojo.ConcentrationQuarantine;
import cn.wit.pojo.HomeQuarantine;
import cn.wit.pojo.HouseHold;
import cn.wit.pojo.Route;
import cn.wit.pojo.Temperature;
import cn.wit.pojo.User;

/**
 * 用户登录及信息初始化
 * 
 * @author yanyue
 *
 */
public class UserLoginDaoImpl implements UserLoginDao {
	@Override
	public User selectUsersByUserNameAndUserPwd(String uname, String pwd) { // 用户登录
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select uid,username,password from user where username=? and password=?";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setString(1, uname);
			ps.setString(2, pwd);
			rs = ps.executeQuery();
			while (rs.next()) {
				u = new User();
				u.setUserid(rs.getInt("uid"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("password"));
			}
			conn.commit();
			JdbcUtil.closeAll(conn, null, ps);
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
	public User selectUserInfo(User user) { // 用户所有信息
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		User u = null;
		try {
			conn = JdbcUtil.getConn();
			conn.setAutoCommit(false);
			String sql = "select user.*,unit,building,room,communityname,location   "
					+ "from user,communityinfo,household where uid = ? and user.communityid = communityinfo.communityid and  user.householdid = household.householdid";
			ps = JdbcUtil.getPreSta(conn, sql);
			ps.setInt(1, user.getUserid());

			u = new User();
			CommunityInfo communityInfo = new CommunityInfo();
			HouseHold hold = new HouseHold();

			rs = ps.executeQuery();

			while (rs.next()) {
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
				
				Timestamp t = rs.getTimestamp("latestDetection");
				u.setLatestDetection(t);
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
				
				System.out.println("ceshi homeid" + rs.getObject("homeid"));
				System.out.println("ceshi concentrationid" + rs.getObject("concentrationid"));
				
				

				if (rs.getObject("homeid") != null) {
					System.out.println("homeid");
					HomeQuarantine HomeQuarantine = new HomeQuarantine();

					String homeSql = "select homeid,starttime from homequarantine where homeid=?";
					ps = JdbcUtil.getPreSta(conn, homeSql);
					ps.setInt(1, homeid);
					rs = ps.executeQuery();
					while(rs.next()){
						System.out.println("进入homeid");
						HomeQuarantine.setHomeid(rs.getInt("homeid"));
						HomeQuarantine.setStarttime(rs.getDate("starttime"));
						u.setHomeQuarantine(HomeQuarantine);
					}

				} else if (rs.getObject("concentrationid") != null) {
					System.out.println("concentrationid");
					ConcentrationQuarantine concentrationQuarantine = new ConcentrationQuarantine();
					String concentrationSql = "select concentrationid,starttime,quarantineaddress from concentrationquarantine where concentrationid=?";
					ps = JdbcUtil.getPreSta(conn, concentrationSql);
					ps.setInt(1, concentrationid);
					rs = ps.executeQuery();
					while(rs.next()){
						System.out.println("进入concentrationid");
						concentrationQuarantine.setConcentrationid(rs.getInt("concentrationid"));
						concentrationQuarantine.setStarttime(rs.getDate("starttime"));
						concentrationQuarantine.setQuarantineaddress(rs.getString("quarantineaddress"));
						u.setConcentrationQuarantine(concentrationQuarantine);
					}
					
				}
			}
			
			
			
			//用户行程信息和体温打卡
			List<Route> routeList = new ArrayList();
			String routesql = "select * from route where uid = ?";
			ps = JdbcUtil.getPreSta(conn, routesql);
			ps.setInt(1, u.getUserid());
			rs = ps.executeQuery();
			while(rs.next()){
				Route route = new Route();
				route.setRouteid(rs.getInt("routeid"));
				route.setUid(rs.getInt("uid"));
				route.setPlace(rs.getString("place"));
				route.setArrivaltime(rs.getDate("arrivaltime"));
				routeList.add(route);
			}
			u.setRouteList(routeList);
			
			List<Temperature> teList = new ArrayList<>();
			String tesql = "select * from temperature where uid = ?";
			ps = JdbcUtil.getPreSta(conn, tesql);
			ps.setInt(1, u.getUserid());
			rs = ps.executeQuery();
			while(rs.next()){
				Temperature temperature = new Temperature();
				temperature.setTid(rs.getInt("tid"));
				temperature.setTemperature(rs.getDouble("temperature"));
				temperature.setDate(rs.getDate("date"));
				teList.add(temperature);
			}
			u.setTemperatureList(teList);
			
			
			conn.commit();
			JdbcUtil.closeAll(conn, null, ps);
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
