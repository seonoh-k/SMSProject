package sms.student.action;

import java.util.Scanner;
import sms.student.svc.GradeDeleteService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Grade;

public class GradeDeleteAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	GradeDeleteService gradeDeleteService = new GradeDeleteService();

	@Override
	public void execute(Scanner sc) throws Exception {

		boolean isDeleteSuccess = false;
		int student_no = consoleUtil.getStudent_no("", sc);
		Grade deleteGrade = gradeDeleteService.getDeleteScore(student_no);
		
		if(deleteGrade == null) {
			consoleUtil.printGradeNotFound(student_no);
			return;
		}
		
		isDeleteSuccess = gradeDeleteService.deleteGrade(student_no);
		
		if(isDeleteSuccess) {
			consoleUtil.printDeleteSuccess(deleteGrade);
		}else {
			consoleUtil.printDeleteSuccess(deleteGrade);
			return;
		}
		
	}
	
}
