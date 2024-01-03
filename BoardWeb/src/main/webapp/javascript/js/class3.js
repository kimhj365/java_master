// class3.js
// p.100
const ary = [];
ary.push(1);
ary.push(2);
ary.push(3);
console.log(ary.find(item => item >= 2));   //true 값을 만족하는 첫번째 요소 반환

class Estimate {
    constructor(param) {
        this.unit = param;
    }

    getEstimate(unitType, width, height) {
        console.log(unitType, width, height);
        let priceInfo = this.unit.find(item => item.type == unitType);

        console.log(priceInfo);
        return priceInfo.price * width * height;
    }

    addUnit(unit) {
        unit.push(unit);
    }
}
let unitInfo = [{ type: 'wood', price: 100 }, { type: 'iron', price: 300 }, { type: 'plastic', price: 200 }];
const estimator = new Estimate(unitInfo);
let result = estimator.getEstimate('wood', 20, 20);
console.log(result);

// p.111
// <this>
// 1. 객체의 this : 자기자신
// 2. function()의 this : 전역객체(window)
function myFunc() {
    console.log(this);
}
myFunc();   // window

let obj = {};
obj.act = function () {
    this.value = 'default value';

    function innerAct() {
        this.value = 'innerAct value';
        console.log('this.value : ' + this.value);
    }

    function innerReact(caller) {
        caller.value = 'innerReact value';
        console.log('this.value : ' + this.value);       // 함수 안에서의 this.value : window
        console.log('caller.value : ' + caller.value);   // caller.value : innerReact value
    }

    innerAct();
    console.log('obj 객체의 this.value : ' + this.value);

    innerReact(this);   // this = object
    console.log('obj 객체의 this.value : ' + this.value);

}
obj.act();

// p.116
// 클로저
function outerFunc(name) {
    let saying = name + ' 안녕!';
    return function () {
        return saying;
    }
}

const closure1 = outerFunc('라이언');
const closure2 = outerFunc('콘');
console.log(closure1());
console.log(closure2());

function getCounter(){
    let cnt = 1;

    return function (){
        cnt++;
        console.log(cnt);
    }  
}
const clo1 = getCounter();
clo1();
clo1();
clo1();
clo1();