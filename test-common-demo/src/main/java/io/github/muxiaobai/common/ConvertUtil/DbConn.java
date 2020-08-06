package io.github.muxiaobai.common.ConvertUtil;


import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DbConn {
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String USER = "test";
    private static final String PASSWORD = "test";
    private static final String DATABASE = "jdbc:postgresql://localhost:5432/test";

    public static Connection getConnection(String d,String c,String u,String p) {
        Connection connection;
        String URL = d ;
        try{
            Class.forName(c);
            connection = DriverManager.getConnection(URL,u,p);
        } catch (ClassNotFoundException | SQLException e) {
            return null;
        }
        return connection;
    }

    public  void close(PreparedStatement ps,Connection conn) {
        if(null != ps){
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(null != conn) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        DbConn dbUtil = new DbConn();
        System.out.println(dbUtil.getDBTable());
        System.out.println(dbUtil.getSystemData("",new ArrayList<>()));
    }
    public List<String> getDBTable() {
        List<String> tableNames = new ArrayList<>();
        Connection conn = DbConn.getConnection(DATABASE,DRIVER,USER,PASSWORD);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(" SELECT tablename,tableowner FROM pg_tables where tablename not like 'pg_%' and tablename not like 'sql_%';");
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                tableNames.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close(ps,conn);
        }
        return  tableNames;
    }


    public List getSystemData(String sql,List<String> columns) {
        List tableNames = new ArrayList<>();
        Connection conn = DbConn.getConnection(DATABASE,DRIVER,USER,PASSWORD);
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                Map map = new HashMap();
                for (int i = 0; i < columns.size(); i++) {
                    map.put(columns.get(i),resultSet.getString(columns.get(i)));
                }
                tableNames.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            this.close(ps,conn);
        }
        return  tableNames;
    }
}
