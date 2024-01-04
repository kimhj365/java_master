// array3.js
import { members, titles } from "./data.js";
console.log(members);
console.log(titles);

// 테이블 만들기(with reduce())
// html 태그로 만들기
let str = titles.reduce((acc, title, idx) => {
    if(idx == 0){
        acc += '<tr>';
    }
    acc += '<th>' + title + '</th>';

    if(idx == titles.length - 1){
        acc += '</tr>';
    }

    return acc;
},'');
document.getElementById('theader').innerHTML = str;

// DOM 으로 만들기
const tbody = document.getElementById('tbody');
members.reduce((acc, member, idx) => {
    let tr = document.createElement('tr');
    for(let prop in member){
        let td = document.createElement('td');
        td.innerText = member[prop];
        tr.appendChild(td);
    }
    acc.appendChild(tr);
    return acc;
}, tbody);


// map(A -> A'): 
let result = members.map((item, idx) => {
    let obj = {};
    obj.id = item.id;
    obj.name = item.first_name + ' ' +item.last_name;
    obj.email = item.email;
    return obj;
});
console.log(result);

// filter(A -> B): 조건 만족하는 요소들로 새로운 배열 구성
result = members// 메소드 체인
    .filter(item => item.gender == 'Female')
    .map((item, idx) => {
        let obj = {};
        obj.id = item.id;
        obj.name = item.first_name + ' ' +item.last_name;
        obj.email = item.email;
        return obj;
    })
    .map(item => item.name);
result.push('Charles');
result.push('Hong');
result.push('Charles');
console.log(result);
console.log(result.indexOf('Charles', 6));

console.clear();

// indexOf(): 
// 1) 조건 만족하는 첫번째 요소 인덱스 반환
const ary1 = ['펭수', '라이언', '어피치', '콘', '브라운', '무지'];
const index = ary1.indexOf('라이언');
console.log(index);
console.log(ary1.indexOf('라이언', index + 1));

// 2) 인덱스 모두 찾기
const ary2 =  ['펭수', '라이언', '어피치', '콘', '브라운', '무지', '라이언', '어피치', '콘', '콘'];
let idx = -1;
let aryFound = [];
do{
    idx = ary2.indexOf('콘', (idx + 1))
    if(idx >= 0 ) aryFound.push(idx);
}while(idx >= 0)
console.log(aryFound);

// 3) 검색값 나오는 횟수
let count = 0;
do{
    idx = ary2.indexOf('라이언', idx + 1);
    count += idx >= 0 ? 1 : 0;
}while(idx >= 0);
console.log(count);

// 4) 검색된 모든 요소 변경


