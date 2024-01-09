// start
function makeLi(reply = {}) {
	console.log(reply);
	let li = document.createElement('li');
	let span = document.createElement('span');
	span.innerText = '댓글 번호: ' + reply.replyNo + ' ';
	li.appendChild(span);

	span = document.createElement('span');
	span.innerText = reply.reply + ' ';
	li.appendChild(span);

	span = document.createElement('span');
	span.innerText = reply.name + ' ';
	li.appendChild(span);

	// span = document.createElement('span');
	// span.innerText = reply.replyDate + ' ';
	// li.appendChild(span);

	// 삭제 버튼
	let delBtn = document.createElement('button');
	delBtn.addEventListener('click', async function () {
	// delBtn.onclick = async function() {
		// fetch 함수 이용한 삭제기능 구현 + async/await
		const promise = await fetch('delReplyJson.do', {
			method: 'post',
			headers: {
				'Content-Type': 'application/x-www-form-urlencoded'
			},
			body: 'rno=' + reply.replyNo
		});
		const json = await promise.json();
		try {
			if (json.retCode == 'OK') {
				alert('삭제됨');
				showList(pageInfo);
			} else if (json.retCode == 'NG') {
				alert('처리중 에러');
			}
		} catch (err) {
			console.error('예외=> ', err);
		}
	}, true);


	// 기존 Ajax 코드

	// 댓글 번호 삭제 후 화면에서 제거
	// let delHtp = new XMLHttpRequest();
	// delHtp.open('post', 'delReplyJson.do');
	// delHtp.send('rno=' + reply.replyNo);
	// delHtp.onload = function() {
	// 	let result = JSON.parse(delHtp.responseText);
	// 	if (result.retCode == 'OK') {
	// 		alert('삭제됨');
	// 		// delBtn.parentElement.remove();
	// 		// bno, page => pageList, pagingList.
	// 		showList(pageInfo);
	// 	} else if (result.retCode == 'NG') {
	// 		alert('처리중 에러');
	// 	}
	// }


	delBtn.innerText = '삭제';
	li.appendChild(delBtn); // end

	return li;
}