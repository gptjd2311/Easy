package com.easy.easy0810.dao;

import java.util.ArrayList;
import java.util.List;

import com.easy.easy0810.dto.BCommentDto;
import com.easy.easy0810.dto.BDto;
import com.easy.easy0810.dto.MemberVO;
import com.easy.easy0810.dto.ProductVO;
import com.easy.easy0810.dto.ReserveVO;
import com.easy.easy0810.dto.SugDto;

public interface IDao {

	// 회원 관련 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

	// <!-- 회원가입 ID 중복체크  -->
	public int userCheck(String memId , String memPwd);

	// <!-- ID값으로 데이터가져오는 메소드  -->
	public MemberVO getMember(String memId );

	// <!-- 로그인시 ID와 비밀번호 맞는지 확인하는 메소드  -->
	public String confirmID(String memId );

	// 	<!-- 회원가입 메소드  -->
	public void insertMember(MemberVO mVo);

	//	<!-- 관리자 회원가입  메소드  -->
	public void insertAdmin(MemberVO mVo);
	
	// 	<!-- 회원 정보 수정시 정보 출력 메소드  -->
	public MemberVO selectOneMemId(String memId);
	
	// 	<!-- 회원 정보 수정 메소드  -->
	public void updateMember(MemberVO mVo);
	
	// <!-- 관리자  정보 수정 메소드  -->
	public void updateAdmin(MemberVO mVo);		
	
	// 관리자 메뉴 회원 관련 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	// 	<!-- 관리자 메뉴 회원 전체 출력 메소드  -->
	public ArrayList<MemberVO> memSearchSelect(String page, String pageDataCount, String searchCol, String searchVal);
	
	//	<!-- 관리자 메뉴 회원 데이터카운트 메소드  -->
	public Integer DataCountmemName(String searchCol,String searchVal);
	
	// 	<!-- 관리자 메뉴 회원 정보 세부보기 메소드  -->
	public MemberVO selectOneMemByMemId(String memId);		
	
	// <!-- 관리자 메뉴 회원 정보 수정 메소드  -->
	public void adminMemUpdate(String memId,int memType, String memPwd, String memName, int user_birth_year, int user_birth_month,
			int user_birth_day, String memGen, String memEmail, String memPhone, String memAdd_1, String memAdd_2,
			String memAdd_3);		
	
	// 	<!-- 관리자 메뉴 회원 삭제 메소드  -->);	
	public void adminMemDelete(String memId);
	
	//	<!-- 회원 탈퇴 메소드  -->
	public void MemDelete(String memId);
	
	// 	<!-- 회원 탈퇴시 기존 예약 Id 바꾸는 메소드  -->
	public void member_res_Delete(String memId);

	// 관리자 메뉴 예약 관련 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	//	<!-- 관리자 메뉴 예약 전체 출력 메소드  -->
	public ArrayList<ReserveVO> resSearchSelect(String page, String pageDataCount, String searchCol, String searchVal);
	
	//	<!-- 관리자 메뉴 배송완료된 예약 출력 메소드  -->
	public ArrayList<ReserveVO> resSearchSelectDel(String page, String pageDataCount, String searchCol, String searchVal);
	
	//	<!-- 관리자 메뉴 취소된 예약 출력 메소드  -->
	public ArrayList<ReserveVO> resSearchSelectOld(String page, String pageDataCount, String searchCol, String searchVal);
	
	//	<!-- 관리자 메뉴 예약 전체 데이터카운트 메소드  -->
	public Integer DataCountmemId(String searchCol,String searchVal);
	
	//	<!-- 관리자 메뉴 배송완료된 예약 데이터카운트 메소드  -->
	public Integer DataCountmemIdOld(String searchCol,String searchVal);
	
	//	<!-- 관리자 메뉴 취소된 예약 데이터카운트 메소드  -->
	public Integer DataCountmemIdDel(String searchCol,String searchVal);
	
	// 	<!-- 관리자 메뉴 예약관리 예약 세부정보 보기 메소드 -->
	public ReserveVO selectOneResByResId(String resId);
	
	//	<!-- 관리자 메뉴 예약 정보 수정 메소드 -->
	public void adminResUpdate(int resId,int proId,String proType, String proName, int resNum, int resCharge,String resData);
	
	// 	<!-- 관리자 메뉴 예약 취소 메소드 -->
	public void adminResDelete(int resId);
	
	// 	<!-- 관리자 메뉴 예약 상품준비중 처리 메소드 -->
	public void ReserveAdminUpdate1(int resId);
	
	//	<!-- 관리자 메뉴 예약 배송중 처리 메소드 -->
	public void ReserveAdminUpdate2(int resId);
	
	//	<!-- 관리자 메뉴 예약 배송완료 처리 메소드 -->
	public void ReserveAdminUpdate3(int resId);
	
