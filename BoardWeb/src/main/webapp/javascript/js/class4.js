// class4.js

const friend = {
    name: '홍길동',
    age: 20,
    hobbies: ['독서', '운동', '영화'],
    pets: [{ name: '야옹이', gender: 'Male', friends: ['검양이', '빨양이'] }, { name: '멍멍이', gender: 'Female' }],
    showHobby() {
        return `${this.hobbies[0]}, ${this.hobbies[1]}, ${this.hobbies[2]}`;
    }
}
console.log(friend.pets[0].name);
friend['pets'][0]['friends'][2] = '노량이';
console.log(friend['pets'][0]['friends'][2]);

delete friend.age;  // 속성 지우기.
friend.ages = 20;   // 속성 추가.
friend.showFriends = function () {
    console.log(this);  // this: friend
}   // 메소드 추가.

console.log(friend);
friend.showFriends();

// 참조값을 복사.
// 복사본 변경시 원본도 변경됨.
const fcopy = friend;
fcopy.age = 22;

console.log(friend);
console.log(fcopy);

// 객체를 복사.
// Object.assign(붙여넣을 객체, 복사할 객체); => 정적 메소드.
// 복사본 변경해도 원본 변경 안됨.
const fcopy2 = Object.assign({ bloodType: 'O' }, friend); // 기본값 설정.
fcopy2.age = 24;
console.log(fcopy2);

// 속성 추가.
Object.defineProperty(friend, 'height', {
    // getter, setter : 메소드 아님, 그냥 속성 추가하는 방식.
    get: function () {
        return this._height; 
        // this : 자기자신
        // 언더바 넣은 이유: 숨김 속성?? => 자신을 계속 참조하는 무한루프 방지??
    },
    set: function (value) {
        if (value <= 0) {
            alert('error');
        } else {
            this._height = value;
        }
    }
});
friend.height = 162;
console.log(friend.height);