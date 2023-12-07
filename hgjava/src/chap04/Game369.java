package chap04;

import java.util.Scanner;

public class Game369 {

	public static void main(String[] args) {
		//Q. 369 게임
		System.out.println("==========369 게임==========");
		int count = 0;
		
		for (int i = 1; i <= 100; i++) {
			//카운트 초기화
			count = 0;
			
			//일의 자리 3의 배수 검사 
			if(i % 10 == 3 || i % 10 == 6 || i % 10 == 9) count++;
			
			//십의 자리 3의 배수 검사
			if(i > 10 && (i / 10) % 3 == 0) count++;
			
			//하트 갯수대로 찍기
//			if(count == 0) System.out.print(i + "\t");
//			else if(count == 1) System.out.print("♥\t");
//			else System.out.print("♥♥\t");
			
			//switch문으로 찍기
			switch(count) {
			case 0 : System.out.print(i + "\t"); break;
			case 1 : System.out.print("♥\t"); break;
			case 2 : System.out.print("♥♥\t");
			}
			
			//10마다 줄 바꿈
			if(i % 10 == 0) System.out.println();
		}
		
		
		//Q. 동전 교환 게임
		System.out.println("==========동전교환 게임==========");
		Scanner scInput = new Scanner(System.in);
		
		System.out.print("##교환할 금액 : ");
		int money = scInput.nextInt();
		int change = 0;
		
		System.out.printf("500원 짜리 : %d개\n", money / 500);
		change = money % 500;
		System.out.printf("100원 짜리 : %d개\n", change / 100);
		change %= 100;
		System.out.printf("50원 짜리 : %d개\n", change / 50);
		change %= 50;
		System.out.printf("10원 짜리 : %d개\n", change / 10);
		change %= 10;
	
		System.out.printf("교환 금액 : %d원\n", money - change);
		System.out.printf("남은 금액 : %d원\n", change);
		
		
		//Q. 숫자 추측게임
		System.out.println("==========숫자 추측 게임==========");
		int rNum = (int)(Math.random()*100) + 1;
		System.out.println(rNum);
		
		while(true) {
			System.out.print("숫자 입력 : ");
			int gNum = scInput.nextInt();
			
			if(gNum < rNum) {
				System.out.println("UP 하세요!");
			}
			else if(gNum > rNum) {
				System.out.println("DOWN 하세요!");
			}
			else {
				System.out.println("축하합니다!");
				break;
			}
		}
		
		
		//Q. 윤년 계산 프로그램
		System.out.println("==========윤년 계산==========");
		System.out.print("##년도 입력 : ");
		int yearInput = scInput.nextInt();
		
		if(yearInput % 4 == 0 && yearInput % 100 != 0 || yearInput % 400 == 0 ) {
			System.out.println(yearInput + "년은 윤년입니다.");
		}
		else {
			System.out.println(yearInput + "년은 평년입니다.");
		}
	
		
		//Q. 구구단 프로그램
		for(int i = 2; i <= 9; i++) {
			System.out.printf("  %d단\t", i);
			if(i == 9) System.out.println();
		}
		for(int i = 1; i <= 9; i++) {
			for(int j = 2; j <= 9; j++) {
				System.out.printf("%dx%d= %d\t", j, i, i*j);
				if(j == 9) System.out.println();; 
			}
			
		}
		
//		scInput.close();
		
		//Q. 가위바위보 프로그램
		//github java_master repository에 추가됨
		int hDec = 0;
		int cDec = 0;
		int hScore = 0;
		int cScore = 0;
		boolean run = true;
		
		while(run) {
			System.out.print("## 가위(0) 바위(1) 보(2) : ");
			hDec = scInput.nextInt();
			cDec = (int)(Math.random() * 3);
			if(hDec == 0 && cDec == 2) hDec = 3;
			if(hDec == 2 && cDec == 0) cDec = 3;
						
			if(hDec > cDec) {
				System.out.printf("사람 %d, 컴 %d : 사람 승리\n", hDec % 3, cDec % 3);
				hScore++;
			}
			else if(hDec < cDec) {
				System.out.printf("사람 %d, 컴 %d : 컴 승리\n", hDec % 3, cDec % 3);
				cScore++;
			}
			else if(hDec == cDec) {
				System.out.printf("사람 %d, 컴 %d : 무승부\n", hDec % 3, cDec % 3);
			}
			
			if(hScore == 3) {
				System.out.printf("최종 스코어 %d : %d  사람 승리!", hScore, cScore);
				run = false;
			}
			if(cScore == 3) {
				System.out.printf("최종 스코어 %d : %d  컴퓨터 승리!", hScore, cScore);
				run = false;
			}
		}
		
		scInput.close();
	}
}
