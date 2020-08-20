<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE HTML>
<!-- Main -->
<head>
<script language="javascript">
	function itemSum(frm) {
		var sum = 0;
		var totalsum = 0;
		var tka = 0;
		var dnjs = "원";
		var count = frm.chBox.length;

		if (frm.chBox.length == 0) {
			alert("값을 입력하세요");
		} else {
			for (var i = 0; i < count; i++) {
				if (frm.chBox[i].checked == true) {
					sum += parseInt(frm.chBox[i].value);
					frm.chBox2[i].checked = true;
				}
			}
		}

		frm.total_sum.value = sum + dnjs;
		frm.total_sum_3.value = sum + tka + dnjs;
	}

	function bucketCheck() {
		if (frm.chBox.length == 0) {
			alert("체크박스를 선택해주세요");
			return false;
		}
		return true;
	}
</script>
</head>
<div id="main" class="wrapper style1">
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
			<div id="content" class="9u">
				<section>
					<header class="major">
						<h2>장바구니</h2>

					</header>
					<form name="form" method="post">
						<input type="hidden" name="memId" value=<%=id%>>
						<table class="mypage-bucket-table">
							<div style="float: right; margin-bottom: 1em;">
								<input type="submit" id="btn_global_mypageres2" value="선택삭제"
									name="action"
									onclick="javascript: form.action='reserveBucketdeleteChooseAction';"">
							</div>
							<tr class="mypage-bucket-table-tr">
								<th>체크박스</th>
								<th>예약번호</th>
								<th>상품타입</th>
								<th>상품명</th>
								<th>갯수</th>
								<th>총금액</th>
								<th>관리</th>
							</tr>
							<tr class="mypage-bucket-table-line" style="display: none">
								<td><input type="checkbox" name="chBox"
									value="${list.resCharge}" onClick="itemSum(this.form);">
									<input type="checkbox" name="chBox2" value="${list.resId}"
									style="display: none;"> /></td>
								<td>${list.resId}</td>
								<td>${list.proType}</td>
								<td>${list.proName}</td>
								<td>${list.resNum}</td>
								<td>${list.resCharge}</td>
								<td><input type="button" value="삭제"
									id="btn_global_mypageres2" onclick="reserve_bucket_delete"></td>
							</tr>
							<c:set var="listtest" value="${bucket_list}" />
							<c:choose>						
								<c:when test="${empty listtest}">
									<tr class="mypage-bucket-table-line">
										<td colspan="7">장바구니가 비었습니다!</td>									
									</tr>
								</c:when>

								<c:when test="${not empty listtest}">
									<c:forEach var="list" items="${bucket_list}">
										<tr class="mypage-bucket-table-line">
											<td><input type="checkbox" name="chBox"
												value="${list.resCharge}" onClick="itemSum(this.form);">
												<input type="checkbox" name="chBox2" value="${list.resId}"
												style="display: none;"> <input type="hidden"
												name="memId" value="${list.memId}" /></td>
											<td>${list.resId}</td>
											<td>${list.proType}</td>
											<td>${list.proName}</td>
											<td>${list.resNum}</td>
											<td>${list.resCharge}</td>
											<td><input type="button" value="삭제"
												id="btn_global_mypageres2"
												onclick="location.href='reserve_bucket_delete?resId=${list.resId}&memId=${list.memId}'"></td>
										</tr>
									</c:forEach>
								</c:when>
							</c:choose>

						</table>
						<table class="mypage-bucket-table">
							<tr class="mypage-bucket-table-tr-2">
								<th>총 상품금액</th>
								<th>서비스비용</th>
								<th>총 주문금액</th>
							</tr>
							<tr class="mypage-bucket-table-line">
								<td><input type="text" name="total_sum" readonly></td>
								<td><input type="hidden" name="total_sum_2" value="3000"
									readonly>무료</td>
								<td><input type="text" name="total_sum_3" readonly></td>
							</tr>
						</table>
						<div align="center" class="mypage-bucket-table-2">
							<input type="button" id="mypage-bucket-pay-btn2"
								onclick="location.href='product_buy_0'" value="상품페이지로이동">
							<input type="submit" id="mypage-bucket-pay-btn2" name="action"
								value="결제하기"
								onclick="javascript: form.action='reserveBucketResAction';">
						</div>
					</form>
				</section>
			</div>
		</div>
	</div>
</div>

<%@ include file="../footer.jsp"%>