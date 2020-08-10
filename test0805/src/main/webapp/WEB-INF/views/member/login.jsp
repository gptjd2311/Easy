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
				<center>
					<h1 id="board-text-1">EASY AND CLEAN</h1>
									<p>${message}</p>
				</center>

				<br> <br>
				<form action="postlogin" method="post" name="frm">
					<fieldset>
						<td>
							<center>
								<input type="text" name="memId" value="${memid}" id="user_id"
									placeholder="아이디" style="width: 500px; height: 50px">
							</center> <br>
							<center>
								<input type="password" name="memPwd" id="user_pw"
									placeholder="패스워드" style="width: 500px; height: 50px">

							</center>
					</fieldset>
					<fieldset>
						<center>
							<input type="submit" class="login-btn-1" value="로그인"
								onclick="return loginCheck()">
						</center>
					</fieldset>
				</form>

			</section>
		</div>
	</div>

	<%@ include file="../footer.jsp"%>
</body>

</html>