// class7.js

// 다른 js 파일에서 export한 요소 가져오기
import {friend, sum, getMax} from './class6.js';

let n1 = 10;
let n2 = 20;

// 같은 html에서 참조 => 다른 js 파일에 있는 함수, 객체 사용 가능
console.log(sum(n1, n2));
console.log(getMax(n1, n2));
console.log(friend.showInfo());