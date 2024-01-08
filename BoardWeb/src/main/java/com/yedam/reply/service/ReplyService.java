package com.yedam.reply.service;

import java.util.HashMap;
import java.util.List;

import com.yedam.reply.vo.ReplyVO;

public interface ReplyService {
	List<ReplyVO> replyList(int boardNo);
	List<ReplyVO> replyListPaging(int boardNo, int page);
	boolean removeReply(int replyNo);
	boolean addReply(ReplyVO vo);
	ReplyVO getReply(int replyNo);
	// 전체 건수 계산
	int getTotalCnt(int boardNo);
	List<HashMap<String, Object>> chartData();
}
