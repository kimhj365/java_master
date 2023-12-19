package com.yedam;

import lombok.Data;

@Data

public class User {

//	2. 회원 테이블
//	-ID(PK)
//	-비밀번호(NOT NULL)
//	-이름
//	-연락처
	
	// 필드.
	private int num;
	private String userId;
	private String passwd;
	private String userName;
	private String userTel;
	private String joinDate;
	
	// 생성자.
	User() {}

	public User( String userId, String passwd, String userName, String userTel) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
		this.userTel = userTel;
	}
	
	public User(int num, String userId, String passwd, String userName, String userTel, String joinDate) {
		this.num = num;
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
		this.userTel = userTel;
		this.joinDate = joinDate;
	}
	
	public User(String userId, String passwd, String userName, String userTel, String joinDate) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
		this.userTel = userTel;
		this.joinDate = joinDate;
	}
	
	// 메서드.
	void showUserInfo() {
		System.out.printf("%5d %10s %5s %20s %20s\n", num, userId, userName, userTel, joinDate); 
	}

}
