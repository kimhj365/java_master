// table.js 
// 객체 배열로 테이블 만들기 (for문)
// 테이블 생성 / thead, tbody 연결
let tbl = document.createElement('table');
tbl.setAttribute('border', 1);  // attribute 추가(border)
tbl.setAttribute('id', 'list');
tbl.appendChild(makeHead());
tbl.appendChild(makeBody());
document.querySelector('body').appendChild(tbl);
// 테이블 생성 end.

// 추가 버튼 클릭 이벤트.
document.getElementById('addBtn').addEventListener('click', function () {
    let id = document.getElementById('uid').value;
    let name = document.getElementById('uname').value;
    let phone = document.getElementById('uphone').value;

    // 값 없을 경우 경고창 + 함수 취소
    if (!id || !name || !phone) {
        alert("값을 입력하세요");
        // 입력창 비우기
        document.getElementById('uid').value = '';
        document.getElementById('uname').value = '';
        document.getElementById('uphone').value = '';
        // uid 입력창에 커서
        document.getElementById('uid').focus();
        return;
    }

    // let obj = {id: id, name: name, phone: phone};
    let obj = { id, name, phone };    // 속성명=변수명 이면 생략가능
    document.querySelector('#list>tbody').appendChild(makeTr(obj))

    // 입력창 비우기
    document.getElementById('uid').value = '';
    document.getElementById('uname').value = '';
    document.getElementById('uphone').value = '';
    // uid 입력창에 커서
    document.getElementById('uid').focus();
});

// 변경 버튼 클릭 이벤트.
document.querySelector('#editBtn').addEventListener('click', function () {
    // findId : 찾을 값
    let findId = document.getElementById('uid').value;
    let phone = document.getElementById('uphone').value;

    // target : 찾을 대상
    // ( > : 바로 밑 자식 요소 /  공백: 모든 하위 요소 )
    // tr을 배열 형태로 target에 저장
    let target = document.querySelectorAll('#list>tbody>tr');

    // 배열.forEach() : 배열 요소 개수만큼 반복문
    // item: 배열 요소 / idx: 인덱스 / ary: 배열
    target.forEach(function (item, idx, ary) {
        // console.log(item, idx, ary);
        let tr = item;
        if (tr.children[0].innerText == findId) {
            tr.children[2].innerText = phone;
        }
    });
});

// 선택삭제 버튼 클릭 이벤트
document.querySelector('#delBtn').addEventListener('click', function(){
    let target = document.querySelectorAll('#list>tbody>tr>td>input:checked');
    target.forEach(function(item, idx, ary){
        // console.log(item);
        item.parentElement.parentElement.remove();
    })
})

// (1) thead 생성 함수
function makeHead() {
    let thd = document.createElement('thead');
    let trh = document.createElement('tr');
    for (let prop in friends[0]) {
        let th = document.createElement('th');
        th.innerText = prop.toUpperCase();
        trh.appendChild(th);
    }
    // 삭제
    let th = document.createElement('th');
    th.innerText = '삭제';
    trh.appendChild(th);
    thd.appendChild(trh);

    th = document.createElement('th');
    th.innerText = '선택삭제';
    trh.appendChild(th);
    thd.appendChild(trh);

    return thd;
}

// (2) tbody 생성 함수
function makeBody() {
    let tbd = document.createElement('tbody');
    for (let friend of friends) {
        tbd.appendChild(makeTr(friend));
    }
    return tbd;
}

// (3) tr, td 생성 함수
function makeTr(obj) {
    let trb = document.createElement('tr');
    
    // tr 클릭시 이벤트(tr 내용을 입력창에 넣기)
    trb.addEventListener('click', function () {
        document.getElementById('uid').value = this.children[0].innerText;
        document.getElementById('uname').value = this.children[1].innerText;
        document.getElementById('uphone').value = this.children[2].innerText;
        // document.getElementById('uid').focus();
        // querySelector 사용시 찾는 타입 맞춰줘야됨
        document.querySelector('#uid').focus();
    });

    for (let prop in obj) {
        let td = document.createElement('td');
        td.innerText = obj[prop];
        trb.appendChild(td);
    }

    // 삭제 버튼 생성
    let td = document.createElement('td');
    let btn = document.createElement('button');
    
    // 버튼 이벤트 등록
    btn.addEventListener('click', function (e) {  // 이벤트 핸들러.
        e.stopPropagation();    // 상위요소로 이벤트 전파 차단(버블링 차단).
        console.log(this.parentElement.parentElement.remove());
    })
    btn.innerText = '삭제';
    td.appendChild(btn);
    trb.appendChild(td);

    // 체크박스 생성
    td = document.createElement('td');
    td.setAttribute('align', 'center');

    let chkbox = document.createElement('input');
    chkbox.addEventListener('click', function(e){
        e.stopPropagation();    // 상위요소로 이벤트 전파 차단(버블링 차단).
        console.log(e)  // e: 이벤트 => target: input 태그
    });

    chkbox.setAttribute('type', 'checkbox');
    td.appendChild(chkbox);
    trb.appendChild(td);

    return trb;
}