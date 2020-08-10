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
							<span class="byline">예약 확인 및 배달 조회</span>
						</header>

						<table class="mypageres">
							<p>
								<span class="mypageresP">예약 번호 또는 아이디</span> <input type="memId"
									name="memId"> <input type="submit"
									id="btn_global_mypageres2" value="조회"
									onclick="ReserveServlet?command=reserve_listAll">
							</p>


							<tr class="mypage-bucket-table-tr">
								<th><input type="checkbox" checked></th>
								<th>결제일</th>
								<th>회원아이디</th>
								<th>예약번호</th>
								<th>상품번호</th>
								<th>상품타입</th>
								<th>상품명</th>
								<th>갯수</th>
								<th>총금액</th>
								<th>결제여부</th>

							</tr>
							<c:forEach var="list" items="${reserve_listAll}">
								<tr class="mypage-bucket-table-line">
									<td><input type="checkbox"></td>
									<td>${list.resDate}</td>
									<td>${list.memId}</td>
									<td>${list.resId}</td>
									<td>${list.proId}</td>
									<td>${list.proType}</td>
									<td>${list.proName}</td>
									<td>${list.resNum}</td>
									<td>${list.resCharge}</td>
									<td>${list.resPay}</td>
								</tr>
							</c:forEach>
							<tr>
							<td colspan="15"><a
								href="reserveListAll.do?page=${bPageDto.firstPageNum}&pageDataCount=${bPageDto.pageDataCount}">◀◀맨앞으로 </a>&nbsp;&nbsp; <a
								href="reserveListAll.do?page=${bPageDto.prevPageNum}&pageDataCount=${bPageDto.pageDataCount}">◀앞으로 </a>&nbsp;&nbsp;
								 <c:forEach var="i" begin="${bPageDto.startPageNum }" end="${bPageDto.endPageNum }" step="1">
									<c:choose>
										<c:when test="${i eq bPageDto.currentPageNum }">
											<a style="font-weight: bold; color: blue" href="reserveListAll.do?page=${i} &pageDataCount=${bPageDto.pageDataCount}">${i}</a>
											&nbsp;&nbsp;
										</c:when>
										<c:otherwise>
											<a href="reserveListAll.do?page=${i} &pageDataCount=${bPageDto.pageDataCount}">${i}</a>&nbsp;&nbsp;
										</c:otherwise>
									</c:choose>
								</c:forEach>
								<a href="reserveListAll.do?page=${bPageDto.nextPageNum}&pageDataCount=${bPageDto.pageDataCount}">뒤로▶</a>&nbsp;&nbsp;
								<a href="reserveListAll.do?page=${bPageDto.lastPageNum}&pageDataCount=${bPageDto.pageDataCount}">맨뒤로▶▶</a>
							</td>
						</tr>
						</table>
					</section>
					<div id="mypageres_cen">
						<input type="submit" id="btn_global_mypageres" value="수정">
						<input type="submit" id="btn_global_mypageres" value="삭제">
					</div>
				</section>
			</div>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>