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
			<h3 id="notice_text">건의사항 & 불만족 신고 답변</h3>
			<form action="B_Sug_ModifyUpdate" method="post">
				<input type="hidden" name="bId" value="${content_view.bId}">
				<table align="center" id="content-table">
					<tr>
						<td>번호</td>
						<td>${content_view.bId}</td>
					</tr>
					<tr>
						<td>히트</td>
						<td>${content_view.bHit}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="bName"
							value="${content_view.bName}">></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="bTitle"
							value="${content_view.bTitle}"></td>
					</tr>
					<tr>
						<td style="border-right: 1px solid lightgray; ">내용</td>
						<td><textarea rows="10" name="bContent">${content_view.bContent}</textarea></td>
					</tr>
					<tr>
						<td>
							<c:choose>
								<c:when test = "${empty dto.bSugFile}">
									<img src = "">
								</c:when>
								<c:otherwise>
									<img src = "image/${dto.bSugFile}">
								</c:otherwise>
							</c:choose>
						</td>
					</tr>
				</table>
				<input type="submit" id="listbutton" value="수정"> <a
					href="board_sug.do"><button type="button" id="listbutton">목록</button></a>&nbsp;&nbsp;
				<a href="delete.do?bId=${content_view.bId}"><button
						type="button" id="listbutton">삭제</button></a> &nbsp;&nbsp; <a
					href="board_sug_reply_view.do?bId=${content_view.bId}"><button
						type="button" id="listbutton">답변</button></a>
			</form>
		</div>
	</div>
</body>
<%@ include file="../footer.jsp"%>