package sms.student.util;

import java.util.ArrayList;
import java.util.Scanner;
import sms.student.vo.Scholarship;
import sms.student.vo.ScholarshipStudent;
import sms.student.vo.Grade;
import sms.student.vo.Student;

public class ConsoleUtil {

	//�л� ���� �ܼ� ��ƿ

	public void printRegistedStudent(int student_no) {
		System.out.println("> �й� : " + student_no + " �л��� �̹� ��ϵǾ� �ֽ��ϴ�.\n");
	}

	
	public void printUnfitForm(String unfitForm) {
		System.out.println("\n> ������� : " + unfitForm + "�� ���Ŀ� ���� �ʽ��ϴ�. (���� : 1988-06-15)");
	}
	
	public Student getNewStudent(int student_no, Scanner sc) {
		sc.useDelimiter(System.getProperty("line.separator"));

		System.out.println("\n> ���ο� �л����� �Է�");

		System.out.print("> �̸� : ");
		String stu_name = sc.next();

		System.out.print("> �г� : ");
		int grade = sc.nextInt();

		System.out.print("> �ּ� : ");
		String address = sc.next();

		System.out.print("> ��ȭ��ȣ : ");
		String tel = sc.next();

		System.out.print("> ������� : ");
		String birth = sc.next();

		return new Student(student_no, stu_name, grade, address, tel, birth);
	}


	public void printRegistSuccess(Student newStudent) {
		System.out.println("> �й� : " + newStudent.getStudent_no() + " �л��� ������ ��ϵǾ����ϴ�.\n");
	}


	public void printRegistFail(Student newStudent) {
		System.out.println("> �й� : " + newStudent.getStudent_no() + " �л��� ���� ����� �����߽��ϴ�.\n");
	}


	public int getByteLength(String str) {
		int strLength = 0;
		char tempChar[] = new char[str.length()];

		for(int i=0 ; i<tempChar.length ; i++) {
			tempChar[i] = str.charAt(i);
			if(tempChar[i] < 128) {
				strLength++;
			}
			else {
				strLength += 2;
			}
		}
		return strLength;
	}


	public void printStudentList(ArrayList<Student> studentList) {
		System.out.println("\n> �� " + studentList.size() + "���� �л��� ��ȸ�մϴ�.");
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������");
		System.out.println("��      [�й�]     [�̸�]     [�г�]                         [�ּ�]                           [��ȭ��ȣ]      [�������]   [������] ��");

		for(int i=0 ; i<studentList.size() ; i++) {

			System.out.print("��" + (i+1) + ".");
			for(int j=0 ; (Integer.toString(i+1).length() + j) < 4 ; j++) {
				System.out.print(" ");
			}

			System.out.print(studentList.get(i).getStudent_no());
			for(int j=0 ; (Integer.toString(studentList.get(i).getStudent_no()).length() + j) < 12 ; j++) {
				System.out.print(" ");
			}


			System.out.print(studentList.get(i).getStudent_name());
			int nameByte = getByteLength(studentList.get(i).getStudent_name());
			for(int j=0 ; nameByte + j < 14 ; j++) {
				System.out.print(" ");
			}

			System.out.print(studentList.get(i).getStudent_year());
			for(int j=0 ; (Integer.toString(studentList.get(i).getStudent_year()).length() + j) < 5 ; j++) {
				System.out.print(" ");
			}

			System.out.print(studentList.get(i).getStudent_addr());
			int addressByte = getByteLength(studentList.get(i).getStudent_addr());
			for(int j=0 ; addressByte + j < 55 ; j++) {
				System.out.print(" ");
			}

			System.out.print(studentList.get(i).getStudent_tel());
			for(int j=0 ; (studentList.get(i).getStudent_tel().length() + j) < 17 ; j++) {
				System.out.print(" ");
			}

			System.out.print(studentList.get(i).getStudent_birth());
			for(int j=0 ; (studentList.get(i).getStudent_birth().length() + j) < 16 ; j++) {
				System.out.print(" ");
			}

			System.out.print(studentList.get(i).getAge());
			for(int j=0 ; (Integer.toString(studentList.get(i).getAge()).length() + j) < 6 ; j++) {
				System.out.print(" ");
			}

			System.out.println("��");

		}
		System.out.println("��������������������������������������������������������������������������������������������������������������������������������������");
	}

	public void printStudentListNotFound() {
		System.out.println("> ��ϵ� �л������� �������� �ʽ��ϴ�.\n");
	}

