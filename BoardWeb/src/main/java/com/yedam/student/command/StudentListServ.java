package com.yedam.student.command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yedam.student.service.StudentService;
import com.yedam.student.serviceImpl.StudentServiceMybatis;
import com.yedam.student.vo.Student;

@WebServlet("/studentList")
public class StudentListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentListServ() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();	
		
		StudentService dao = new StudentServiceMybatis();
		List<Student> list = dao.studentList();
		
		String str = "<table border= '1'>";
		str += "<thead><tr><th>학번</th><th>이름</th><th>영어</th><th>수학</th><tr></thead>";
		str += "<tbody>";
		for(Student std : list) {
			str += "<tr><td><a href='getStudentServlet?sno="+std.getStudentNumber()+"'>" + std.getStudentNumber() + "</a></td><td>" + std.getStudentName()//
			+ "</td><td>" + std.getEnglishScore() + "</td><td>" + std.getMathematicsScore()//
			+ "</td></tr>";
		}
		str += "</tbody></table>";
		str += "<br><a href='student/inform.html'>등록화면</a>";
		out.print(str);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
