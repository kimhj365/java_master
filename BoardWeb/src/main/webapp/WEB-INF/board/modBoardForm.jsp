<%@page import="com.yedam.board.vo.BoardVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../layout/menu.jsp" %>
<%@ include file="../layout/nav.jsp" %>
	<h3>수정화면</h3>
	<%
        BoardVO vo = (BoardVO) request.getAttribute("vo");
    %>
    <form action="modifyBoard.do">
    <input type="hidden" name="bno" value="<%=vo.getBoardNo() %>">
	    <table class="table">
	        <tbody>
	            <tr>
	                <th>글번호</th>
	                <td colspan='3'><%=vo.getBoardNo() %></td>
	            </tr>
	            <tr>
	                <th>제목</th>
	                <td colspan="3"><%=vo.getTitle() %></td>
	            </tr>
	            <tr>
	                <th>내용</th>
	                <td colspan="3">
	                <textarea cols="30" rows="4" name="content"><%=vo.getContent() %></textarea>
	                </td>
	            </tr>
	            <tr>
	                <th>작성자</th>
	                <td colspan="3"><%=vo.getWriter() %></td>
	            </tr>
	            <tr>
	                <th>작성일</th>
	                <td><%=vo.getWriteDate() %></td>
	                <td>조회수</td>
	                <td><%=vo.getClickCnt() %></td>
	            </tr>
	            <tr>
	                <th>이미지</th>
	                <td colspan="3"><%=vo.getImage() %></td>
	            </tr>
	            <tr>
	                <td colspan="4" align="center">
	                    <input type="submit" value="저장">
	                    <input type="reset" value="취소">
	                </td>
	            </tr>
	        </tbody>
	    </table>
    </form>
    <br>
    <a href="boardList.do">글목록으로</a>
<%@ include file="../layout/foot.jsp" %>