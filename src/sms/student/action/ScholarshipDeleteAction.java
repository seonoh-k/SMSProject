package sms.student.action;

import java.util.Scanner;
import sms.student.svc.ScholarshipDeleteService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Scholarship;

public class ScholarshipDeleteAction implements Action {
	
	ConsoleUtil consoleUtil = new ConsoleUtil();
	ScholarshipDeleteService scholarshipDeleteService = new ScholarshipDeleteService();

	@Override
	public void execute(Scanner sc) throws Exception {

		boolean isDeleteSuccess = false;
		String sc_name = consoleUtil.getScholar_name("", sc);
		Scholarship deleteScholarship = scholarshipDeleteService.getDeleteScholarship(sc_name);
		
		if(deleteScholarship == null) {
			consoleUtil.printScholarshipNotFound(sc_name);
			return;
		}
		
		isDeleteSuccess = scholarshipDeleteService.deleteScore(sc_name);
		
		if(isDeleteSuccess) {
			consoleUtil.printDeleteSuccess(deleteScholarship);
		}else {
			consoleUtil.printDeleteFail(deleteScholarship);
			return;
		}
		
	}
	
}
