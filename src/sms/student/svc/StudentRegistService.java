package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.sql.Date;
import sms.student.dao.StudentDAO;
import sms.student.vo.Student;

public class StudentRegistService {

	public String compareBirthRegistForm(Student newStudent) {

		
		return null;
	}
	
	public boolean searchStudent(int student_no) throws Exception{
		
		boolean isRegisted = false;
		
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		
		Student student = studentDAO.selectStudent(student_no);
		
		if(student != null) {
			isRegisted = true;
		}
		
		return isRegisted;
	}
	
	public boolean registStudent(Student newStudent) throws Exception{

		boolean isRegisted = false;
		
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		
		int student = studentDAO.insertStudent(newStudent);
		
		if(student != 0) {
			isRegisted = true;
		}
		
		return isRegisted;
	}
	
}
