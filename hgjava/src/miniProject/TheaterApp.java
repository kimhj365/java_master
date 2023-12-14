package miniProject;

import java.util.Scanner;

public class TheaterApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		
		System.out.println();
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃                        예담시네마 동성로점                         ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.println("┏━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┳━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┓");
		System.out.println("┃            1. 로그인             ┃            2.회원가입           ┃");
		System.out.println("┗━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┻━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━┛");
		System.out.print("동작을 입력하세요 \n>>>> ");
		int menu = 0;
		try {
			menu = Integer.parseInt(scn.nextLine());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(menu == 1) {
			System.out.println("< 로그인 >");
			System.out.print("아이디를 입력하세요 \n>>>>");
			String userId = scn.nextLine();
			System.out.print("비밀번호를 입력하세요 \n>>>>");
			String passwd = scn.nextLine();
			
		}
				
		while(run) {
			
		}
	}

}
