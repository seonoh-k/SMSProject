package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import sms.student.dao.GradeDAO;
import sms.student.dao.StudentDAO;
import sms.student.vo.Grade;
import sms.student.vo.Student;

public class GradeRegistService {
		
	public Student getRightStudent(int student_no) throws Exception{
		
		Connection con = getConnection();
		StudentDAO studentDAO = new StudentDAO(con);
		
		Student student = studentDAO.selectStudent(student_no);
		
		return student;
	}
	
	public boolean searchGrade(int student_no) throws Exception{
		
		boolean isGradeExist = false;
		
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		
		Grade grade = gradeDAO.selectGrade(student_no);
		
		if(grade != null) {
			isGradeExist = true;
		}
		
		return isGradeExist;
	}
	
	public boolean registGrade(Grade newGrade) throws Exception{
		
		boolean isRegistSuccess = false;
		
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		
		int isRegisted = gradeDAO.insertGrade(newGrade);
		
		if(isRegisted != 0) {
			isRegistSuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		return isRegistSuccess;
	}

}
