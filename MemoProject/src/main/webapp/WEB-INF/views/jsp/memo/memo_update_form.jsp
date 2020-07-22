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
<title>메모</title>
<jsp:include page="../common/include.jsp" />
</head>
<body>
<div class="login-card" style="width:548px;">
		<h1>메모 수정</h1>
		<br>
		<form action="/seulki/memoUpdate" method="post" id="formst">
			<input type="hidden" name="memoNum" id="memoNum" value="${memo.memoNum}">
			<input type="text" name="title" id="title" placeholder="제목" value="${memo.memoTitle}"> 
			<textarea rows="10" cols="80" name="content" id="content" placeholder="내용을 입력해주세요.">${memo.memoContent}</textarea>
			<input type="button" name="update" class="login login-submit" value="메모 수정" 
				onclick="insert_check();" style="margin-bottom: 10px; margin-top:10px;">
		</form>
		<form action="/seulki/memoDelete" method="post" id="formst1">
			<input type="hidden" name="memoNum" id="memoNum" value="${memo.memoNum}">
			<input type="button" name="delete" class="login login-submit" value="메모 삭제" 
				onclick="delete_check();">
		</form>
		<%-- <input type="button" name="delete" class="login login-submit" value="메모 삭제" 
			onclick="alert('메모를 삭제하시겠습니까?');location.href='/seulki/memoDelete?memoNum=${memo.memoNum}'"> --%>
		<input type="button" name="back" class="login login-submit" value="뒤로" 
			onclick="history.go(-1)">
	</div>	
</body>
</html>