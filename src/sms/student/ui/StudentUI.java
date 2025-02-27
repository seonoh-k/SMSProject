package sms.student.ui;

import java.util.Scanner;
import sms.student.action.Action;
import sms.student.action.ScholarshipDeleteAction;
import sms.student.action.ScholarshipListAction;
import sms.student.action.ScholarshipModifyAction;
import sms.student.action.ScholarshipRegistAction;
import sms.student.action.ScholarshipSearchAction;
import sms.student.action.ScholarshipStudentSearchAction;
import sms.student.action.GradeDeleteAction;
import sms.student.action.GradeListAction;
import sms.student.action.GradeModifyAction;
import sms.student.action.GradeRegistAction;
import sms.student.action.GradeSearchAction;
import sms.student.action.StudentDeleteAction;
import sms.student.action.StudentListAction;
import sms.student.action.StudentModifyAction;
import sms.student.action.StudentRegistAction;
import sms.student.action.StudentSearchAction;
import sms.student.controller.StudentController;

public class StudentUI {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		boolean isOuterStop = false;
		boolean isInnerStop = false;
		int outerMenu = 0;
		int innerMenu = 0;
		
		Action action = null;
		StudentController studentController = new StudentController();
		
		do{
			System.out.println("\n��������������< �л��������� ���α׷� >��������������");
			System.out.println("             1. �л����� ����              �� ");
			System.out.println("             2. �������� ����             ���� ");
			System.out.println("             3. ���б� ����               �䢺");
			System.out.println("             4. ���α׷� ����                 ");
			System.out.print("             ���� : ");
			outerMenu = sc.nextInt();
			
			isInnerStop = false;

			switch (outerMenu) {
			
			case 1:
				do{
					System.out.println("\n������������������< �л����� ���� >������������������");
					System.out.println("             1. �л����� �Է�              ��");
					System.out.println("             2. �л����� ��ȸ             �⢺");
					System.out.println("             3. �л����� �˻�             ����");
					System.out.println("             4. �л����� ����                 ");
					System.out.println("             5. �л����� ����                 ");
					System.out.println("             6. ù ȭ������                   ");
					System.out.print("             ���� : ");
					innerMenu = sc.nextInt();
					
					switch (innerMenu) {
					
					case 1:
						action = new StudentRegistAction();
						break;
						
					case 2:
						action = new StudentListAction();
						break;
						
					case 3:
						action = new StudentSearchAction();
						break;
						
					case 4:
						action = new StudentModifyAction();
						break;
						
					case 5:
						action = new StudentDeleteAction();
						break;
						
					case 6:
						System.out.println("             ù ȭ������ �̵��մϴ�.\n");
						isInnerStop = true;
						action = null;
						break;
						
					default:
						System.out.println("             �߸� �Է��ϼ̽��ϴ�.\n");
						action = null;
						break;
					}
					
					if(action != null) {
						studentController.requestProcess(action, sc);
					}
				}while(!isInnerStop);
				break;
				
			case 2:
				do{
					System.out.println("\n������������������< �������� ���� >������������������");
					System.out.println("             1. �������� �Է�              ��");
					System.out.println("             2. �������� ��ȸ             �⢺           ");
					System.out.println("             3. �������� �˻�             ����           ");
					System.out.println("             4. �������� ����                  ");
					System.out.println("             5. �������� ����                  ");
					System.out.println("             6. ù ȭ������                    ");
					System.out.print("             ���� : ");
					innerMenu = sc.nextInt();
					
					switch (innerMenu) {
					
					case 1:
						action = new GradeRegistAction();
						break;
						
					case 2:
						action = new GradeListAction();
						break;
						
					case 3:
						action = new GradeSearchAction();
						break;
						
					case 4:
						action = new GradeModifyAction();
						break;
						
					case 5:
						action = new GradeDeleteAction();
						break;
					
					case 6:
						System.out.println("             ù ȭ������ �̵��մϴ�.\n");
						isInnerStop = true;
						action = null;
						break;
						
					default:
						System.out.println("             �߸� �Է��ϼ̽��ϴ�.\n");
						action = null;
						break;
					}
					
					if(action != null) {
						studentController.requestProcess(action, sc);
					}
				}while(!isInnerStop);
				break;
				
			case 3:
				do{
					System.out.println("\n������������������< ���б� ���� >��������������������");
					System.out.println("             1. ���б����� �߰�            ��");
					System.out.println("             2. ���б����� ��ȸ           �⢺");
					System.out.println("             3. ���б����� �˻�           ����");
					System.out.println("             4. ���б����� ����               ");
					System.out.println("             5. ���б����� ����               ");
					System.out.println("             6. ���бݺ� �����л� �˻�        ");
					System.out.println("             7. ù ȭ������                  ");
					System.out.print("             ���� : ");
					innerMenu = sc.nextInt();
					
					switch (innerMenu) {
					
					case 1:
						action = new ScholarshipRegistAction();
						break;
						
					case 2:
						action = new ScholarshipListAction();
						break;
						
					case 3:
						action = new ScholarshipSearchAction();
						break;
						
					case 4:
						action = new ScholarshipModifyAction();
						break;
						
					case 5:
						action = new ScholarshipDeleteAction();
						break;
						
					case 6:
						action = new ScholarshipStudentSearchAction();
						break;
					
					case 7:
						System.out.println("             ù ȭ������ �̵��մϴ�.\n");
						isInnerStop = true;
						action = null;
						break;
						
					default:
						System.out.println("             �߸� �Է��ϼ̽��ϴ�.\n");
						action = null;
						break;
					}
					
					if(action != null) {
						studentController.requestProcess(action, sc);
					}
				}while(!isInnerStop);
				break;
				
			case 4:
				System.out.println("             ���α׷��� �����մϴ�. Bye~ ¥���~\n");
				isOuterStop = true;
				break;
				
			default:
				System.out.println("             �߸� �Է��ϼ̽��ϴ�.\n");
				break;
			}
		}while(!isOuterStop);
	}
	
}
