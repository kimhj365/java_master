package com.yedam.reply.mapper;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyMapper {
	List<ReplyVO> selectList(int boardNo);
	List<ReplyVO> selectListPaging(@Param("boardNo") int boardNo, @Param("page") int page);
	int deleteReply(int replyNo);
	int insertReply(ReplyVO vo);
	ReplyVO selectReply(int replyNo);
	// 페이지 계산 하기 위한 전체 건수 반환
	int selectCount(int boardNo);
	// 차트 데이터(댓글 작성자, 작성 건수)
	List<HashMap<String, Object>> selectReplyCnt();
}
