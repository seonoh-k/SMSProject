package sms.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	static {
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		
		Connection con = null;
		
		try {
			
			String url = "jdbc:oracle:thin:@localhost:1521:orcl";
			String id = "javaDB";
			String pw = "javaDB";
			
		
			con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return con;
	}
	
	public static void close(ResultSet rs) {
		try {
			rs.close();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Statement stnt) {
		try {
			stnt.close();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void close(Connection con) {
		try {
			con.close();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void commit(Connection con) {
		try {
			con.commit();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void rollback(Connection con) {
		try {
			con.rollback();			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
