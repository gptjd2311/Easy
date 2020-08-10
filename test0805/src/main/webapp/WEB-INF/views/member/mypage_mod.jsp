<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

<head>

<%
	String id = (String) session.getAttribute("loginUser");
	String admin = (String) session.getAttribute("loginAdmin");
	String pwd = (String) session.getAttribute("loginAdmin");

	while (true) {
		if (id == null && admin == null) {
			response.sendRedirect("login.do");
			break;
		} else if (id != null && admin == null) {
			break;
		} else if (admin != null && id == null) {
			break;
		}
	}
%>

</head>
<!DOCTYPE HTML>
<!-- Main -->
<div id="main" class="wrapper style1">
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

			<!-- Content -->
			<div id="content" class="9u">
				<section>
					<header class="major">
						<h2 id=>개인정보 수정</h2>
					</header>
					<article>
						<fieldset>
							<div class="newreg">
								<form action="MemberServlet" method="post" name="frm">
									<input type="hidden" name="command" value="member_update">
									<input type="hidden" name="ch1" value=<%=id%>> <input
										type="hidden" name="ch2" value=<%=admin%>> <input
										type="hidden" name="memNum" value="${member_mod.memNum}">
									<input type="hidden" name="memGen" value="${member_mod.memGen}">
									<input type="hidden" name="memId" value="${member_mod.memId}">
									<input type="hidden" name="memType"
										value="${member_mod.memType}">
									<table>
										<tr>
											<th>비밀번호</th>
											<td><input id="join-password" type="password"
												name="memPwd" placeholder="영문/숫자포함 6자 이상"></td>
										</tr>
										<tr>
											<th>비밀번호확인</th>
											<td><input id="join-password-check" type="password"
												name="mempwd_check"></td>
										</tr>
										<tr>
											<th>이름</th>
											<td><input id="join-name" type="text" name="memName"
												value="${member_mod.memName}"></td>
										</tr>
										<tr>
											<th>생년월일</th>
											<td><select id="join-birth" name="user_birth_year"
												value="${member_mod.user_birth_year}">
													<option value="1901" selected>1901</option>
													<option value="1902" selected>1902</option>
													<option value="1903" selected>1903</option>
													<option value="1904" selected>1904</option>
													<option value="1905" selected>1905</option>
													<option value="1906" selected>1906</option>
													<option value="1907" selected>1907</option>
													<option value="1908" selected>1908</option>
													<option value="1909" selected>1909</option>
													<option value="1910" selected>1910</option>
													<option value="1911" selected>1911</option>
													<option value="1912" selected>1912</option>
													<option value="1913" selected>1913</option>
													<option value="1914" selected>1914</option>
													<option value="1915" selected>1915</option>
													<option value="1916" selected>1916</option>
													<option value="1917" selected>1917</option>
													<option value="1918" selected>1918</option>
													<option value="1919" selected>1919</option>
													<option value="1920" selected>1920</option>
													<option value="1921" selected>1921</option>
													<option value="1922" selected>1922</option>
													<option value="1923" selected>1923</option>
													<option value="1924" selected>1924</option>
													<option value="1925" selected>1925</option>
													<option value="1926" selected>1926</option>
													<option value="1927" selected>1927</option>

													<option value="1928" selected>1928</option>
													<option value="1929" selected>1929</option>
													<option value="1930" selected>1930</option>
													<option value="1931" selected>1931</option>
													<option value="1932" selected>1932</option>
													<option value="1933" selected>1933</option>
													<option value="1934" selected>1934</option>
													<option value="1935" selected>1935</option>
													<option value="1936" selected>1936</option>
													<option value="1937" selected>1937</option>
													<option value="1938" selected>1938</option>
													<option value="1939" selected>1939</option>
													<option value="1940" selected>1940</option>

													<option value="1941" selected>1941</option>
													<option value="1942" selected>1942</option>
													<option value="1943" selected>1943</option>
													<option value="1944" selected>1944</option>
													<option value="1945" selected>1945</option>
													<option value="1946" selected>1946</option>
													<option value="1947" selected>1947</option>
													<option value="1948" selected>1948</option>
													<option value="1949" selected>1949</option>
													<option value="1950" selected>1950</option>
													<option value="1951" selected>1951</option>
													<option value="1952" selected>1952</option>
													<option value="1953" selected>1953</option>
													<option value="1954" selected>1954</option>
													<option value="1955" selected>1955</option>
													<option value="1956" selected>1956</option>
													<option value="1957" selected>1957</option>
													<option value="1958" selected>1958</option>
													<option value="1959" selected>1959</option>
													<option value="1960" selected>1960</option>
													<option value="1961" selected>1961</option>
													<option value="1962" selected>1962</option>
													<option value="1963" selected>1963</option>
													<option value="1964" selected>1964</option>
													<option value="1965" selected>1965</option>
													<option value="1966" selected>1966</option>
													<option value="1967" selected>1967</option>
													<option value="1968" selected>1968</option>
													<option value="1969" selected>1969</option>
													<option value="1970" selected>1970</option>
													<option value="1971" selected>1971</option>
													<option value="1972" selected>1972</option>
													<option value="1973" selected>1973</option>
													<option value="1974" selected>1974</option>
													<option value="1975" selected>1975</option>
													<option value="1976" selected>1976</option>
													<option value="1977" selected>1977</option>
													<option value="1978" selected>1978</option>
													<option value="1979" selected>1979</option>
													<option value="1980" selected>1980</option>
													<option value="1981" selected>1981</option>
													<option value="1982" selected>1982</option>
													<option value="1983" selected>1983</option>
													<option value="1984" selected>1984</option>
													<option value="1985" selected>1985</option>
													<option value="1986" selected>1986</option>
													<option value="1987" selected>1987</option>
													<option value="1988" selected>1988</option>
													<option value="1989" selected>1989</option>
													<option value="1990" selected>1990</option>
													<option value="1991" selected>1991</option>
													<option value="1992" selected>1992</option>
													<option value="1993" selected>1993</option>
													<option value="1994" selected>1994</option>
													<option value="1995" selected>1995</option>
													<option value="1996" selected>1996</option>
													<option value="1997" selected>1997</option>
													<option value="1998" selected>1998</option>
													<option value="1999" selected>1999</option>
													<option value="2001" selected>2001</option>
													<option value="2002" selected>2002</option>
													<option value="2003" selected>2003</option>
													<option value="2004" selected>2004</option>
													<option value="2005" selected>2005</option>
													<option value="2006" selected>2006</option>
													<option value="2007" selected>2007</option>
													<option value="2008" selected>2008</option>
													<option value="2009" selected>2009</option>
													<option value="2010" selected>2010</option>
													<option value="2011" selected>2011</option>
													<option value="2012" selected>2012</option>
													<option value="2013" selected>2013</option>
													<option value="2014" selected>2014</option>
													<option value="2015" selected>2015</option>
													<option value="2016" selected>2016</option>
													<option value="2017" selected>2017</option>
													<option value="2018" selected>2018</option>
													<option value="2019" selected>2019</option>


											</select> 년 <select name="user_birth_month"
												value="${member_mod.user_birth_month}">
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
													<option value="11">11</option>
													<option value="12">12</option>
											</select> 월 <select name="user_birth_day"
												value="${member_mod.user_birth_day}">
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
													<option value="11">11</option>
													<option value="12">12</option>
													<option value="13">13</option>
													<option value="14">14</option>
													<option value="15">15</option>
													<option value="16">16</option>
													<option value="17">17</option>
													<option value="18">18</option>
													<option value="19">19</option>
													<option value="20">20</option>
													<option value="21">21</option>
													<option value="22">22</option>
													<option value="23">23</option>
													<option value="24">24</option>
													<option value="25">25</option>
													<option value="26">26</option>
													<option value="27">27</option>
													<option value="28">28</option>
													<option value="29">29</option>
													<option value="30">30</option>
													<option value="31">31</option>
											</select> 일</td>
										</tr>
										<tr>
											<th>이메일</th>
											<td><input id="join-name" type='text' name="memEmail"
												value="${member_mod.memEmail}"></td>
										</tr>
										<tr>
											<th>연락처</th>
											<td><input id="join-name" type="text" name="memPhone"
												value="${member_mod.memPhone}" title="전화번호"></td>

										</tr>
										<tr>
											<th>우편번호</th>
											<td style="width: 13.2em; height: 1.8em;"><input
												type="text" id="sample6_postcode" class="join-id"
												placeholder="우편번호" name="memAdd_1"
												value="${member_mod.memAdd_1}">
											<td>&nbsp;
											<td><input type="button" id="id-check"
												onclick="sample6_execDaumPostcode()" class="join-id"
												value="우편번호 찾기"></td>
										</tr>
										<tr>
											<th>주소</th>
											<td><input type="text" id="sample6_address"
												class="join-id" name="memAdd_2" placeholder="주소"
												value="${member_mod.memAdd_2}"></td>
										</tr>
										<tr>
											<th>상세주소</th>
											<td><input type="text" id="sample6_detailAddress"
												name="memAdd_3" class="join-id" placeholder="상세주소"
												value="${member_mod.memAdd_3}"></td>
											<td><input type="hidden" id="sample6_extraAddress"
												class="join-id" placeholder="참고항목"></td>

										</tr>
									</table>
									<center>
										<input id="join-button" type="submit" value="회원 정보 수정"
											onclick="return modCheck()">

									</center>
								</form>
							</div>
						</fieldset>
					</article>
				</section>
			</div>
		</div>
	</div>
</div>


<%@ include file="../footer.jsp"%>