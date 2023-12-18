package com.yedam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.Data;

@Data

public class Ticket {

	int ticketId;
	String user_id;
	int schedule_id;
	String age;
	String seat_row;
	int seat_column;
	String discount;
	int price;
	String reserveDate;

	Ticket() {}

	public Ticket(String user_id, int schedule_id, String age, String seat_row, int seat_column, String discount) {
		this.user_id = user_id;
		this.schedule_id = schedule_id;
		this.age = age;
		this.seat_row = seat_row;
		this.seat_column = seat_column;
		this.discount = discount;
		
		int price = 0;
		if(getAge().equals("����")) {
			price = 15000;
			
			if(getDiscount().equals("����")) {
				price = 11000;
			}
			else if(getDiscount().equals("�ɾ�")) {
				price = 9000;
			}
		}
		else if(getAge().equals("û�ҳ�")) {
			price = 11000;
			if(getDiscount().equals("����")) {
				price = 8000;
			}
			else if(getDiscount().equals("�ɾ�")) {
				price = 9000;
			}
		}
		this.price = price;
		
		LocalDateTime now = LocalDateTime.now();
		String formattedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		this.reserveDate = formattedNow;
	}
	
}

