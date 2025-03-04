package sms.student.action;

import java.util.ArrayList;
import java.util.Scanner;

import sms.student.svc.ScholarshipStudentSearchService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Scholarship;
import sms.student.vo.ScholarshipStudent;
import sms.student.vo.Grade;

public class ScholarshipStudentSearchAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	ScholarshipStudentSearchService scholarshipStudentSearchService = new ScholarshipStudentSearchService();

	
	@Override
	public void execute(Scanner sc) throws Exception {
				
		String scholar_name = consoleUtil.getScholar_name("", sc);
		Scholarship searchScholarship = scholarshipStudentSearchService.getSearchScholarship(scholar_name);
		
		if(scholar_name == null) {
			consoleUtil.printScholarshipListNotFound();
			return;
		}
		
		ArrayList<Grade> gradeListAddPercent = scholarshipStudentSearchService.getScoreListAddPercent(searchScholarship);
		ArrayList<ScholarshipStudent> scholarshipStudentList = scholarshipStudentSearchService.getScholarshipStudentSearchList(searchScholarship, gradeListAddPercent);
		
		if(scholarshipStudentList != null && !scholarshipStudentList.isEmpty()) {
			consoleUtil.printScholarshipStudentList(scholarshipStudentList);
		}else {
			consoleUtil.printScholarshipStudentListNotFound();
			return;
		}
		
	}
}
