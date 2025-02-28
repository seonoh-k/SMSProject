package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import sms.student.dao.StudentDAO;
import sms.student.vo.Student;

public class StudentDeleteService {

	public Student getDeleteStudent(int student_no) throws Exception{
		
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		Student deleteStudent = studentDAO.selectStudent(student_no);
		
		return deleteStudent;
	}
		
	public boolean deleteStudent(int student_no) throws Exception{
		
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		boolean isDeleteSuccess = false;
		int result = studentDAO.deleteStudent(student_no);
		
		if(result != 0) {
			isDeleteSuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		return isDeleteSuccess;
	}
	
}
