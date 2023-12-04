package todo.p20231201;

import java.util.Calendar;

public class CalenderExe {
	public static void main(String[] args) {
		
		// 10월 달력 만들기.
		String[] days = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
		
		System.out.println("=========== 12 월 ===========");
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		
		int j;
		for(j = 0; j < 5; j++) {
			System.out.printf("%4s", " ");
		}
		
		for(int i = 1; i <= 31; i++) {
			System.out.printf("%4d", i);
			if((i + j) % 7 == 0) {
				System.out.println();
			}
		}
		System.out.println("\n========== the end ==========\n");
		
		// 월별로 바뀌는 달력 만들기.
		int year = 2023;
		int month = 12;
		
		Calendar today = Calendar.getInstance();
		
		today.set(Calendar.YEAR, year);
		today.set(Calendar.MONTH, month - 1);
		today.set(Calendar.DATE, 1);
		// 1일의 요일 = 월의 시작하는 날의 요일 => 공백 갯수.
		int firstDayOfWeek = today.get(Calendar.DAY_OF_WEEK);
		// 마지막 날 => for문 돌려 날짜 찍기
		int lastDate = today.getActualMaximum(Calendar.DATE);

		// 월 출력.
		System.out.printf("=========== %d 월 ===========\n", month);
		// 요일 출력.
		for(String day : days) {
			System.out.printf("%4s", day);
		}
		System.out.println();
		// 공백 출력 => 첫째날 요일 -1 만큼
		for(int i = 1; i < firstDayOfWeek; i++) {
			System.out.printf("%4s", " ");
		}		
		// 날짜 출력 => 달의 마지막날 까지 반복
		for(int i = 1; i <= lastDate; i++) {
			System.out.printf("%4d", i);
			// 공백(첫째날 요일 -1) + i 가 7의 배수인 날에서 줄 바꿈
			if((firstDayOfWeek - 1 + i) % 7 == 0)
				System.out.println();
		}
		System.out.println("\n========== the end ==========\n");
		
		
		
	}
}

