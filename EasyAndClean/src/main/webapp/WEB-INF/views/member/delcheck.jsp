<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE HTML>
<html>

<%
	String id = (String) session.getAttribute("loginUser");
	String admin = (String) session.getAttribute("loginAdmin");
	String pwd = (String) session.getAttribute("loginAdmin");

	while (true) {
		if (id == null && admin == null) {
			response.sendRedirect("login");
			break;
		} else if (id != null && admin == null) {
			break;
		} else if (admin != null && id == null) {
			break;
		}
	}
%>

<head>
<link rel="stylesheet" href="${path}/resources/css/style.css" />
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

<title>회원탈퇴</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
</head>
<body>
	<h2>정말로 탈퇴하시겠습니까?</h2>
	<form action="member_delete" method="get" name="frm">
		<input type="hidden" name="memId" value="<%=id%>">
		<input type="submit" value="회원 탈퇴" id="inbucket">
		<input type="button" value="창닫기" id="inbucket"
			onclick="javascript:self.close()"></a>
	</form>
</body>
</html>