// dom1.js 
// 객체(object)를 포함한 배열 : [{id, name, phone},...]
const obj1 = { id: 'user1', name: '홍길동', phone: '010-1111' };
const obj2 = { id: 'user2', name: '김민수', phone: '010-2222' };
const obj3 = { id: 'user3', name: '박철호', phone: '010-3333' };
const friends = [obj1, obj2, obj3];

// for(~ in 객체) : 속성 이름 읽어옴
// 객체명[속성] :  속성 값 읽어옴
for (let friend of friends) {
    for (let prop in friend) {
        console.log(prop, ' - ', friend[prop]); // obj1['id']
    }
}