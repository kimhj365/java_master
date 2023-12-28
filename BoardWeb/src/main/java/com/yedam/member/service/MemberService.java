package com.yedam.member.service;

import java.util.List;

import com.yedam.member.vo.MemberVO;

public interface MemberService {
	public MemberVO login(String id, String pw);
	public List<MemberVO> memberList();
	public MemberVO getMember(String id);
}
