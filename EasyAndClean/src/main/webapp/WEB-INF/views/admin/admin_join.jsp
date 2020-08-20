<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>


<!DOCTYPE HTML>
<body class="no-sidebar">
	<!-- Main -->
	<div id="main" class="wrapper style1">
		<div id="mem-container">
			<section id="join-section">
				<header>
					<center>
						<h1 id="join-newmem">EASY AND CLEAN</h1>
						<h1 id="join-newmem">관리자계정 추가 페이지입니다.</h1>
					</center>
				</header>
				<article>
					<fieldset>
						<div class="newreg">
							<form action="admin_join" method="post" name="frm">
								<table>
									<tr>
										<th>아이디</th>
										<td><input id="join-id" type="text" name="memId"
											placeholder="영어와 숫자만 입력하세요"> <input type="hidden"
											name="reid" size="20">
										<td><input type="button" id="id-check" value="중복 체크"
											onclick="idCheck()"></td>
									</tr>
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
										<th>관리자 직책</th>
										<td><input id="join-name" type="text" name="memName"></td>
									</tr>
									<tr>
										<th id="join-gen">성별</th>
										<td><input type="radio" name="memGen" value="남성"
											checked="checked">남성 <input type="radio"
											name="memGen" value="여성"> 여성</td>

									</tr>
									<tr>
										<th>이메일</th>
										<td><input id="join-name" type='text' name="memEmail">
										</td>
									</tr>
									<tr>
										<th>사무실 전화번호</th>
										<td><input id="join-name" type="text" name="memPhone"
											title="전화번호"></td>
									</tr>
									<tr>

										<th></th>
										<td><input id="join-button" type="submit" value="회원 가입"
											onclick="return adminjoinCheck()"></td>
									</tr>
								</table>
							</form>
						</div>
					</fieldset>
				</article>
			</section>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>