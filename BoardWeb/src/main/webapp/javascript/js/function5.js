// function5.js

const ary = ['a', 'b', 'c'];

// 화살표 함수
ary.forEach(ele => console.log(ele));
ary.forEach((ele, idx) => {
    if(idx > 0){
        console.log(ele);
    }
});

// 프로토타입(인터페이스 => 사용자가 정의해서 기능구현)
Array.prototype.sum = function () {
    console.log(this);
    let result = 0;
    this.forEach(val => result += val);
    return result;
}
const numbers = [1, 2, 3, 4];
console.log(`sum : ${numbers.sum()}`);