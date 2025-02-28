package sms.student.action;

import java.util.Scanner;
import sms.student.svc.StudentDeleteService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Student;

public class StudentDeleteAction implements Action {
	
	ConsoleUtil consoleUtil = new ConsoleUtil();
	StudentDeleteService studentDeleteService = new StudentDeleteService();

	@Override
	public void execute(Scanner sc) throws Exception {
		
		boolean isDeleteSuccess = false;
		int student_no = consoleUtil.getStudent_no("", sc);
		Student deleteStudent = studentDeleteService.getDeleteStudent(student_no);
		
		if(deleteStudent == null) {
			consoleUtil.printStudentNotFound(student_no);
			return;
		}
		
		isDeleteSuccess = studentDeleteService.deleteStudent(student_no);
		
		if(isDeleteSuccess) {
			consoleUtil.printDeleteSuccess(student_no);
		}else {
			consoleUtil.printDeleteFail(student_no);
			return;
		}
		
	}
	
}
