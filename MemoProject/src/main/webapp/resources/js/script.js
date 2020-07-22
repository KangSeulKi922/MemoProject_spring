function login_check(){
	
	if($.trim($('#userid').val())=='' || typeof($('#userid').val())=='undefind'){
		alert('아이디를 입력하세요.');
		$('#userid').focus();
		return;
	}
	if($.trim($('#userpw').val())=='' || typeof($('#userpw').val())=='undefind'){
		alert('비밀번호를 입력하세요.');
		$('#userpw').focus();
		return;
	}
	$('#formst').submit();

}

function join_check(){
	
	var re = RegExp(/^[a-zA-Z0-9]{4,12}$/);

	if($.trim($('#userid').val())=='' || typeof($('#userid').val())=='undefine'){
		alert('아이디를 입력하세요.');
		$('#userid').focus();
		return;
	}
	if(!re.test($('#userid').val())) {
		alert('아이디는 4~12자의 영문 대소문자와 숫자로만 입력하세요.');
		$('#userid').focus();
		return;
    }
	if($('#userid').val()!=$('#ch_id').val()){
		alert('아이디 중복확인을 해주세요.');
		$('#userid').focus();
		return;
	}
	if($('#userid').val()!=$('#ch_id').val() || $('#ch_value').val()=='n'){
		alert('아이디 중복확인을 해주세요.');
		$('#userid').focus();
		return;
	}
	
	if($.trim($('#username').val())=='' || typeof($('#username').val())=='undefine'){
		alert('이름을 입력하세요.');
		$('#username').focus();
		return
	}
	
	if($.trim($('#userpw').val())=='' || typeof($('#userpw').val())=='undefine'){
		alert('비밀번호를 입력하세요.');
		$('#userpw').focus();
		return;
	}
	if(!re.test($('#userpw').val())) {
		alert('패스워드는 4~12자의 영문 대소문자와 숫자로만 입력하세요.');
		$('#userpw').focus();
		return;
    }
	
	if($.trim($('#userpw_ch').val())=='' || typeof($('#userpw_ch').val())=='undefine'){
		alert('비밀번호를 입력하세요.');
		$('#userpw_ch').focus();
		return;
	}
	if($('#userpw').val() != $('#userpw_ch').val()){
		alert('두 비밀번호가 맞지 않습니다.');
		return;
	}

	$('#formst').submit();

}

function insert_check(){
	
	if($.trim($('#title').val())=='' || typeof($('#title').val())=='undefine'){
		alert('제목을 입력하세요.');
		$('#title').focus();
		return;
	}
	if($.trim($('#content').val())=='' || typeof($('#content').val())=='undefine'){
		alert('내용을 입력하세요.');
		$('#content').focus();
		return;
	}
	
	
	$('#formst').submit();
}

function delete_check(){
	var result = confirm('메모를 삭제하시겠습니까?'); 
	if(result) { 
		$('#formst1').submit();
	} else { 
		
	}

}

function id_check(){
        
        var userid =  $("#userid").val(); 
        
        var re = RegExp(/^[a-zA-Z0-9]{4,12}$/);

    	if($.trim(userid)=='' || typeof(userid)=='undefine'){
    		alert('아이디를 입력하세요.');
    		$('#userid').focus();
    		return;
    	}
    	if(!re.test(userid)) {
    		alert('아이디는 4~12자의 영문 대소문자와 숫자로만 입력하세요.');
    		$('#userid').focus();
    		return;
        }
    	
        $.ajax({
        	async: true,
            type : 'POST',
            data : userid,
            url : "/seulki/idCheck",
            dataType : "json",
            contentType: "application/json; charset=UTF-8",
            success : function(data) {
                if (data.cnt==1) {
                    alert("아이디가 존재합니다. 다른 아이디를 입력해주세요.");
                    $("#userid").focus();
                    
                } else {
                    alert("사용 가능한 아이디입니다.");
                    $("#ch_id").val(userid);
                    $("#ch_value").val("y");
                    
                }
            },
            error : function(error) {
                alert("error : " + error);
            }
        });
}

// 이전 버튼 이벤트

function fn_prev(page, range, rangeSize) {
		var page = ((range - 2) * rangeSize) + 1;
		var range = range - 1;
		
		var url = "/seulki/memoList?page="+page+"&range="+range;

		location.href = url;

	}


  // 페이지 번호 클릭

	function fn_pagination(page, range, rangeSize) {

		var url = "/seulki/memoList?page="+page+"&range="+range;

		location.href = url;	

	}


	// 다음 버튼 이벤트

	function fn_next(page, range, rangeSize) {

		var page = parseInt((range * rangeSize)) + 1;
		var range = parseInt(range) + 1;

		var url = "/seulki/memoList?page="+page+"&range="+range;

		location.href = url;

	}




