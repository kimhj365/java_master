package todo.p20231205;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmpApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		EmpExe exe = new EmpExe();
		boolean run = true;

		while (run) {

			System.out.println();
			System.out.println("┏━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━━━━━━┳━━━━━━━━┳━━━━━━━━┳━━━━━━━━┓");
			System.out.println("┃ 1.사원 등록 ┃ 2.목록 조회 ┃ 3.단건 조회 ┃ 4.수정 ┃ 5.삭제 ┃ 6.종료 ┃");
			System.out.println("┗━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━━━━━━┻━━━━━━━━┻━━━━━━━━┻━━━━━━━━┛");
			System.out.print("동작을 입력하세요 \n>> ");
			int menu;
			try {
				menu = Integer.parseInt(scn.nextLine());
			} catch (NumberFormatException e) {
				menu = 0;
			}

			switch (menu) {
			case 1:
				System.out.println("< 사원 등록 >");
				System.out.print("사원 번호를 입력하세요 \n>> ");
				String num = scn.nextLine();
				System.out.print("사원 이름을 입력하세요 \n>> ");
				String name = scn.nextLine();
				System.out.print("전화번호를 입력하세요 \n>> ");
				String tel = scn.nextLine();
				System.out.print("급여를 입력하세요 \n>> ");
				int salary = 0;
				try {
					salary = Integer.parseInt(scn.nextLine());
				} catch (NumberFormatException e) {
					System.out.println("사원 등록에 실패했습니다");
					continue;
				}
				Date date = new Date();
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				String joinDate = sdf.format(date);
				
				boolean chk = exe.addEmp(num, name, tel, joinDate, salary);
				if(chk)
					System.out.println("사원 정보가 등록됐습니다");
				else
					System.out.println("사원 정보 등록에 실패했습니다");
				break;
			case 2:
				System.out.println("< 전체 목록 조회 > ");
	
				exe.getEmplist();
				break;
			case 3:
				System.out.println("< 단건 조회 > ");
				System.out.print("입사일자를 입력하세요 \n>> ");
				joinDate = scn.nextLine();
				
				break;
			case 4:
				break;
			case 5:
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				scn.close();
				run = false;
				break;
			default:
				System.out.println("올바른 동작을 입력하세요");
			} // end of switch
		} // end of while
		System.out.println("end of prog.");
	} // end of main
}
