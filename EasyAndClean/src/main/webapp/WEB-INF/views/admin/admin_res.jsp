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
					<form method="post" name="frm">
						<table class="mypageres">
							<p>
								<span class="mypageresP">회원 아이디 입력&nbsp; <input
									type="hidden" name="searchCol" value="${BSearchDto.searchCol}">
									<input type="text" id="join-id" name="searchVal"
									value="${BSearchDto.searchVal}"> <input type="submit"
									id="btn_global_mypageres2" value="조회"
									onclick="javascript: form.action='reserve_listAll';">
								</span>
							</p>

							<p>ㅇ예약번호를 클릭하여 수정 및 삭제</p>
							<tr class="mypage-bucket-table-tr">
								<th>선택박스</th>
								<th>예약번호</th>
								<th>결제일</th>
								<th>회원아이디</th>
								<th>상품번호</th>
								<th>상품타입</th>
								<th>상품명</th>
								<th>갯수</th>
								<th>총금액</th>
								<th>결제여부</th>
								<th>예약상황</th>

							</tr>
							<c:forEach var="list" items="${reserve_listAll}">
								<tr class="mypage-bucket-table-line">
									<td><input type="checkbox" name="chBox"
										value="${list.resId}">
									<td style="color: green;"><a
										href="reserve_admin_view?resId=${list.resId}" />${list.resId}</td>
									<td>${list.resDate}</td>
									<td>${list.memId}</td>
									<td>${list.proId}</td>
									<td>${list.proType}</td>
									<td>${list.proName}</td>
									<td>${list.resNum}</td>
									<td>${list.resCharge}</td>
									<td><c:choose>
											<c:when test="${2 eq list.resPay}">
									결제완료
                 							 </c:when>
											<c:when test="${1 eq list.resPay}">
									결제진행중
                 							 </c:when>
											<c:otherwise>
									미결제
									</c:otherwise>
										</c:choose></td>
									<td>${list.resData}</td>
								</tr>
							</c:forEach>
						</table>
						<div id="mypageres_cen">
							<input type="submit" id="btn_global_mypageres-1" name="action"
								value="서비스진행중"
								onclick="javascript: form.action='reserveAdminUpdate1Action';">
							<input type="submit" id="btn_global_mypageres-1" name="action"
								value="배송중 처리"
								onclick="javascript: form.action='reserveAdminUpdate2Action';">
							<input type="submit" id="btn_global_mypageres-1" name="action"
								value="배송완료 처리"
								onclick="javascript: form.action='reserveAdminUpdate3Action';">
							<input type="submit" id="btn_global_mypageres-1" name="action"
								value="취소된예약 처리"
								onclick="javascript: form.action='reserveAdminUpdate4Action';">
						</div>

					</form>
					<table id="mypageres_cen">
						<tr>
							<td colspan="15"><a
								href="reserve_listAll?page=${BSearchDto.firstPageNum}
		&pageDataCount=${BSearchDto.pageDataCount}
		&searchCol=${BSearchDto.searchCol}
		&searchVal=${BSearchDto.searchVal}">◀◀맨앞으로
							</a>&nbsp; <a
								href="reserve_listAll?page=${BSearchDto.prevPageNum}
		&pageDataCount=${BSearchDto.pageDataCount}
		&searchCol=${BSearchDto.searchCol}
		&searchVal=${BSearchDto.searchVal}">◀앞으로
							</a>&nbsp; <c:forEach var="i" begin="${BSearchDto.startPageNum}"
									end="${BSearchDto.endPageNum}" step="1">

									<c:choose>
										<c:when test="${i eq BSearchDto.currentPageNum}">
											<a style="color: blue;"
												href="reserve_listAll?page=${i}
			&pageDataCount=${BSearchDto.pageDataCount}
			&searchCol=${BSearchDto.searchCol}
			&searchVal=${BSearchDto.searchVal}">${i}
											</a>&nbsp; 
		</c:when>
										<c:otherwise>
											<a
												href="reserve_listAll?page=${i}
			&pageDataCount=${BSearchDto.pageDataCount}
			&searchCol=${BSearchDto.searchCol}
			&searchVal=${BSearchDto.searchVal}">${i}
											</a>&nbsp;
		</c:otherwise>
									</c:choose>

								</c:forEach> <a
								href="reserve_listAll?page=${BSearchDto.nextPageNum}
		&pageDataCount=${BSearchDto.pageDataCount}
		&searchCol=${BSearchDto.searchCol}
		&searchVal=${BSearchDto.searchVal}">뒤로▶
							</a>&nbsp; <a
								href="reserve_listAll?page=${BSearchDto.lastPageNum}
		&pageDataCount=${BSearchDto.pageDataCount}
		&searchCol=${BSearchDto.searchCol}
		&searchVal=${BSearchDto.searchVal}">맨뒤로▶▶</a>

							</td>
						</tr>
					</table>
					<div id="mypageres_cen">
						<input type="button" id="btn_global_mypageres-1" value="이전예약보기"
							onclick="location.href='reserve_admin_view_old';"> <input
							type="button" id="btn_global_mypageres-1" value="취소된예약보기"
							onclick="location.href='reserve_admin_view_del';">

					</div>
				</section>
			</section>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>