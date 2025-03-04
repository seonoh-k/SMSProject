package sms.student.dao;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sms.student.vo.Scholarship;

public class ScholarshipDAO {

	Connection con;

	public ScholarshipDAO(Connection con) {
		this.con = con;
	}

	public Scholarship selectScholarship(String scholar_name) throws Exception{

		String sql = "SELECT * FROM SCHOLARSHIP WHERE SCHOLAR_NAME LIKE ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Scholarship scholarship = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, scholar_name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String sc_name = rs.getString("scholar_name");
				int sc_percent = rs.getInt("scholar_percent");
				int sc_money = rs.getInt("scholar_money");
				
				scholarship = new Scholarship(sc_name, sc_percent, sc_money);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return scholarship;
	}

	public int insertScholarship(Scholarship newScholarship) throws Exception{

		String sql = "INSERT INTO SCHOLARSHIP VALUES (?, ?, ?)";
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, newScholarship.getScholar_name());
			ps.setInt(2, newScholarship.getScholar_percent());	
			ps.setInt(3, newScholarship.getScholar_money());	
			
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;
	}

	public ArrayList<Scholarship> selectScholarshipList() throws Exception{

		ArrayList<Scholarship> scholarshipList = new ArrayList<>();
		Scholarship scholarship = null;
		String sql = "SELECT * FROM SCHOLARSHIP";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String sc_name = rs.getString("scholar_name");
				int sc_percent = rs.getInt("scholar_percent");
				int sc_money = rs.getInt("scholar_money");
				
				scholarship = new Scholarship(sc_name, sc_percent, sc_money);
				scholarshipList.add(scholarship);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return scholarshipList;
	}

	public ArrayList<Scholarship> selectScholarshipByScholar_name(String scholar_name) throws Exception{

		ArrayList<Scholarship> scholarshipList = new ArrayList<>();
		Scholarship scholarship = null;
		String sql = "SELECT * FROM SCHOLARSHIP WHERE SCHOLAR_NAME LIKE '%' || ? || '%'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, scholar_name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String sc_name = rs.getString("scholar_name");
				int sc_percent = rs.getInt("scholar_percent");
				int sc_money = rs.getInt("scholar_money");
				
				scholarship = new Scholarship(sc_name, sc_percent, sc_money);
				scholarshipList.add(scholarship);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return scholarshipList;
		
	}

	public ArrayList<Scholarship> selectScholarshipByScholar_Money(int scholar_money) throws Exception{

		ArrayList<Scholarship> scholarshipList = new ArrayList<>();
		Scholarship scholarship = null;
		String sql = "SELECT * FROM SCHOLARSHIP WHERE SCHOLAR_MONEY = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, scholar_money);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				String sc_name = rs.getString("scholar_name");
				int sc_percent = rs.getInt("scholar_percent");
				int sc_money = rs.getInt("scholar_money");
				
				scholarship = new Scholarship(sc_name, sc_percent, sc_money);
				scholarshipList.add(scholarship);
			}
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return scholarshipList;
		
	}

	public int updateScholarship(Scholarship changeScholarship) throws Exception{

		String sql = "UPDATE SCHOLARSHIP SET SCHOLAR_PERCENT = ?, SCHOLAR_MONEY = ?"
				+ "WHERE SCHOLAR_NAME LIKE ?";
		
		PreparedStatement ps = null;
		int result = 0;
		
try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, changeScholarship.getScholar_percent());
			ps.setInt(2, changeScholarship.getScholar_money());
			ps.setString(3, changeScholarship.getScholar_name());
			
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;
	}

	public int deleteScholarship(String scholar_name) throws Exception{

		String sql = "DELETE SCHOLARSHIP WHERE SCHOLAR_NAME LIKE ?";
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, scholar_name);
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;
	}
	
}
