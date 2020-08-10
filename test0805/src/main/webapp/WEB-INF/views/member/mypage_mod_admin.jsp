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
							<li><a href="MemberServlet?command=admin_update_form&memId=<%=id%>">개인정보	수정</a></li>
		
								<li><a
									href="ReserveServlet?command=reserve_list&memId=<%=id%>">나의예약</a></li>
								<li><a
									href="ReserveServlet?command=reserve_bucket&memId=<%=id%>">장바구니</a></li>
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
									<input type="hidden" name="command" value="admin_update">								
									<input type="hidden" name="memId" value="${member_mod.memId}">
	
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
											<th>성별</th>
											<td><input type="radio" name="memGen" value="남성"
											checked="checked">남성 <input type="radio"
											name="memGen" value="여성"> 여성</td>
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
									</table>
									<center>
										<input id="join-button" type="submit" value="관리자 정보 수정"
											onclick="return mypage_mod_pop()">
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