package com.yedam.reply.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> selectList(int boardNo);
	List<ReplyVO> selectListPaging(@Param("boardNo") int boardNo, @Param("page") int page);
	int deleteReply(int replyNo);
	int insertReply(ReplyVO vo);
	ReplyVO selectReply(int replyNo);
}
