       // 변수
        // var: 함수 레벨 / let, const : 블록 레벨.

        // 1. var: 함수 범위 안에서만 유효함.
        // => 블럭 의미X. 중복 선언해도 에러 안남.
        
        // (1)
        var name1 = "Hwang";
        function myfunc1(){
            var name1 = "Hong";
            console.log(name1);
        }
        myfunc1();           // "Hong"
        console.log(name1);  // "Hwang"

        // (2)
        var name2 = "Hwang";
        function myfunc2(){
            name2 = "Hong";
            console.log(name2);
        }
        myfunc2();            // "Hong"
        console.log(name2);   // "Hong"

        // (3)
        var name3 = "Hwang";
        {
            var name3 = "Hong"
            console.log(name3); // "Hong"
        }
        console.log(name3);     // "Hong"

        // 2. let: 블럭 레벨 범위.
        //  => 블럭 안에서만 유효한 값. 블럭 벗어나면 X.
        let age = 20;
        {
            let age = 22;
            console.log(age);   // 22
        }
        console.log(age);       // 20


        // this
        // 1. 전역영역: window 객체.
        console.log(this);

        // 2. 함수: window 객체.
        function thisfunc(){
            console.log(this);
        }
        thisfunc();

        // 3. 객체: object.
        let obj ={
            id: 'Hong',
            age: 20,
            show: function(){
                console.log(this);
            }
        }
        obj.show();

        // 4. 이벤트: 이벤트를 받는 대상(실행 대상).
        document.body.addEventListener('click', function(){ // 이벤트 핸들러.
            console.log(this);
        });


        // 함수 이름 - 변수 이름.
        // let show = 'Hello';
        function show(){
            console.log('show');
            // return undefined;    // 반환값 지정 안할 시 기본 값.
            return '반환값';
        }

        // let show = function(){
        //     console.log('show');
        // }
        // => 변수명과 함수명 겹치면 에러


        // (): 함수 실행.
        console.log(show);      // => 함수 정의 출력됨.
        console.log(show());    // => 함수 실행 + 함수 반환값 출력.

        (function() {
            console.log('익명함수');
        })();   // => 익명함수 선언과 동시에 실행.


        // 함수, 변수 명명 규칙 : camelCase.
        function showMyName(){
            console.log('홍길동');
        }


        // 상수 선언.
        // 한 번 값 담고 나면 변경 불가능
        const height = 167.9;
        //height = 169;   // => error

        // 객체의 상수 선언
        const friend = {
            name: '홍길동',
            phone: '010-1111',
        };
        friend.phone = '010-2222';
        console.log(friend.phone);
        // 참조하는 주소 값의 속성 바꾸는 것: 에러 아님

        // friend = {};
        // 객체에 새로운 값 할당하는 것 : 에러

