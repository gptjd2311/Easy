<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<form name="frm" method="post" action="BCommentWriteCommand">
	<input type="hidden" name="page" value="${bSearchDto.currentPageNum}" />
	<input type="hidden" name="pageDataCount"
		value="${bSearchDto.pageDataCount}" />
	<!--<input  type = "hidden" id="forAdd_num" value="${bcommentDtoList.NOTICE_COMMENT_NUM}"/> -->
	<table id="CommentTable">
		<input type="hidden" name="comment_num">
		<input type="hidden" name="bId" value="${dto.bId}" readonly>
		<tr id="tabcontent_head">
			<td><img src="${path}/resources/images/personvec1.png"></td>

			<td><c:if test="${!empty loginUser}">
					<input type="hidden" name="NOTICE_COMMENT_ID" value=${loginUser }>${loginUser }
					</c:if> <c:if test="${!empty loginAdmin}">
					<input type="hidden" name="NOTICE_COMMENT_ID" value=${loginAdmin }>${loginAdmin }
					</c:if> <c:if test="${(loginAdmin==null)&&(loginUser==null)}">
					<input type="hidden" name="NOTICE_COMMENT_ID" value="guest">guest
					</c:if></td>
			<td><input type="hidden" style="border: 1px solid lightgray">날짜</td>
		</tr>
		<tr id="${bcommentDtoList.NOTICE_COMMENT_NUM}">
			<td colspan="5" style="border: 1px solid lightgray"><textarea
					cols="100" rows="5" name="NOTICE_COMMENT_CONTENT"
					style="border: none"></textarea></td>
			<td><input type="submit" id="listbutton" value="답글"></td>

		</tr>
	</table>
</form>
