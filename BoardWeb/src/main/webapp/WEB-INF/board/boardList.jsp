<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h3>게시판</h3>
<table class="table">
	<thead>
		<tr>
			<th>글번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일자</th>
			<th>조회수</th>
		</tr>
	</thead>
	<tbody>
		<!-- 어트리뷰트 값 읽어옴 -->
		<c:forEach var="vo" items="${boardList}">
		<tr>
			<td>${vo.boardNo}</td>
			<td><a href="getBoard.do?bno=${vo.boardNo}">${vo.title}</a></td>
			<td>${vo.writer}</td>
			<td><fmt:formatDate value="${vo.writeDate}" pattern="yyyy-MM-dd" /></td>
			<td>${vo.clickCnt}</td>
		</tr>
		</c:forEach>
	</tbody>
</table>
