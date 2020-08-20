<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../header.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<body class="no-sidebar">

	<div id="main" class="wrapper style1">
		<div class="container">
		
			<h3 id="notice_text">건의사항 & 불만족 신고</h3>
			<table align="center" id="content-table">
				<tr>
					<td colspan="5">
						<form action="board_sug" method="post">
							<div id="board_sug_search">
								검색 옵션 :&nbsp;<select id="boardSearch_select" name=searchCol>
									<option value="bTitle" selected="selected">제목</option>
									<option value="bName">작성자</option>
									<option value="bContent">내용</option>
								</select>&nbsp;검색 값 :&nbsp;<input type="text" name="searchVal"
									id="board_sug_search_text" value="${bSearchDto.searchVal}">
								<input type="submit" id="listbutton" value="검색">
							</div>
						</form>
					</td>
				</tr>
				<tr>
					<th>번호</th>
					<th>이름</th>
					<th>제목</th>
					<th>날짜</th>
					<th>조회수</th>
				</tr>
				<c:forEach items="${dtos}" var="dto">
					<tr>
						<td>${dto.bId}</td>
						<td>${dto.bName}</td>
						<td>
						
						<c:forEach begin="1" end="${dto.bIndent}">(답변)
						
						</c:forEach> <a
							href="board_sug_content_view?bId=${dto.bId}
							&bName=${ dto.bName }
							&page=${bSearchDto.currentPageNum}
							&pageDataCount=${bSearchDto.pageDataCount}">${dto.bTitle}</a>
						</td>
						<td>${dto.bDate}</td>
						<td>${dto.bHit}</td>
					</tr>
				</c:forEach>
				<tr>

					<td colspan="5"><a
						href="board_sug?page=${bSearchDto.firstPageNum}&pageDataCount=${bSearchDto.pageDataCount}&searchCol=${bSearchDto.searchCol}&searchVal=${bSearchDto.searchVal}">
							◀◀맨앞으로 </a> &nbsp;&nbsp; <a
						href="board_sug?page=${bSearchDto.prevPageNum}&pageDataCount=${bSearchDto.pageDataCount}&searchCol=${bSearchDto.searchCol}&searchVal=${bSearchDto.searchVal}">
							◀앞으로 </a> &nbsp;&nbsp; <c:forEach var="i"
							begin="${bSearchDto.startPageNum}" end="${bSearchDto.endPageNum}"
							step="1">

							<c:choose>
								<c:when test="${i eq bSearchDto.currentPageNum}">
									<a style="font-weight: bold; color: red"
										href="board_sug?page${i}&pageDataCount=${bSearchDto.pageDataCount}">${i }</a>&nbsp;&nbsp;
                 							 </c:when>
								<c:otherwise>
									<a
										href="board_sug?page=${i}&pageDataCount=${bSearchDto.pageDataCount}&searchCol=${bSearchDto.searchCol}&searchVal=${bSearchDto.searchVal}">${i}</a>&nbsp;&nbsp;
                  							</c:otherwise>
							</c:choose>
						</c:forEach> <a
						href="board_sug?page=${bSearchDto.nextPageNum}&pageDataCount=${bSearchDto.pageDataCount}&searchCol=${bSearchDto.searchCol}&searchVal=${bSearchDto.searchVal}">
							뒤로 ▶</a> &nbsp;&nbsp; <a
						href="board_sug?page=${bSearchDto.lastPageNum}&pageDataCount=${bSearchDto.pageDataCount}&searchCol=${bSearchDto.searchCol}&searchVal=${bSearchDto.searchVal}">
							맨뒤로 ▶▶ </a> &nbsp;&nbsp;</td>



				</tr>
			</table>
			<c:choose>
				<c:when test="${!empty loginUser}">
					<a href="board_sug_write_view"><button type="button"
							id="listbutton">작성</button></a>
				</c:when>
			</c:choose>
		</div>
	</div>

<%@ include file="../footer.jsp"%>