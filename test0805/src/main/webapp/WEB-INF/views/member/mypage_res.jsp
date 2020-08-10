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
								<li><a href="member_update_form?memId=<%=id%>">개인정보 수정</a></li>
								<li><a href="reserve_list?memId=<%=id%>">나의예약</a></li>
								<li><a href="reserve_bucket?memId=<%=id%>">장바구니</a></li>
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
					<p>ㅇ예약번호를 클릭하면 주문상세보기가 가능합니다</p>
					<form action="reserve_delete" method="post" name="frm">
						<c:set var="listtest" value="${reserve_list}" />
						<c:choose>
							<c:when test="${empty listtest}">
								<table class="mypage-bucket-table">
									<tr class="mypage-bucket-table-tr">
									<tr class="mypage-bucket-table-tr">
										<th>결제일</th>
										<th>예약번호</th>
										<th class="mypage-bucket-table-tr-sp">상태</th>
										<th>관리</th>
									</tr>
									<tr class="mypage-bucket-table-line">
										<td colspan="4">현재 예약이 없습니다!</td>
									</tr>
								</table>
							</c:when>

							<c:when test="${not empty listtest}">
								<c:forEach var="list" items="${reserve_list}">
									<table class="mypage-bucket-table">
										<tr class="mypage-bucket-table-tr">
											<th>결제일</th>
											<th>예약번호</th>
											<th class="mypage-bucket-table-tr-sp">상태</th>
											<th>관리</th>
										</tr>
										<tr class="mypage-bucket-table-line">
											<td>${list.resDate}</td>
											<td>${list.resGroup}<input type="button"
												id="btn_global_mypageres2" value="예약상세보기"
												onclick="location.href='reserve_detail?resGroup=${list.resGroup}'">
											</td>
											<td class="mypage-bucket-table-tr-sp">${list.resData}</td>
											<td><input type="button" value="삭제"
												id="btn_global_mypageres2"
												onclick="location.href='reserve_delete?resData=${list.resData}&resGroup=${list.resGroup}&memId=<%=id%>'"></td>

										</tr>
									</table>
								</c:forEach>
							</c:when>
						</c:choose>
					</form>
					<div align="center" class="mypage-bucket-table-2">
						<input type="button" id="mypage-bucket-pay-btn2"
							onclick="location.href='product_buy_0.jsp'" value="상품페이지로이동">
					</div>
				</section>
			</div>

		</div>
	</div>
</div>

<%@ include file="../footer.jsp"%>