package com.yedam;

import java.time.*;
import java.util.*;
import lombok.Data;

@Data

public class Schedule {
	
	String scheduleId;
	String movieId;
	String movieDate;
	int remainSeat;
	String discount;
	
	Schedule() {}

	public Schedule(String scheduleId, String movieId, String movieDate, int remainSeat, String discount) {
		this.scheduleId = scheduleId;
		this.movieId = movieId;
		this.movieDate = movieDate;
		this.remainSeat = remainSeat;
		this.discount = discount;
		
	}
	
	void showInfo() {
		System.out.printf("%5s %-20s %-20s %5d %10s\n", scheduleId, movieId, movieDate, remainSeat, discount);
	}
}

