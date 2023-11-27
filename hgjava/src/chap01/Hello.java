package chap01;

import java.io.IOException;
import java.util.Scanner;

public class Hello {

	public static void main(String[] args) throws IOException {
		System.out.println("Hello, Java!");
		
		int x = 5;
		int y = x + 10;
		System.out.println(y);
		
		double z = 3.5;
		System.out.println(z);
		System.out.println("y = " + y);
		
		//변수의 값 교환
		x = 3;
		y = 10;
		
		int temp = x;
		x = y;
		y = temp;
		
		System.out.println("x = " + x + ", y = " + y);
		
		//기본타입
		//크기 순서 : byte < short < char(음수x) < int < long 
		char charData = 'A';
		int intData = charData;
		System.out.println("char : " + charData + ", int : " + intData);
		
		//타입 변환
		char c1 = 'a';
		int c2 = c1 + 2;	//자동 타입 변환
		char c3 = (char)c2;	//강제 타입 변환
		//printf() : 형식화된 문자열 출력하기 => %d(정수), %f(실수), %s(문자열)
		System.out.printf("c2의 값 : %d, c3의 값 : %s \n", c2, c3);
		
		//int / int => int
		x = 5;
		y = 2;
		double result = (double)x / y;		//둘 중 하나라도 double로 변환
		System.out.println(result);
		
		//double 연산결과를 int에 대입
		double v1 = 3.5;
		double v2 = 2.7;
		int result2 = (int)(v1 + v2);	//계산 결과에 (int) 씌워서 타입 변환
		System.out.println(result2);
		
		//확인문제 9
		long var1 = 2L;
		float var2 = 1.8f;
		double var3 = 2.5;
		String var4 = "3.9";
		int result3 = (int)(var1 + var2 + var3) + (int)(Double.parseDouble(var4));
		System.out.println(result3);
		
		//표준입력 : 키보드 => System.in.read()
		//한글자만 읽어들임
		
//		int keyCode;
//		while(true) {
//			keyCode = System.in.read();
//			System.out.println("keyCode : " + keyCode);
//			if(keyCode == 113) {
//				break;
//			}
//		}
//		System.out.println("종료");
		
		//문자열 입력 => Scanner 클래스 => 객체 생성해서 사용
		//이름 받고 출력하기 반복문
		String scinput;
		//Scanner 클래스 객체 sc 인스턴스 생성
		Scanner sc  = new Scanner(System.in);
		while(true) {
			System.out.print("이름 입력 : ");
			scinput = sc.nextLine();	//nextLine(): 엔터키 입력전 입력된 내용 문자열로 읽음
			
			if(scinput.equals("q")) {
				break;
			}
			System.out.println("제 이름은 " + scinput + "입니다.");	
		}
		System.out.println("종료");
		
		//입력된 숫자에 덧셈 
		System.out.println("수 입력 : ");
		scinput = sc.nextLine();
		System.out.print(Integer.parseInt(scinput) + 10);	//문자열 => int로 변경해서 계산
		
		sc.close();	//입력 열어놓은 sc 닫기
		
	}	//end main()
}	//end class
