<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<%

String adminName = (String) session.getAttribute("loginUser_name");


%>
</head>
<body class="no-sidebar">

	<div id="main" class="wrapper style1">
		<div class="container">
			<h3 id="notice_text">건의사항 & 불만족 신고 답변 작성</h3>
			<form action="board_sug_reply.do" method="post">
				<input type="hidden" name="bId" value="${dto.bId}"> <input
					type="hidden" name="bGroup" value="${dto.bGroup}"> <input
					type="hidden" name="bStep" value="${dto.bStep}"> <input
					type="hidden" name="bIndent" value="${dto.bIndent}">
				<table ahttp://localhost:8181/test0709/board_sug.dolign="center" id="content-table">
					<tr>
						<td>번호</td>
						<td>${dto.bId}</td>
					</tr>
					<tr>
						<td>조회수</td>
						<td>${dto.bHit}</td>
					</tr>
					<tr>
						<td>이름</td>
						<td><%=adminName%></td>
					</tr>
					<tr>
						<td>제목</td>
						<td><input type="text" name="bTitle"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea rows="10" name="bContent"></textarea></td>
					</tr>


				</table>
				<input type="submit" id="listbutton" value="답변"> <a
					href="board_sug.do"><button type="button" id="listbutton">목록</button></a>
			</form>
		</div>
	</div>
	</div>
	</div>
	</div>
</body>
<%@ include file="../footer.jsp"%>