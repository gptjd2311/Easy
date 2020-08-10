<%@page import="org.omg.PortableInterceptor.ForwardRequest"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
<script type="text/javascript" src="${path}/resources/js/jquery.dropotron.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/skel.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/skel-layers.min.js"></script>
<script type="text/javascript" src="${path}/resources/js/init.js" ></script>

<script type="text/javascript" src="${path}/resources/js/post.js"></script>

<script type="text/javascript" src="${path}/resources/js/member.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" />
<script src="https://t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="${path}/resources/jquery/jquery-3.3.1.min.js"></script>
<script src="http://code.jquery.com/jquery-1.10.1.js"></script>

</head>
<%
	String id = (String) session.getAttribute("loginUser");
	String admin = (String) session.getAttribute("loginAdmin");
	String pwd = (String) session.getAttribute("loginAdmin");

while (true) {
	if(id == null && admin == null){
		response.sendRedirect("login.do");
		break;
	}else if (id != null && admin == null) {
		break;
	}else if (admin != null && id == null) {
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

			<div id="tab-1" class="tab-content current">
				<div class="row no-collapse-1">
					<ul class="res-ul-1">
						<li>
							<h2 align="center" size="80%">장바구니담기</h2>
						</li>
					</ul>
					<ul class="res-ul-2">

						<li><img src="${path}/resources/images/product_3.JPG"
							style="max-width: 100%; height: auto !important"></li>
					</ul>
					<form action="reserve_insert" method="post" name="frm">
						<input type="hidden" name="command" value="reserve_insert">
						<input type="hidden" name="memId" value=<%=id%>>
						<input type="hidden" name="memPwd" value=<%=pwd%>>
						<ul class="res-ul-3">
							<li><P>옵션을 선택하세요</P> <select name="proId" id="res-ul-3-sel">
									<option value="1">1/세탁-물빨래/세탁30L/10000</option>
									<option value="2">2/세탁-셔츠/일반셔츠/2000</option>
									<option value="3">3/세탁-이불/이불커버,홑이불/9000</option>
									<option value="4">4/세탁-이불/일반이불,극세사패드/12000</option>
									<option value="5">5/세탁-이불/극세사,이불,일반토퍼/18000</option>
									<option value="6">6/세탁-이불/구스이불,양모이불,실크이불/23000</option>
									<option value="7">7/세탁-이불/구스토퍼/30000</option>
									<option value="8">8/세탁-이불/구스베개/12000</option>
									<option value="9">9/세탁-이불/아동이불,무릎담요/7000</option>
									<option value="10">10/세탁-잡화/커튼/15000</option>
									<option value="11">11/세탁-잡화/암막/25000</option>
									<option value="12">12/세탁-잡화/러그,카펫/18000</option>
									<option value="13">13/세탁-잡화/베개커버/3500</option>
									<option value="14">14/세탁-잡화/발매트/5000</option>
									<option value="15">15/세탁-잡화/일반모자/4000</option>
									<option value="16">16/세탁-잡화/캡모자/6000</option>
									<option value="17">17/세탁-잡화/스카프,목도리/4000</option>
									<option value="18">18/세탁-잡화/장갑/4000</option>
									<option value="19">19/세탁-잡화/숄/8000</option>
									<option value="20">20/세탁-잡화/넥타이/2500</option>
									<option value="21">21/세탁-잡화/수영복/6000</option>
									<option value="22">22/세탁-잡화/스키복(상의)/15000</option>
									<option value="23">23/세탁-잡화/스키복(하의)/10000</option>
									<option value="24">24/세탁-잡화/에코백/3500</option>
									<option value="25">25/세탁-잡화/인형/7000</option>
									<option value="26">26/세탁-잡화/모직,양모양말/3000</option>
									<option value="27">27/세탁-잡화/일반운동화/6500</option>
									<option value="28">28/세탁-잡화/세무,가죽운동화/8500</option>
									<option value="29">29/세탁-잡화/로퍼/11000</option>
									<option value="30">30/세탁-잡화/농구화,축구화/9000</option>
									<option value="31">31/세탁-잡화/골프화,등산화/11000</option>
									<option value="32">32/세탁-잡화/아동신발/5500</option>
									<option value="33">33/세탁-잡화/명품운동화/20000</option>
									<option value="34">34/드라이크리닝-정장/상의/5000</option>
									<option value="35">35/드라이크리닝-정장/하의/4000</option>
									<option value="36">36/드라이크리닝-정장/조끼/3000</option>
									<option value="37">37/드라이크리닝-정장/원피스/6000</option>
									<option value="38">38/드라이크리닝-상의/티셔츠/4000</option>
									<option value="39">39/드라이크리닝-상의/블라우스/4500</option>
									<option value="40">40/드라이크리닝-상의/후드티,맨투맨/4500</option>
									<option value="41">41/드라이크리닝-상의/니트,스웨터/5000</option>
									<option value="42">42/드라이크리닝-상의/가디건/6000</option>
									<option value="43">43/드라이크리닝-상의/롱가디건/7500</option>
									<option value="44">44/드라이크리닝-하의/바지/4500</option>
									<option value="45">45/드라이크리닝-하의/스커트/4500</option>
									<option value="46">46/드라이크리닝-하의/점프수트/9000</option>
									<option value="47">47/드라이크리닝-하의/인조가죽/세무/8500</option>
									<option value="48">48/드라이크리닝-아우터/점퍼/6500</option>
									<option value="49">49/드라이크리닝-아우터/재킷/7500</option>
									<option value="50">50/드라이크리닝-아우터/패딩/10000</option>
									<option value="51">51/드라이크리닝-아우터/다운패딩/15000</option>
									<option value="52">52/드라이크리닝-아우터/롱패딩/18000</option>
									<option value="53">53/드라이크리닝-아우터/프리미엄패딩/25000</option>
									<option value="54">54/드라이크리닝-아우터/패딩조끼/7000</option>
							</select></li>
							<br>
							<br>
							<li><P>
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
									</select></span>
								</P></li>
						</ul>
						<ul>
							<center>
								<input type="submit" id="inbucket" value="장바구니 담기" onclick="return bucketSuccess()">
							</center>
						</ul>
					</form>
				</div>
			</div>
			<div id="tab-2" class="tab-content">
				<div class="row no-collapse-1">
					<center>
						<h2>상품가격 상세</h2>
					</center>
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
		<input type="button" value="창닫기" id="mypage-bucket-pay-btn2" onclick="javascript:self.close()"></a>
	</center>
</body>
</html>