<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>promise2.jsp</title>
</head>
<body>
    <script>
        // fetch: promise 쉽게
        fetch('data.json', {
            method: 'post',
            mode: 'cors',
            headers: {
                'Content-Type': 'appliction/x-www-form-urlencoded'
            },
            body: 'x=36&y=128'
        })    // url, option 객체
        // 정상 실행시
        .then(result => {
            console.log(result);
            return result.json(); // Json 문자열 => JS 객체로 변환
        })
        .then(json => {
            console.log(json);
        })
        // 에러시
        .catch(error => {
            console.error(error);
        })
    </script>
</body>
</html>