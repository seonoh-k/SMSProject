package sms.student.action;

import java.util.Scanner;
import sms.student.svc.StudentModifyService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Student;

public class StudentModifyAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	StudentModifyService studentModifyService =	new StudentModifyService();

	@Override
	public void execute(Scanner sc) throws Exception {
		
		boolean isModified = false;
		int student_no = consoleUtil.getStudent_no("", sc);
		Student modifyStudent = studentModifyService.getModifyStudent(student_no);
		
		if(modifyStudent == null) {
			consoleUtil.printStudentNotFound(student_no);
			return;
		}
		
		Student changeStudent = consoleUtil.getChangeStudent(modifyStudent, sc);
		String unfitForm = studentModifyService.compareBirthRegistForm(changeStudent);
		
		if(unfitForm != null) {
			consoleUtil.printUnfitForm(unfitForm);
			return;
		}
		
		isModified = studentModifyService.modifyStudent(changeStudent);
		
		if(isModified) {
			consoleUtil.printModifySuccess(student_no);
		}else {
			consoleUtil.printModifyFail(student_no);
			return;
		}
		
		
	}
	
}
