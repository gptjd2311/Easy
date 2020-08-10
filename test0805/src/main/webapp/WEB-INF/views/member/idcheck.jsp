<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML>
<html>
<head>
<script src="${path}/resources/js/member.js"></script>
<style>
/*회원가입 아이디체크 폼*/
.join-id-check {
	width: 3em;
	height: 1.8em;
	display: inline-block;
	margin-bottom: 1.87em;
	font-size: 0.8em;
	text-align: center;
}

/* 아이디 확인 이모티콘 */
#id-check {
	font-size: 1em;
	background: #3ac984;
	border-radius: 2.5em;
	border: 0;
	color: #ffffff;
}
</style>

<title>아이디 중복체크</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<body>
	<h2>아이디 중복확인</h2>
	<form action="idCheck" method="get" name="frm">
		아이디 
		<input type=text name="memId" value="${memId}" >
		<input type=submit value="중복 체크" id="id-check"> <br>
		<c:if test="${result == 1}">
			<script type="text/javascript">
				opener.document.frm.memId.value = "";
			</script>
			${memId}는 이미 사용 중인 아이디입니다.
		</c:if>
		<c:if test="${result==-1}">
		${memId}는 사용 가능한 아이디입니다.
		<input type="button" id="id-check" value="사용" class="cancel"
				onclick="idok('${memId}')">
		</c:if>
	</form>
</body>
</html>