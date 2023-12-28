package com.yedam.member.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.member.vo.MemberVO;

public interface MemberMapper {
	public MemberVO selectMember(@Param("id") String id, @Param("pw") String pw);
	public List<MemberVO> selectList();
	public MemberVO selectOne(String id);
	
}
