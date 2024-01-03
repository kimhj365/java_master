// string1.js

let str1 = 'Hello';
console.log(str1, typeof str1); // string 타입

let str2 = new String('Hello');
console.log(str2, typeof str2); // object 타입

console.log(str1 == str2);  // 내용만 비교 => true
console.log(str1 === str2); // 타입도 비교 => false

// substring(1,3): 인덱스 1~3 사이 문자열 가져옴(1 포함 / 3 제외)
console.log(str1.substring(1, 3));  // 원래 object 타입만 사용가능 => 내부 형변환(자동)
console.log(str2.substring(1, 3));

// trim(): 좌우 여백 삭제
let word = '   Hello, World!  ';
console.log(word.trim());
console.log(word.trimStart());
console.log(word.trimEnd());

// replace() : 문자열 대체
// 여러개 대체할때 => 정규표현식 사용
// const obj = new Object(); => {}
// const reg = new RegExp(); => /값/
console.log(word.replace('H', 'h'));
console.log(word.replace(/l/g, 'L'));   // g(global): 전체 문장에서 찾기
console.log(word.replace(/\s/g, ''));   // \s: 공백

// split(): 특정 문자 기준으로 잘라서 배열로 저장
// filter(): 조건 true인 값만 배열로 저장
// join(): 배열을 특정 문자 끼워서 합친 문자열로 저장
word = '   how are you   today    everyone  ?   ';
console.log(word.split(' ').filter(val => val).join(' '));


// 문자열 자르기
const str3 = 'This is the only one story';

// slice(8,11): 8~10 위치의 문자열 반환
console.log(str3.slice(8,11));       
console.log(str3.slice(8,7));       // 앞 인덱스 <= 뒷 인덱스: 빈 문자열
console.log(str3.slice(8, -10));    // 음수값: 문자열 길이+값
console.log(str3.slice(8));         // 파라미터 1개 : 시작 인덱스(~문자열 끝)
console.log(str3.slice());          // 파라미터 없음: 전체 문자열 반환

// substring(): =slice()
console.log(str3.substring(8, 11));
console.log(str3.substring(11, 8));     // 앞 인덱스 < 뒷 인덱스: 순서바뀜
console.log(str3.substring(8, -10));    // 음수값: 0으로 대체

// substr(8,11): 8번 인덱스부터 11개 문자열 가져옴
console.log(str3.substr(8, 11));    // 8번 자리부터 11개 문자
console.log(str3.substr(11, 8));    // 11번 자리부터 8개 문자
console.log(str3.substr(11, 8));    // 파라미터 음수 => 0으로 대체
console.log(str3.substr(-11, 8));   // 시작 인덱스 음수 => 문자열 뒤에서 11번째 부터 8개 문자


// 문자열 변환
// toString(): 문자열 변환 함수
const num1 = 123;
const num2 = 123.45;
const bool = true;
const str = '문자열 변환';
const arr= [1, 2, 'a', 'b', 3];
const obj = {key: 'data', value: 15};

console.log(num1.toString());
console.log(num2.toString());
console.log(bool.toString());
console.log(str.toString());
console.log(arr.toString());
console.log(obj.toString());
console.log(obj.key.toString());
console.log(obj.value.toString());


// 문자열 찾기
// indexOf(word): 찾는 문자열 시작 위치 반환(없으면 -1)
console.log(str3.indexOf('the'));
console.log(str3.indexOf('kim'));     // -1
console.log(str3.lastIndexOf('the')); // 뒤에서 찾음
console.log(str3.indexOf('is', 4));   // 4번 인덱스 부터 찾음

// charAt(): 특정 인덱스 문자 1개 반환
console.log(str3.charAt('10'));

// includes(): 특정 문자열 포함되면 true 없으면 false
console.log(str3.includes('the'));  // true
console.log(str3.includes('kim'));  // false

// toUpperCase(): 대문자 변환
// toLowerCase(): 소문자 변환
// search(): 정규표현식 맞는 인덱스 위치 반환
// match():  정규표현식 맞는 모든 문자열 => 배열로 반환(없으면 null)


// Q1. 배열에서 '홍'이 들어간 단어의 갯수 구하기
const keyword = '홍';
const wordAry = ['사과', '홍씨', '홍장군', '김시홍', '감자'];
console.log(wordAry.filter(val => val.includes(keyword)).length);

// 교수님 답
console.log(wordAry.filter(val => val.indexOf(keyword) != -1).length)

// Q2. url에서 파라미터(x, y)의 값 찾기
const url = 'http:/localhost/BoardWeb/index.jsp?x=12&y=23';
let x = url.split('?')[1].split('&')[0].substring(2,4)
let y = url.split('?')[1].split('&')[1].substring(2,4)
console.log(x, y);

x = url.substring(url.indexOf('x=')+2, url.indexOf('&'));
y = url.substring(url.indexOf('y=')+2);
console.log(x, y);

// 교수님 답
console.log(url.match(/\d+/g)[0], url.match(/\d+/g)[1]);

// Q3. '안녕하세요 만나서 반갑습니다.' 문장으로 변환하기
const words = '안녕하세요xx만나서xx반갑습x니x다.';
console.log(words.replace(/xx/g,' ').replace(/x/g, ''));
 
