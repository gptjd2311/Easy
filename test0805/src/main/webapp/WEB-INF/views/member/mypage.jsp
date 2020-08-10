<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE HTML>
<head>
<%
	String id = (String) session.getAttribute("loginUser");
if (id == null) {

	response.sendRedirect("login.do");
}
%>
</head>

<body class="no-sidebar">
	<!-- Main -->
	<div id="main" class="wrapper style1">
		<div class="container">
			<section>
				<header class="major">
					<h2></h2>
					<span class="byline"></span>
				</header>
				<center>
					<h1 id="board-text-1">EASY AND CLEAN</h1>
					<h1 id="board-text-1">마이페이지 입니다. 원하시는 메뉴로 이동하세요</h1>
					<ul id="button-ul">
						<li><a
							href="MemberServlet?command=member_update_form&memId=<%=id%>"
							class="button-index-sign" target="_blank">개인정보수정으로 이동</a></li>
					</ul>
					<ul id="button-ul">
						<li><a
							href="ReserveServlet?command=reserve_list&memId=<%=id%>"
							class="button-index-sign" target="_blank">나의 예약으로 이동</a></li>
					</ul>
				</center>
				<br> <br>
			</section>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>