	public int getSearchMenuNum(Scanner sc) {
		System.out.println("\n������������������< �л����� �˻� >������������������");
		System.out.println("             1. �̸����� �˻�                  ");
		System.out.println("             2. �й����� �˻�                  ");
		System.out.println("             3. �г����� �˻�                  ");
		System.out.println("             4. �˻� ���                      ");
		System.out.print("             ���� : ");
		return sc.nextInt();
	}

	public int getStudent_no(String msgKind, Scanner sc) {
		System.out.print("\n> " + msgKind + "�й� : ");
		return sc.nextInt();
	}

	public String getStudent_name(String msgKind, Scanner sc) {
		System.out.print("\n> " + msgKind + "�̸� : ");
		return sc.next();
	}

	public int getGrade(String msgKind, Scanner sc) {
		System.out.print("\n> " + msgKind + "�г� : ");
		return sc.nextInt();
	}

	public void printSearchStudentCancel() {
		System.out.println("             �л����� ���� ȭ������ �̵��մϴ�.\n");

	}

	public void printSearchMenuNumWrong() {
		System.out.println("             �߸� �����ϼ̽��ϴ�.\n");
	}

	public void printSearchStudentListNotFound() {
		System.out.println("> �˻����ǿ� �ش��ϴ� �л������� �������� �ʽ��ϴ�.\n");
	}

	public void printStudentNotFound(int student_no) {
		System.out.println("> �й� : " + student_no + " �л��� ������ �������� �ʽ��ϴ�.\n");
	}

	public Student getChangeStudent(Student modifyStudent, Scanner sc) {
		sc.useDelimiter(System.getProperty("line.separator"));

		System.out.println("\n> ������ �л� ���� �Է�");

		System.out.println("������ �̸� : " + modifyStudent.getStudent_name());
		System.out.print("������ �̸� : ");
		String stu_name = sc.next();

		System.out.println("������ �г� : " + modifyStudent.getStudent_year());
		System.out.print("������ �г� : ");
		int grade = sc.nextInt();

		System.out.println("������ �ּ� : " + modifyStudent.getStudent_addr());
		System.out.print("������ �ּ� : ");
		String address = sc.next();

		System.out.println("������ ��ȭ��ȣ : " + modifyStudent.getStudent_tel());
		System.out.print("������ ��ȭ��ȣ : ");
		String tel = sc.next();

		System.out.println("������ ������� : " + modifyStudent.getStudent_birth());
		System.out.print("������ ������� : ");
		String birth = sc.next();

		return new Student(modifyStudent.getStudent_no(), stu_name, grade, address, tel, birth);
	}

	public void printModifySuccess(int student_no) {
		System.out.println("> �й� : " + student_no + " �л��� ������ �����Ǿ����ϴ�.\n");
	}

	public void printModifyFail(int student_no) {
		System.out.println("> �й� : " + student_no + " �л��� ���� ������ �����߽��ϴ�.\n");
	}

	public void printDeleteSuccess(int student_no) {
		System.out.println("> �й� : " + student_no + " �л��� ������ �����Ǿ����ϴ�.\n");
	}

	public void printDeleteFail(int student_no) {
		System.out.println("> �й� : " + student_no + " �л��� ���� ������ �����߽��ϴ�.\n");
	}

	// ���� ���� �ܼ� ��ƿ

	public void printRegistedGrade(int student_no) {
		System.out.println("> �й� : " + student_no + " �л��� ������ �̹� ��ϵǾ� �ֽ��ϴ�.\n");
	}

	public Grade getNewGrade(int student_no, Scanner sc) {
    	sc.useDelimiter(System.getProperty("line.separator"));

		System.out.println("\n> ���ο� ���� ���� �Է�");

		System.out.print("> �������� : ");
		int grade_kor = sc.nextInt();

		System.out.print("> �������� : ");
		int grade_eng = sc.nextInt();

		System.out.print("> �������� : ");
		int grade_math = sc.nextInt();

		return new Grade(student_no, grade_kor, grade_eng, grade_math);
	}

	public void printRegistSuccess(Grade newGrade) {
		System.out.println("> " + newGrade.getStudent_no() + "�л��� ������ �ԷµǾ����ϴ�.\n");
	}
	
	public void printRegistFail(Grade newGrade) {
		System.out.println("> " + newGrade.getStudent_no() + "�л��� �����Է��� �����߽��ϴ�.\n");
	}

