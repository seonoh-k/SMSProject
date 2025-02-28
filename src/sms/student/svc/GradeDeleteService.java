package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import sms.student.dao.GradeDAO;
import sms.student.vo.Grade;

public class GradeDeleteService {

	public Grade getDeleteScore(int student_no) throws Exception{
		
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		Grade deleteGrade = gradeDAO.selectGrade(student_no);
		
		return deleteGrade;
	}
	
	public boolean deleteGrade(int student_no) throws Exception{
		
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		boolean isDeleteSuccess = false;
		int result = gradeDAO.deleteGrade(student_no);
		
		if(result != 0) {
			isDeleteSuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		return isDeleteSuccess;
	}
	
}
