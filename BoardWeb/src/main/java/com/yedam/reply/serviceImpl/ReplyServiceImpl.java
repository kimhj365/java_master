package com.yedam.reply.serviceImpl;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.yedam.common.DataSource;
import com.yedam.reply.mapper.ReplyMapper;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.vo.ReplyVO;

public class ReplyServiceImpl implements ReplyService{

	SqlSession session = DataSource.getInstance().openSession(true);
	ReplyMapper mapper = session.getMapper(ReplyMapper.class);
	
	@Override
	public List<ReplyVO> replyList(int boardNo) {
		return mapper.selectList(boardNo);
	}

	@Override
	public boolean removeReply(int replyNo) {
		return mapper.deleteReply(replyNo) == 1;
	}

	@Override
	public boolean addReply(ReplyVO vo) {
		return mapper.insertReply(vo) == 1;
	}

	@Override
	public ReplyVO getReply(int replyNo) {
		return mapper.selectReply(replyNo);
	}

	@Override
	public List<ReplyVO> replyListPaging(int boardNo, int page) {
		return mapper.selectListPaging(boardNo, page);
	}

	@Override
	public int getTotalCnt(int boardNo) {
		return mapper.selectCount(boardNo);
	}

	@Override
	public List<HashMap<String, Object>> chartData() {
		return mapper.selectReplyCnt();
	}

}
