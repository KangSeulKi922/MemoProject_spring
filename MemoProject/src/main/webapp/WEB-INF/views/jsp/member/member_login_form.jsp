<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<jsp:include page="../common/include.jsp" />
<script type="text/javascript">
window.onload = function () {
	var msg='${param.msg}';
	if(msg){
		alert(msg);		
	}
}
</script>
</head>
<body>
	<div class="login-card">
		<h1>MEMO</h1>
		<br>
		<form action="/seulki/login" method="post" id="formst">
			<input type="text" name="userid" id="userid" placeholder="Id"> 
			<input type="password" name="userpw" id="userpw" placeholder="Password"> 
			<input type="button" name="login" class="login login-submit" value="로그인" 
				onclick="login_check();" style="margin-bottom: 10px;">
		</form>
		<input type="button" name="join" class="login login-submit" value="회원가입" 
			onclick="location.href='/seulki/memberJoinForm'">
	</div>	
</body>
</html>