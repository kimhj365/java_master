package com.yedam.reply.command;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.reply.service.ReplyService;
import com.yedam.reply.serviceImpl.ReplyServiceImpl;
import com.yedam.reply.vo.ReplyVO;

public class ReplyListJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		// json 데이터를 생성해서 반환.
		// [{"replyNo": 4, "boardNo":2, "reply":"test1", ...}, {...}, ...]
		resp.setContentType("text/json;charset=utf-8");
		String bno = req.getParameter("bno");
		String page = req.getParameter("page");
		// 페이지 값 없으면 임의로 1 넣어줌
		page = page == null ? "1" : page;
		
		ReplyService svc = new ReplyServiceImpl();
		List<ReplyVO> list = svc.replyListPaging(Integer.parseInt(bno), Integer.parseInt(page));
		
		int cnt = list.size();
		String json = "[";
		for (int i = 0; i < cnt; i++) {
			json += "{\"replyNo\":" + list.get(i).getReplyNo() + ",";
			json += "\"boardNo\":" + list.get(i).getBoardNo() + ",";
			json += "\"reply\":\"" + list.get(i).getReply() + "\",";
			json += "\"name\":\"" + list.get(i).getName() + "\",";
			json += "\"replyDate\":\"" + list.get(i).getReplyDate() + "\"}";
			if(i != cnt - 1) {
				json += ",";
			}
		}
		json += "]";
		
		try {
			resp.getWriter().print(json);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
