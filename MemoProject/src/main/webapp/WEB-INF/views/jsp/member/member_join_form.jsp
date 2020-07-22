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
<title>join</title>
<jsp:include page="../common/include.jsp" />
</head>
<body>
<div class="login-card">
		<h1>JOIN</h1>
		<br>
		<form action="/seulki/join" method="post" id="formst">
			<input type="hidden" name="ch_id" id="ch_id" value="">
			<input type="hidden" name="ch_value" id="ch_value" value="n">
			<input type="text" name="userid" id="userid" placeholder="아이디">
			<input type="button" name="join" id="idch" class="login login-submit" value="중복 확인" 
				onclick="id_check();" style="margin-bottom:10px;">
			<input type="text" name="username" id="username" placeholder="이름">
			<input type="password" name="userpw" id="userpw" placeholder="비밀번호">
			<input type="password" name="userpw_ch" id="userpw_ch" placeholder="비밀번호 확인">
			<input type="button" name="join" class="login login-submit" value="회원가입" 
				onclick="join_check();" style="margin-bottom:10px;">
		</form>
		<input type="button" name="back" class="login login-submit" value="뒤로" 
			onclick="history.go(-1)">
	</div>	
</body>
</html>