<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<!DOCTYPE HTML>
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

<body class="no-sidebar">

	<!-- Main -->
	<div id="main" class="wrapper style1">
		<div class="container">
			<section>
				<header class="major">
					<h2>서비스 예약 페이지</h2>
					<span class="byline">Easy and Clean 세탁 서비스</span>
				</header>
				<div>
					<ul class="tabs">
						<li class="tab-link current" data-tab="tab-1"><span
							style="text-align: center">세탁</span></li>
						<li class="tab-link" data-tab="tab-2">드라이크리닝</li>
					</ul>

					<div id="tab-1" class="tab-content current">
						<div class="row no-collapse-1">
							<section class="4u">
								<a href="" class="image feature"><img
									src="${path}/resources/images/product_1.JPG" alt=""></a>

								<table class="product-table">
									<tr>
										<th>세탁 서비스</th>
										<th>물빨래</th>
										<th>일반셔츠</th>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>10,000원<br>30L
										</td>
										<td>2,000원</td>
									</tr>

								</table>
								<p class="product-table-more">생활빨래만 가능하며, 30L 빨래망 수 기준으로
									과금됩니다. 건조 불가한 품목은 주의해주세요.</p>

								<center>
									<input type="button" id="inbucket" value="장바구니 담기"
										onclick="inbucket()">
								</center>
							</section>
							<section class="4u">
								<a href="" class="image feature"><img
									src="${path}/resources/images/product_2.JPG" alt=""></a>
								<table class="product-table">
									<tr>
										<th>세탁 서비스</th>
										<th>이불</th>
										<th>토퍼</th>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>7,000원~<br>23,000원
										</td>
										<td>18,000원~<br>30,000원
										</td>
									</tr>
								</table>
								<p class="product-table-more">이불은 커버와 이불을 분리하여 세탁하므로 별도
									과금됩니다.</p>

								<center>
									<input type="button" id="inbucket" value="장바구니 담기"
										onclick="inbucket()">
								</center>
							</section>
							<section class="4u">
								<a href="" class="image feature"><img
									src="${path}/resources/images/product_7.JPG" alt=""></a>
								<table class="product-table">
									<tr>
										<th>세탁 서비스</th>
										<th>잡화</th>
									</tr>
									<tr>
										<td>&nbsp;</td>
										<td>2,500원~<br>25,000원
										</td>
									</tr>
								</table>
								<p class="product-table-more">취급품목 : 운동화, 커튼, 러그, 카펫, 배게커버,
									발매트, 모자, 목도리, 장갑 등 잡화 일체</p>
								<center>
									<input type="button" id="inbucket" value="장바구니 담기"
										onclick="inbucket()">
								</center>
							</section>
						</div>
					</div>


					<div id="tab-2" class="tab-content">
						<div class="row no-collapse-1">
							<section class="4u">
								<a href="" class="image feature"><img
									src="${path}/resources/images/product_4.JPG" alt=""></a>
								<table class="product-table">
									<tr>
										<th>드라이크리닝</th>
										<th>정장</th>

									</tr>

									<tr>
										<td>&nbsp;</td>
										<td>5,000원~<br>6,000원
										</td>

									</tr>
								</table>
								<p class="product-table-more">정장,교복 드라이크리닝 서비스입니다.</p>
								<center>
									<input type="button" id="inbucket" value="장바구니 담기"
										onclick="inbucket()">
								</center>
							</section>
							<section class="4u">
								<a href="" class="image feature"><img
									src="${path}/resources/images/product_5.JPG" alt=""></a>
								<table class="product-table">
									<tr>
										<th>드라이크리닝</th>
										<th>상의</th>
										<th>하의</th>
									</tr>

									<tr>
										<td>&nbsp;</td>
										<td>4,000원~<br>7,500원
										</td>
										<td>4,500원~<br>9,000원
										</td>
									</tr>
								</table>
								<p class="product-table-more">일반 의류 드라이크리닝 서비스입니다.</p>
								<center>
									<input type="button" id="inbucket" value="장바구니 담기"
										onclick="inbucket()">
								</center>
							</section>
							<section class="4u">
								<a href="" class="image feature"><img
									src="${path}/resources/images/product_6.JPG" alt=""></a>
								<table class="product-table">
									<tr>
										<th>드라이크리닝</th>
										<th>아우터</th>

									</tr>

									<tr>
										<td>&nbsp;</td>
										<td>6,500원~<br>25,000원
										</td>

									</tr>
								</table>

								<p class="product-table-more">아우터 드라이크리닝 서비스입니다.</p>

								<center>
									<input type="button" id="inbucket" value="장바구니 담기"
										onclick="inbucket()">
								</center>
							</section>
						</div>
					</div>
				</div>
				<div class="mypage-bucket-pay-div">
					<ul class="mypage-bucket-pay-btn">
						<li><a
							href="reserve_bucket?memId=<%=id%>"
							id="mypage-bucket-pay-btn2" target="_blank"> 장바구니로 이동</a></li>

						<li><a href="product_buy_0" id="mypage-bucket-pay-btn2"
							target="_blank"> 상품페이지로 이동</a></li>
					</ul>
				</div>
			</section>
		</div>
	</div>
</body>


<!-- Footer -->
<%@include file="../footer.jsp"%>