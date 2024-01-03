// class1.js

const obj1 = {
    name: 'Hong',
    age: 20,
    showInfo() {
        return `이름은 ${this.name} 이고 나이는 ${this.age} 입니다.`;
    }
}

// 클래스 생성.
class Member {
    constructor(name, age) { // 생성자.
        this.name = name;
        this.age = age;
    }
    titles = ['이름', '나이'];  // 필드 선언
    showTitle() {    // 메소드.
        this.titles.forEach(item => {
            console.log(item);
        });
    }
    showInfo() {
        return `이름은 ${this.name} 이고 나이는 ${this.age} 입니다.`;
    }
}
// 클래스의 프로토타입에 함수 구현
Member.prototype.showName = function () {
    return `이름은 ${this.name} 입니다.`;
}

const obj2 = new Member('Hong', 20);
console.log(obj1.showInfo());
console.log(obj2.showInfo());
obj2.showTitle();
console.log(obj2.showName());