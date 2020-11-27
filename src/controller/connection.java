package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class connection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getDB());
		
		
	}
	public static String schema="diving";
	public static Connection getDB() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/?useUnicode=true&characterEncoding=utf-8",
					"root", "1234");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return conn;
	}
}