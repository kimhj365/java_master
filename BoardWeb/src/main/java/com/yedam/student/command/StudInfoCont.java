package com.yedam.student.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class StudInfoCont implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {

		try {
			req.getRequestDispatcher("student/studentInfo.tiles").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
	}

}
