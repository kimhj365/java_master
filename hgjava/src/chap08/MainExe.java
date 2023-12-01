package chap08;

import java.util.Scanner;

public class MainExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		// 인터페이스 변수에 구현하는 클래스 타입 담음
		DatabaseService svc = new OracleService(); // new MySQLService();
		
		boolean run = true;
		while(run){
			System.out.println("1.등록 2.수정 3.삭제 4.종료");
			int menu = Integer.parseInt(scn.nextLine());
			switch(menu) {
			case 1:
				svc.add();
				break;
			case 2:
				svc.modify();
				break;
			case 3:
				svc.remove();
				break;
			}
		}
	}

}
