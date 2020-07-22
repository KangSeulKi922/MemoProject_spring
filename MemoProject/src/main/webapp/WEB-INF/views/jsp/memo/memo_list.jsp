<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>memo list</title>
<jsp:include page="../common/include.jsp" />
</head>
<body>
	<div class="memo-card">
		<input type="button" name="insert" class="login login-submit"
			value="메모 작성"
			onclick="location.href='/seulki/memoInsertForm?userId=${mUser}'">
		<c:forEach var="memoList" items="${memoList}">
			<div class="update" id="update"
				onclick="location.href='/seulki/memoUpdateForm?memoNum=${memoList.memoNum}'">
				<div class="title">${memoList.memoTitle}</div>
				<c:set var="date" value="${memoList.memoDate}" />
				<c:set var="dateSubString" value="${fn:substring(date, 0, 19)}" />
				<div class="date" style="text-align:right;width:180px;float:right">${dateSubString}</div>
			</div>
			<br>
		</c:forEach>
		
		<div id="paginationBox">
 		<c:if test="${pagination.prev}">
					<a class="page-link" href="#" 
					onclick="fn_prev('${pagination.page}','${pagination.range}','${pagination.rangeSize}'); return false;">
						이전
					</a>
		</c:if>
		&nbsp;
		<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
					<a class="page-link" href="#" 
					onClick="fn_pagination('${idx}','${pagination.range}','${pagination.rangeSize}'); return false;">
						${idx} 
					</a>&nbsp;
				</c:forEach>
		
		<c:if test="${pagination.next}">
					<a class="page-link" href="#" 
					onclick="fn_next('${pagination.page}','${pagination.range}','${pagination.rangeSize}'); return false;">
						다음
					</a>
		</c:if>
		</div>
		
 		<%-- <!-- pagination{s} -->
		<div id="paginationBox">
			<ul class="pagination">
				<c:if test="${pagination.prev}">
					<li class="page-item">
					<a class="page-link" href="#" onClick="fn_prev('${pagination.page}', '${pagination.range}', '${pagination.rangeSize}'); return false;">
						Previous
					</a></li>
				</c:if>

				<c:forEach begin="${pagination.startPage}" end="${pagination.endPage}" var="idx">
					<li class="page-item <c:out value="${pagination.page == idx ? 'active' : ''}"/> ">
					<a class="page-link" href="#" 
					onClick="fn_pagination('${idx}','${pagination.range}','${pagination.rangeSize}'); return false;">
						${idx} 
					</a></li>
				</c:forEach>

				<c:if test="${pagination.next}">
					<li class="page-item"><a class="page-link" href="#" 
					onClick="fn_next('${pagination.range}','${pagination.range}','${pagination.rangeSize}'); return false;">
						Next
					</a></li>
				</c:if>
			</ul>
		</div>
		<!-- pagination{e} --> --%>

		<input type="button" name="join" class="login login-submit"
			value="로그아웃" onclick="location.href='/seulki/logout'" style="margin-top:30px;">
	</div>
</body>
</html>