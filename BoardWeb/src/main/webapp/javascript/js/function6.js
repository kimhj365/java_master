// function6.js

const args = [4,5,6];

// <나머지 파라미터>
// 펼침 연산자 ... : 배열 요소 펼쳐놓음
function sum(num1 = 0, num2 = 0, ...args){
    let result = 0;
    result = num1 + num2;
    if(args.length > 0){
        args.forEach(val => result += val);
    }
    return result;
}

// 펼침 연산자를 파라미터로 => 나머지 파라미터
// 마지막 파라미터로만 사용 가능
console.log(sum(10, 20, ...args)); 

// concat 함수: 배열 합침
const ary1 =[10, 20];
const ary2 = ary1.concat(args);
console.log(ary2);

const ary3 = [...ary1, ...args];
console.log(ary3);

// 객체 + 펼침 연산자
const obj1 = {name: 'Hong', age: 20};
const obj2 = {name: 'Hwang', height: 170};

// 서로 다른 속성 가진 객체 합침
//  => 같은 속성: 값 바뀜 / 다른 속성: 누적됨
const obj3 = {...obj1, ...obj2};
console.log(obj3);  // {name: 'Hwang', age: 20, height: 170}

// reduce 함수
// redune((이전 함수 누산값, 현재값, 인덱스, 배열) => {});
let result = [4,5,6].reduce((acc, curItem, idx, ary) => {
    console.log(acc, curItem, idx)
    return acc+curItem;
}, 0);
console.log(`결과값 : ${result}`);

// map 메소드.
// forEach랑 비슷 but 리턴값 있음.
result = [1, 2, 3, 4].map((item, idx, ary) => item * 2);
console.log(`결과값 : ${result}`);

// 변수의 스코프
// 1) var: 함수 레벨
var name = '어피치'; // 전역변수.
function run(){
    if(true){
        var name = '라이언';
    }
    console.log(name);  // '라이언'
    return name;
}
run();
console.log(name);      // '어피치'

// 2) let: 블록 레벨
var name2 = '어피치'; // 전역변수.
function run2(){
    if(true){
        let name2 = '라이언';
    }
    console.log(name2);  // '어피치'
    return name2;
}
run2();
console.log(name2);      // '어피치'

// 스코프 체인
// 내부 함수는 외부함수 안쪽에서만 실행됨(외부에서 실행X)
var a = 1;
var b = 5;
function outerFunc(){
    // var b;           // 변수는 먼저 끌어올려져서 선언됨(호이스팅)
    function innerFunc(){
        a = b;
    }
    console.log(a, b);  // a: 1 / b: undefined
    a = 3;              
    b = 4;              // a: 3 / b: 4
    innerFunc();       
    console.log(a, b);  // a: 4 / b: 4   
    var b = 2;   
    console.log(a, b);  // a: 4 / b: 2
}
outerFunc();
console.log(a, b);      // a: 4 / b: 5

const c = 10;
try{
    c = 20; // 정적 변수 수정 => 에러
} catch (error) {
    console.log(error.message);
} finally {
    console.log(c);
}


