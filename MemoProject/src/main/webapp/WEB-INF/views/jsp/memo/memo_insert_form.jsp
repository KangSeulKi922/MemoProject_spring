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
<title>메모 작성</title>
<jsp:include page="../common/include.jsp" />
</head>
<body>
<div class="login-card" style="width:548px;">
		<h1>메모 작성</h1>
		<br>
		<form action="/seulki/memoInsert" method="post" id="formst">
			<input type="hidden" name="mUserId" id="mUserId" value="${param.userId}">
			<input type="text" name="title" id="title" placeholder="제목"> 
			<textarea rows="10" cols="80" name="content" id="content" placeholder="내용을 입력해주세요."></textarea>
			<input type="button" name="insert" class="login login-submit" value="작성완료" 
				onclick="insert_check();" style="margin-bottom: 10px; margin-top:10px;">
		</form>
		<input type="button" name="back" class="login login-submit" value="뒤로" 
			onclick="history.go(-1)">
	</div>	
</body>
</html>