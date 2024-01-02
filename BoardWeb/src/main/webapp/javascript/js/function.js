// function.js

// <함수>

// 함수 선언식.
// 매개값 없으면 undefined 넣어 계산 => NaN
// 매개변수 초기값 넣어 에러 막기
// js 함수는 매개값, 반환값 타입 지정 안해도 됨
function sum(num1 = 0, num2 = 0) {
    let result = 0;
    result = num1 + num2;
    return result;
}

// 매개값 없으면 undefined 넣어 계산 => NaN
// 매개변수 초기값 넣어 에러 막기
let result = sum(11, 22);  // 0
console.log(`결과는 ${result}`);


// arguments : 함수 실행 시점의 매개값 전부를 배열 형태로 가져옴
//   => 불명확한 함수되니까 사용 자제(매개변수 갯수 맞춰주기)
function sum1(num1 = 0, num2 = 0) {
    let result = 0;
    result = num1 + num2

    console.log(arguments);
    if (arguments.length > 2) {
        for (let arg = 2; arg < arguments.length; arg++) {
            result += arguments[arg];
        }
    }
    return result;
}

result = sum1(11, 22, 33, 44, 55);
console.log(`결과는 ${result}`);


// 함수 표현식
// 변수에다가 함수 정의하는 내용 대입
let sum2 = function(num1 = 0, num2 = 0){
    let result = num1 + num2;
    return result;
}
console.log(`결과는 ${sum2(10, 20)}`);


// 객체를 매개변수로 받는 함수
let obj1 = {
    name: 'Hong',
    point: 100
}
let obj2 = {
    name: 'Hwang',
    point: 80
}
let average = function(obj1={}, obj2={}){
    let result = 0;
    result = ( obj1.point + obj2.point ) / 2;
    return result;
}
console.log(`평균은 ${average(obj1, obj2)}`);

// 배열을 매개변수로 받는 함수
let array1 = [10, 20];
let array2 = [30, 40];
let sum3 = function(ary1 = [], ary2=[]){
    let result = 0;
    ary1.concat(ary2).forEach(function(val){
        result += val;
    });
    return result;
}
console.log(`배열의 총합은 ${sum3(array1, array2)}`);

// 함수를 매개변수로 받는 함수
let myfunc = function(callback){
    let result = 0;
    let num1 = 10;
    let num2 = 5;
    result = callback(num1, num2);
    return result;
}

let sumfunc = function(n1, n2){
    return n1 + n2;
}
let minusfunc = function(n1, n2){
    return n1 - n2;
}

console.log(`함수 결과는 ${myfunc(sumfunc)}`);
console.log(`함수 결과는 ${myfunc(minusfunc)}`);