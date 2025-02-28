package sms.student.dao;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import sms.student.vo.Grade;

public class GradeDAO {
	
	Connection con;

	public GradeDAO(Connection con) {
		this.con = con;
	}

	ArrayList<Grade> gradeList = null;
	
	public int insertGrade(Grade newGrade) throws Exception{

		String sql = "INSERT INTO GRADE VALUES (?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, newGrade.getStudent_no());
			ps.setString(2, newGrade.getStudent_name());
			ps.setInt(3, newGrade.getGrade_kor());
			ps.setInt(4, newGrade.getGrade_eng());
			ps.setInt(5, newGrade.getGrade_math());
			
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
				close(ps);
		}
		
		return result;	
	}

	public ArrayList<Grade> selectGradeList() throws Exception{

		String sql = "SELECT * FROM GRADE";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Grade grade = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int stu_no = rs.getInt("student_no");
				String stu_name = rs.getString("student_name");
				int grade_kor = rs.getInt("grade_kor");
				int grade_eng = rs.getInt("grade_eng");
				int grade_math = rs.getInt("grade_math");
				
				
				grade = new Grade(stu_no, stu_name, grade_kor, grade_eng, grade_math);
				gradeList.add(grade);
			}
			 
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return gradeList;
	}

	public ArrayList<Grade> selectGradeListByStudent_name(String student_name) throws Exception {

		Grade grade = null;
		String sql = "SELECT * FROM GRADE WHERE STUDENT_NAME LIKE ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, student_name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int stu_no = rs.getInt("student_no");
				String stu_name = rs.getString("student_name");
				int grade_kor = rs.getInt("grade_kor");
				int grade_eng = rs.getInt("grade_eng");
				int grade_math = rs.getInt("grade_math");
				
				grade = new Grade(stu_no, stu_name, grade_kor, grade_eng, grade_math);
				gradeList.add(grade);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return gradeList;
	}

	public ArrayList<Grade> selectGradeListByStudent_no(int student_no) throws Exception{

		Grade grade = null;
		String sql = "SELECT * FROM GRADE WHERE STUDENT_NO LIKE ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, student_no);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int stu_no = rs.getInt("student_no");
				String stu_name = rs.getString("student_name");
				int grade_kor = rs.getInt("grade_kor");
				int grade_eng = rs.getInt("grade_eng");
				int grade_math = rs.getInt("grade_math");
				
				grade = new Grade(stu_no, stu_name, grade_kor, grade_eng, grade_math);
				gradeList.add(grade);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}

		return gradeList;
	}

	public ArrayList<Grade> selectGradeListByStudent_year(int student_year) throws Exception{

		Grade grade = null;
		String sql = "SELECT * FROM GRADE WHERE STUDENT_NO = (SELECT STUDENT_NO FROM STUDENT WHERE STUDENT_YEAR = ?)";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, student_year);
			rs = ps.executeQuery();
						
			while(rs.next()) {
				int stu_no = rs.getInt("student_no");
				String stu_name = rs.getString("student_name");
				int grade_kor = rs.getInt("grade_kor");
				int grade_eng = rs.getInt("grade_eng");
				int grade_math = rs.getInt("grade_math");
				
				grade = new Grade(stu_no, stu_name, grade_kor, grade_eng, grade_math);
				gradeList.add(grade);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return gradeList;
	}
	
	public Grade selectGrade(int student_no) throws Exception{

		String sql = "SELECT * FROM GRADE WHERE STUDENT_NO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Grade grade = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, student_no);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				int stu_no = rs.getInt("student_no");
				String stu_name = rs.getString("student_name");
				int grade_kor = rs.getInt("grade_kor");
				int grade_eng = rs.getInt("grade_eng");
				int grade_math = rs.getInt("grade_math");
				
				
				grade = new Grade(stu_no, stu_name, grade_kor, grade_eng, grade_math);
			}
			 
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return grade;
	}
	
	public int updateGrade(Grade changeGrade) throws Exception{

		String sql = "UPDATE GRADE SET GRADE_KOR = ?, GRADE_ENG = ?, GRADE_MATH = ? WHERE STUDENT_NO = ?";
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, changeGrade.getGrade_kor());
			ps.setInt(2, changeGrade.getGrade_eng());
			ps.setInt(3, changeGrade.getGrade_math());
			ps.setInt(4, changeGrade.getStudent_no());
			
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;
	}

	public int deleteGrade(int student_no) throws Exception {
		
		String sql = "DELETE GRADE WHERE STUDENT_NO = ?";
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, student_no);
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;
		
	}

	public ArrayList<Grade> selectGradeListAddPercent(int gradeListSize) throws Exception{
		
		
		return null;
	}
	
}
