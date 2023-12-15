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
	private String userId;
	private String passwd;
	private String userName;
	private String userTel;
	
	// 생성자.
	User() {}

	public User(String userId, String passwd, String userName, String userTel) {
		this.userId = userId;
		this.passwd = passwd;
		this.userName = userName;
		this.userTel = userTel;
	}
	
	// 메서드.
	void showUserInfo() {
		System.out.println("User [userId=" + userId + 
				", userName= " + userName + ", userTel= " + userTel + "]"); 
	}

}
