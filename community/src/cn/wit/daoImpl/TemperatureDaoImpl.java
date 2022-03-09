package cn.wit.daoImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import cn.wit.common.JdbcUtil;
import cn.wit.dao.TemperatureDao;
import cn.wit.pojo.Temperature;

public class TemperatureDaoImpl implements TemperatureDao{

	@Override
	public void addUserTemperature(Temperature temperature) {
		Connection conn=null;
        PreparedStatement ps=null;
        try {
            conn= JdbcUtil.getConn();
            conn.setAutoCommit(false);
            String sql = "insert into temperature values(default,?,?,?)";
            ps = JdbcUtil.getPreSta(conn, sql);
            ps.setDouble(1, temperature.getTemperature());
            ps.setDate(2, new java.sql.Date(temperature.getDate().getTime()));
            ps.setInt(3,temperature.getUid());
            ps.executeUpdate();
            conn.commit();
            JdbcUtil.closeAll(conn,null,ps);
        }catch (SQLException e) {
            try {
                conn.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
	}

}
