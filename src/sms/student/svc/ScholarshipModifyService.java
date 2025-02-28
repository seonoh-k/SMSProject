package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import sms.student.dao.ScholarshipDAO;
import sms.student.vo.Scholarship;

public class ScholarshipModifyService {

	Scholarship scholarship = null;
	
	public Scholarship getModifyScholarship(String sc_name) throws Exception{
		
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		scholarship = scholarshipDAO.selectScholarship(sc_name);
		
		return scholarship;
	}

	public boolean modifyScholarship(Scholarship changeScholarship) throws Exception{
		
		boolean isModifySuccess = false;
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		
		int isModified = scholarshipDAO.updateScholarship(changeScholarship);
		
		if(isModified != 0) {
			isModifySuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		return isModifySuccess;
	}
	
}
