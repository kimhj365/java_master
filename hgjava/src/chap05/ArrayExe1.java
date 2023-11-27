package chap05;

public class ArrayExe1 {

	public static void main(String[] args) {
		
		int[] ary = { 10, 20, 33, 25, 34 };		//배열 선언 + 크기 3짜리 배열의 값 초기화
		
		int sum = 0;
		for (int i = 0; i < ary.length; i++) {
			sum += ary[i];
		}
		System.out.println("합계는 " + sum + "입니다.");
		
		int[] intAry = new int[5];		//new 예약어로 int 배열 크기만 선언
		System.out.println(intAry[0]);	//int 배열 기본값 0
		
		String[] names = new String[10];	//new 예약어로 String 배열 선언
		names[0] = "홍길동";
		names[1] = "김길동";
		System.out.println(names[0]);
		System.out.println(names[2]);		//String 배열 기본값 null
		
		
	}

}
