// array4.js

const str = '펭수, 라이언, 어피치, 콘, 브라운, 무지, 라이언, 어피치, 콘';

// Q1. 콘이라는 이름이 몇번?
let ary = str.split(', ');
let result = ary.filter(name => name == '콘');
console.log(result.length);

// Q2. 이름이 3글자 이상 몇명?
let set = new Set(ary)
let setAry = [];
set.forEach(name => setAry.push(name));
result = setAry.filter(name => name.length >=3);
console.log(result.length);

// Q3. 2자인 이름 있는지 여부
result = setAry.some(name => name.length == 2);
console.log(result);

// Q4. {no:1, name:'펭수} 형태의 값가지는 배열 생성 => strAry에 대입
const strAry = setAry.map((item, idx) => {
    return{
        no: idx,
        name: item
    }
})
console.log(strAry);
