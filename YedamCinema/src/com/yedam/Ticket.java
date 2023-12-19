package com.yedam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data

public class Ticket {

	int num;
	int ticketId;
	String user_id;
	int schedule_id;
	String age;
	String seat_row;
	int seat_column;
	String discount;
	int price;
	String reserveDate;

	Ticket() {
	}

//	

	public Ticket(String user_id, int schedule_id, String age, String seat_row, int seat_column, String discount) {
		this.user_id = user_id;
		this.schedule_id = schedule_id;
		this.age = age;
		this.seat_row = seat_row;
		this.seat_column = seat_column;
		this.discount = discount;

		int price = 0;
		if (getAge().equals("성인")) {
			price = 15000;

			if (getDiscount().equals("조조")) {
				price = 11000;
			} else if (getDiscount().equals("심야")) {
				price = 9000;
			}
		} else if (getAge().equals("청소년")) {
			price = 11000;
			if (getDiscount().equals("조조")) {
				price = 8000;
			} else if (getDiscount().equals("심야")) {
				price = 9000;
			}
		}
		this.price = price;

		LocalDateTime now = LocalDateTime.now();
		String formattedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.reserveDate = formattedNow;
	}

	public Ticket(int num, int ticketId, String user_id, int schedule_id, String age, String seat_row, int seat_column,
			String discount, int price, String reserveDate) {
		this.num = num;
		this.ticketId = ticketId;
		this.user_id = user_id;
		this.schedule_id = schedule_id;
		this.age = age;
		this.seat_row = seat_row;
		this.seat_column = seat_column;
		this.discount = discount;
		this.price = price;
		this.reserveDate = reserveDate;
	}

	void showInfo() {
		System.out.printf("%5d %13s %10d %5s %5s %-5d %7d원    %15s\n"
				, num, user_id, schedule_id, age, seat_row, seat_column, price, reserveDate);
	}

}
