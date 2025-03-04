package sms.student.action;

import java.util.Scanner;
import sms.student.svc.GradeModifyService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Grade;

public class GradeModifyAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	GradeModifyService gradeModifyService =	new GradeModifyService();

	@Override
	public void execute(Scanner sc) throws Exception {		
		
		boolean isModified = false;
		int student_no = consoleUtil.getStudent_no("", sc);
		Grade grade = gradeModifyService.getModifyGrade(student_no);
		Grade changeGrade = null;
		
		if(grade == null) {
			consoleUtil.printGradeNotFound(student_no);
			return;
		}else {
			changeGrade = consoleUtil.getChangeGrade(grade, sc);
		}
		
		isModified = gradeModifyService.modifyGrade(changeGrade);
		
		if(isModified) {
			consoleUtil.printModifySuccess(changeGrade);
		}else {
			consoleUtil.printModifyFail(changeGrade);
			return;
		}
		
		
	}
	
}
