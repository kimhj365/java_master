// class5.js
// Map. => key, value
const map = new Map();
map.set('홍길동', 20);
map.set('홍길동', 21);  // 같은 key 값 있으면 새로운 값으로 변경.
map.set('김민수', 22);
map.set('최성우', 25);

console.log(map.get('김민수')); // key 값이 '김민수'인 value 출력.
console.log(map.keys());        // key 값만 반환.
console.log(map.values());      // value 값만 반환.

// Map의 forEach: 첫번째 매개값 = value / 두번째 매개값 = key
map.forEach((value, key) => console.log(`key : ${key}, value : ${value}`));

// 요소 제거.
map.delete('최성우');   // key 값이 '최성우'인 요소 제거.
// map.clear();            // 요소 전부 제거.

for(let key of map.keys()){
    console.log(`key는 ${key}, value는 ${map.get(key)}`);
}

// entries(): Map 객체를 배열로 저장.
console.log(map.entries());
for(let obj of map.entries()){
    console.log(obj);
}
for(let [item, value] of map.entries()){
    console.log(item, value);
}

// console.clear();        // 콘솔 내용 지우기

// Set.
const set = new Set();
set.add('홍길동');
set.add('홍길동');      // 중복값 안들어감
set.add('김민수');
set.add('홍성길');

// 요소 제거
set.delete('홍성길');
console.log(set.size);

set.forEach(name => console.log(name));

// 중복값 제거 => Set 컬렉션에 담기
const numAry = [10, 14, 12, 10];
const num = new Set(numAry);      // 배열 => Set 변환
num.forEach(number => console.log(number)); // 중복값 제거됨

console.clear();
map.clear();

map.set('김명철', 80);
map.set('김익수', 70);
map.set('이명철', 80);
map.set('이익수', 85);
map.set('홍길동', 80);
map.forEach((score, name) => console.log(name, score));

// 김씨 점수의 합계
let sum = 0;
map.forEach((score, name) => {
    if(name.indexOf('김') == 0){    // '김'이 첫번째 인덱스에 있다면
        sum += score;
    }
});
console.log(`합계 점수 : ${sum}`);



