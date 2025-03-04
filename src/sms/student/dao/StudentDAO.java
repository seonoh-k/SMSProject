package sms.student.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import sms.student.vo.Student;
import static sms.db.JdbcUtil.*;

public class StudentDAO {
	
	Connection con;
	
	public StudentDAO(Connection con) {
		this.con = con;
	}

	public int insertStudent(Student newStudent, Date birth) throws Exception{

		String sql = "INSERT INTO STUDENT VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			
			ps = con.prepareStatement(sql);
			
			ps.setInt(1, newStudent.getStudent_no());
			ps.setString(2, newStudent.getStudent_name());
			ps.setInt(3, newStudent.getStudent_year());
			ps.setString(4, newStudent.getStudent_addr());
			ps.setString(5, newStudent.getStudent_tel());
			ps.setDate(6, birth);
			
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
				close(ps);
		}
		
		return result;		
	}

	public ArrayList<Student> selectStudentList() throws Exception{

		ArrayList<Student> studentList = new ArrayList<>();
		Student student = null;
		String sql = "SELECT * FROM STUDENT";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int stu_no = rs.getInt("student_no");
				String stu_name = rs.getString("student_name");
				int stu_year = rs.getInt("student_year");
				String stu_addr = rs.getString("student_addr");
				String stu_tel = rs.getString("student_tel");
				String stu_birth = rs.getDate("student_birth").toString();
				
				student = new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel, stu_birth);
				studentList.add(student);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return studentList;
	}

	public Student selectStudent(int student_no) throws Exception{

		String sql = "select * from student where student_no = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, student_no);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int stu_no = rs.getInt("student_no");
				String stu_name = rs.getString("student_name");
				int stu_year = rs.getInt("student_year");
				String stu_addr = rs.getString("student_addr");
				String stu_tel = rs.getString("student_tel");
				String stu_birth = rs.getDate("student_birth").toString();
				
				student = new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel, stu_birth);
			}
			 
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		
		return student;
	}

	public ArrayList<Student> selectStudentByStudent_no(int student_no) {

		ArrayList<Student> studentList = new ArrayList<>();
		Student student = null;
		String sql = "SELECT * FROM student WHERE student_no LIKE '%' || ? || '%'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, student_no);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int stu_no = rs.getInt("student_no");
				String stu_name = rs.getString("student_name");
				int stu_year = rs.getInt("student_year");
				String stu_addr = rs.getString("student_addr");
				String stu_tel = rs.getString("student_tel");
				String stu_birth = rs.getDate("student_birth").toString();
				
				student = new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel, stu_birth);
				studentList.add(student);
			}

			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return studentList;
	}

	public ArrayList<Student> selectStudentListByStudent_name(String student_name) throws Exception{

		ArrayList<Student> studentList = new ArrayList<>();
		Student student = null;
		String sql = "SELECT * FROM student WHERE student_name LIKE '%' || ? || '%'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, student_name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int stu_no = rs.getInt("student_no");
				String stu_name = rs.getString("student_name");
				int stu_year = rs.getInt("student_year");
				String stu_addr = rs.getString("student_addr");
				String stu_tel = rs.getString("student_tel");
				String stu_birth = rs.getDate("student_birth").toString();
				
				student = new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel, stu_birth);
				studentList.add(student);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return studentList;
	}

	public ArrayList<Student> selectStudentListByStudent_year(int student_year) throws Exception {

		ArrayList<Student> studentList = new ArrayList<>();
		Student student = null;
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_YEAR = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setInt(1, student_year);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int stu_no = rs.getInt("student_no");
				String stu_name = rs.getString("student_name");
				int stu_year = rs.getInt("student_year");
				String stu_addr = rs.getString("student_addr");
				String stu_tel = rs.getString("student_tel");
				String stu_birth = rs.getDate("student_birth").toString();
				
				student = new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel, stu_birth);
				studentList.add(student);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(ps);
		}
		return studentList;
	}

	public int deleteStudent(int student_no) throws Exception{

		String sql = "DELETE STUDENT WHERE STUDENT_NO = ?";
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


	public int updateStudent(Student changeStudent, Date birth) throws Exception{

		String sql = "UPDATE STUDENT SET STUDENT_NAME = ?, "
				+ "STUDENT_YEAR = ?, STUDENT_ADDR = ?, STUDENT_TEL = ?, "
				+ "STUDENT_BIRTH = ? WHERE STUDENT_NO = ?";
		
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			
			ps = con.prepareStatement(sql);
			ps.setString(1, changeStudent.getStudent_name());
			ps.setInt(2, changeStudent.getStudent_year());
			ps.setString(3, changeStudent.getStudent_addr());
			ps.setString(4, changeStudent.getStudent_tel());
			ps.setDate(5, birth);
			ps.setInt(6, changeStudent.getStudent_no());
			
			result = ps.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(ps);
		}
		
		return result;
	}
	
}