	public void printGradeList(ArrayList<Grade> gradeList) {
		System.out.println("\n<�� " + gradeList.size() + "���� �л� ������ ��ȸ�մϴ�.>");

		System.out.println("��������������������������������������������������������������������������������");

		System.out.println("��      [�й�]     [�̸�]       [����]    [����]    [����]   [����]    [���] ��");
		for(int i=0 ; i<gradeList.size() ; i++) {

			System.out.print("��" + (i+1) + ".");
			for(int j=0 ; (Integer.toString(i+1).length() + j) < 4 ; j++) {
				System.out.print(" ");
			}

			System.out.print(gradeList.get(i).getStudent_no());
			for(int j=0 ; (Integer.toString(gradeList.get(i).getStudent_no()).length() + j) < 12 ; j++) {
				System.out.print(" ");
			}			
			
			System.out.print(gradeList.get(i).getStudent_name());
			int nameByte = getByteLength(gradeList.get(i).getStudent_name());
			for(int j=0 ; (nameByte + j) < 15 ; j++) {
				System.out.print(" ");
			}

			System.out.print(gradeList.get(i).getGrade_kor());
			for(int j=0 ; (Integer.toString(gradeList.get(i).getGrade_kor()).length() + j) < 10 ; j++) {
				System.out.print(" ");
			}

			System.out.print(gradeList.get(i).getGrade_eng());
			for(int j=0 ; (Integer.toString(gradeList.get(i).getGrade_eng()).length() + j) < 10 ; j++) {
				System.out.print(" ");
			}

			System.out.print(gradeList.get(i).getGrade_math());
			for(int j=0 ; (Integer.toString(gradeList.get(i).getGrade_math()).length() + j) < 9 ; j++) {
				System.out.print(" ");
			}

			System.out.print(gradeList.get(i).getTotal());
			for(int j=0 ; (Integer.toString(gradeList.get(i).getTotal()).length() + j) < 9 ; j++) {
				System.out.print(" ");
			}

			System.out.printf("%.1f", gradeList.get(i).getAvg());
			if(gradeList.get(i).getAvg() >= 100) {
				System.out.print(" ��\n");
			}
			else if(gradeList.get(i).getAvg() >=10) {
				System.out.print("  ��\n");
			}
			else {
				System.out.print("   ��\n");
			}
		}
		System.out.println("��������������������������������������������������������������������������������");
	}

	public void printGradeListNotFound() {
		System.out.println("> ��ϵ� ���������� �������� �ʽ��ϴ�.\n");		
	}

	public int getSearchGradeMenuNum(Scanner sc) {
		System.out.println("\n������������������< �������� �˻� >������������������");
		System.out.println("             1. �̸����� �˻�                  ");
		System.out.println("             2. �й����� �˻�                  ");
		System.out.println("             3. �г����� �˻�                  ");
		System.out.println("             4. �˻� ���                      ");
		System.out.print("             ���� : ");
		return sc.nextInt();
	}
	
	public void printSearchGradeCancel() {
		System.out.println("             �������� ���� ȭ������ �̵��մϴ�.\n");
	}
	
	public void printSearchGradeListNotFound() {
		System.out.println("> �˻����ǿ� �ش��ϴ� ���������� �������� �ʽ��ϴ�.\n");
	}

	public void printGradeNotFound(int stu_no) {
		System.out.println("> �й� : " + stu_no + " �л��� ���������� �������� �ʽ��ϴ�.\n");
	}

	public Grade getChangeGrade(Grade modifyGrade, Scanner sc) {
		sc.useDelimiter(System.getProperty("line.separator"));

		System.out.println("\n> ������ ���� ���� �Է�");

		System.out.println("> ���� ����� : " + modifyGrade.getGrade_kor());
		System.out.print("> ���� ����� : ");
		int kor_grade = sc.nextInt();

		System.out.println("> ���� ����� : " + modifyGrade.getGrade_eng());
		System.out.print("> ���� ����� : ");
		int eng_grade = sc.nextInt();

		System.out.println("> ���� ���м��� : " + modifyGrade.getGrade_math());
		System.out.print("> ���� ���м��� : ");
		int math_grade = sc.nextInt();

		return new Grade(modifyGrade.getStudent_no(), modifyGrade.getStudent_name(), kor_grade, eng_grade, math_grade);
	}

