package com.yedam.student.command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.common.Control;

public class StudentListCont implements Control {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) {
		
		try {
			//tiles.xml => WILDCARD:student/* => student/{1}.jsp
			req.getRequestDispatcher("student/studentList.tiles").forward(req, resp);
		} catch (ServletException | IOException e) {
			e.printStackTrace();
		}
		
	}

}
