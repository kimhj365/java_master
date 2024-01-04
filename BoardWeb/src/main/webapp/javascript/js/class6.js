// class6.js

function sum(num1, num2) {
    return num1 + num2;
}

function getMax(num1, num2) {
    return num1 > num2 ? num1 : num2;
}

const friend = {
    name: 'Hong',
    age: 20,
    showInfo() {
        return `이름은 ${this.name}, 나이는 ${this.age} 입니다.`;
    }
}

// 모듈
// 특정 요소(변수, 함수, 객체..)만 반환해서 외부에서 쓰게 하기
export { friend, sum, getMax };     