	public void printModifySuccess(Grade changeGrade) {
		System.out.println("> �й� : " + changeGrade.getStudent_no() + " �л��� ���������� �����Ǿ����ϴ�.\n");
	}

	public void printModifyFail(Grade changeGrade) {
		System.out.println("> �й� : " + changeGrade.getStudent_no() + " �л��� �������� ������ �����߽��ϴ�.\n");
	}

	public void printDeleteSuccess(Grade deleteGrade) {
		System.out.println("> �й� : " + deleteGrade.getStudent_no() + " �л��� ���������� �����Ǿ����ϴ�.\n");
	}

	public void printDeleteFail(Grade deleteGrade) {
		System.out.println("> �й� : " + deleteGrade.getStudent_no() + " �л��� �������� ������ �����߽��ϴ�.\n");
	}

	// ���б� ���� �ܼ� ��ƿ

	public String getScholar_name(String msgKind, Scanner sc) {
		System.out.print("\n> " + msgKind + "���бݸ� : ");
		return sc.next();
	}

	public void printRegistedScholarship(String scholar_name) {
		System.out.println("> ���бݸ� : " + scholar_name + " �� �̹� ��ϵǾ� �ֽ��ϴ�.\n");
	}

	public Scholarship getNewScholarShip(String scholar_name, Scanner sc) {
		sc.useDelimiter(System.getProperty("line.separator"));

		System.out.println("\n> ���ο� ���б� ���� �Է�");

		System.out.print("> ����� : ");
		int percent = sc.nextInt();

		System.out.print("> ���бݾ� : ");
		int money = sc.nextInt();

		return new Scholarship(scholar_name, percent, money);
	}

	public void printRegistSuccess(Scholarship newScholarship) {
		System.out.println("> ���бݸ� : " + newScholarship.getScholar_name() + " �� ������ ��ϵǾ����ϴ�.\n");
	}

	public void printRegistFail(Scholarship newScholarship) {
		System.out.println("> ���бݸ� : " + newScholarship.getScholar_name() + " �� ���� ����� �����߽��ϴ�.\n");
	}

    public void printScholarshipList(ArrayList<Scholarship> scholarshipList) {
		System.out.println("\n<�� " + scholarshipList.size() + "������ ���б��� ��ȸ�մϴ�.>");
		System.out.println("������������������������������������������������������������");
		System.out.println("��       [���бݸ�]       [���������]         [�ݾ�]     ��");
		for(int i=0 ; i<scholarshipList.size() ; i++) {
			
			System.out.print("��" + (i+1) + ".");
			for(int j=0 ; (Integer.toString(i+1).length() + j) < 4 ; j++) {
				System.out.print(" ");
			}

			System.out.print(scholarshipList.get(i).getScholar_name());
			int nameByte = getByteLength(scholarshipList.get(i).getScholar_name());
			for(int j=0 ; (nameByte + j) < 25 ; j++) {
				System.out.print(" ");
			}

			System.out.print(scholarshipList.get(i).getScholar_percent());
			for(int j=0 ; (Integer.toString(scholarshipList.get(i).getScholar_percent()).length() + j) < 15 ; j++) {
				System.out.print(" ");
			}

			System.out.print(scholarshipList.get(i).getScholar_money());
			for(int j=0 ; (Integer.toString(scholarshipList.get(i).getScholar_money()).length() + j) < 11 ; j++) {
				System.out.print(" ");
			}
			
			System.out.println("��");
		}
		System.out.println("������������������������������������������������������������");
	}

	public void printScholarshipListNotFound() {
		System.out.println("> ��ϵ� ���б������� �������� �ʽ��ϴ�.\n");
	}

	public int getSearchMenuNumScholarship(Scanner sc) {
		System.out.println("\n������������������< ���б����� �˻� >����������������");
		System.out.println("             1. ���бݸ����� �˻�");
		System.out.println("             2. ���бݾ����� �˻�");
		System.out.print("             ���� : ");
		return sc.nextInt();
	}

	public int getMoney(String msgKind, Scanner sc) {
		System.out.print("\n> " + msgKind + "�ݾ� : ");
		return sc.nextInt();
	}

	public void printSearchScholarshipListNotFound() {
		System.out.println("> �˻����ǿ� �ش��ϴ� ���б������� �������� �ʽ��ϴ�.\n");
	}

	public void printScholarshipNotFound(String scholar_name) {
		System.out.println("> ���бݸ� : " + scholar_name + " ������ �������� �ʽ��ϴ�.\n");
	}

