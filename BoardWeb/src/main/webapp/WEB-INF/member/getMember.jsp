<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<h3>상세화면</h3>
<input type="hidden" name="id" value="${vo.id}">
<table class="table">
	<tbody>
		<tr>
			<th>아이디</th>
			<td colspan='3'>${vo.id}</td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td colspan="3">${vo.pw}</td>
		</tr>
		<tr>
			<th>이름</th>
			<td colspan="3">${vo.name}</td>
		</tr>
		<tr>
			<th>권한</th>
			<td colspan="3">${vo.responsibility}</td>
		</tr>
	</tbody>
</table>

    