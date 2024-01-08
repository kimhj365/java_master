<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<style>
.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
}

.pagination a.active {
  background-color: #4CAF50;
  color: white;
}

.pagination a:hover:not(.active) {background-color: #ddd;}
</style>

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
<br>
<!-- 댓글 입력창 -->
댓글 내용 : <input type="text" id="content">
<button id="addReply">등록</button>
<br>댓글 목록 : <br>
<div id="show">
	<ul id="list">
	</ul>
</div>
<!-- 페이징 처리 -->
<div id="paging" class="pagination"></div>
<br>
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
	
	let pageInfo = 1;
	function pageList(e){	// 이벤트를 인수로 받음
		// a 태그 클릭해도 페이지 이동 안하고 계속 머물러 있게 하기
		// preventDefault(): a 태그의 기본 기능(링크 페이지로 보내기) => 차단
		e.preventDefault();
		// a 태그 클릭하면 이동하는 페이지
		pageInfo = this.getAttribute("href"); // this: 이벤트를 받는 대상 = a
		console.log(pageInfo); 
		
		// Ajax 호출.
		showList(pageInfo);
		// 페이지를 생성하는 함수 호출
		pagingList(pageInfo);
	}
	
	// Ajax 호출.
	function showList(page){
		ul.innerHTML = '';
		const xhtp = new XMLHttpRequest();
		// bno, page 파라미터 넘김
		xhtp.open('get', 'replyListJson.do?bno=' + bno + "&page=" + page);
		xhtp.send();
		xhtp.onload = function () {
			let data = JSON.parse(xhtp.responseText);	// JSON 문자열 => 객체
			data.forEach(reply => {
				let li = makeLi(reply);
				ul.appendChild(li);
			});
		}
	}
	showList(pageInfo);	
	
	// 페이지 생성
	let paging = document.querySelector('#paging');
	pagingList();
	
	function pagingList(page=1){
		// 다음 페이지 기준으로 페이지 목록 다시 생성.
		paging.innerHTML = '';
		
		let pagingAjax = new XMLHttpRequest();
		pagingAjax.open('get', 'pagingListJson.do?bno=' + bno + '&page=' + page)
		pagingAjax.send();
		pagingAjax.onload= function () {
			let result = JSON.parse(pagingAjax.responseText);
			console.log(result);
			
			// 이전 페이지 링크 출력
			if(result.prev){
				let aTag = document.createElement('a');
				aTag.href = result.startPage - 1;
				aTag.innerText = '이전';
				aTag.addEventListener('click', pageList);
				paging.appendChild(aTag);
			}
			// 페이징 목록 출력
			for(let p = result.startPage; p <= result.lastPage; p++){
				let aTag = document.createElement('a');
				if(p == page){
					aTag.setAttribute('class', 'active');
				}
				
				aTag.href = p;
				aTag.innerText = p;
				// a 태그 클릭시 페이지 보여주는 함수(콜백 함수: 나중에 이벤트 실행되면 실행됨)
				aTag.addEventListener('click', pageList);
				paging.appendChild(aTag);
			}
			// 이후 페이지 링크 출력
			if(result.next){
				let aTag = document.createElement('a');
				aTag.href = result.lastPage + 1;
				aTag.innerText = '다음';
				aTag.addEventListener('click', pageList);
				paging.appendChild(aTag);
			}
		}
	}	// end of pagingList
	
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
				alert('댓글등록됨.');
				let reply = result.vo;
				let li = makeLi(reply);				
				ul.appendChild(li);
				
				document.querySelector('#content').value = '';
				console.log(result);
				
				showList(1);
				pagingList(1);
				
			} else if (result.retCode == 'NG'){
				alert('처리 중 에러');
			}
		}
	}
	
</script>
