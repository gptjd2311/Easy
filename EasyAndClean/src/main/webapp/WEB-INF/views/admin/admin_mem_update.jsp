<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<body class="no-sidebar">
	<!-- Main -->
	<div id="main" class="wrapper style1">
		<div class="container">
			<section>
				<form action="member_admin_update" method="post" name="frm">
					<input type="hidden" name="memId" value="${list.memId}">
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
								<td><input type="text" name="memType"
									value="${list.memType}"></td>
								<th>아이디</th>
								<td><input type="text" name="memId" value="${list.memId}"></td>
								<th>패스워드</th>
								<td><input type="text" name="memPwd" value="${list.memPwd}"></td>
							</tr>
							<tr class="admin-view-bucket-table-tr">
								<th>이름</th>
								<td><input type="text" name="memName"
									value="${list.memName}"></td>
								<th>출생년도</th>
								<td><input type="text" name="user_birth_year"
									value="${list.user_birth_year}"></td>
								<th>출생월</th>
								<td><input type="text" name="user_birth_month"
									value="${list.user_birth_month}"></td>
								<th>출생일</th>
								<td><input type="text" name="user_birth_day"
									value="${list.user_birth_day}"></td>
							</tr>
							<tr class="admin-view-bucket-table-tr">
								<th>성별</th>
								<td><input type="text" name="memGen" value="${list.memGen}"></td>
								<th>이메일</th>
								<td><input type="text" name="memEmail"
									value="${list.memEmail}"></td>
								<th>연락처</th>
								<td><input type="text" name="memPhone"
									value="${list.memPhone}"></td>
								<th>공백</th>
								<td></td>
							</tr>
							<tr class="admin-view-bucket-table-tr">
								<th>우편번호</th>
								<td><input type="text" id="sample6_postcode"
									 placeholder="우편번호" name="memAdd_1"
									value="${list.memAdd_1}"></td>
								<th>우편번호 찾기</th>
								<td><input type="button" id="id-check"
									onclick="sample6_execDaumPostcode()" 
									value="우편번호 찾기"></td>
								<th>주소</th>
								<td><input type="text" id="sample6_address" 
									name="memAdd_2" placeholder="주소" value="${list.memAdd_2}"></td>
								<th>상세주소</th>
								<td><input type="text" id="sample6_detailAddress"
									name="memAdd_3"  placeholder="상세주소"
									value="${list.memAdd_3}"></td>
							</tr>
						</table>
						<div>
							<input type="hidden" id="sample6_extraAddress" class="join-id"
								placeholder="참고항목">
						</div>
					</section>
					<div id="mypageres_cen">
						<input type="submit" value="정보 수정" id="btn_global_mypageres">
						<input type="reset" value="다시 작성" id="btn_global_mypageres">
						<input type="button" value="회원 목록" id="btn_global_mypageres"
							onclick="location.href='member_listAll'">							
					</div>
				</form>
			</section>
		</div>
	</div>


	<%@ include file="../footer.jsp"%>