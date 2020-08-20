<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<% 
	String id = (String) session.getAttribute("loginUser");
	String admin = (String) session.getAttribute("loginAdmin");

while (true) {
	if (admin != null && id == null) {
		break;
	} if (id != null && admin == null) {
		break;
	} else {
		response.sendRedirect("login");
	}
}
%>

<body class="no-sidebar">
	<div id="main" class="wrapper style1">
 		<div class="container">
			<h3 id="notice_text">건의사항 & 불만족 신고 게시글 작성</h3>
	<form action="board_sug_write" method="post" name="frm" enctype="multipart/form-data">
				<table align="center" id="content-table">

					<tr>
						<td>아이디</td>
						<td><input type="hidden" name="bName" value="${loginUser}">${loginUser}</td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="bTitle" size="50"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="bContent" rows="10"></textarea></td>
					</tr>
					<tr>
						<th>사진</th>
						<td><input type = "file" name = "bSugFile"></td>
					</tr> 
				</table>
				<input type="submit" id="listbutton" value="입력">
				<a href="board_sug"><button type="button" id="listbutton">목록</button></a>
			</form>
		</div>
	</div>
	</div>
	</div>
	</div>
</body>
<%@ include file="../footer.jsp"%>