package chap05;

import java.util.Scanner;

public class WhileExe1 {

	public static void main(String[] args) {

		// for :  반복횟수가 정해져있는 경우
		
		//while : 조건을 만족하는 동안 반복
		Scanner scn = new Scanner(System.in);
		while(true) {
			System.out.print("문자값을 입력하세요 > ");
			String txt = scn.nextLine();
			if(txt.equals("quit")) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
			System.out.println("입력값은 " + txt + " 입니다.");
		}
		scn.close();
		System.out.println("end of prog.");
	}

}
