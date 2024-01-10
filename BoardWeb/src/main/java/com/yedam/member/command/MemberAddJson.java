package com.yedam.member.command;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.yedam.common.Control;
import com.yedam.member.service.MemberService;
import com.yedam.member.serviceImpl.MemberServiceImpl;
import com.yedam.member.vo.MemberVO;

public class MemberAddJson implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("utf-8");
			resp.setContentType("text/json;charset=utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 파일 업로드 포함.
		// 이미지 폴더의 경로
		String saveLoc = req.getServletContext().getRealPath("images");
		int maxSize = 1024 * 1024 * 5;
		MultipartRequest mr = null;
		
		// 1.request 2.saveLoc 3.maxSize 4.인코딩 방식 5.리네임 정책(같은 이름 파일있을시)
		try {
			mr = new MultipartRequest(req, saveLoc, maxSize, "UTF-8", new DefaultFileRenamePolicy());
			String id = mr.getParameter("id");
			String pw = mr.getParameter("pw");
			String name = mr.getParameter("name");
			String image = mr.getFilesystemName("image");
			String responsibility = "User";

			MemberVO vo = new MemberVO();
			vo.setId(id);
			vo.setPw(pw);
			vo.setName(name);
			vo.setResponsibility(responsibility);
			vo.setImage(image);
			
			MemberService svc = new MemberServiceImpl();
			
			Map<String, Object> map = new HashMap<>();
			if(svc.addMember(vo)) {
				map.put("retCode", "OK");
				map.put("vo", vo);
			} else {
				map.put("retCode", "NG");
			}
			Gson gson = new GsonBuilder().create();
			resp.getWriter().print(gson.toJson(map));
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
