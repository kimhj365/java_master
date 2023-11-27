package chap05;

import java.util.Scanner;

public class StudentApp {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		boolean run = true;
		int studentsNum = 0;
		int[] scores = null;	//초기값 배정해야 .length 오류 안뜸
		String[] names = null;
		
		while(run) {
			System.out.println("-----------------------------------------------------------");
			System.out.println("| 1.학생 수 | 2.점수 입력 | 3.목록 출력 | 4.분석 | 5.종료 |");
			System.out.println("-----------------------------------------------------------");
			System.out.print("숫자를 입력하세요 > ");
			int menu = scn.nextInt();	
			
			switch(menu) {
			case 1 : 
				System.out.print("학생 수 입력 >> ");
				studentsNum = scn.nextInt();	//3 enter => 3만 읽고 엔터 처리 안함
				scn.nextLine();
				scores = new int[studentsNum];
				names = new String[studentsNum];
				break;
			case 2 : 
				System.out.println("점수 입력 >> ");
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("names[%d] >> ", i);
					names[i] = scn.nextLine();	//netInt에서 엔터 처리 안하면 여기서 엔터 처리 => 그냥 넘어가짐
					System.out.printf("scores[%d] >> ", i);
					scores[i] = scn.nextInt();
					scn.nextLine();
				}
				break;
			case 3 : 
				System.out.println("목록 출력 >> ");
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("이름은 %s, 점수는 %d점 입니다.\n", names[i], scores[i]);
				}
				break;
			case 4 : 
				System.out.println("분석 >> ");
				int maxScore = scores[0];
				int sum = 0;
				String maxName = null;
				for(int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if(maxScore < scores[i]) {
						maxScore = scores[i];
						maxName = names[i];
					}
				}
				double avg = (double)sum / scores.length;
				
				System.out.printf("최고점수 : %s의 점수 %d\n", maxName, maxScore);
				System.out.println("평균 : " + avg);
				
				break;
			case 5 : 
				System.out.print("종료 >> ");
				run = false;
				break;
				
			}	// end of switch
			
		}	// end of while
		scn.close();
		
	}

}
