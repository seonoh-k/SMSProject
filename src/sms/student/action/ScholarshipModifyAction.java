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
		Scholarship scholarship = scholarshipModifyService.getModifyScholarship(sc_name);
		Scholarship modifyScholarship = null;
		
		if(scholarship == null) {
			consoleUtil.printScholarshipNotFound(sc_name);
			return;
		}else {
			modifyScholarship = consoleUtil.getChangeScholarship(scholarship, sc);	
		}
		
		isModified = scholarshipModifyService.modifyScholarship(modifyScholarship);
		
		if(isModified) {
			consoleUtil.printModifySuccess(modifyScholarship);
		}else {
			consoleUtil.printModifyFail(modifyScholarship);
			return;
		}
	}
	
}
