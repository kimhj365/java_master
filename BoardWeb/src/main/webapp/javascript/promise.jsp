<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>promise.jsp</title>
</head>
<body>
    <div id="show"></div>
<script>
    let show = document.getElementById('show');
    // setInterval: 일정 시간 주기로 함수 계속 실행
    let cnt = 0;
    let interval = setInterval(() => {
        const today = new Date();
        let hh = today.getHours();
        let mm = today.getMinutes();
        let ss = today.getSeconds();
        cnt++;
        if(cnt >= 20){
        	// 인터벌 종료
            clearInterval(interval);
        }
        show.innerHTML = hh + "시 " + mm + "분 " + ss + "초 <br>";
    }, 1000)


    // promise: Ajax 콜백 함수 개선
    // 인수1: 성공했을때 실행 / 인수2: 실패했을때 실행하는 함수
    const promise = new Promise(function(resolve, reject){
        // setTimeout: 일정 시간 지연 시키고 함수 실행(한번)
        // 인수: 실행할 함수, 지연 시간(ms)
        setTimeout(function() {
            resolve('Success');
            // reject('Fail');
        }, 3000);
    }); 
    // promise 상태: pending(초기화) -> fulfilled(정상처리) / rejected(비정상처리)
    // then(): 정상 실행 시 -> 여러번 사용 가능
    promise.then(function(result) {
            console.log('then=> ', result);
            return 'ok';
        })
        .then(function(result) {
            console.log('second then=>', result);
        })
        // catch(): 비정상 실행 시
            .catch(function(err) {
                console.error('error=> ', err);
        })

</script>
</body>
</html>