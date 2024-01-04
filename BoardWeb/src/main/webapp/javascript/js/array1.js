// array1.js

// 배열 생성: ary = [];
const ary = [1, 2, '3', new Date()];    // 타입에 상관없이 배열에 담을 수 있음(권장X)

const numAry=[10, 20, 30, 40];

// 배열 요소 하나씩 추가, 삭제
numAry.push(30);        // 배열 맨 뒤에 요소 추가
numAry.unshift(40);     // 배열 맨 앞에 요소 추가
numAry.pop()            // 마지막 요소 삭제
numAry.shift()          // 처음 요소 삭제

// ★splice() : 추가, 변경, 삭제
numAry.splice(1, 2);            // 1번 위치부터 2개 삭제
numAry.splice(1, 1, 40, 50);    // 1번 위치의 1개 요소를 50, 60으로 대체
numAry.splice(1, 0, 20, 30);    // 1번 위치에 70, 80을 추가
// numAry.splice(0);            // 배열 요소 전부 삭제

// length 속성 (JAVA에선 읽기 전용/ JS에서는 크기 변경 기능)
// numAry.length = 0;              // 배열 요소 삭제
// numAry.length = 10;             // 배열 크기 변경
console.log(numAry.length);
console.log(numAry);

// numAry에 numAry2를 추가
const numAry2 = [60, 70];
// const numAry3 = numAry.concat(numAry2);
numAry2.forEach(num => numAry.push(num));
console.log(numAry);
