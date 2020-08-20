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
						<h2>회원 관리</h2>
						<span class="byline">회원 조회</span>
					</header>

					<table class="mypageres">
						<tr class="admin-view-bucket-table-tr">
							<th>사용자 번호</th>
							<td>${list.memNum}</td>
							<th>사용자 종류</th>
							<td>${list.memType}</td>
							<th>아이디</th>
							<td>${list.memId}</td>
							<th>패스워드</th>
							<td>${list.memPwd}"</td>
						</tr>
						<tr class="admin-view-bucket-table-tr">
							<th>이름</th>
							<td>${list.memName}</td>
							<th>출생년도</th>
							<td>${list.user_birth_year}</td>
							<th>출생월</th>
							<td>${list.user_birth_month}</td>
							<th>출생일</th>
							<td>${list.user_birth_day}</td>
						</tr>
						<tr class="admin-view-bucket-table-tr">
							<th>성별</th>
							<td>${list.memGen}</td>
							<th>이메일</th>
							<td>${list.memEmail}</td>
							<th>연락처</th>
							<td>${list.memPhone}</td>
							<th>공백</th>
							<td>&nbsp;</td>
						</tr>
						<tr class="admin-view-bucket-table-tr">
							<th>우편번호</th>
							<td>${list.memAdd_1}</td>
							<th>주소</th>
							<td>${list.memAdd_2}</td>
							<th>상세주소</th>
							<td>${list.memAdd_3}</td>
							<th>공백</th>
							<td>&nbsp;</td>
						</tr>
					</table>
				</section>
				<div id="mypageres_cen">
					<input type="button" value="정보 수정" id="btn_global_mypageres"
						onclick="location.href='member_admin_update_form?memId=${list.memId}'">
					<input type="button" value="회원 삭제" id="btn_global_mypageres"
						onclick="location.href='member_admin_delete?memId=${list.memId}'">
					<input type="button" value="회원 목록" id="btn_global_mypageres"
						onclick="location.href='member_listAll'">

				</div>
			</section>
		</div>
	</div>


	<%@ include file="../footer.jsp"%>