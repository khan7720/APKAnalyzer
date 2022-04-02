package com.test.demo;

import java.sql.*;


public class DBUtil {
	
	static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	static final String DB_URL = "jdbc:mysql://localhost:3306/apktester";
	static final String USER = "root";
	static final String PASS = "4goyaxiabsj";
	
	public static Connection getConncetion() {
        Connection conn = null;
        Statement stmt = null;
        try{
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);
        
            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL,USER,PASS);
        
        }catch(SQLException se){
            // 处理 JDBC 错误
            se.printStackTrace();
        }catch(ClassNotFoundException e){
        	System.out.println("连接失败");
            e.printStackTrace();
        }
        return conn;
    }
}
