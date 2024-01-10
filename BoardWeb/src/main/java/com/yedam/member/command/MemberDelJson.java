package com.yedam.member.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;

public class MemberDelJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		String id = req.getParameter("id");
		
		MemberService svc = new MemberServiceImpl();
		Map<String, Object> map = new HashMap<>();
		if(svc.removeMember(id)) {
			map.put("retCode", "OK");
		} else {
			map.put("retCode", "NG");
		}
		
	}

}
