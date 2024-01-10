/**
 * member.js
 */
$(document).ready(function() {
	// 회원 목록 출력/
	$.ajax('memberListJson.do', {
        method: 'get',
        // data: {bno:1, rno:2}, // 'bno=1&rno=2'
        dataType: 'json', // 서버의 데이터 포맷을 저장 
        success: function(result) {
            $(result).each((idx, member) => {
                // tr 생성, td 생성.(jQuery)
                let img = '';
                if(member.image){
                    img = $('<img />').attr({'src':'images/' + member.image, 'style':'width: 100px'});
                }
                let tr = $('<tr />').append($('<td />').text(member.id),
                                            $('<td />').text(member.name),
                                            $('<td />').text(member.responsibility),
                                            $('<td />').html(img)
                                            );
                $('#list').append(tr);
            }); // = js의 forEach
        },
        error: function(err) {
            console.error(err);
        }
    })

    $('input[type="file"]').on('change', function (e) {
        console.log(e.target.files[0]);
    });

    $('#addBtn').on('click', function() {
        let formData = new FormData(); // multipart/form-data
        formData.append('id', $('input[name="id"]').val());
        formData.append('pw', $('input[name="pw"]').val());
        formData.append('name', $('input[name="name"]').val());
        formData.append('image', $('input[name="image"]')[0].files[0]);
        
        // for(let ent of formData.entries()){
        //     console.log(ent);
        // }
        $.ajax('memberAddJson.do', {
            method: 'post',
            data: formData,
            processData: false,
            contentType: false,
            dataType: 'json',
            success: function (result) {
                try {
                    if (result.retCode == 'OK') {
                        
                        console.log(result);
                        let img = '';
                        
                        if(result.vo.image){
                            img = $('<img />').attr({'src':'images/' + result.vo.image, 'style':'width: 100px'});
                        }
                        let tr = $('<tr />').append($('<td />').text(result.vo.id),
                                            $('<td />').text(result.vo.name),
                                            $('<td />').text(result.vo.responsibility),
                                            $('<td />').html(img)
                                            );
                        $('#list').append(tr);

                        $('input[name="id"]').val('');
				        $('input[name="pw"]').val('');
				        $('input[name="name"]').val('');
                        $('input[name="image"]').val('');
                        alert('추가됨!');
                        
                    } else if (result.retCode == 'NG') {
                        alert('처리중 에러');
                    }
                } catch (err) {
                    console.error('예외=> ', err);
                }            },
            error: function (err) {
                console.error(err);
            }
        })
    });
})