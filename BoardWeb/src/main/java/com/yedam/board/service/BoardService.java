package com.yedam.board.service;

import java.util.List;

import com.yedam.board.vo.BoardVO;

public interface BoardService {
	// 업무로직.
	public List<BoardVO> boardList();		// 목록.
	public BoardVO getBoard(int bno);		// 글 번호 조회.
	public boolean addBoard(BoardVO vo);	// 글 등록 기능.
	public boolean modBoard(BoardVO vo);	// 글 수정 기능.
	public boolean remBoard(int bno);		// 글 삭제 기능.
}
