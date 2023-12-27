<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student/jstl.jsp</title>
</head>
<body>
	<!-- 자바코드 => jsp 코드로 대체하기(+ JSTL) -->
	<c:set var="name" value="홍길동"></c:set>
	<c:out value="${name }"></c:out>
	<c:set var="age" value="19"></c:set>
	
	<!-- 배열 -->
	<c:set var="names" value="Hong, Hwang, Kim"></c:set>
	<!-- 확장 for문: for(String name : names){} -->
	<c:forEach items="${names }" var="n">
		<p>${n }</p>
	</c:forEach>
	
	<!-- if문 -->
	<c:if test="${age >=20 }">
		<p>성인입니다.</p>
	</c:if>
	
	<!-- if-else 문 -->
	<c:choose>
		<c:when test="${age >= 20 }">
			<p>성인입니다.</p>
		</c:when>
		<c:otherwise>
			<p>미성년입니다.</p>
		</c:otherwise>
	</c:choose>
	
	<!-- for문 : for(int i = ; i <= 10; i++){} -->
	<c:forEach begin="1" end="9" step="1" var="i">
		<p>3 * ${i } = ${3*i }</p>
	</c:forEach>
	
</body>
</html>