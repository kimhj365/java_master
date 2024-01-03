// class4.js

const friend = {
    name: '홍길동',
    age: 20,
    hobbies: ['독서', '운동', '영화'],
    pets: [{name: '야옹이', gender: 'Male', friends: ['검양이', '빨양이']}, { name: '멍멍이', gender: 'Female' }],
    showHobby() {
        return `${this.hobbies[0]}, ${this.hobbies[1]}, ${this.hobbies[2]}`;
    }
}
console.log(friend.pets[0].name);
friend['pets'][0]['friends'][2] = '노량이';
console.log(friend['pets'][0]['friends'][2]);

delete friend.age;  // 속성 지우기
friend.ages = 20;   // 속성 추가
friend.showFriends = function(){
    console.log(this);  // this: friend
}   // 메소드 추가

console.log(friend);
friend.showFriends();