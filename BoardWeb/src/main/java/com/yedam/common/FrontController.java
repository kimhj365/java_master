package com.yedam.common;
// 컨트롤러 : url 입력 => 서블릿 실행.

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.board.command.AddBoardControl;
import com.yedam.board.command.BoardFormControl;
import com.yedam.board.command.BoardListControl;
import com.yedam.board.command.GetBoardControl;
import com.yedam.board.command.ModifyBoardControl;
import com.yedam.board.command.ModifyFormControl;
import com.yedam.board.command.RemoveBoardControl;
import com.yedam.board.command.RemoveFormControl;
import com.yedam.member.command.LoginControl;
import com.yedam.member.command.LoginFormControl;
import com.yedam.member.command.LogoutControl;

//@WebServlet("*.do")
public class FrontController extends HttpServlet{
	// 생명주기(톰캣에서 정함) : 생성자 => init() => service() => destroy()
	
	Map<String, Control> map;
	
	public FrontController() {
		System.out.println("생성자 호출.");
		map = new HashMap<String, Control>();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init() 호출");
//		map.put("/main.do", new MainControl());
//		map.put("/sub.do", new SubControl());
		
		// 게시판 관련.
		// URL과 실행할 컨트롤을 연결
		// 조회한 코드를 HTML로 넘겨주기(JAVA) => boardList.jsp
		// BoardListControl : Board를 구현하는 컨트롤
		map.put("/boardList.do", new BoardListControl());
		map.put("/boardForm.do", new BoardFormControl());
		map.put("/addBoard.do", new AddBoardControl());
		map.put("/getBoard.do", new GetBoardControl());
		map.put("/modifyForm.do", new ModifyFormControl());
		map.put("/modifyBoard.do", new ModifyBoardControl());
		map.put("/removeForm.do", new RemoveFormControl());
		map.put("/removeBoard.do", new RemoveBoardControl());
		
		// 회원 관련.
		map.put("/loginForm.do", new LoginFormControl());
		map.put("/login.do", new LoginControl());
		map.put("/logout.do", new LogoutControl());
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// service() 실행될 때 요청내용 한글로 인코딩
		req.setCharacterEncoding("utf-8");
		
		System.out.println("service() 호출");
		// http://localhost/BoardWeb/main.do => mainControl
		String url = req.getRequestURI();	// /BoardWeb/main.do
		String context = req.getContextPath();	// /BoardWeb
		String path = url.substring(context.length()); // /main.do
		System.out.println(path);
		
		Control ctrl = map.get(path);
		ctrl.execute(req, resp);
		
	}
	
	@Override
	public void destroy() {
		System.out.println("destroy() 호출");
	}
}
