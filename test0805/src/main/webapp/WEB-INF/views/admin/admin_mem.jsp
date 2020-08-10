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
						<p>
						<form action="member_listAll" method="post">
							<span class="mypageresP">회원 이름 입력&nbsp; <input
								type="hidden" name="searchCol" value="${BSearchDto.searchCol}">
								<input type="text" id="join-id" name="searchVal"
								value="${BSearchDto.searchVal}"> <input type="submit"
								id="btn_global_mypageres2" value="조회"></span>
						</form>
						</p>
						<p>ㅇ아이디를 클릭하여 수정 및 삭제</p>
						<tr>
							<th>사용자 번호</th>
							<th>사용자 종류</th>
							<th>아이디</th>
							<th>패스워드</th>
							<th>이름</th>
							<th>출생년도</th>
							<th>출생월</th>
							<th>출생일</th>
							<th>성별</th>
							<th>이메일</th>
							<th>연락처</th>
							<th>우편번호</th>
							<th>주소</th>
							<th>상세주소</th>

						</tr>
						<c:forEach var="list" items="${member_listAll}">
							<tr class="mypage-bucket-table-line">
								<td>${list.memNum}</td>
								<td>
								<c:choose>
										<c:when test="${1 eq list.memType}">
									<p style="color: blue">일반회원</p>
                 							 </c:when>
										<c:otherwise>
									<p style="color: purple;">관리자</p>
									</c:otherwise>
									</c:choose>
								
								</td>
								<td><a href="member_admin_view?memId=${list.memId}">${list.memId}</td>
								<td>${list.memPwd}</td>
								<td>${list.memName}</td>
								<td>${list.user_birth_year}</td>
								<td>${list.user_birth_month}</td>
								<td>${list.user_birth_day}</td>
								<td>${list.memGen}</td>
								<td>${list.memEmail}</td>
								<td>${list.memPhone}</td>
								<td>${list.memAdd_1}</td>
								<td>${list.memAdd_2}</td>
								<td>${list.memAdd_3}</td>
							</tr>
						</c:forEach>

					</table>
					<table id="mypageres_cen">
						<tr>
							<td colspan="15"><a
								href="member_listAll?page=${BSearchDto.firstPageNum}
		&pageDataCount=${BSearchDto.pageDataCount}
		&searchCol=${BSearchDto.searchCol}
		&searchVal=${BSearchDto.searchVal}">◀◀맨앞으로
							</a>&nbsp; <a
								href="member_listAll?page=${BSearchDto.prevPageNum}
		&pageDataCount=${BSearchDto.pageDataCount}
		&searchCol=${BSearchDto.searchCol}
		&searchVal=${BSearchDto.searchVal}">◀앞으로
							</a>&nbsp; <c:forEach var="i" begin="${BSearchDto.startPageNum}"
									end="${BSearchDto.endPageNum}" step="1">

									<c:choose>
										<c:when test="${i eq BSearchDto.currentPageNum}">
											<a style="color: blue;"
												href="member_listAll?page=${i}
			&pageDataCount=${BSearchDto.pageDataCount}
			&searchCol=${BSearchDto.searchCol}
			&searchVal=${BSearchDto.searchVal}">${i}
											</a>&nbsp; 
		</c:when>
										<c:otherwise>
											<a
												href="member_listAll?page=${i}
			&pageDataCount=${BSearchDto.pageDataCount}
			&searchCol=${BSearchDto.searchCol}
			&searchVal=${BSearchDto.searchVal}">${i}
											</a>&nbsp;
		</c:otherwise>
									</c:choose>

								</c:forEach> <a
								href="member_listAll?page=${BSearchDto.nextPageNum}
		&pageDataCount=${BSearchDto.pageDataCount}
		&searchCol=${BSearchDto.searchCol}
		&searchVal=${BSearchDto.searchVal}">뒤로▶
							</a>&nbsp; <a
								href="member_listAll?page=${BSearchDto.lastPageNum}
		&pageDataCount=${BSearchDto.pageDataCount}
		&searchCol=${BSearchDto.searchCol}
		&searchVal=${BSearchDto.searchVal}">맨뒤로▶▶</a>

							</td>
						</tr>
					</table>
				</section>
			</section>
		</div>
	</div>


	<%@ include file="../footer.jsp"%>