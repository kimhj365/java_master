<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h3>상세화면</h3>
<form name="myForm" action="modifyForm.do">
	<input type="hidden" name="bno" value="${vo.boardNo}">
	<table class="table">
		<tbody>
			<tr>
				<th>글번호</th>
				<td colspan='3'>${vo.boardNo}</td>
			</tr>
			<tr>
				<th>제목</th>
				<td colspan="3">${vo.title}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td colspan="3">${vo.content}</td>
			</tr>
			<tr>
				<th>작성자</th>
				<td colspan="3">${vo.writer}</td>
			</tr>
			<tr>
				<th>작성일</th>
				<td><fmt:formatDate value="${vo.writeDate}" pattern="yyyy-MM-dd"/> </td>
				<th>조회수</th>
				<td>${vo.clickCnt}</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td colspan="3">
					<c:if test="${!empty vo.image }">
						<img  width="300px" src="images/${vo.image }">
					</c:if>
				</td>
			</tr>
			<tr>
				<td colspan="4" align="center">
					<c:choose>
						<c:when test="${logName eq vo.writer}">
							<input type="submit" value="수정">
							<input type="button" onclick="deleteFunc()" value="삭제">
						</c:when>
						<c:otherwise>
							<input type="submit" disabled value="수정">
							<input type="button" disabled onclick="deleteFunc()" value="삭제">
						</c:otherwise>
					</c:choose>
				</td>
			</tr>
		</tbody>
	</table>
</form>
${logName } vs. ${vo.writer }
<br>
<a href="boardList.do">글목록으로</a>
<script>
	function deleteFunc() {
		console.log(window);
		document.forms.myForm.action = "removeForm.do";
		document.forms.myForm.submit();
	}
</script>
