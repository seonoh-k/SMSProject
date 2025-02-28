package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import sms.student.dao.ScholarshipDAO;
import sms.student.vo.Scholarship;

public class ScholarshipRegistService {

	public boolean searchScholarship(String sc_name) throws Exception{
		
		boolean isRegisted = false;
		
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		
		Scholarship newScholarship = scholarshipDAO.selectScholarship(sc_name);
		
		if(newScholarship != null) {
			isRegisted = true;
		}
		
		return isRegisted;
	}

	public boolean registScholarship(Scholarship newScholarship) throws Exception{

		boolean isRegistSuccess = false;
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		
		int isRegisted = scholarshipDAO.insertScholarship(newScholarship);
		
		if(isRegisted != 0) {
			isRegistSuccess = true;
			commit(con);
		}else {
			rollback(con);
		}
		
		return isRegistSuccess;
	}
	
}
