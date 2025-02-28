package sms.student.action;

import java.util.Scanner;
import sms.student.svc.ScholarshipModifyService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Scholarship;

public class ScholarshipModifyAction implements Action {

	ConsoleUtil consoleUtil = new ConsoleUtil();
	ScholarshipModifyService scholarshipModifyService = new ScholarshipModifyService();

	@Override
	public void execute(Scanner sc) throws Exception {
			
		boolean isModified = false;
		String sc_name = consoleUtil.getScholar_name("", sc); 
		Scholarship modyfiScholarship = scholarshipModifyService.getModifyScholarship(sc_name);
		
		if(modyfiScholarship == null) {
			consoleUtil.printScholarshipNotFound(sc_name);
			return;
		}
		
		isModified = scholarshipModifyService.modifyScholarship(modyfiScholarship);
		
		if(isModified) {
			consoleUtil.printModifySuccess(modyfiScholarship);
		}else {
			consoleUtil.printModifyFail(modyfiScholarship);
			return;
		}
	}
	
}
