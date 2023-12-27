package com.yedam.board.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.service.BoardService;
import com.yedam.board.serviceImpl.BoardServiceMybatis;
import com.yedam.board.vo.BoardVO;
import com.yedam.common.Control;

public class BoardListControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// 게시글 목록  => boardList.jsp 로 전달.
		// BoardService 인터페이스를 BoardServiceMybatis 클래스로 구현
		BoardService svc = new BoardServiceMybatis();
		List<BoardVO> list = svc.boardList();
		
		// (속성)어트리뷰트 추가 => 참조변수 주소값(list)을 boardList라는 이름으로 jsp에 전달
		req.setAttribute("boardList", list);
		
		// 페이지 이동(forward)
		// Control 페이지가 보여지는 것을 다시 JSP 페이지로 이동시킴(재지정)
		// requestDispatcher 객체 : 요청을 재지정해줌
		// =>  BoardListControl에서 보여지는 페이지를
		RequestDispatcher rd = req.getRequestDispatcher("board/boardList.tiles");
		try {
			rd.forward(req,resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
