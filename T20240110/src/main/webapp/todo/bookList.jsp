<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script>
	$(document).ready(function() {
		// 책 목록 출력
		$.ajax('bookListJson.do', {
	        method: 'get',
	        dataType: 'json',
	        success: function(result) {
	            $(result).each((idx, book) => {
	                // tr 생성, td 생성
	                let tr = $('<tr />').append($('<td />').append('<input type="checkbox">'),
	                							$('<td />').text(book.bookCode),
	                                            $('<td />').text(book.bookName),
	                                            $('<td />').text(book.bookAuthor),
	                                            $('<td />').text(book.bookPress),
	                                            $('<td />').text(book.bookPrice),
	                                            $('<button id="delBtn"/>').text('삭제')
	                                            );
	                $('#list').append(tr);
	            });
	        },
	        error: function(err) {
	            console.error(err);
	        }
	    })
	    
	    // 전체 선택 / 해제
        $('thead input[type="checkbox"]').on('change', function(){
			$('tbody input[type="checkbox"]').prop('checked', this.checked);
		})
		
	})
	</script>
<body>
	<h3>책목록</h3>

	<table class="table">
		<thead>
			<tr>
				<th><input type="checkbox"></th>
				<th>도서코드</th>
				<th>도서명</th>
				<th>저자</th>
				<th>출판사</th>
				<th>가격</th>
				<th>삭제</th>
			</tr>
		</thead>
		<tbody id="list"></tbody>
	</table>

</body>
</html>