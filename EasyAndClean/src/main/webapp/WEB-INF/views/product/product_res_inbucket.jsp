<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Easy and Clean</title>
<meta http-equiv="content-type" content="text/html; charset=utf-8" />
<meta name="description" content="" />
<meta name="keywords" content="" />

<link rel="stylesheet" href="${path}/resources/css/skel.css" />
<link rel="stylesheet" href="${path}/resources/css/style.css" />

<script type="text/javascript" src="${path}/resources/js/jquery.min.js"></script>
<script type="text/javascript"
	src="${path}/resources/js/jquery.dropotron.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/skel.min.js"></script>
<script type="text/javascript"
	src="${path}/resources/js/skel-layers.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/init.js"></script>

<script type="text/javascript" src="${path}/resources/js/post.js"></script>

<script type="text/javascript" src="${path}/resources/js/member.js"></script>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<script
	src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${path}/resources/jquery/jquery-3.3.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.1.js"></script>

</head>
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

<body>
	<div class="product-main">
		<div>
			<br> <br>
			<ul class="tabs">
				<li class="tab-link current" data-tab="tab-1"><span
					style="text-align: center">장바구니</span></li>
				<li class="tab-link" data-tab="tab-2">상품가격 자세히보기</li>
			</ul>
			<form action="reserve_insert" method="post" name="frm">
				<input type="hidden" name="memId" value=<%=id%>> <input
					type="hidden" name="memPwd" value=<%=pwd%>>
				<div id="tab-1" class="tab-content current">
					<div class="row no-collapse-1">
						<ul class="res-ul-1">
							<li>
								<h2 align="center" size="50%">세탁상품</h2>
							</li>
						</ul>
						<table class="res-table">
							<tr>
								<td style="width: 13em; paddin: 1em;"><img
									src="${path}/resources/images/bucket/1.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										세탁30L/10000원<br> <span><input type="radio"
											name="proId" value="1"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/2.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										셔츠/일반셔츠/2000원<br> <span><input type="radio"
											name="proId" value="2"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/3.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										이불/이불커버,홑이불/9000원<br> <span><input type="radio"
											name="proId" value="3"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/4.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										이불/일반이불,극세사패드/12000원<br> <span><input type="radio"
											name="proId" value="4"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/5.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										이불/극세사,이불,일반토퍼/18000원<br> <span><input
											type="radio" name="proId" value="5"></span>
									</p></td>

							</tr>
							<tr>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/6.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										이불/구스이불,양모이불,실크이불/23000원<br> <span><input
											type="radio" name="proId" value="6"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/7.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										이불/구스토퍼/30000원<br> <span><input type="radio"
											name="proId" value="7"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/8.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										불/구스베개/12000원<br> <span><input type="radio"
											name="proId" value="8"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/9.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										이불/아동이불,무릎담요/7000원<br> <span><input type="radio"
											name="proId" value="9"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/10.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										잡화/커튼/15000원<br> <span><input type="radio"
											name="proId" value="10"></span>
									</p></td>
							</tr>
							<tr>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/11.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										잡화/암막/25000원<br> <span><input type="radio"
											name="proId" value="11"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/12.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										러그,카펫/18000원<br> <span><input type="radio"
											name="proId" value="12"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/13.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										잡화/베개커버/3500원<br> <span><input type="radio"
											name="proId" value="13"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/14.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										잡화/발매트/5000원<br> <span><input type="radio"
											name="proId" value="14"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/15.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										잡화/일반모자/4000원<br> <span><input type="radio"
											name="proId" value="15"></span>
									</p></td>
							</tr>
							<tr>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/16.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										잡화/캡모자/6000원<br> <span><input type="radio"
											name="proId" value="16"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/17.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										스카프,목도리/4000원<br> <span><input type="radio"
											name="proId" value="17"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/18.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										장갑/4000원<br> <span><input type="radio"
											name="proId" value="18"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/19.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										숄/8000원<br> <span><input type="radio" name="proId"
											value="19"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/20.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										넥타이/2500원<br> <span><input type="radio"
											name="proId" value="20"></span>
									</p></td>
							</tr>

							<tr>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/21.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										수영복/6000원<br> <span><input type="radio"
											name="proId" value="21"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/22.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										스키복(상의)/15000원<br> <span><input type="radio"
											name="proId" value="22"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/23.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										스키복(하의)/10000원<br> <span><input type="radio"
											name="proId" value="23"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/24.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										에코백/3500원<br> <span><input type="radio"
											name="proId" value="24"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/25.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										인형/7000원<br> <span><input type="radio"
											name="proId" value="25"></span>
									</p></td>
							</tr>

							<tr>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/26.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										모직,양모양말/3000원<br> <span><input type="radio"
											name="proId" value="26"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/27.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										일반운동화/6500원<br> <span><input type="radio"
											name="proId" value="27"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/28.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										세무,가죽운동화/8500원<br> <span><input type="radio"
											name="proId" value="28"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/29.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										로퍼/11000원<br> <span><input type="radio"
											name="proId" value="29"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/30.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										농구화,축구화/9000원<br> <span><input type="radio"
											name="proId" value="30"></span>
									</p></td>
							</tr>

							<tr>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/31.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										골프화,등산화/11000원<br> <span><input type="radio"
											name="proId" value="31"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/32.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										아동신발/5500원<br> <span><input type="radio"
											name="proId" value="32"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/33.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										명품운동화/20000원<br> <span><input type="radio"
											name="proId" value="33"></span>
									</p></td>
								<td></td>
								<td></td>
							</tr>
						</table>


						<ul class="res-ul-1">
							<li>
								<h2 align="center" size="50%">드라이크리닝상품</h2>
							</li>
						</ul>
						<table class="res-table">
							<tr>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/34.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										정장/상의/5000원<br> <span><input type="radio"
											name="proId" value="34"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/35.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										정장/하의/4000원<br> <span><input type="radio"
											name="proId" value="35"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/36.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										정장/조끼/3000원<br> <span><input type="radio"
											name="proId" value="36"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/37.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										정장/원피스/6000원<br> <span><input type="radio"
											name="proId" value="37"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/38.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										상의/티셔츠/4000원<br> <span><input type="radio"
											name="proId" value="38"></span>
									</p></td>
							<tr>
							<tr>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/39.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										상의/블라우스/4500원<br> <span><input type="radio"
											name="proId" value="39"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/40.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										상의/후드티,맨투맨/4500원<br> <span><input type="radio"
											name="proId" value="40"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/41.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										상의/니트,스웨터/5000원<br> <span><input type="radio"
											name="proId" value="41"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/42.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										상의/가디건/6000원<br> <span><input type="radio"
											name="proId" value="42"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/43.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										상의/롱가디건/7500원<br> <span><input type="radio"
											name="proId" value="43"></span>
									</p></td>
							<tr>
							<tr>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/44.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										하의/바지/4500원<br> <span><input type="radio"
											name="proId" value="44"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/45.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										하의/스커트/4500원<br> <span><input type="radio"
											name="proId" value="45"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/46.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										하의/점프수트/9000원<br> <span><input type="radio"
											name="proId" value="46"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/47.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										하의/인조가죽/세무/8500원<br> <span><input type="radio"
											name="proId" value="47"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/48.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										아우터/점퍼/6500원<br> <span><input type="radio"
											name="proId" value="48"></span>
									</p></td>
							<tr>
							<tr>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/49.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										아우터/재킷/7500원<br> <span><input type="radio"
											name="proId" value="49"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/50.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										아우터/패딩/10000원<br> <span><input type="radio"
											name="proId" value="50"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/51.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										아우터/다운패딩/15000원<br> <span><input type="radio"
											name="proId" value="51"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/52.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										아우터/롱패딩/18000원<br> <span><input type="radio"
											name="proId" value="52"></span>
									</p></td>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/53.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										아우터/프리미엄패딩/25000원<br> <span><input type="radio"
											name="proId" value="53"></span>
									</p></td>
							<tr>
								<td style="width: 13em;"><img
									src="${path}/resources/images/bucket/54.JPG" alt=""
									style="max-width: 100%; height: auto;">
									<p>
										아우터/패딩조끼/7000원<br> <span><input type="radio"
											name="proId" value="54"></span>
									</p></td>
							</tr>

						</table>

						<ul class="res-ul-1">
							<li align="center">
								<h2 align="center" size="50%">수량선택</h2>
								<P>
									수량을 선택하세요 <span>&nbsp;<select name="resNum">
											<option value="1">1</option>
											<option value="2">2</option>
											<option value="3">3</option>
											<option value="4">4</option>
											<option value="5">5</option>
											<option value="6">6</option>
											<option value="7">7</option>
											<option value="8">8</option>
											<option value="9">9</option>
											<option value="10">10</option>
									</select></span> &nbsp; <input type="submit" id="inbucket" value="장바구니 담기"
										onclick="return bucketSuccess()">
								</P>
							</li>
						</ul>
					</div>
				</div>
			</form>
			<div id="tab-2" class="tab-content">
				<div class="row no-collapse-1">
					<ul class="res-ul-1">
						<li align="center">
							<h2 align="center" size="50%">상품가격 상세</h2>
						</li>
					</ul>
					<table class="product-bucket-table">
						<tr>
							<th>구분</th>
							<th>분류</th>
							<th>서비스 상품 명</th>
							<th>가격</th>
						</tr>
						<c:forEach var="product" items="${productList }">
							<tr>
								<td>${product.proId }</td>
								<td>${product.proType }</td>
								<td>${product.proName }</td>
								<td>${product.proPrice }</td>
							</tr>
						</c:forEach>
					</table>

				</div>
			</div>
		</div>
		<br>
	</div>
	<center>
		<input type="button" value="창닫기" id="inbucket"
			onclick="javascript:self.close()"></a>
	</center>
	<br>
	<br>
</body>
</html>