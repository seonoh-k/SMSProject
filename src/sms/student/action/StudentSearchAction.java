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
		String msgKind = "검색하려는";
		ArrayList<Student> studentList = new ArrayList<>();
		StudentSearchService studentSearch = new StudentSearchService();
		
		do {
			
			int searchMenu = consoleUtil.getSearchMenuNum(sc);
			
			switch(searchMenu) {
			case 1 :
				String student_name = consoleUtil.getStudent_name(msgKind, sc);
				studentList = studentSearch.getSearchStudentListByStudent_name(student_name);
				break;
			case 2 :
				
				int student_no = consoleUtil.getStudent_no(msgKind, sc);
				studentList = studentSearch.getSearchStudentListByStudent_no(student_no);
				break;
			case 3 :
				int student_year = consoleUtil.getGrade(msgKind, sc);
				studentList = studentSearch.getSearchStudentListByStudent_year(student_year);
				break;
			case 4 :
				consoleUtil.printSearchStudentCancel();
				isSearchSuccess = true;
				break;
			default :
				consoleUtil.printSearchMenuNumWrong();
				break;
			}
			
		}while(!isSearchSuccess);
		
		if(studentList != null) {
			consoleUtil.printStudentList(studentList);
		}else {
			consoleUtil.printSearchStudentListNotFound();
		}
		
	}
}
