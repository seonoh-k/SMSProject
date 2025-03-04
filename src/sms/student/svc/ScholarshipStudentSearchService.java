package sms.student.svc;

import static sms.db.JdbcUtil.*;
import java.sql.Connection;
import java.util.ArrayList;
import sms.student.dao.GradeDAO;
import sms.student.dao.ScholarshipDAO;
import sms.student.vo.Scholarship;
import sms.student.vo.ScholarshipStudent;
import sms.student.vo.Grade;

public class ScholarshipStudentSearchService {

	public Scholarship getSearchScholarship(String scholar_name) throws Exception{
		
		Connection con = getConnection();
		ScholarshipDAO scholarshipDAO = new ScholarshipDAO(con);
		Scholarship searchScholarship = scholarshipDAO.selectScholarship(scholar_name);
		
		return searchScholarship;
	}

	public ArrayList<Grade> getScoreListAddPercent(Scholarship searchScholarship) throws Exception{
		
		Connection con = getConnection();
		GradeDAO gradeDAO = new GradeDAO(con);
		int gradeListSize = 0;
		if(searchScholarship != null) {
			gradeListSize = searchScholarship.getScholar_percent();			
		}
		ArrayList<Grade> gradeListAddPercent = gradeDAO.selectGradeListAddPercent(gradeListSize);
		
		
		return gradeListAddPercent;
	}

	public ArrayList<ScholarshipStudent> getScholarshipStudentSearchList(
			Scholarship searchScholarship, ArrayList<Grade> gradeListAddPercent) throws Exception{

		ArrayList<ScholarshipStudent> scholarshipStudentList = new ArrayList<>();
		
		if(gradeListAddPercent != null) {
			for(Grade grade : gradeListAddPercent) {
				ScholarshipStudent scholarshipStudent = new ScholarshipStudent(
						grade.getStudent_no(),
						grade.getStudent_name(),
						grade.getAvg(),
						searchScholarship.getScholar_name(),
						searchScholarship.getScholar_percent(),
						searchScholarship.getScholar_money()
						);
				scholarshipStudentList.add(scholarshipStudent);			
			}
		}else {
			scholarshipStudentList = null;
			
		}
		
		
		
		return scholarshipStudentList;
	}
	
}
