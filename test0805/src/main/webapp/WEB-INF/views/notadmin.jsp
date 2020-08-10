<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<!DOCTYPE HTML>
<body class="no-sidebar">
	<!-- Main -->

	</div>
	<div id="main" class="wrapper style1">
		<div class="container">
			<section>
				<header class="major">
					<h2></h2>
					<span class="byline"></span>
				</header>
				<center>
					<h1 id="board-text-1">EASY AND CLEAN</h1>
					<c:if test="${em.lev =='C'}">
						<p align="center">당신은 권한이 없습니다.
					</c:if>
					<c:if test="${empty emp}">
						<p align="center">로그인 하시면 더 좋은 정보를 얻을 수 있습니다.
					</c:if>
				</center>

			</section>
		</div>
	</div>

	<%@ include file="footer.jsp"%>