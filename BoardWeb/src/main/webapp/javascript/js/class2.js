// class2.js
// 날짜 객체
// 오늘 날짜 선언
let today = new Date(); // {} new Object();
console.log(today.getFullYear());
console.log(today.getMonth() + 1); // month: 0~11
console.log(today.getDate());
console.log(today.getDay());    // 일~토: 0~6

// 날짜 직접 선언
let date = new Date(2023, 0, 1); // 1월 1일
date = new Date(2023, 1, 0); // 2월 1일의 전날 => 1월 마지막 날
console.log(date.getDate());     // 31

let year = 2023;
let month = 5;
let date1 = new Date(year, month - 1, 1);
let date2 = new Date(year, month, 0);
console.log(date1.getDate(), date1.getDay());

// 날짜 클래스 선언
// 내 코드
class Calendar {
    // 생성자
    constructor(year, month) {
        this.year = year;
        this.month = month;
    }

    // 필드
    days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

    // 메소드
    makeCalendar() {
        this.makeTable(this.year, this.month);
        this.makeTitle(this.days, document.querySelector('#theader'));
        this.makeBody(this.year, this.month, document.querySelector('#tbody'));
    }

    makeTable(year, month) {
        let tbl = document.createElement('table');
        tbl.setAttribute('border', 1);
        document.querySelector('body').appendChild(tbl);

        let cpt = document.createElement('caption');
        let h2 = document.createElement('h2');
        h2.innerText = `${year}년 ${month}월`;
        cpt.appendChild(h2);
        tbl.appendChild(cpt);

        let thd = document.createElement('thead');
        thd.setAttribute('id', 'theader');
        tbl.appendChild(thd);

        let tbd = document.createElement('tbody');
        tbd.setAttribute('id', 'tbody');
        tbl.appendChild(tbd);
    }

    makeTitle(fields, pos) {
        let tr = document.createElement('tr');
        fields.forEach(function (field) {
            let th = document.createElement('th');
            th.innerText = field;
            tr.appendChild(th);
        });
        pos.appendChild(tr);
    }

    makeBody(year, month, pos) {
        let tr = document.createElement('tr');

        let firstDay = this.getFirstDay(year, month);
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = '';
            tr.appendChild(td);
        }

        let lastDate = this.getLastDate(year,month);
        for (let i = 1; i <= lastDate; i++) {
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

    getFirstDay(year, month) {
        let day = new Date(year, month-1, 1);
        return day.getDay();
    }

    getLastDate(year, month) {
        let day = new Date(year, month, 0);
        return day.getDate();
    }
}

// 교수님 코드
class Calendar2 {
    // 생성자
    constructor(year, month) {
        this.year = year;
        this.month = month;
    }

    // 필드
    days = ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'];

    // 메소드
    makeCalendar() {
        this.makeTable();
        this.makeTitle(document.querySelector('#theader'));
        this.makeBody(document.querySelector('#tbody'));
    }

    makeTable() {
        let tbl = document.createElement('table');
        tbl.setAttribute('border', 1);
        document.querySelector('body').appendChild(tbl);

        let cpt = document.createElement('caption');
        let h2 = document.createElement('h2');
        h2.innerText = `${this.year}년 ${this.month}월`;
        cpt.appendChild(h2);
        tbl.appendChild(cpt);

        let thd = document.createElement('thead');
        thd.setAttribute('id', 'theader');
        tbl.appendChild(thd);

        let tbd = document.createElement('tbody');
        tbd.setAttribute('id', 'tbody');
        tbl.appendChild(tbd);
    }

    makeTitle(pos) {
        let tr = document.createElement('tr');
        this.days.forEach(function (field) {
            let th = document.createElement('th');
            th.setAttribute('style', 'background-color : #ddd')
            th.innerText = field;
            tr.appendChild(th);
        });
        pos.appendChild(tr);
    }

    makeBody(pos) {
        let tr = document.createElement('tr');

        let firstDay = this.getFirstDay();
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = '';
            tr.appendChild(td);
        }

        let lastDate = this.getLastDate();
        for (let i = 1; i <= lastDate; i++) {
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

    getFirstDay() {
        let day = new Date(this.year, this.month-1, 1);
        return day.getDay();
    }

    getLastDate() {
        let day = new Date(this.year, this.month, 0);
        return day.getDate();
    }
}

y = 2024;
m = 1;
// const cal = new Calendar(y, m);
const cal = new Calendar2(y, m);
cal.makeCalendar();