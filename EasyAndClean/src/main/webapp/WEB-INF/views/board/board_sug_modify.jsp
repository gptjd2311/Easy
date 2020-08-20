<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String id = (String) session.getAttribute("loginUser");
String memName = (String) session.getAttribute("loginUser_Name");
String admin = (String) session.getAttribute("loginAdmin");

while (true) {
	if (admin != null && id == null) {
		break;
	}
	if (id != null && admin == null) {
		break;
	} else {
		response.sendRedirect("login.do");
	}
}
%>
<body class="no-sidebar">

	<div id="main" class="wrapper style1">
		<div class="container">
			<h3 id="notice_text">건의사항 & 불만족 신고 게시글 수정</h3>
			<form action="board_sug_modify" method="post" name="frm" enctype="multipart/form-data">
				<input type="hidden" name=bId value="${dto.bId }" /> 
				<input type="hidden" name=page value="${bSearchDto.currentPageNum }" /> 
					<input type="hidden" name=pageDataCount value="${bSearchDto.pageDataCount }" />
					<input type="hidden" name = "nonmakeimg" value="${dto.bSugFile}">
				<table align="center" id="content-table">
					<tr>
						<td>이름</td>
						<td>${dto.bName}</td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name=bTitle value="${dto.bTitle }" /></td>

					</tr>
					<tr>
						<td>내용</td>
						<td><textarea rows=10 name=bContent>${dto.bContent}</textarea></td>
					</tr>
					<tr>
						<td colspan=2;>
							<c:choose>
								<c:when test = "${empty dto.bSugFile}">
									<img src = ".//images/MARK.jpg">
								</c:when>
								<c:otherwise>
									<img src = "image/${dto.bSugFile}">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
					<tr>
						<th>사진</th>
						<td><input type="file" name="bSugFile"></td>
					</tr>
				</table>
					<input type="submit" id="listbutton" value="수정">
					<a href="board_sug.do?page=${bSearchDto.currentPageNum}&pageDataCount=${bSearchDto.pageDataCount}">
					<button	type="button" id="listbutton">목록</button></a>
			</form>
		</div>
	</div>
</body>
<%@ include file="../footer.jsp"%>