// calendar.js

// 테이블 만들기 (DOM)
let tbl = document.createElement('table');
tbl.setAttribute('border', 1);
document.querySelector('body').appendChild(tbl);

let thd = document.createElement('thead');
thd.setAttribute('id', 'theader');
tbl.appendChild(thd);

let tbd = document.createElement('tbody');
tbd.setAttribute('id', 'tbody');
tbl.appendChild(tbd);

let days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

makeCalendar(1);

// 달력 만들기
function makeCalendar(month) {
    makeTitle(days, document.querySelector('#theader'));
    makeBody(month, document.querySelector('#tbody'))
}


function getLastDate(month) {
    // 월 입력 => 마지막 날 반환
    switch (month) {
        case 1: case 3: case 5: case 7: case 8: case 10: case 12:
            return 31;
        case 4: case 6: case 9: case 11:
            return 30;
        case 2:
            return 29;
        default:
            return;
    }
}

function getFirstDay(month) {
    // 월 입력 => 시작 요일 반환
    let sum = 1;
    for (let i = 1; i <= month - 1; i++) {
        sum += getLastDate(i);
    }
    let result = sum % 7;
    return result;
}

// thead 생성
function makeTitle(dayAry = [], pos = {}) {
    let tr = document.createElement('tr');
    dayAry.forEach(function (field) {
        let th = document.createElement('th');
        th.innerText = field;
        tr.appendChild(th);
    });
    pos.appendChild(tr);
}

//tbody 생성
function makeBody(month = 1, pos = {}) {
    let tr = document.createElement('tr');

    // 공백
    let firstDay = getFirstDay(month);
    for (let i = 0; i < firstDay; i++) {
        let td = document.createElement('td');
        td.innerText = '';
        tr.appendChild(td);
    }

    // 날짜
    let lastDate = getLastDate(month);
    for (let i = 1; i <= lastDate; i++) {
        // 토요일: aqua / 일요일: pink
        let td = document.createElement('td');
        td.innerText = i;
        tr.appendChild(td)

        if ((firstDay + i) % 7 == 1) {
            td.setAttribute('style', 'background-color : pink')
        }

        if ((firstDay + i) % 7 == 0) {
            td.setAttribute('style', 'background-color : skyblue')
            pos.appendChild(tr);
            tr = document.createElement('tr');
        }
    }
    pos.appendChild(tr);
}