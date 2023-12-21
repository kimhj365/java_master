package common;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getStudentServlet")
public class GetStudentServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html;charset=utf-8");
		
		String sno = req.getParameter("sno");
		
		StudentDAO dao = new StudentDAO();
		Student std = dao.getStudent(sno);
		
		String str = "<table border = '1'>";
		str += "<caption>학생정보</caption>";
		str += "<tr><th>학번</th><td>" + std.getStuNum() + "</td></tr>";
		str += "<tr><th>이름</th><td>" + std.getStuName() + "</td></tr>";
		str += "<tr><th>영어</th><td>" + std.getEngScore() + "</td></tr>";
		str += "<tr><th>수학</th><td>" + std.getMathScore() + "</td></tr>";
		str += "</table>";
		str += "<br><a href='modifyStudent?sno=" + std.getStuNum() + "'>정보 수정</a>";
		str += "<br><a href='studentList'>목록</a>";
		
		resp.getWriter().print(str);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		super.doPost(req, resp);
	}
}
