package sms.student.action;

import java.util.Scanner;
import sms.student.svc.StudentRegistService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Student;

public class StudentRegistAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	StudentRegistService studentRegistService = new StudentRegistService();
	
	@Override
	public void execute(Scanner sc) throws Exception{

		int stu_no = consoleUtil.getStudent_no("", sc);
		
		boolean isRegisted = studentRegistService.searchStudent(stu_no);
		
		if(isRegisted) {
			consoleUtil.printRegistedStudent(stu_no);
			return;
		}
		
		Student newStudent = consoleUtil.getNewStudent(stu_no, sc);
		String unfitForm = studentRegistService.compareBirthRegistForm(newStudent);
		
		if (unfitForm != null) {
			consoleUtil.printUnfitForm(unfitForm);
			return;
		}
		
		isRegisted = studentRegistService.registStudent(newStudent);
		
		if(isRegisted) {
			consoleUtil.printRegistSuccess(newStudent);
		}else {
			consoleUtil.printRegistFail(newStudent);	
			return;
		}	
		
	}
	
}
