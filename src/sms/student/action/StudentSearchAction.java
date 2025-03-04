package sms.student.action;

import java.util.ArrayList;
import java.util.Scanner;
import sms.student.controller.StudentController;
import sms.student.svc.StudentSearchService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Student;

public class StudentSearchAction implements Action {
	
	ConsoleUtil consoleUtil = new ConsoleUtil();
	StudentSearchService studentSearchService =	new StudentSearchService();

	@Override
	public void execute(Scanner sc) throws Exception {

		boolean isSearchSuccess = false;
		ArrayList<Student> studentList = new ArrayList<>();
		int searchMenuNum = consoleUtil.getSearchMenuNum(sc);
		
		do {
			
			isSearchSuccess = false;
			
			switch(searchMenuNum) {
			case 1 :
				String student_name = consoleUtil.getStudent_name("검색할 ", sc);
				studentList = studentSearchService.getSearchStudentListByStudent_name(student_name);
				break;
			case 2 :
				int student_no = consoleUtil.getStudent_no("검색할 ", sc);
				studentList = studentSearchService.getSearchStudentListByStudent_no(student_no);
				break;
			case 3 :
				int student_year = consoleUtil.getGrade("검색할 ", sc);
				studentList = studentSearchService.getSearchStudentListByStudent_year(student_year);
				break;
			case 4 :
				consoleUtil.printSearchStudentCancel();
				isSearchSuccess = true;
				return;
			default :
				consoleUtil.printSearchMenuNumWrong();
				Action action = new StudentSearchAction();
				StudentController studentController = new StudentController();
				studentController.requestProcess(action, sc); 
				return;
			}
			
			if(studentList != null && !studentList.isEmpty()) {
				consoleUtil.printStudentList(studentList);
				isSearchSuccess = true;
			}else {
				consoleUtil.printSearchStudentListNotFound();
				return;
			}
		}while(!isSearchSuccess);
		
		
	}
}
