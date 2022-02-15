package cn.wit.common;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JdbcUtil {
    private static  String driver;
    private static String url;
    private static String password;
    private static String username;
    //��ȡ�����ļ������ݣ����������
    static {
        //����properties�����ȡ�����ļ�������
        Properties p=new Properties();
        //��ȡ�����ļ��Ķ�ȡ������(JdbcUtil.class.�ᶯ̬��λĿǰ����ĿsrcĿ¼)
        InputStream is= JdbcUtil.class.getResourceAsStream("/db.properties");
        //�������������ļ�
        try {
            p.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        driver= p.getProperty("driver");
        url= p.getProperty("url");
        password= p.getProperty("password");
        username= p.getProperty("username");

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    //���Connection����
    public static Connection getConn(){
        Connection conn=null;
        try {
             conn= DriverManager.getConnection(url,username,password);
            return conn;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }



    //���Statement����

    public static PreparedStatement getPreSta( Connection conn,String sql){
        PreparedStatement ps=null;
        try {
             ps=conn.prepareStatement(sql);
            return ps;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ps;

    }

    public static Statement getSta(Connection conn){
        Statement stmt=null;
        try {
            stmt=conn.createStatement();
            return stmt;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return stmt;
    }

    public static void closeAll(Connection conn,ResultSet rs,Statement stmt){
        //�ر���Դ
        try {
            if(rs!=null){
                rs.close();
            }
        } catch (SQLException e) {

        }
        try {
            if(stmt!=null){
                stmt.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            if(conn!=null){
                conn.close();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static int excuteDml(String sql,Object...objs){

            Connection conn=null;
            PreparedStatement ps=null;
            try {
                //��ȡ���ݿ����Ӷ���
                conn= JdbcUtil.getConn();
                conn.setAutoCommit(false);
                //��ȡsql�������
                ps= conn.prepareStatement(sql);
                for(int i=0;i<objs.length;i++){
                    ps.setObject(i+1,objs[i]);
                }
                int i=ps.executeUpdate();
                conn.commit();
                JdbcUtil.closeAll(conn,null,ps);
                return i;
            } catch (SQLException e) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            }
            return 0;
    }


}
