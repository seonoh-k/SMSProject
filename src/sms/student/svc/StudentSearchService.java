package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import sms.student.dao.StudentDAO;
import sms.student.vo.Student;

public class StudentSearchService {

	boolean isSearchSuccess = false;
	ArrayList<Student> studentList = new ArrayList<>();
	
	public ArrayList<Student> getSearchStudentListByStudent_name(String student_name) throws Exception{
		
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		studentList = studentDAO.selectStudentListByStudent_name(student_name);
		
		return studentList;
	}
	
	public ArrayList<Student> getSearchStudentListByStudent_no(int student_no) throws Exception{
		
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		studentList = studentDAO.selectStudentByStudent_no(student_no);
		
		return studentList;
	}

	public ArrayList<Student> getSearchStudentListByStudent_year(int student_year) throws Exception{
		
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		studentList = studentDAO.selectStudentListByStudent_year(student_year);
		
		return studentList;
	}
	
}