	//	<!-- 관리자 메뉴 예약 취소 처리 메소드 -->
	public void ReserveAdminUpdate4(int resId);
	
	// 	<!-- 관리자 메뉴 예약관리 예약 세부정보 보기 메소드 -->
	public int insert(MemberVO mVo);

	// 마이페이지 예약관련ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	// 	<!-- 장바구니 담기 메소드 -->
	public void ReserveInsert(String memId, int proId,String proType, String proName, int resNum, int resCharge,String resData, String memAdd_1, String memAdd_2, String memAdd_3);

	//	<!-- 장바구니 출력 메소드 -->
	public List<ReserveVO> selectAllbucket(String memId);
	
	//	<!-- 장바구니 상품 결제 메소드 -->
	public void reserveRes(int resId,int resGroup);
	
	//	<!-- 장바구니에서 예약 취소 메소드 -->
	public void ReserveBucketDelete(int resId); 

	// 	<!-- 장바구니에서 선택 예약 취소 메소드 -->
	public void ReserveBucketDeleteChoose(int resId) ;

	// 	<!-- 나의예약 그룹별 출력 메소드 -->
	public List<ReserveVO> selectGroupReserve(String memId); 
	
	//	<!-- 나의예약 그룹별 세부보기 메소드 -->
	public List<ReserveVO> selectDetailReserve(String resGroup);
	
	//	<!-- 나의예약 주소 수정 메소드 -->
	public void Member_Add_Update(String resGroup,String memAdd_1,String memAdd_2,String memAdd_3);
	
	
	//	<!-- 나의예약에서 예약 취소 메소드 -->
	public void ReserveReserveDelete(int resGroup);

	// 공지사항ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	//	<!-- 공지사항 출력 메소드-->
	public ArrayList<BDto> searchSelect(String page, String pageDataCount
			, String searchCol, String searchVal);
	
	//	<!-- 공지사항 글쓰기 메소드-->
	public void insert(String bName, String bTitle, String bContent, String bFile);

	//	<!-- 공지사항 게시글로 정보 받아오기 메소드-->
	public BDto select(String bId);

	//	<!-- 공지사항 게시글로 정보 받아오기 메소드-->
	public BDto select2(String bId) ;

	//	<!-- 공지사항 조회수 증가 메소드-->
	public void updateHit(String bId) ;

	//	<!-- 공지사항 댓글쓸때 조회수 처리 메소드-->
	public void downdateHit(int notice_COMMENT_BOARD);

	//	<!-- 공지사항 글 삭제 메소드-->
	public void delete(String bId);

	//	<!-- 공지사항 수정 메소드-->
	public void update(String bId, String bTitle, String bContent, String bFile);

	//	<!-- 공지사항  데이터카운트 메소드-->
	public int dataCountBoard2(String searchCol, String searchVal);
	
	//	<!-- 공지사항 댓글 데이터카운트 메소드-->
	public int dataCoCount(String bId);
	
	//	<!-- 공지사항 댓글 출력 메소드-->
	public ArrayList<BCommentDto> searchCoSelect(String page, String pageDataCount, String bId);

	//	<!-- 공지사항 댓글 입력 메소드-->
	public void insertBoardComment(BCommentDto bcommentDto);

	//	<!-- 공지사항 대댓글 입력 메소드-->
	public void insertBoardCommentReply(BCommentDto bcommentDto);

	//	<!-- 공지사항 댓글 삭제 메소드-->
	public void delete_comment(String NOTICE_COMMENT_NUM);
	

	//건의사항 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
	
	//	<!-- 건의사항 출력 메소드-->
	public ArrayList<SugDto> searchSelectSug(String page, String pageDataCount, String searchCol, String searchVal);

	//	<!-- 건의사항 세부보기 메소드-->
	public SugDto selectSug(String bId);

	//	<!-- 건의사항 작성 메소드-->
	public void write(String bName, String bTitle, String bContent, String bSugFile);

	//	<!-- 건의사항 수정 메소드-->
	public void modify(String bId, String bTitle, String bContent, String bSugFile);

	//	<!-- 건의사항 삭제 메소드-->
	public void deleteSug(String bId);

	//	<!-- 건의사항 답글 메소드-->
	public void reply(String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent);

	//	<!-- 건의사항 답글 세부보기 메소드-->
	public SugDto reply_view(String str);

	//	<!-- 건의사항 조회수 처리 메소드-->
	public void upHit(String bId);

	//	<!-- 건의사항 데이터카운트 메소드-->
	public int dataCountSug(String searchCol, String searchVal);
	
	// 상품테이블ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

	// 	<!-- 상품정보 출력 메소드 -->
	public List<ProductVO> selectAllproduct();
	
	// 	<!-- 상품 번호로 정보 출력 메소드 -->
	public ProductVO ListselectProId(int proId);
}

