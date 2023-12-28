package com.yedam.member.command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class GetMemberControl implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		String id = req.getParameter("id");
		
		MemberService svc = new MemberServiceImpl();
		MemberVO vo = svc.getMember(id);

		// "vo" 이름으로 req의 어트리뷰트 지정
		req.setAttribute("vo", vo);
		RequestDispatcher rd = req.getRequestDispatcher("admin/getMember.tiles");
		try {
			rd.forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
