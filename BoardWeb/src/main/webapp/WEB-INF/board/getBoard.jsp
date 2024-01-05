<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

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
				<td><fmt:formatDate value="${vo.writeDate}"
						pattern="yyyy-MM-dd" /></td>
				<th>조회수</th>
				<td>${vo.clickCnt}</td>
			</tr>
			<tr>
				<th>이미지</th>
				<td colspan="3"><c:if test="${!empty vo.image }">
						<img width="300px" src="images/${vo.image }">
					</c:if></td>
			</tr>
			<tr>
				<td colspan="4" align="center"><c:choose>
						<c:when test="${logName eq vo.writer}">
							<input type="submit" value="수정">
							<input type="button" onclick="deleteFunc()" value="삭제">
						</c:when>
						<c:otherwise>
							<input type="submit" disabled value="수정">
							<input type="button" disabled onclick="deleteFunc()" value="삭제">
						</c:otherwise>
					</c:choose></td>
			</tr>
		</tbody>
	</table>
</form>
${logName } vs. ${vo.writer }
<br>
댓글 내용
<input type="text" id="content">
<button id="addReply">등록</button>
<div id="show">
	<ul id="list">
	</ul>
</div>

<a href="boardList.do">글목록으로</a>
<script src="js/service.js"></script>
<script>
	function deleteFunc() {
		console.log(window);
		document.forms.myForm.action = "removeForm.do";
		document.forms.myForm.submit();
	}
	
	const bno = '${vo.boardNo}';
	let ul = document.querySelector('#list');
	// Ajax 호출.
	const xhtp = new XMLHttpRequest();
	xhtp.open('get', 'replyListJson.do?bno=' + bno);
	xhtp.send();
	xhtp.onload = function(){
		let data = JSON.parse(xhtp.responseText);	// JSON 문자열 => 객체
		data.forEach(reply => {
			let li = makeLi(reply);
			ul.appendChild(li);
		})
	}
	
	// 등록버튼 클릭 이벤트 생성
	// document.querySelector('#addReply').addEventListener('click', function() {});
	document.querySelector('#addReply').onclick = function() {
		// 사용자 입력값(input)
		let reply = document.querySelector('#content').value;
		let replyer = '${logId}';
		
		const addAjax = new XMLHttpRequest();
		addAjax.open('get', 'addReplyJson.do?reply=' + reply + '&replyer=' + replyer + '&bno=' + bno);
		addAjax.send();
		addAjax.onload = function () {
			let result = JSON.parse(addAjax.responseText);
			if(result.retCode == 'OK'){
				let reply = result.vo;
				let li = makeLi(reply);				
				ul.appendChild(li);	//
				
				document.querySelector('#content').value = '';
			} else if (result.retCode == 'NG'){
				alert('처리 중 에러');
			}
		}
	}
	
	
</script>
