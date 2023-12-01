package chap10;

import java.util.Scanner;

public class NumberExectionExe {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		while(run) {
			System.out.println("1.추가 2.삭제 3.종료");
			int menu = 0;
			
			try {
				menu = Integer.parseInt(scn.nextLine()); // "1" => 1.
			} catch(NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
			}
			switch(menu) {
			case 1:
				System.out.println("추가합니다");
				break;
			case 2:
				System.out.println("삭제합니다");
				break;
			case 3:
				System.out.println("종료합니다");
				run = false;
			}
		}
		scn.close();
		System.out.println("end of prog.");
	}

}