	public Scholarship getChangeScholarship(Scholarship modifyScholarship,
			Scanner sc) {

		sc.useDelimiter(System.getProperty("line.separator"));
		System.out.println("\n> ������ ���б� ���� �Է�");

		System.out.println("> ���� ����� : " + modifyScholarship.getScholar_percent());
		System.out.print("> ���� ����� : ");
		int scholar_percent = sc.nextInt();

		System.out.println("> ���� ���бݾ� : " + modifyScholarship.getScholar_money());
		System.out.print("> ���� ���бݾ� : ");
		int scholar_money = sc.nextInt();

		return new Scholarship(modifyScholarship.getScholar_name(), scholar_percent, scholar_money);
	}

	public void printModifySuccess(Scholarship changeScholarship) {
		System.out.println("> ���бݸ� : " + changeScholarship.getScholar_name() + " �� ������ �����Ǿ����ϴ�.\n");
	}

	public void printModifyFail(Scholarship changeScholarship) {
		System.out.println("> ���бݸ� : " + changeScholarship.getScholar_name() + " �� ���� ������ �����߽��ϴ�.\n");
	}

	public void printDeleteSuccess(Scholarship deletescholarship) {
		System.out.println("> ���бݸ� : " + deletescholarship.getScholar_name() + " �� ������ �����Ǿ����ϴ�.\n");
	}

	public void printDeleteFail(Scholarship deletescholarship) {
		System.out.println("> ���бݸ� : " + deletescholarship.getScholar_name() + " �� ���� ������ �����߽��ϴ�.\n");

	}

	public void printScholarshipStudentList(
			ArrayList<ScholarshipStudent> scholarshipStudentSearchList) {
				System.out.println("\n<�� " + scholarshipStudentSearchList.size() + "���� �����л��� ��ȸ�մϴ�.>");
		System.out.println("������������������������������������������������������������������������������������");
		System.out.println("��      [�й�]     [�̸�]       [���]   [�����]      [���бݸ�]      [���бݾ�] ��");

		for(int i=0 ; i<scholarshipStudentSearchList.size() ; i++) {
			
			System.out.print("��" + (i+1) + ".");
			for(int j=0 ; (Integer.toString(i+1).length() + j) < 4 ; j++) {
				System.out.print(" ");
			}

			System.out.print(scholarshipStudentSearchList.get(i).getStudent_no());
			for(int j=0 ; (Integer.toString(scholarshipStudentSearchList.get(i).getStudent_no()).length() + j) < 12 ; j++) {
				System.out.print(" ");
			}

			System.out.print(scholarshipStudentSearchList.get(i).getStudent_name());
			int stu_noByte = getByteLength(scholarshipStudentSearchList.get(i).getStudent_name());
			for(int j=0 ; stu_noByte + j < 14 ; j++) {
				System.out.print(" ");
			}

			System.out.print(scholarshipStudentSearchList.get(i).getAvg());
			if(scholarshipStudentSearchList.get(i).getAvg() >= 100) {
				System.out.print("     ");
			}
			else if(scholarshipStudentSearchList.get(i).getAvg() >=10) {
				System.out.print("      ");
			}
			else {
				System.out.print("       ");
			}
			
			System.out.print(scholarshipStudentSearchList.get(i).getPercent());
			if(scholarshipStudentSearchList.get(i).getPercent() >= 100) {
				System.out.print("     ");
			}
			else if(scholarshipStudentSearchList.get(i).getPercent() >=10) {
				System.out.print("      ");
			}
			else {
				System.out.print("       ");
			}
			
			System.out.print(scholarshipStudentSearchList.get(i).getScholar_name());
			int sc_nameByte = getByteLength(scholarshipStudentSearchList.get(i).getScholar_name());
			for(int j=0 ; sc_nameByte + j < 20 ; j++) {
				System.out.print(" ");
			}

			System.out.print(scholarshipStudentSearchList.get(i).getScholar_money());
			for(int j=0 ; (Integer.toString(scholarshipStudentSearchList.get(i).getScholar_money()).length() + j) < 9 ; j++) {
				System.out.print(" ");
			}
			System.out.println("��");
		}
		System.out.println("������������������������������������������������������������������������������������");
	}

	public void printScholarshipStudentListNotFound() {
		System.out.println("> ��ϵ� ���б� �����л� ������ �������� �ʽ��ϴ�.\n");	
	}

}
