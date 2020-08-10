<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<body class="no-sidebar">
	<!-- Main -->
	<div id="main" class="wrapper style1">
		<div class="container">
			<section>
				<header class="major">
					<h2></h2>
					<span class="byline"></span>
				</header>
				<section>
					<header class="major">
						<h2>회원 예약 관리</h2>
					</header>

					<table class="mypageres">
						<tr class="admin-view-bucket-table-tr">				
							<th>결제일</th>
							<td>${list.resDate}</td>
							<th>회원아이디</th>
							<td>${list.memId}</td>
							<th>예약번호</th>
							<td>${list.resId}</td>
						</tr>
						<tr class="admin-view-bucket-table-tr">		
							<th>상품번호</th>
							<td>${list.proId}</td>
							<th>상품타입</th>
							<td>${list.proType}</td>
							<th>상품명</th>
							<td>${list.proName}</td>
						</tr>
						<tr class="admin-view-bucket-table-tr">		
							<th>갯수</th>
							<td>${list.resNum}</td>
							<th>총금액</th>
							<td>${list.resCharge}</td>
							<th>결제여부</th>
							<td>${list.resPay}</td>
						</tr>
						<tr class="admin-view-bucket-table-tr">
							<th>예약상황</th>
							<td>${list.resData}</td>
							<th>공백</th>
							<td></td>
							<th>공백</th>
							<td></td>
						</tr>
					</table>
				</section>
				<div id="mypageres_cen">
					<input type="button" value="예약 수정" id="btn_global_mypageres"
						onclick="location.href='reserve_admin_update_form?resId=${list.resId}'">
					<input type="button" value="예약 삭제" id="btn_global_mypageres"
						onclick="location.href='reserve_admin_delete?resId=${list.resId}'">
					<input type="button" value="예약 목록" id="btn_global_mypageres"
						onclick="location.href='reserve_listAll'">


				</div>
			</section>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>