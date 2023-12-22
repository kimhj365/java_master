package com.yedam.student.command;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.mapper.StudentDAO;
import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceImpl;
import com.yedam.student.vo.Student;

@WebServlet("/MyInfoServlet")
public class MyInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MyInfoServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8"); // content 타입: txt, html, json.
		
		// ?sno=23-010&sname=황철수&escore=80&mscore=85
		String sno = request.getParameter("sno");
		String sname = request.getParameter("sname");
		String escore = request.getParameter("escore");
		String mscore = request.getParameter("mscore");
		
		System.out.println("sno: " + sno + ", sname: " + sname //
				+ ", escore: " + escore + ", mscore: " + mscore);
		
		Student std = new Student(sno, sname, Integer.parseInt(escore), Integer.parseInt(mscore));
		StudentService dao = new StudentServiceImpl();
		boolean done = dao.addStudent(std);
		
		PrintWriter out = response.getWriter();
		//out.append("Served at: ").append(request.getContextPath());
		out.println("<h3>Welcome Servlet , 안녕...</h3>");
		out.println("<a href='index.html'> 인덱스 이동</a>");
		
		if(done) {
			out.println("<script>alert('OK'); location.href='studentList';</script>");
		}
		else {
			out.println("<script>alert('Fail'); location.href='index.html';</script>");
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		doGet(request, response);
	}

}
