package sms.student.action;

import java.util.ArrayList;
import java.util.Scanner;
import sms.student.controller.StudentController;
import sms.student.svc.GradeSearchService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Grade;

public class GradeSearchAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	GradeSearchService gradeSearchService = new GradeSearchService();

	@Override
	public void execute(Scanner sc) throws Exception {

		boolean isSearchSuccess = false;
		ArrayList<Grade> gradeList = new ArrayList<>();
		int searchMenuNum = consoleUtil.getSearchGradeMenuNum(sc);
		
		do {
			
			isSearchSuccess = false;
			
			switch(searchMenuNum) {
			case 1 :
				String student_name = consoleUtil.getStudent_name("", sc);
				gradeList = gradeSearchService.getSearchGradeListByStudent_name(student_name);
				break;
			case 2 :
				int student_no = consoleUtil.getStudent_no("", sc);
				gradeList = gradeSearchService.getSearchGradeListByStudent_no(student_no);
				break;
			case 3 :
				int student_year = consoleUtil.getGrade("°Ë»öÇÒ ", sc);
				gradeList = gradeSearchService.getSearchGradeListByStudent_year(student_year);
				break;
			case 4 :
				consoleUtil.printSearchGradeCancel();
				isSearchSuccess = true;
				break;
			default :
				consoleUtil.printSearchMenuNumWrong();
				Action action = new GradeSearchAction();
				StudentController studentController = new StudentController();
				studentController.requestProcess(action, sc); 
				return;
			}
			
			if(gradeList != null) {
				consoleUtil.printGradeList(gradeList);
				isSearchSuccess = true;
			}else {
				consoleUtil.printGradeListNotFound();
			}
		}while(!isSearchSuccess);
		
	}
	
}
