package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import sms.student.dao.ScholarshipDAO;
import sms.student.vo.Scholarship;

public class ScholarshipSearchService {

	ArrayList<Scholarship> scholarshipList = new ArrayList<>();
	
	public ArrayList<Scholarship> getSearchScholarshipListBySc_name(String scholar_name) throws Exception{
		
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		scholarshipList = scholarshipDAO.selectScholarshipByScholar_name(scholar_name);
				
		return scholarshipList;
	}

	public ArrayList<Scholarship> getSearchScholarshipListByMoney(int scholar_money) throws Exception{
		
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		scholarshipList = scholarshipDAO.selectScholarshipByScholar_Money(scholar_money);
				
		return scholarshipList;
	}

}
