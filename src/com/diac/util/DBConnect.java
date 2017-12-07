package com.diac.util;

import java.sql.*;

public class DBConnect { 
	
	private static String url = "jdbc:mysql://localhost:3306/"; 
	private static String dbName = "userdb";
	private static String driver = "com.mysql.jdbc.Driver";
	private static String userName = "root"; 
	private static String password = "feng";
	private static Connection conn;
	
	public DBConnect(){}
	
	public void connectDB(){
		
		try { 
			Class.forName(driver).newInstance(); 
			conn = DriverManager.getConnection(url+dbName,userName,password);
			 
			} catch (Exception e) { 
				e.printStackTrace();
			} 
	}
	
	public Connection getConn(){
		return conn;
	}
	
	public void closeCon(){
		
		try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}



