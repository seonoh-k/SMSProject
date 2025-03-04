package sms.student.action;

import java.util.ArrayList;
import java.util.Scanner;
import sms.student.controller.StudentController;
import sms.student.svc.ScholarshipSearchService;
import sms.student.util.ConsoleUtil;
import sms.student.vo.Scholarship;

public class ScholarshipSearchAction implements Action {
	
	ConsoleUtil consoleUtil = new ConsoleUtil();
	ScholarshipSearchService scholarshipSearchService = new ScholarshipSearchService();

	@Override
	public void execute(Scanner sc) throws Exception {
	
		boolean isSearchSuccess = false;
		ArrayList<Scholarship> scholarshipList = new ArrayList<>();
		int searchMenuNum = consoleUtil.getSearchMenuNumScholarship(sc);
		
		do {
			
			isSearchSuccess = false;
			
			switch(searchMenuNum) {
			case 1 :
				String sc_name = consoleUtil.getScholar_name("", sc);
				scholarshipList = scholarshipSearchService.getSearchScholarshipListBySc_name(sc_name);
				break;
			case 2 :
				int sc_money = consoleUtil.getMoney("", sc);
				scholarshipList = scholarshipSearchService.getSearchScholarshipListByMoney(sc_money);
				break;
			default :
				consoleUtil.printSearchMenuNumWrong();
				Action action = new ScholarshipSearchAction();
				StudentController studentController = new StudentController();
				studentController.requestProcess(action, sc); 
				return;
			}
			
			if(scholarshipList != null && !scholarshipList.isEmpty()) {
				consoleUtil.printScholarshipList(scholarshipList);
				isSearchSuccess = true;
			}else {
				consoleUtil.printScholarshipListNotFound();
				return;
			}
			
		}while(!isSearchSuccess);
		
	}
	
}
