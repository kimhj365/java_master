package com.yedam;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class TestApp {

	public static void main(String[] args) {

		// 1. 현재시간
		LocalDateTime now = LocalDateTime.now();
		System.out.println("LocalDateTime now = " + now);
		
		String formattedNow = now.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분"));
		System.out.println("String formattedNow = " + formattedNow);
		
		int hour = now.getHour();
		System.out.println("now.getHour() = " + hour);
		System.out.println();
		
		// 2. 직접 입력
		LocalDateTime then = LocalDateTime.of(2023, 12, 20, 8, 00);
		System.out.println("LocalDateTime then = " + then);
		
		String formattedThen = then.format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분"));
		System.out.println("String formattedThen = " + formattedThen);
		
		int hour2 = then.getHour();
		if(hour2 <= 9) {
			System.out.println("조조영화 입니다");
		}
		else if(hour2 >= 23) {
			System.out.println("심야영화 입니다");
		}
		else {
			System.out.println("일반영화 입니다");
		}
		System.out.println();
		
		// 3. String to LocalDateTime
		String strDateTime = "2023-12-16 09:00";
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime ldtDate = LocalDateTime.parse(strDateTime, formatter);
		System.out.println("LocalDateTime ldtDate = " + ldtDate);
		
		// 4. String to LocalDate
		String strDate = "2023-12-16";
		DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate ldDate = LocalDate.parse(strDate, formatter2);
		System.out.println("LocalDate ldDate = " + ldDate);
		
		
		char A = 65;
		char E = 69;
		System.out.println(A + ", " + E);
		
		String movieDate = "2023-12-20 12:00";
		DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
		LocalDateTime ldt;
		try {
			ldt = LocalDateTime.parse(movieDate, formatter3);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
		System.out.println("\n\t   영화 입장권\n");
		System.out.println("  2023-12-19 17:30");
		System.out.println(" ================================");
		System.out.println("  12세 이상 관람가\n");
		System.out.println("  서울의 봄\n");
		System.out.println("  2023-12-25 12:00 ~ 14:30\n");
		System.out.println("  1관 A열 5번\n");
		System.out.println(" ================================");
		System.out.println("  총인원 1명(성인)");
		System.out.println("  주간 15000원\n");
		System.out.println(" --------------------------------");
		System.out.println("  예담시네마 동성로점\n");
		System.out.println("VVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVVV");
	}

}
