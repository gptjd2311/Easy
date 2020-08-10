<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body class="no-sidebar">

	<div id="main" class="wrapper style1">
		<div class="container">
			<h3 id="notice_text">건의사항 & 불만족 신고 게시글</h3>
			<table align="center" id="content-table">
				<tr>
					<td>이름</td>
					<td>${dto.bName }</td>
				</tr>
				<tr>
					<td>번호</td>
					<td>${dto.bId }</td>
				</tr>
				<tr>
					<td>날짜</td>
					<td>${dto.bDate }</td>
				</tr>
				<tr>
					<td>조회수</td>
					<td>${dto.bHit }</td>
				</tr>
				<tr>
					<td>제목</td>
					<td>${dto.bTitle }</td>
				</tr>
				<tr>
					<td>내용</td>
					<td>${dto.bContent }</td>
				</tr>
			</table>
			<!--  삭제,수정,목록보기  -->
			<a
				href="board_sug_reply_view.do?bId=${dto.bId }&page=${bSearchDto.currentPageNum }
											&pageDataCount=${bSearchDto.pageDataCount }
											&searchCol=${bSearchDto.searchCol }
											&searchVal=${bSearchDto.searchVal }"><button
					type="button" id="listbutton">답글</button></a> <a
				href="delete.do?bId=${dto.bId }&page=${bSearchDto.currentPageNum }
											&pageDataCount=${bSearchDto.pageDataCount }
											&searchCol=${bSearchDto.searchCol }
											&searchVal=${bSearchDto.searchVal }"><button
					type="button" id="listbutton">삭제</button></a> <a
				href="board_sug_modify_view.do?bId=${dto.bId }&page=${bSearchDto.currentPageNum }
											&pageDataCount=${bSearchDto.pageDataCount }
											&searchCol=${bSearchDto.searchCol }
											&searchVal=${bSearchDto.searchVal }"><button
					type="button" id="listbutton">수정</button></a> <a
				href="board_sug.do?page=${bSearchDto.currentPageNum }
											&pageDataCount=${bSearchDto.pageDataCount }
											&searchCol=${bSearchDto.searchCol }
											&searchVal=${bSearchDto.searchVal }"><button
					type="button" id="listbutton">목록</button></a>
		</div>
	</div>
	</div>
	</div>
	</div>
</body>
<%@ include file="../footer.jsp"%>