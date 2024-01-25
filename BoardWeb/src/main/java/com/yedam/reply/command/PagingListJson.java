package com.yedam.reply.command;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.yedam.common.Control;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;
import com.yedam.reply.vo.PageDTO;

public class PagingListJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		// bno, page => json 생성
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		
		ReplyService svc = new ReplyServiceImpl();
		int total = svc.getTotalCnt(Integer.parseInt(bno));
		
		PageDTO dto = new PageDTO(Integer.parseInt(page), total);
		req.setAttribute("dto", dto);
		
		Gson gson = new GsonBuilder().create();
		
		try {
			resp.getWriter().print(gson.toJson(dto));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
