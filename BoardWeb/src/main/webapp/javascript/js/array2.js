// array2.js

// reduce(함수, 초기값): 누적 함수.
// 누적합.
const numAry = [23, 10, 17, 35, 9];
let sum = numAry.reduce((acc, num) => {
    console.log(acc, num);
    return acc + num;
}, 0);
console.log(`누적합: ${sum}`);

// 최대값.
let max = numAry.reduce((acc, num) => {
    console.log(acc, num);
    return acc > num ? acc : num;
});
console.log(`최대값: ${max}`);

// 최소값.
let min = numAry.reduce((acc, num) => {
    console.log(acc, num);
    return acc < num ? acc : num;
});
console.log(`최소값: ${min}`);

// 평균.
// let n = 0;
let avg = numAry.reduce((acc, num, idx) => {
    // n++;
    // return ((acc * n) + num)/(n+1);
    console.log(acc, num, idx);
    return idx == numAry.length-1 ? (acc + num) / numAry.length : acc+num;
});
console.log(`평균: ${avg}`);

// 10보다 큰 수만 배열에 담기
let result = numAry.reduce((acc, num) => {
    console.log(acc, num);
    if(num > 10) 
        acc.push(num);
    return acc;
}, []);
console.log(`10보다 큰 수: ${result}`);

