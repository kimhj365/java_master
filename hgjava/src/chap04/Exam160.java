package chap04;

import java.util.Scanner;

public class Exam160 {

	public static void main(String[] args) {
		//문제 2 : 3의 배수 합
		int sum = 0;
		for(int i = 1; i <= 100; i++) {
			if(i % 3 == 0) {
				sum += i;
			}
		}
		System.out.println(sum);
		
		//문제 3
		while(true) {
		int dice1 = (int)(Math.random()* 6) + 1;
		int dice2 = (int)(Math.random()* 6) + 1;
		
		System.out.printf("(%s, %s)\n", dice1, dice2);
		if(dice1 + dice2 == 5) {
				System.out.println("종료");
				break;
			}
		}
		
		//문제 4		
		for(int x = 1; x <= 10; x++) {
			for(int y = 1; y <= 10; y++) {
				if(4*x + 5*y == 60) {
					System.out.printf("(%s, %s)\n", x, y);
					break;
				}
			}
		}
		
		//문제 5
		int line = 4;
		String stars = "";
		for (int i = 1; i <= line; i++) {
			for (int j = 1; j <= i; j++) {
				stars += "*";
			}
			stars += "\n";
		}
		System.out.println(stars);
		
		//문제 6
		for (int i = 1; i <= line; i++) {
			for(int j = line-1; j >= i; j--) {
				stars += " ";
			}
			for (int j = 1; j <= i; j++) {
				stars += "*";
			}
			stars += "\n";
		}
		System.out.println(stars);
		
		//문제 7
		boolean run = true;
		int balance = 0;
		Scanner scanner = new Scanner(System.in);
		
		bankProgram: while(run) {
			System.out.println("------------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("------------------------------------");
			System.out.print("선택> ");
			
			String scInput = scanner.nextLine();
			
			switch(scInput) {
				case "1" :
				case "예금" : 
					System.out.print("예금액> ");
					scInput = scanner.nextLine();
					balance += Integer.parseInt(scInput);
					System.out.println();
					break;
				case "2" : 
				case "출금" :
					System.out.print("출금액> ");
					scInput = scanner.nextLine();
					if(Integer.parseInt(scInput) <= balance) {
						balance -= Integer.parseInt(scInput);
						System.out.println();						
					}
					else {
						System.out.println("잔액이 부족합니다");						
						System.out.println();						
					}
					break;
				case "3" : 
				case "잔고" :
					System.out.printf("잔고> %d\n", balance);
					System.out.println();
					break;
				case "4" :
				case "종료" :
					System.out.println();
					break bankProgram;
//					run = false;
//					break;
				default : 
					System.out.println("다시 입력하세요\n");
			}
		}
		System.out.println("프로그램 종료");
		scanner.close();
		
	}

}
