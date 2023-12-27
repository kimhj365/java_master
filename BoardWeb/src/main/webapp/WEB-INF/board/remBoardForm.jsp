<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<h3>삭제화면</h3>
<form name="myForm" action="removeBoard.do">
	<input type="hidden" name="bno" value="${vo.boardNo }">
	<table class="table">
		<tbody>
			<tr>
				<th>글번호</th>
				<td colspan='3'>${vo.boardNo }</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${vo.title }</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">${vo.content }</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td colspan="3">${vo.writer }</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${vo.writeDate }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
				<td>조회수</td>
				<td>${vo.clickCnt }</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td colspan="3">${vo.image }</td>
			</tr>
			<tr>
				<td colspan="4" align="center"><input type="submit" value="삭제">
					<input type="reset" value="취소"></td>
			</tr>
		</tbody>
	</table>
</form>
<br>
<a href="boardList.do">글목록으로</a>
