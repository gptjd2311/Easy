<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page
	import="javax.xml.parsers.*, org.w3c.dom.*, java.net.URL, org.xml.sax.InputSource, javax.xml.xpath.*"%>
<c:set var="path" value="${pageContext.request.contextPath}" />


<!-- 댓글 다는곳   -->
<form name="frm" method="post" action="BCommentInsert">
	<input type="hidden" name="page" value="${bSearchDto.currentPageNum}" />
	<input type="hidden" name="pageDataCount"
		value="${bSearchDto.pageDataCount}" /> <input type="hidden"
		name="bId" value="${dto.bId}" readonly />
	<table id="CommentTable">
		<tr id="tabcontent_head">
			<td style="border: 1px solid lightgray" colspan="2">
				<c:if test="${!empty loginUser}">
					<input type="hidden" name="NOTICE_COMMENT_ID" value=${loginUser }>&nbsp;&nbsp;아이디 : ${loginUser }
					</c:if> <c:if test="${!empty loginAdmin}">
					<input type="hidden" name="NOTICE_COMMENT_ID" value=${loginAdmin }>&nbsp;&nbsp;아이디 : ${loginAdmin }
					</c:if> <c:if test="${(loginAdmin==null)&&(loginUser==null)}">
					<input type="hidden" name="NOTICE_COMMENT_ID" value="guest">&nbsp;&nbsp;guest
					</c:if>
			</td>
		</tr>
		<tr>
			<c:if test="${!empty loginAdmin && empty loginUser}">
				<td colspan="5" style="border: 1px solid lightgray"><textarea
						cols="100" rows="5" name="NOTICE_COMMENT_CONTENT"
						style="border: none" placeholder="댓글을 입력하세요!"></textarea><input
					type="submit" id="listbutton" style="float: right;" value="댓글"
					onclick="return commCheck()"></td>
			</c:if>
			<c:if test="${empty loginAdmin && !empty loginUser}">
				<td colspan="5" style="border: 1px solid lightgray"><textarea
						cols="100" rows="5" name="NOTICE_COMMENT_CONTENT"
						style="border: none" placeholder="댓글을 입력하세요!"></textarea><input
					type="submit" id="listbutton" style="float: right;" value="댓글"
					onclick="return commCheck()"></td>
			</c:if>
		</tr>
		<tr>
			<td></td>
			<td></td>
		</tr>
	</table>
