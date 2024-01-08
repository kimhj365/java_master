package com.yedam.board.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;
import com.yedam.reply.vo.PageDTO;

public class GetBoardControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 글 번호 조회
		// getParameter => 입력값 파라미터 가져옴
		String bno = req.getParameter("bno");
		
		BoardService svc = new BoardServiceMybatis();
		BoardVO vo = svc.getBoard(Integer.parseInt(bno));
		
		// 페이징 객체 생성
		int totalCnt = 70;
		PageDTO dto = new PageDTO(1, totalCnt);
		
		// "vo" 이름으로 req의 어트리뷰트 지정
		req.setAttribute("vo", vo);
		req.setAttribute("page", dto);
		
		RequestDispatcher rd = req.getRequestDispatcher("board/getBoard.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
