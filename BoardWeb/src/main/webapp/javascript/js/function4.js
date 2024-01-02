// function4.js

// 달력을 생성하는 객체.
const cal = {
    days: ['Sun', 'Mon', 'Tue', 'Wed', 'Thu', 'Fri', 'Sat'],

    makeCalendar: function (month) {
        this.makeTable(month);
        this.makeTitle(this.days, document.querySelector('#theader'));
        this.makeBody(month, document.querySelector('#tbody'));
    },

    makeTable: function(month){
        let tbl = document.createElement('table');
        tbl.setAttribute('border', 1);
        document.querySelector('body').appendChild(tbl);
        
        let cpt = document.createElement('caption');
        cpt.innerText = `${month}월`;
        tbl.appendChild(cpt);

        let thd = document.createElement('thead');
        thd.setAttribute('id', 'theader');
        tbl.appendChild(thd);
        
        let tbd = document.createElement('tbody');
        tbd.setAttribute('id', 'tbody');
        tbl.appendChild(tbd);
    },

    makeTitle: function (fields, pos) {
        let tr = document.createElement('tr');
        fields.forEach(function (field) {
            let th = document.createElement('th');
            th.innerText = field;
            tr.appendChild(th);
        });
        pos.appendChild(tr);
    }, 

    makeBody: function (month, pos) {
        let tr = document.createElement('tr');

        // 공백
        let firstDay = this.getFirstDay(month);
        for (let i = 0; i < firstDay; i++) {
            let td = document.createElement('td');
            td.innerText = '';
            tr.appendChild(td);
        }

        // 날짜
        let lastDate = this.getLastDate(month);
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
    },

    getFirstDay: function (month) {
        // 월 입력 => 시작 요일 반환
        let sum = 1;
        for (let i = 1; i <= month - 1; i++) {
            sum += this.getLastDate(i);
        }
        let result = sum % 7;
        return result;
    },

    getLastDate: function (month) {
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
}

cal.makeCalendar(1);