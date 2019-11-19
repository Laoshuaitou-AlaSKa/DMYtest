package com.alaska.dmytest.dbconnect;

import org.junit.Test;

import java.sql.*;

public class SQLConnect {
    private static final String URL = "jdbc:mysql://101.132.128.122:3306/dmytest?characterEncoding=utf8";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private  static Connection conn = null;     //初始化连接值

    static {
        //1. 加载驱动成绩
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        //2. 获得数据库的连接
        try {
            conn = DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){   //构建获取连接的方法
        return conn;
    }

    @Test
    public void testConnect() throws ClassNotFoundException, SQLException {
        //1. 加载驱动成绩
        Class.forName("com.mysql.jdbc.Driver");
        //2. 获得数据库的连接
        Connection conn = DriverManager.getConnection(URL,USER,PASSWORD);
        if(!conn.isClosed())
            System.out.println("Succeeded connecting to the Database!");
        //3. 操作数据库
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * FROM test");

        while (rs.next()){
            System.out.println(rs.getInt("id") + "    " + rs.getString("value"));
        }
    }
}
