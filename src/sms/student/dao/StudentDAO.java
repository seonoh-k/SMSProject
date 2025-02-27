package sms.student.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import sms.student.vo.Student;

public class StudentDAO {
	
	Connection con;
	
	public StudentDAO(Connection con) {
		this.con = con;
	}

	public int insertStudent(Student newStudent) throws Exception{

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
			ps.setString(6, newStudent.getStudent_birth());
			
			result = ps.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;		
	}

	public ArrayList<Student> selectStudentList() throws Exception{

		ArrayList<Student> studentList = new ArrayList<>();
		Student student = null;
		String sql = "SELECT * FROM STUDENT";
		PreparedStatement ps = null;
		ResultSet rs = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		try {
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				int stu_no = rs.getInt("student_no");
				String stu_name = rs.getString("student_name");
				int stu_year = rs.getInt("student_year");
				String stu_addr = rs.getString("student_addr");
				String stu_tel = rs.getString("student_tel");
				Date stu_date = rs.getDate("student_birth");
				String stu_birth = dateFormat.format(stu_date);
				
				student = new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel, stu_birth);
				studentList.add(student);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null ) {
					rs.close();									
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return studentList;
	}

	public Student selectStudent(int student_no) throws Exception{

		String sql = "select * from student where student_no = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
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
				Date stu_date = rs.getDate("student_birth");
				String stu_birth = dateFormat.format(stu_date);
				
				student = new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel, stu_birth);
			}
			 
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null ) {
					rs.close();									
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return student;
	}

	public ArrayList<Student> selectStudentByStudent_no(int student_no) {

		ArrayList<Student> studentList = new ArrayList<>();
		Student student = null;
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_NO = ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
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
				Date stu_date = rs.getDate("student_birth");
				String stu_birth = dateFormat.format(stu_date);
				
				student = new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel, stu_birth);
				studentList.add(student);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null ) {
					rs.close();									
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return studentList;
	}

	public ArrayList<Student> selectStudentListByStudent_name(String student_name) throws Exception{

		ArrayList<Student> studentList = new ArrayList<>();
		Student student = null;
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_NAME LIKE ?";
		PreparedStatement ps = null;
		ResultSet rs = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
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
				Date stu_date = rs.getDate("student_birth");
				String stu_birth = dateFormat.format(stu_date);
				
				student = new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel, stu_birth);
				studentList.add(student);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null ) {
					rs.close();									
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return studentList;
	}

	public ArrayList<Student> selectStudentListByStudent_year(int student_year) throws Exception {

		ArrayList<Student> studentList = new ArrayList<>();
		Student student = null;
		String sql = "SELECT * FROM STUDENT WHERE STUDENT_YEAR LIKE '?'";
		PreparedStatement ps = null;
		ResultSet rs = null;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
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
				Date stu_date = rs.getDate("student_birth");
				String stu_birth = dateFormat.format(stu_date);
				
				student = new Student(stu_no, stu_name, stu_year, stu_addr, stu_tel, stu_birth);
				studentList.add(student);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null ) {
					rs.close();									
				}
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return studentList;
	}

	public int deleteStudent(int student_no) throws Exception{

		
		return 0;
	}


	public int updateStudent(Student changeStudent, Date birth) throws Exception{

		
		return 0;
	}
	
}
