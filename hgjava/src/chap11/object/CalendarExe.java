package chap11.object;

import java.util.Calendar;

public class CalendarExe {

	public static void main(String[] args) {

		// Calenadar 클래스의 정적 메소드 호출 => 인스턴스 생성( new 아님 )
		Calendar cal = Calendar.getInstance();
		
		// 1.YEAR 2.MONTH(0: 1월 ~ 11: 12월) 5:DATE
		cal.set(1,  2022);
//		cal.set(Calendar.YEAR, 2022);
		cal.set(2, 5);
//		cal.set(Calendar.MONTH, 5);
		cal.set(5, 20);
//		cal.set(Calendar.DATE, 20);
		cal.set(2023, 11, 25);
		
		// DAY_OF_WEEK: 1.일 2.월 ~ 7.토
		System.out.println("년: " + cal.get(Calendar.YEAR));
		System.out.println("월: " + (cal.get(Calendar.MONTH ) + 1));
		System.out.println("일: " + cal.get(Calendar.DATE));
		System.out.println("요일: " + cal.get(Calendar.DAY_OF_WEEK));
		System.out.println("월의 마지막 날: " + cal.getActualMaximum(Calendar.DATE));
		
		
		
	}

}
