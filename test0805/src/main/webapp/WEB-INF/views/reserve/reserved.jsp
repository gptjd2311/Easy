<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<%
	String id = (String) session.getAttribute("loginUser");

%>
<!DOCTYPE HTML>
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
					<input type="hidden" name="memId" value=<%=id%>>
					<h1 id="board-text-1">이미 준비중인 상품입니다.</h1>
					<h1 id="board-text-1">취소하시려면 고객센터로 연락주세요.!</h1>
					<ul id="button-ul">
						<li><a href="reserve_list?memId=<%=id%>" class="button-index-sign"
							target="_blank">나의예약으로 이동</a></li>
					</ul>
				</center>

				<br> <br>

			</section>
		</div>
	</div>

	<%@ include file="../footer.jsp" %>
