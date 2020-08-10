<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<head>

<%
	String id = (String) session.getAttribute("loginUser");
String admin = (String) session.getAttribute("loginAdmin");
String pwd = (String) session.getAttribute("loginAdmin");

while (true) {
	if (id == null && admin == null) {
		response.sendRedirect("login.do");
		break;
	} else if (id != null && admin == null) {
		break;
	} else if (admin != null && id == null) {
		break;
	}
}
%>

</head>
<!DOCTYPE HTML>
<!-- Main -->
<div id="main" class="wrapper style1">
	<div class="container">
		<div class="row">
			<!-- Sidebar -->
			<div id="sidebar" class="3u sidebar">
				<section>
					<header class="major">
						<h2>Mypage</h2>
					</header>
					<div class="row half">
						<section class="6u">
							<ul class="default">
								<li><a
									href="MemberServlet?command=member_update_form&memId=<%=id%>">개인정보
										수정</a></li>
								<li><a
									href="ReserveServlet?command=reserve_list&memId=<%=id%>">나의예약</a></li>
								<li><a
									href="ReserveServlet?command=reserve_bucket&memId=<%=id%>">장바구니</a></li>
							</ul>
						</section>
					</div>
				</section>
			</div>


			<!-- Content -->

			<div id="content" class="9u">
				<section>
					<header class="major">
						<h2>나의 예약</h2>
						<input type="hidden" name="memId" value=<%=id%>>
					</header>
					<form action="ReserveServlet" method="post" name="frm">
						<input type="hidden" name="command" value="reserve_delete">

						<table class="mypage-bucket-table">
							<tr class="mypage-bucket-table-tr">
								<th>결제일</th>
								<th>예약번호</th>
								<th >상품타입</th>
								<th >상품명</th>
								<th>갯수</th>
								<th>총금액</th>
								<th>상태</th>
								<th>관리</th>
							</tr>
							<c:forEach var="list" items="${reserve_list}">
								<tr class="mypage-bucket-table-line">
									<td >${list.resDate}</td>
									<td >${list.resGroup}</td>
									<td >${list.proType}</td>
									<td >${list.proName}</td>
									<td>${list.resNum}</td>
									<td>${list.resCharge}</td>
									<td>${list.resData}</td>
									<input type="hidden" name="resData" value="${list.resData}">
									</td>
									<td><input type="submit" value="삭제"
										id="btn_global_mypageres2" onclick="return reserved()"></td>
								</tr>
							</c:forEach>
						</table>

					</form>
					<div align="center" class="mypage-bucket-table-2">
						<input type="button" id="mypage-bucket-pay-btn2"
							onclick="location.href='ReserveServlet?command=reserve_list&memId=<%=id%>'" value="나의예약으로 이동">
					</div>
				</section>
			</div>

		</div>
	</div>
</div>

<%@ include file="../footer.jsp"%>