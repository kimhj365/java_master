package com.yedam;

import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {

		//ExpDAO 인스턴스 dao 생성.
		EmpDAO dao = new EmpDAO();
		Scanner scn = new Scanner(System.in);
		boolean run = true;

		while (run) {
			System.out.println();
			System.out.println("┏━━━━━━━━┳━━━━━━━━┳━━━━━━━━━━━━━━┳━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━┓");
			System.out.println("┃ 1.등록 ┃ 2.목록 ┃ 3.수정(급여) ┃ 4.삭제 ┃ 5.조회(조건:입사일자) ┃ 6.종료 ┃");
			System.out.println("┗━━━━━━━━┻━━━━━━━━┻━━━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━┛");
			System.out.print("동작을 입력하세요 >> ");
			int menu;
			// parseInt 예외처리.
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				menu = 0;
			}

			switch (menu) {
			// 1. 추가.
			case 1:
				System.out.println("< 사원 등록 >");
				System.out.print("사번 입력 >> ");
				String empNo = scn.nextLine();
				System.out.print("이름 입력 >> ");
				String empName = scn.nextLine();
				System.out.print("전화번호 입력 >> ");
				String empTel = scn.nextLine();
				System.out.print("입사일 입력 >> ");
				String empDate = scn.nextLine();
				System.out.print("급여 입력 >> ");
				int salary = 0;
				// parseInt 예외처리.
				try {
					salary = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("올바른 급여를 입력하세요");
					continue;
				}
				// ExeDAO의 추가 함수 호출.
				boolean check = dao.addEmployee(empNo, empName, empTel, empDate, salary);
				if (check)
					System.out.println("사원 정보가 등록되었습니다");
				else
					System.out.println("사원 등록에 실패했습니다");
				break;

			// 2. 목록 출력.
			case 2:
				System.out.println("< 사원 목록 >");
				System.out.printf("%3s %3s %5s\n", "사번", "이름", "전화번호");
				System.out.println("========================");
				// ExeDAO 목록 출력 함수 호출.
				dao.getEmployeeList();
				break;

			// 2. 수정(급여).
			case 3:
				System.out.println("< 급여 수정 >");
				System.out.print("사번 급여 >> ");
				String input = scn.nextLine();
				// ExeDAO 급여 수정 함수 호출.
				check = dao.modifyEmploy(input);
				if (check)
					System.out.println("급여가 수정되었습니다");
				else
					System.out.println("급여 수정에 실패했습니다");
				break;

			// 4. 삭제.
			case 4:
				System.out.println("< 사원 삭제 >");
				System.out.print("사번 >> ");
				input = scn.nextLine();
				// ExeDAO 사원 삭제 함수 호출.
				check = dao.removeEmploy(input);
				if (check)
					System.out.println("사원 정보가 삭제되었습니다");
				else
					System.out.println("사원 삭제에 실패했습니다");
				break;

			// 5. 조회.
			case 5:
				System.out.println("< 사원 조회 >");
				System.out.print("입사일자 >> ");
				input = scn.nextLine();
				System.out.printf("%3s %3s %5s\n", "사번", "이름", "입사일자");
				System.out.println("========================");
				// ExeDAO 사원 조회 함수 호출.
				dao.getEmployee(input);
				break;

			// 6. 종료.
			case 6:
				System.out.println("프로그램을 종료합니다");
				scn.close();
				run = false;
				break;
			default:

			} // end of switch.

		} // end of while.

		System.out.println("end of prog.");

	} // end of main.
}
