// start
function makeLi(reply = {}) {
	console.log(reply);
	let li = document.createElement('li');
	let span = document.createElement('span');
	span.innerText = '댓글 번호: ' + reply.replyNo + ' ';
	li.appendChild(span);

	span = document.createElement('span');
	span.innerText = '댓글 내용: ' + reply.reply + ' ';
	li.appendChild(span);

	span = document.createElement('span');
	span.innerText = '이름: ' + reply.name + ' ';
	li.appendChild(span);

	span = document.createElement('span');
	span.innerText = '작성일: ' + reply.replyDate + ' ';
	li.appendChild(span);

	// 삭제 버튼
	let delBtn = document.createElement('button');
	delBtn.addEventListener('click', function() {
		// 댓글 번호 삭제 후 화면에서 제거
		let delHtp = new XMLHttpRequest();
		delHtp.open('get', 'delReplyJson.do?rno=' + reply.replyNo);
		delHtp.send();
		delHtp.onload = function() {
			let result = JSON.parse(delHtp.responseText);
			if (result.retCode == 'OK') {
				alert('삭제됨');
				delBtn.parentElement.remove();
			} else if (result.retCode == 'NG') {
				alert('처리중 에러');
			}
		}
	})

	delBtn.innerText = '삭제';
	li.appendChild(delBtn); // end

	return li;
}