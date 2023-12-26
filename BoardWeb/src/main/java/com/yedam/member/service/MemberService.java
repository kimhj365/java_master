package com.yedam.member.service;

import com.yedam.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(String id, String pw);
}
