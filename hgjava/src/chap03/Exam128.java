package chap03;

import java.util.*;

public class Exam128 {

	public static void main(String[] args) {
		//문제 4
		int penNum = 534;
		int stuNum = 30;
		
		int ppsNum = penNum /stuNum;
		int rempNum = penNum % stuNum;
		System.out.printf("학생 당 연필 수 : %s, 남은 연필 수 : %s\n", ppsNum, rempNum);
		
		//문제 6
		int value = 356;
		System.out.println(value + "의 십의 자리 이하 버림 : " + value / 100 * 100);	//백의 자리까지만 출력
		
		//문제 7 => 부동 소수점 표현 방식 : 0.1f는 0.1 보다 큰 값
		//강제 타입 변환 : (float)0.1
		
		//문제 8
		//사다리꼴의 너비 = (윗변 + 아랫변) * 높이 / 2
		int lengthTop = 5;
		int lengthBottom = 10;
		int height = 7;
//		double area = ((double)lengthTop + lengthBottom) * height / 2;
		double area = (lengthTop + lengthBottom) * height / 2.0;
		System.out.println("사다리꼴의 넓이 : " + area);
		
		//문제 9
		//Scanner 참조변수 생성
		Scanner sc = new Scanner(System.in);
		
		//숫자만 입력받을 때 : nextDouble() 사용 가능
		System.out.print("첫번째 수 : ");
		double scInput1 = sc.nextDouble();
		
		System.out.print("두번째 수 : ");
		double scInput2 = sc.nextDouble();

		System.out.println("--------------------");
		
		//나누는 수  = 0이면 "결과: 무한대"
		System.out.println(scInput2 != 0 ? "결과: " + scInput1 / scInput2 : "결과: 무한대");
//		if(scInput2 != 0) {
//			System.out.println("결과: " + scInput1 / scInput2);			
//		}
//		else {
//			System.out.println("결과: 무한대");			
//		}		
		
		//문제 10
		int var1 = 10;
		int var2 = 3;
		int var3 = 14;
		double var4 = var1 * var1 * Double.parseDouble(var2 + "." + var3);
		System.out.println("원의 넓이 : " + var4);
		
		//문제 11 : 기본타입 데이터 비교(==), 참조타입 비교(equals())
		Scanner sc2 = new Scanner(System.in);
		
		System.out.print("아이디 : ");
		String name = sc2.nextLine();
		
		System.out.print("패스워드 : ");
		String strPassword = sc2.nextLine();		
		int password = Integer.parseInt(strPassword);
		
		if(name.equals("java")) {
			if(password == 12345) {
				System.out.println("로그인 성공");
			}
			else {
				System.out.println("로그인 실패: 패스워드가 틀림");
			}
		}
		else {
			System.out.println("로그인 실패: 아이디 존재하지 않음");
		}
		
		sc.close();
		sc2.close();
	}//end main()

}//end class
