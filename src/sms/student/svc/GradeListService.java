package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import sms.student.dao.GradeDAO;
import sms.student.vo.Grade;

public class GradeListService {

	public ArrayList<Grade> getGradeList() throws Exception{
		
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		
		ArrayList<Grade> gradeList = gradeDAO.selectGradeList();
		
		return gradeList;
	}
	
}
