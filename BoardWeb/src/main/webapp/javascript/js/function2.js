// function2.js
let members = `[{"id":1,"first_name":"Stanwood","last_name":"Gaukrodge","email":"sgaukrodge0@mashable.com","gender":"Male","salary":4883},
{"id":2,"first_name":"Vernen","last_name":"Colson","email":"vcolson1@sourceforge.net","gender":"Male","salary":3187},
{"id":3,"first_name":"Borg","last_name":"Friman","email":"bfriman2@xrea.com","gender":"Male","salary":4912},
{"id":4,"first_name":"Wadsworth","last_name":"Genders","email":"wgenders3@youku.com","gender":"Male","salary":2863},
{"id":5,"first_name":"Marshall","last_name":"Jacson","email":"mjacson4@admin.ch","gender":"Male","salary":3273},
{"id":6,"first_name":"Chaddie","last_name":"Russilll","email":"crussilll5@illinois.edu","gender":"Male","salary":3589},
{"id":7,"first_name":"Ulises","last_name":"Dibnah","email":"udibnah6@mayoclinic.com","gender":"Male","salary":3599},
{"id":8,"first_name":"Carr","last_name":"McAless","email":"cmcaless7@shop-pro.jp","gender":"Male","salary":8634},
{"id":9,"first_name":"Steward","last_name":"Stoll","email":"sstoll8@intel.com","gender":"Male","salary":5369},
{"id":10,"first_name":"Paulita","last_name":"Fuke","email":"pfuke9@a8.net","gender":"Female","salary":9870},
{"id":11,"first_name":"Hakeem","last_name":"Hartzog","email":"hhartzoga@walmart.com","gender":"Male","salary":9544},
{"id":12,"first_name":"Forrester","last_name":"Kosel","email":"fkoselb@wiley.com","gender":"Male","salary":3560},
{"id":13,"first_name":"Westleigh","last_name":"Zanicchelli","email":"wzanicchellic@liveinternet.ru","gender":"Male","salary":5458},
{"id":14,"first_name":"Gib","last_name":"Mangham","email":"gmanghamd@unicef.org","gender":"Male","salary":2241},
{"id":15,"first_name":"Jarret","last_name":"Willoughway","email":"jwilloughwaye@google.de","gender":"Male","salary":8516}]`;

let memberAry = JSON.parse(members);    // 문자열 => 객체 변환

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

let titles = ['아이디', '이름', '성씨', '이메일', '성별', '급여'];

function makeHeader(fields = [], pos = {}) {
    let tr = document.createElement('tr');
    fields.forEach(function (field) {
        let th = document.createElement('th');
        th.innerText = field;
        tr.appendChild(th);
    });
    pos.appendChild(tr);
}
makeHeader(titles, document.querySelector('#theader'));

function makeBody(data = [], pos = {}) {
    data.forEach(function (item) {
        let tr = document.createElement('tr');

        if(item.gender == 'Male'){
            tr.setAttribute('style','background-color : aqua')
        }
        else if(item.gender == 'Female'){
            tr.setAttribute('style','background-color : pink')
        }

        for (let prop in item) {
            let td = document.createElement('td');
            td.innerText = item[prop];
            tr.appendChild(td);

            // if (prop == 'gender' && item[prop] == 'Male') {
            //     td.setAttribute('style', 'background-color : aqua')
            // }
            // else if (prop == 'gender' && item[prop] == 'Female') {
            //     tbd.setAttribute('style', 'background-color : pink')
            // }
        }
        pos.appendChild(tr);
    });
}
makeBody(memberAry, document.querySelector('#tbody'));

