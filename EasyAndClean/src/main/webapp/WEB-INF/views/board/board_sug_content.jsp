<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="path" value="${pageContext.request.contextPath}" />

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
			response.sendRedirect("login");
		}
	}
%>

<body class="no-sidebar">
	<form method="post" action="board_sug" enctype="multipart/form-data"
		name="frm">
		<input type="hidden" name="page" value="${bSearchDto.currentPageNum}" />
		<input type="hidden" name="pageDataCount"
			value="${bSearchDto.pageDataCount}" /> <input type="hidden"
			name="nonmakeimg" value="${dto.bSugFile}">
		<div id="main" class="wrapper style1">
			<div class="container">
				<h3 id="notice_text">건의사항 & 불만족 신고 게시글</h3>
				<table align="center" id="content-table">
					<tr>
						<td>이름</td>
						<td>${dto.bName}<input type="hidden" name="memId"
							value=<%=id%>></td>
						<td>번호</td>
						<td>${dto.bId }</td>
						<td>날짜</td>
						<td>${dto.bDate }</td>
						<td>조회수</td>
						<td>${dto.bHit }</td>
					</tr>
					<tr>
						<td>제목</td>
						<td colspan=7;>${dto.bTitle }</td>
					</tr>
					<tr>
						<td style="border-right: 1px solid lightgray;">내용</td>
						<td colspan=7;>${dto.bContent }</td>
					</tr>
					<tr>
						<td style="vertical-align: middle;">사진</td>
						<td colspan=7;><c:choose>
								<c:when test="${empty dto.bSugFile}">
									<img src="">
								</c:when>
								<c:otherwise>
									<img src="/img/${dto.bSugFile}">
								</c:otherwise>
							</c:choose></td>
					</tr>
				</table>
				<!--  삭제,수정,목록보기  -->
				<c:choose>
					<c:when test="${!empty loginAdmin}">
						<a
							href="board_sug_reply_form?bId=${dto.bId }&page=${bSearchDto.currentPageNum }
											&pageDataCount=${bSearchDto.pageDataCount }
											&searchCol=${bSearchDto.searchCol }
											&searchVal=${bSearchDto.searchVal }"><button
								type="button" id="listbutton">답글</button></a>
						<a
							href="board_sug_delete?bId=${dto.bId}&page=${bSearchDto.currentPageNum }
											&pageDataCount=${bSearchDto.pageDataCount }
											&searchCol=${bSearchDto.searchCol }
											&searchVal=${bSearchDto.searchVal }"><button
								type="button" id="listbutton">삭제</button></a>
					</c:when>
				</c:choose>
				<c:set var="bName" value="${dto.bName}" />
				<c:if test="${loginUser == bName}">
					<a
						href="board_sug_modify_view?bId=${dto.bId }&bName=${dto.bName}&page=${bSearchDto.currentPageNum }
											&pageDataCount=${bSearchDto.pageDataCount }
											&searchCol=${bSearchDto.searchCol }
											&searchVal=${bSearchDto.searchVal }"><button
							type="button" id="listbutton">수정</button></a>
					<a
						href="board_sug_delete?bId=${dto.bId }&page=${bSearchDto.currentPageNum }
											&pageDataCount=${bSearchDto.pageDataCount }
											&searchCol=${bSearchDto.searchCol }
											&searchVal=${bSearchDto.searchVal }"><button
							type="button" id="listbutton">삭제</button></a>

				</c:if>
				<a
					href="board_sug?page=${bSearchDto.currentPageNum }
											&pageDataCount=${bSearchDto.pageDataCount }
											&searchCol=${bSearchDto.searchCol }
											&searchVal=${bSearchDto.searchVal }"><button
						type="button" id="listbutton">목록</button></a>
			</div>
		</div>
	</form>
</body>
<%@ include file="../footer.jsp"%>