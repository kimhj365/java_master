package com.yedam;

import lombok.Data;

@Data

public class Schedule {
	
	int num;
	int scheduleId;
	String movieId;
	String movieDate;
	int remainSeat;
	String discount;
	
	Schedule() {}

	public Schedule(int scheduleId, String movieId, String movieDate, int remainSeat, String discount) {
		this.scheduleId = scheduleId;
		this.movieId = movieId;
		this.movieDate = movieDate;
		this.remainSeat = remainSeat;
		this.discount = discount;
		
	}
	
	public Schedule(int num, int scheduleId, String movieId, String movieDate, int remainSeat, String discount) {
		this.num = num;
		this.scheduleId = scheduleId;
		this.movieId = movieId;
		this.movieDate = movieDate;
		this.remainSeat = remainSeat;
		this.discount = discount;
		
	}
	
	void showInfo() {
		System.out.printf("%5d %10d %-20s %-20s %5d %10s\n", num, scheduleId, movieId, movieDate, remainSeat, discount);
	}
	void showInfo2() {
		System.out.printf("%5d %-20s %-20s %5d %10s\n", num, movieId, movieDate, remainSeat, discount);
	}
//	void showInfo2() {
//		System.out.printf("%5d %-20s\t %-20s\t %5d %10s\n", num, movieId, movieDate, remainSeat, discount);
//	}
}