</form>
<!-- 댓글 보여주는 곳   -->
<c:choose>
	<c:when test="${empty bcommentDtoList}">
	</c:when>
	<c:otherwise>
		<div>
			<c:forEach items="${bcommentDtoList}" var="bcommentDtoList">
				<input type="hidden" value="${bcommentDtoList.NOTICE_COMMENT_NUM}"
					name="NOTICE_COMMENT_NUM">
				<table id="tabcontent">
					<tr id="comIndent">
						<c:forEach begin="1"
							end="${bcommentDtoList.NOTICE_COMMENT_INDENT}">
							<td rowspan="2">&nbsp;</td>
						</c:forEach>
						<td id="comContent">&nbsp;&nbsp;${bcommentDtoList.NOTICE_COMMENT_ID}
							&nbsp; : &nbsp;${bcommentDtoList.NOTICE_COMMENT_CONTENT}</td>

					</tr>
					<tr id="tabcontent_head">

						<td><img src="${path}/resources/images/personvec1.png">
							&nbsp;
							${bcommentDtoList.NOTICE_COMMENT_DATE} &nbsp; <!-- 댓글 창--></td>
						<td><input type="button" value="답글" id="listbutton"
							style="float: left;"
							onclick="attachAddr4(${bcommentDtoList.NOTICE_COMMENT_NUM});">
							<c:set var="comId" value="${bcommentDtoList.NOTICE_COMMENT_ID}" />
							<c:if test="${loginUser == comId}">
								<input type="button" value="삭제" id="listbutton"
									onclick="location.href='delete_comment?NOTICE_COMMENT_NUM=${bcommentDtoList.NOTICE_COMMENT_NUM}&bId=${dto.bId}&page=${bSearchDto.currentPageNum}&pageDataCount=${bSearchDto.pageDataCount}'"
									style="float: left;" />
							</c:if> <c:if test="${!empty loginAdmin}">
								<input type="button" value="삭제" id="listbutton"
									onclick="location.href='delete_comment?NOTICE_COMMENT_NUM=${bcommentDtoList.NOTICE_COMMENT_NUM}&bId=${dto.bId}&page=${bSearchDto.currentPageNum}&pageDataCount=${bSearchDto.pageDataCount}'"
									style="float: left;" />
							</c:if></td>
					</tr>
				</table>


				<form name="frm" method="post" action="BCommentReplyInsert">
					<input type="hidden" name="page"
						value="${bSearchDto.currentPageNum}" /> <input type="hidden"
						name="pageDataCount" value="${bSearchDto.pageDataCount}" /> <input
						type="hidden" value="${bcommentDtoList.NOTICE_COMMENT_GROUPID}"
						name="NOTICE_COMMENT_GROUPID" /> <input type="hidden"
						value="${bcommentDtoList.NOTICE_COMMENT_STEP}"
						name="NOTICE_COMMENT_STEP" /> <input type="hidden"
						value="${bcommentDtoList.NOTICE_COMMENT_INDENT}"
						name="NOTICE_COMMENT_INDENT" /> <input type="hidden"
						name="comment_num"> <input type="hidden" name="bId"
						value="${dto.bId}" readonly>
					<table id="CommentTable">
						<tr id="tabcontent_head" style="border: none;">
							<td></td>
							<td><c:if test="${!empty loginUser}">
									<input type="hidden" name="NOTICE_COMMENT_ID"
										value=${loginUser }>
								</c:if> <c:if test="${!empty loginAdmin}">
									<input type="hidden" name="NOTICE_COMMENT_ID"
										value=${loginAdmin }>
								</c:if> <c:if test="${(loginAdmin==null)&&(loginUser==null)}">
									<input type="hidden" name="NOTICE_COMMENT_ID" value="guest">
								</c:if> <%-- 				<input type="hidden" name="NOTICE_COMMENT_ID" value=${loginUser } >${loginUser }	 --%>

							</td>
							<td><input type="hidden" style="border: 1px solid lightgray"></td>
						</tr>
						<tr id="${bcommentDtoList.NOTICE_COMMENT_NUM}">
						</tr>
					</table>
				</form>
			</c:forEach>
			<div style="align: center;">
				<table id="mypageres_cen_board">
					<tr>
						<td colspan="5"><a
							href="bContentCommand?bId=${dto.bId }
									&pageCo=${bComPageDto.firstCoPageNum }
									&pageCoDataCount=${bComPageDto.pageCoDataCount }
									&page=${bSearchDto.currentPageNum }
									&searchCol=${bSearchDto.searchCol }
									&searchVal=${bSearchDto.searchVal }
									&pageDataCount=${bSearchDto.pageDataCount }">◀◀맨앞으로</a>&nbsp;
							<a
							href="bContentCommand?bId=${dto.bId }
									&pageCo=${bComPageDto.prevCoPageNum }
									&pageCoDataCount=${bComPageDto.pageCoDataCount }
									&page=${bSearchDto.currentPageNum }
									&searchCol=${bSearchDto.searchCol }
									&searchVal=${bSearchDto.searchVal }
									&pageDataCount=${bSearchDto.pageDataCount }">◀앞으로</a>&nbsp;

							<c:forEach var="i"
								begin="${bComPageDto.startCoPageNum }"
								end="${bComPageDto.endCoPageNum }" step="1">

								<c:choose>
									<c:when test="${i eq bComPageDto.currentCoPageNum }">
										<a style="color: blue;"
											href="bContentCommand2?bId=${dto.bId }
										&pageCo=${i }
										&pageCoDataCount=${bComPageDto.pageCoDataCount }
										&page=${bSearchDto.currentPageNum }
										&searchCol=${bSearchDto.searchCol }
										&searchVal=${bSearchDto.searchVal }
										&pageDataCount=${bSearchDto.pageDataCount }">${i }
										</a>&nbsp; 
								</c:when>
									<c:otherwise>
										<a
											href="bContentCommand2?bId=${dto.bId }
										&pageCo=${i }
										&pageCoDataCount=${bComPageDto.pageCoDataCount }
										&page=${bSearchDto.currentPageNum }
										&searchCol=${bSearchDto.searchCol }
										&searchVal=${bSearchDto.searchVal }
										&pageDataCount=${bSearchDto.pageDataCount }">${i }
										</a>&nbsp;
								</c:otherwise>
								</c:choose>

							</c:forEach> <a
							href="bContentCommand?bId=${dto.bId }
									&pageCo=${bComPageDto.nextCoPageNum }
									&pageCoDataCount=${bComPageDto.pageCoDataCount }
									&page=${bSearchDto.currentPageNum }
									&searchCol=${bSearchDto.searchCol }
									&searchVal=${bSearchDto.searchVal }
									&pageDataCount=${bSearchDto.pageDataCount }">뒤로▶</a>&nbsp;
							<a
							href="bContentCommand?bId=${dto.bId }
									&pageCo=${bComPageDto.lastCoPageNum }
									&pageCoDataCount=${bComPageDto.pageCoDataCount }
									&page=${bSearchDto.currentPageNum }
									&searchCol=${bSearchDto.searchCol }
									&searchVal=${bSearchDto.searchVal }
									&pageDataCount=${bSearchDto.pageDataCount }">맨뒤로▶▶</a>
						</td>
					</tr>
				</table>
			</div>
		</div>
	</c:otherwise>
</c:choose>

