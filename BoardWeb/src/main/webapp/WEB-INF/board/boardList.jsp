<%@page import="com.yedam.board.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="../layout/menu.jsp" %>
<%@ include file="../layout/nav.jsp" %>
<%
	// request 어트리뷰트 읽어옴(BoardListControl)
	// Object 타입으로 반환 => List 타입으로 형변환 필요
	// HTML 임포트 : Ctrl + Space
	List<BoardVO> list = (List<BoardVO>) request.getAttribute("boardList");
%>

<h3>게시판</h3>
<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일지</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<% for(BoardVO vo : list) { %>
		<tr>
			<td><%=vo.getBoardNo() %></td>
			<td><a href="getBoard.do?bno=<%=vo.getBoardNo() %>"><%=vo.getTitle() %></a></td>
			<td><%=vo.getWriter() %></td>
			<td><%=vo.getWriteDate() %></td>
			<td><%=vo.getClickCnt() %></td>
		</tr>
		<% } %>
	</tbody>
</table>
<%@ include file="../layout/foot.jsp" %>