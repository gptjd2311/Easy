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
			response.sendRedirect("login");
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
					<form action="Member_Add_Update" method="post" name="frm">
						<table class="mypage-bucket-table">
							<tr class="mypage-bucket-table-tr">
								<th>결제일</th>
								<th>예약번호</th>
								<th>상품타입</th>
								<th>상품명</th>
								<th>갯수</th>
								<th>총금액</th>
								<th>관리</th>
							</tr>
							<c:forEach var="list" items="${reserve_list}">
								<tr class="mypage-bucket-table-line">
									<td>${list.resDate}</td>
									<td>${list.resGroup}</td>
									<td>${list.proType}</td>
									<td>${list.proName}</td>
									<td>${list.resNum}</td>
									<td>${list.resCharge}</td>

									<td>									
									<input type="hidden" name="resData" value="${list.resData}"> 
									<input type="hidden" name="resGroup" value="${list.resGroup}"> 
										<c:set var="memAdd_1" value="${list.memAdd_1}"/>
										<c:set var="memAdd_2" value="${list.memAdd_2}"/>
										<c:set var="memAdd_3" value="${list.memAdd_3}"/>
										<c:set var="resData" value="${list.resData}" />
										<input type="button" value="삭제" id="btn_global_mypageres2"
										onclick="location.href='reserve_delete?resData=${list.resData}&resGroup=${list.resGroup}&memId=<%=id%>'"></td>
								</tr>
							</c:forEach>
						</table>

						<table class="mypage-bucket-table">
							<tr class="mypage-bucket-table-tr">
								<th style="width: 5em;">주소 찾기</th>
								<th>우편번호</th>
								<th style="width: 15em;">주소</th>
								<th>세부주소</th>
								<th>관리</th>
							</tr>
							<tr>
	
								<td><input type="button" id="id-check"
									onclick="sample6_execDaumPostcode()" class="join-id"
									value="주소 찾기"></td>
								<td><input type="text" id="sample6_postcode"
									class="join-id" placeholder="우편번호" name="memAdd_1"
									value="${memAdd_1}"></td>
								<td><input type="text" id="sample6_address" class="join-id"
									name="memAdd_2" placeholder="주소" value="${memAdd_2}"></td>
								<td><input type="text" id="sample6_detailAddress"
									name="memAdd_3" class="join-id" placeholder="상세주소"
									value="${memAdd_3}"></td>
								<td><c:if test="${resData == '수거중'}">
										<input type="submit" value="수거주소 수정"
											id="btn_global_mypageres2">
									</c:if> <c:if test="${resData != '수거중'}">
										서비스 진행중에는 주소 변경 불가합니다.	
										</c:if> <input type="hidden" id="sample6_extraAddress"
									class="join-id" placeholder="참고항목"></td>
							
							</tr>
						</table>

					</form>
					<div align="center" class="mypage-bucket-table-2">
						<input type="button" id="mypage-bucket-pay-btn2"
							onclick="location.href='reserve_list?memId=<%=id%>'"
							value="나의예약으로 이동">
					</div>
				</section>
			</div>

		</div>
	</div>
</div>

<%@ include file="../footer.jsp"%>