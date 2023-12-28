<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="border-end bg-white" id="sidebar-wrapper">
            	<!-- if-else문 -->
	<c:choose>
		<c:when test="${empty logName }">
	 		<div class="sidebar-heading border-bottom bg-light">Bootstrap(Guest)</div>
		</c:when>
		<c:otherwise>
	 		<div class="sidebar-heading border-bottom bg-light">Bootstrap(${logName })</div>
		</c:otherwise>
	</c:choose>
            	
	<div class="list-group list-group-flush">
    	<c:choose>
			<c:when test="${empty logId }">
		    	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="loginForm.do">로그인</a>
		    </c:when>
			<c:otherwise>
		    	<a class="list-group-item list-group-item-action list-group-item-light p-3" href="logout.do">로그아웃</a>
		   		<a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardForm.do">글등록</a>
			</c:otherwise>
		</c:choose>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="boardList.do">글목록</a>
        
        <c:if test="${responsibility eq 'Admin' }">
	        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="memberList.do">회원관리</a>
        </c:if>
        
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Profile</a>
        <a class="list-group-item list-group-item-action list-group-item-light p-3" href="#!">Status</a>
    </div>
</div>