package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import sms.student.dao.ScholarshipDAO;
import sms.student.vo.Scholarship;

public class ScholarshipDeleteService {

	public Scholarship getDeleteScholarship(String sc_name) throws Exception{
		
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		Scholarship deleteScholarship = scholarshipDAO.selectScholarship(sc_name);
				
		return deleteScholarship;
	}

	public boolean deleteScore(String sc_name) throws Exception{
		
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		boolean isDeleteSuccess = false;
		int result = scholarshipDAO.deleteScholarship(sc_name);
		
		if(result != 0) {
			isDeleteSuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		return isDeleteSuccess;
	}
	
}
