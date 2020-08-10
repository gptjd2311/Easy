<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>

	<!-- Main -->
	<div id="main" class="wrapper style1">
		<div class="container">
			<div class="row">

				<!-- Sidebar -->
				<div id="sidebar" class="4u sidebar">
					<section>
						<header class="major">
							<h2>Mypage</h2>
						</header>
						<div class="row half">
							<section class="6u">
								<ul class="default">
									<li><a href="mypage_mod.html">개인정보 수정</a></li>
									<li><a href="mypage_res.html">나의 예약</a></li>
									<li><a href="mypage_bucket.html">장바구니</a></li>
								</ul>
							</section>
						</div>
					</section>

				</div>
				<!-- Content -->
				<div id="content" class="9u">
					<section>
						<header class="major">
							<center>
							<h3 >아이디와 비밀번호를 다시한번 입력해주세요.</h3>
							</center>
							<form>

								<fieldset>
									<td>
										<center>
											<input type="text" id="user_id" placeholder="아이디"
												style="width:500px;height:50px">
										</center>
										<br>
										<center>
											<input type="password" id="user_pw" placeholder="패스워드"
												style="width:500px;height:50px">

										</center>
								</fieldset>
								<br>
								<fieldset>
									<center>
										<input type="submit" style="width: 22.5%; height: 50px;"
											class="button-mypage-mod-mod" value="회원탈퇴">
									</center>
								</fieldset>


							</form>
						</header>
						<table class="table-mypage-mod-table">


							<!-- Sidebar -->


				</div>
			</div>
		</div>
<%@ include file="../footer.jsp"%>