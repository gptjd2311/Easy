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
				<form action="reserve_admin_update" method="post" name="frm">
					<section>
						<header class="major">
							<h2>회원 예약 관리</h2>
						</header>
						<input type="hidden" name="resId" value="${list.resId}">
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
								<td><input type="text" name="proId" value="${list.proId}"></td>
								<th>상품타입</th>
								<td>상품번호를 선택하세요</td>
								<th>상품명</th>
								<td>상품번호를 선택하세요</td>
							</tr>
							<tr class="admin-view-bucket-table-tr">
								<th>갯수</th>
								<td><input type="text" name="resNum" value="${list.resNum}"></td>
								<th>총금액</th>
								<td>총금액은 자동 계산됩니다.</td>
								<th>결제여부</th>
								<td>${list.resPay}</td>
							</tr>
							<tr class="admin-view-bucket-table-tr">
								<th>예약상황</th>
								<td><input type="text" name="resData"
									value="${list.resData}"></td>
								<th>공백</th>
								<td></td>
								<th>공백</th>
								<td></td>
							</tr>
						</table>
					</section>
					<div>
						<P>상품리스트</P>
						<select name="proId" id="res-ul-3-sel">
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
						</select>
					</div>
					<div id="mypageres_cen">
						<input type="submit" value="예약 수정" id="btn_global_mypageres">
						<input type="reset" id="btn_global_mypageres" value="다시 작성">
						<input type="button" value="예약 목록" id="btn_global_mypageres"
							onclick="location.href='reserve_listAll'">
					</div>
				</form>
			</section>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>