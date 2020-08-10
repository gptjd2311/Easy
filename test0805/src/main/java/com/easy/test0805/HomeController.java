package com.easy.test0805;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easy.test0805.dao.BDao;
import com.easy.test0805.dao.BoardDAO;
import com.easy.test0805.dao.MemberDAO;
import com.easy.test0805.dao.ProductDAO;
import com.easy.test0805.dao.ResDao;
import com.easy.test0805.dao.ReserveDAO;
import com.easy.test0805.dao.SugDao;
import com.easy.test0805.dto.BComPageDto;
import com.easy.test0805.dto.BCommentDto;
import com.easy.test0805.dto.BDto;
import com.easy.test0805.dto.BSearchDto;
import com.easy.test0805.dto.MemberVO;
import com.easy.test0805.dto.ProductVO;
import com.easy.test0805.dto.ReserveVO;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	BDao dao;
	BoardDAO bDao;
	MemberDAO mDao;
	ProductDAO pDao;
	ResDao ResDao;
	ReserveDAO rDao;
	SugDao sDao;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/index_member", method = RequestMethod.GET)
	public String index_member() {
		return "index_member";
	}

	@RequestMapping(value = "/index_admin", method = RequestMethod.GET)
	public String index_admin() {
		return "index_admin";
	}

	@RequestMapping(value = "/product_buy_0")
	public String product_buy_0() {
		return "/product/product_buy_0";
	}
	@RequestMapping(value = "/product_buy_1.jsp")
	public String product_buy_1() {
		return "/product/product_buy_1";
	}

	@RequestMapping(value = "/product_buy_2")
	public String product_buy_2() {
		return "/product/product_buy_2";
	}

	@RequestMapping(value = "/product_buy_3")
	public String product_buy_3() {
		return "/product/product_buy_3";
	}

	@RequestMapping(value = "/product_buy_4")
	public String product_buy_4() {
		return "/product/product_buy_4";
	}

	@RequestMapping(value = "/product_buy_5")
	public String product_buy_5() {
		return "/product/product_buy_5";
	}

	@RequestMapping(value = "/product_buy_6")
	public String product_buy_6() {
		return "/product/product_buy_6";
	}
	@RequestMapping(value = "/product_buy_7")
	public String product_buy_7() {
		return "/product/product_buy_7";
	}
	@RequestMapping(value = "/product_res")
	public String product_res() {
		return "/product/product_res";
	}

	@RequestMapping(value = "/mypage")
	public String mypage() {
		return "/member/mypage";
	}
	@RequestMapping(value = "/reserved")
	public String reserved() {
		return "/reserv/reserved";
	}
	@RequestMapping(value = "/bucketsuccess")
	public String bucketsuccess() {
		return "/reserv/bucketsuccess";
	}

	@RequestMapping(value = "/admin")
	public String admin() {
		return "/admin/admin";
	}

	@RequestMapping(value = "/write_view")
	public String write_view() {
		return "/board/write";
	}

	@RequestMapping(value = "/boardhome")
	public String boardhome() {
		return "/board/home";
	}

	/*로그인*/
	@RequestMapping(value = "/login",  method = RequestMethod.GET)
	public String getlogin(HttpServletRequest request, Model model) {
		String url = "/member/login";
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") != null && session.getAttribute("loginAdmin") == null) {// 이미로그인된 사용자라면
			url = "index_member"; // 메인페이지로 이동합니다
		}else if (session.getAttribute("loginUser") == null && session.getAttribute("loginAdmin") != null) {// 이미로그인된 사용자라면
			url = "index_admin"; // 메인페이지로 이동합니다
		}
		return url;
	}

	/*로그인*/
	@RequestMapping(value = "/postlogin",  method = RequestMethod.POST)
	public String postlogin(HttpServletRequest request, Model model) {

		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");

		String url=null;

		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.userCheck(memId, memPwd);


		if(result == 2){
			MemberVO mVo = new MemberVO();
			mVo = mDao.getMember(memId);
			String memName = mVo.getMemName();

			HttpSession session = request.getSession();
			session.setAttribute("loginUser", memId);	
			session.setAttribute("loginUser_Name", memName);	
			session.setAttribute("result", result);		

			url = "index_member";				

		}else if(result == 3){
			MemberVO mVo = new MemberVO();
			mVo = mDao.getMember(memId);
			String memName = mVo.getMemName();

			HttpSession session = request.getSession();
			session.setAttribute("loginAdmin", memId);	
			session.setAttribute("loginUser_name", memName);	
			session.setAttribute("result", result);		

			url = "index_admin";				

		}else{
			url = "/member/login";
			model.addAttribute("message", "로그인 실패 ! 아이디 or 비밀번호를 확인하세요");

		}

		return url;
	}
	/*로그아웃*/
	@RequestMapping(value = "/logout",  method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		HttpSession session = request.getSession();
		session.invalidate(); 

		return "index";
	}

	/*idCheck.do*/
	@RequestMapping(value = "/idCheck",  method = RequestMethod.GET)
	public String idCheck(HttpServletRequest request, Model model) {
		String memId  = request.getParameter("memId");
		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.confirmID(memId);

		model.addAttribute("memId", memId);
		model.addAttribute("result", result);

		return "/member/idcheck";
	}

	/* 상품 부분 */
	@RequestMapping("/product_list")
	public String product_list(HttpServletRequest request, Model model) {
		ProductDAO pDao = ProductDAO.getInstance();

		List<ProductVO> productList = pDao.selectAllproduct();

		model.addAttribute("productList", productList);

		return "/product/product_res_inbucket";
	}


	/* 예약 관련 부분 */
	@RequestMapping("/reserve_list")
	public String reserve_list(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");

		System.out.println("listAction "+memId);

		ReserveDAO rDao = ReserveDAO.getInstance();
		List<ReserveVO> list2 = rDao.selectGroupReserve(memId);
		List<ReserveVO> list = rDao.selectAllReserve(memId);

		model.addAttribute("reserve_list", list2);
		model.addAttribute("reserve_list2", list2);
		return "/member/mypage_res";
	}

	@RequestMapping("/reserve_bucket")
	public String reserve_bucket(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");

		System.out.println("listAction "+memId);

		ReserveDAO rDao = ReserveDAO.getInstance();
		List<ReserveVO> list = rDao.selectAllbucket(memId);

		model.addAttribute("bucket_list", list);

		return "/member/mypage_bucket";
	}

	@RequestMapping("/reserve_insert")
	public void reserve_insert(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
		ReserveVO rVo = new ReserveVO();
		System.out.println("insert");
		String memId = request.getParameter("memId");
		rVo.setMemId(memId);
		System.out.println("insert "+memId);
		int proId = (Integer.parseInt(request.getParameter("proId")));
		int resNum = (Integer.parseInt(request.getParameter("resNum")));
		System.out.println(resNum);


		ReserveDAO rDao = ReserveDAO.getInstance();
		rDao.ReserveInsert(memId,proId,resNum);

		response.setContentType("text/html; charset=euc-kr"); //한글이 인코딩
		PrintWriter out = response.getWriter(); //선언

		String str="";
		str = "<script language='javascript'>";
		str += "opener.window.location.reload();";  //오프너 새로고침
		str += "self.close();";   // 창닫기
		str += "</script>";
		out.print(str);

	}
	@RequestMapping(value = "/reserve_bucket_delete", method = RequestMethod.GET)
	public String reserve_bucket_delete(HttpServletRequest request, Model model) {
		int resId = Integer.parseInt(request.getParameter("resId"));
		String memId = request.getParameter("memId");
		String url = "ReserveServlet?command=reserve_bucket&"+memId+"="+memId;

		System.out.println(memId);

		ReserveDAO rDao = ReserveDAO.getInstance();

		rDao.ReserveBucketDelete(resId);

		return "redirect:/reserve_bucket?memId="+memId;
	}
	@RequestMapping(value = "/reserveBucketResAction", method = RequestMethod.POST)
	public String reserveBucketResAction(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");
		String ab = null;

		if(request.getParameterValues("chBox2") != null) {
			String url="ReserveServlet?command=reserve_list&memId="+memId;

			String[] resGet = request.getParameterValues("chBox2");

			int[] resId = new int[resGet.length];

			for(int i=0; i<resGet.length;i++) {
				resId[i] = Integer.parseInt(resGet[i]); 
			}

			ReserveDAO rDao = ReserveDAO.getInstance();

			for(int i=0; i < resGet.length; i++) {
				rDao.reserveRes(resId[i],resId[0]);
				System.out.println("reserveDao갔다가"+resId[i]);
			}

			ab = "redirect:/reserve_list?memId="+memId;

		}else if(request.getParameterValues("chBox2") == null) {
			ab = "redirect:/reserve_bucket?memId="+memId;
		}

		return ab;

	}
	@RequestMapping(value = "/reserveBucketdeleteChooseAction", method = RequestMethod.POST)
	public String reserveBucketdeleteChooseAction(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");
		System.out.println(memId);

		String ab = null;

		if(request.getParameterValues("chBox2") != null) {

			String[] resId2 = request.getParameterValues("chBox2");

			String url="ReserveServlet?command=reserve_bucket&memId="+memId;
			System.out.println("서블릿 test"+resId2[0]);


			int[] resId = new int[resId2.length];

			for(int i=0; i < resId2.length; i++) {
				resId[i] = Integer.parseInt(resId2[i]);
			}
			System.out.println("서블릿 test2");

			ReserveDAO rDao = ReserveDAO.getInstance();

			for(int i=0; i < resId.length; i++) {
				rDao.ReserveBucketDeleteChoose(resId[i]);
				System.out.println(resId[i]);
			}

			ab = "redirect:/reserve_list?memId="+memId;
		}else if(request.getParameterValues("chBox2") == null) {
			ab = "redirect:/reserve_list?memId="+memId;

		}

		return ab;
	}
	@RequestMapping("/reserve_delete")
	public String reserve_delete(HttpServletRequest request, Model model) {
		String resData = request.getParameter("resData");
		String url = null;

		if(resData.equals("상품준비중")) {
			int resGroup = Integer.parseInt(request.getParameter("resGroup"));
			String memId = request.getParameter("memId");

			System.out.println(memId);

			ReserveDAO rDao = ReserveDAO.getInstance();

			rDao.ReserveReserveDelete(resGroup);
			url = "redirect:/reserve_list?memId="+memId;
		}else if(resData.equals("상품준비중")) {
			url = "/reserve/reserved";
		}else if(resData.equals("배송중")) {
			url = "/reserve/reserved";
		}

		return url;
	}
	@RequestMapping("/reserve_detail")
	public String reserve_detail(HttpServletRequest request, Model model) {

		String resGroup = request.getParameter("resGroup");

		System.out.println(resGroup);

		ReserveDAO rDao = ReserveDAO.getInstance();	
		List<ReserveVO> rVo = rDao.selectDetailReserve(resGroup);
		request.setAttribute("reserve_list", rVo);

		return "/member/mypage_res_detail";
	}
	@RequestMapping("/reserve_pay_list")
	public String reserve_pay_list(HttpServletRequest request, Model model) {
		String resGroup = request.getParameter("resGroup");

		System.out.println(resGroup);

		ReserveDAO rDao = ReserveDAO.getInstance();	
		List<ReserveVO> rVo = rDao.selectDetailReserve(resGroup);

		request.setAttribute("reserve_list", rVo);

		return "redirect:/member/mypage_res_pay";
	}

	/*관리자 메뉴 - 예약*/
	@RequestMapping("/reserve_listAll")
	public String reserve_listAll(HttpServletRequest request, Model model) {
		String page=(String)request.getParameter("page");
		String pageDataCount=(String)request.getParameter("pageDataCount");

		if(page==null){
			page="1";//값이 넘어오지 않았을때 예외처리
		}
		if(pageDataCount==null){
			pageDataCount="20";//값이 넘어오지 않았을때 예외처리
		}

		System.out.println("Command res test 1번");

		//search
		String searchCol = (String) request.getParameter("searchCol");
		String searchVal = (String) request.getParameter("searchVal");

		if(searchCol == null || searchVal == null) {
			searchCol = "memId";
			searchVal = "";

		}if(searchCol == null || searchVal.equals("")) {
			searchCol = "memId";
			searchVal = "";
		}
		System.out.println(page);
		System.out.println(pageDataCount);
		System.out.println(searchCol);
		System.out.println(searchVal);


		ResDao dao= new ResDao();
		ArrayList<ReserveVO> rVo = dao.resSearchSelect(page,pageDataCount,searchCol,searchVal);

		request.setAttribute("reserve_listAll", rVo);

		int totalDataCount = dao.DataCount(searchCol,searchVal);

		BSearchDto BSearchDto = new BSearchDto();

		BSearchDto.makePage(Integer.parseInt(page),
				Integer.parseInt(pageDataCount),
				totalDataCount,searchCol,searchVal);

		request.setAttribute("BSearchDto", BSearchDto);

		System.out.println(BSearchDto+" comm last test");
		return "/admin/admin_res";
	}
	@RequestMapping("/reserve_admin_view")
	public String reserve_admin_view(HttpServletRequest request, Model model) {
		String resId = request.getParameter("resId");

		ReserveDAO rDao = ReserveDAO.getInstance();	
		ReserveVO rVo = rDao.selectOneResByResId(resId);
		request.setAttribute("list", rVo);

		return "/admin/admin_res_view";
	}
	@RequestMapping("/reserve_admin_view_old")
	public String reserve_admin_view_old(HttpServletRequest request, Model model) {
		String page=(String)request.getParameter("page");
		String pageDataCount=(String)request.getParameter("pageDataCount");

		if(page==null){
			page="1";//값이 넘어오지 않았을때 예외처리
		}
		if(pageDataCount==null){
			pageDataCount="20";//값이 넘어오지 않았을때 예외처리
		}

		System.out.println("Command res test 1번");

		//search
		String searchCol = (String) request.getParameter("searchCol");
		String searchVal = (String) request.getParameter("searchVal");

		if(searchCol == null || searchVal == null) {
			searchCol = "memId";
			searchVal = "";	

		}if(searchCol == null || searchVal.equals("")) {
			searchCol = "memId";
			searchVal = "";
		}
		System.out.println(page);
		System.out.println(pageDataCount);
		System.out.println(searchCol);
		System.out.println(searchVal);


		ResDao dao= new ResDao();
		ArrayList<ReserveVO> rVo = dao.resSearchSelectOld(page,pageDataCount,searchCol,searchVal);

		request.setAttribute("reserve_listAll", rVo);

		int totalDataCount = dao.DataCount(searchCol,searchVal);

		BSearchDto BSearchDto = new BSearchDto();

		BSearchDto.makePage(Integer.parseInt(page),
				Integer.parseInt(pageDataCount),
				totalDataCount,searchCol,searchVal);

		request.setAttribute("BSearchDto", BSearchDto);

		return "/admin/admin_res_old";
	}

	@RequestMapping("/reserve_admin_view_del")
	public String reserve_admin_view_del(HttpServletRequest request, Model model) {
		String page=(String)request.getParameter("page");
		String pageDataCount=(String)request.getParameter("pageDataCount");

		if(page==null){
			page="1";//값이 넘어오지 않았을때 예외처리
		}
		if(pageDataCount==null){
			pageDataCount="20";//값이 넘어오지 않았을때 예외처리
		}

		System.out.println("Command res test 1번");

		//search
		String searchCol = (String) request.getParameter("searchCol");
		String searchVal = (String) request.getParameter("searchVal");

		if(searchCol == null || searchVal == null) {
			searchCol = "memId";
			searchVal = "";	

		}if(searchCol == null || searchVal.equals("")) {
			searchCol = "memId";
			searchVal = "";
		}
		System.out.println(page);
		System.out.println(pageDataCount);
		System.out.println(searchCol);
		System.out.println(searchVal);


		ResDao dao= new ResDao();
		ArrayList<ReserveVO> rVo = dao.resSearchSelectDel(page,pageDataCount,searchCol,searchVal);

		request.setAttribute("reserve_listAll", rVo);

		int totalDataCount = dao.DataCount(searchCol,searchVal);

		BSearchDto BSearchDto = new BSearchDto();

		BSearchDto.makePage(Integer.parseInt(page),
				Integer.parseInt(pageDataCount),
				totalDataCount,searchCol,searchVal);

		request.setAttribute("BSearchDto", BSearchDto);

		System.out.println(BSearchDto+" comm last test");

		return "/admin/admin_res_old";
	}

	@RequestMapping("/reserve_admin_update_form")
	public String reserve_admin_update_form(HttpServletRequest request, Model model) {
		String resId = request.getParameter("resId");
		ReserveDAO rDao = ReserveDAO.getInstance();
		ReserveVO rVo = rDao.selectOneResByResId(resId);
		request.setAttribute("list", rVo);

		return "/admin/admin_res_update";
	}

	@RequestMapping(value = "/reserve_admin_update", method = RequestMethod.POST)
	public String reserve_admin_update(HttpServletRequest request, Model model) {
		int resId = Integer.parseInt(request.getParameter("resId"));
		int proId = Integer.parseInt(request.getParameter("proId"));
		int resNum = Integer.parseInt(request.getParameter("resNum"));
		String resData = request.getParameter("resData");

		ReserveDAO rDao = ReserveDAO.getInstance();
		rDao.adminResUpdate( resId,  proId,  resNum, resData);
		return "redirect:/reserve_listAll";
	}

	@RequestMapping("/reserve_admin_delete")
	public String reserve_admin_delete(HttpServletRequest request, Model model) {
		int resId = Integer.parseInt(request.getParameter("resId"));

		ReserveDAO rDao = ReserveDAO.getInstance();

		rDao.adminResDelete(resId);
		return "redirect:/reserve_listAll";
	}
	@RequestMapping("/reserveAdminUpdate1Action")
	public String reserveAdminUpdate1Action(HttpServletRequest request, Model model) {
		String[] resId2 = request.getParameterValues("chBox");
		System.out.println("서블릿 test"+resId2[0]);

		int[] resId = new int[resId2.length];

		for(int i=0; i < resId2.length; i++) {
			resId[i] = Integer.parseInt(resId2[i]);
		}
		System.out.println("서블릿 test2");

		ReserveDAO rDao = ReserveDAO.getInstance();

		for(int i=0; i < resId.length; i++) {
			rDao.ReserveAdminUpdate1(resId[i]);
			System.out.println(resId[i]);
		}
		return "redirect:/reserve_listAll";
	}
	@RequestMapping("/reserveAdminUpdate2Action")
	public String reserveAdminUpdate2Action(HttpServletRequest request, Model model) {
		String[] resId2 = request.getParameterValues("chBox");
		System.out.println("서블릿 test"+resId2[0]);

		int[] resId = new int[resId2.length];

		for(int i=0; i < resId2.length; i++) {
			resId[i] = Integer.parseInt(resId2[i]);
		}
		System.out.println("서블릿 test2");

		ReserveDAO rDao = ReserveDAO.getInstance();

		for(int i=0; i < resId.length; i++) {
			rDao.ReserveAdminUpdate2(resId[i]);
			System.out.println(resId[i]);
		}
		return "redirect:/reserve_listAll";
	}
	@RequestMapping("/reserveAdminUpdate3Action")
	public String reserveAdminUpdate3Action(HttpServletRequest request, Model model) {
		String[] resId2 = request.getParameterValues("chBox");
		System.out.println("서블릿 test"+resId2[0]);

		int[] resId = new int[resId2.length];

		for(int i=0; i < resId2.length; i++) {
			resId[i] = Integer.parseInt(resId2[i]);
		}
		System.out.println("서블릿 test2");

		ReserveDAO rDao = ReserveDAO.getInstance();

		for(int i=0; i < resId.length; i++) {
			rDao.ReserveAdminUpdate3(resId[i]);
			System.out.println(resId[i]);
		}
		return "redirect:/reserve_listAll";
	}
	@RequestMapping("/reserveAdminUpdate4Action")
	public String reserveAdminUpdate4Action(HttpServletRequest request, Model model) {
		String[] resId2 = request.getParameterValues("chBox");
		System.out.println("서블릿 test"+resId2[0]);

		int[] resId = new int[resId2.length];

		for(int i=0; i < resId2.length; i++) {
			resId[i] = Integer.parseInt(resId2[i]);
		}
		System.out.println("서블릿 test2");

		ReserveDAO rDao = ReserveDAO.getInstance();

		for(int i=0; i < resId.length; i++) {
			rDao.ReserveAdminUpdate4(resId[i]);
			System.out.println(resId[i]);
		}
		return "redirect:/reserve_listAll";
	}

	/*관리자 메뉴 - 멤버*/
	@RequestMapping("/member_listAll")
	public String member_listAll(HttpServletRequest request, Model model) {
		String page=(String)request.getParameter("page");
		String pageDataCount=(String)request.getParameter("pageDataCount");
		if(page==null){
			page="1";//값이 넘어오지 않았을때 예외처리
		}
		if(pageDataCount==null){
			pageDataCount="20";//값이 넘어오지 않았을때 예외처리
		}

		System.out.println("Command test 1번");
		//search
		String searchCol = (String) request.getParameter("searchCol");
		String searchVal = (String) request.getParameter("searchVal");

		if(searchCol == null || searchVal == null) {
			searchCol = "memName";
			searchVal = "";
		}if(searchCol == null || searchVal.equals("")) {
			searchCol = "memName";
			searchVal = "";
		}
		System.out.println(page);
		System.out.println(pageDataCount);
		System.out.println(searchCol);
		System.out.println(searchVal);


		BDao bao= new BDao();
		ArrayList<MemberVO> mVo = bao.memSearchSelect(page,pageDataCount,searchCol,searchVal);
		request.setAttribute("member_listAll", mVo);

		int totalDataCount = bao.dataCount(searchCol,searchVal);

		BSearchDto BSearchDto = new BSearchDto();

		BSearchDto.makePage(Integer.parseInt(page),
				Integer.parseInt(pageDataCount),
				totalDataCount,searchCol,searchVal);

		request.setAttribute("BSearchDto", BSearchDto);

		System.out.println(BSearchDto);

		return "/admin/admin_mem";

	}

	@RequestMapping("/member_admin_view")
	public String member_admin_view(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");

		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.selectOneMemByMemId(memId);
		request.setAttribute("list", mVo);

		return "/admin/admin_mem_view";
	}

	@RequestMapping("/member_admin_update_form")
	public String member_admin_update_form(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");

		MemberDAO mDao = MemberDAO.getInstance();
		MemberVO mVo = mDao.selectOneMemByMemId(memId);

		request.setAttribute("list", mVo);

		return "/admin/admin_mem_update";
	}

	@RequestMapping("/member_admin_update")
	public String member_admin_update(HttpServletRequest request, Model model) {
		int memType = Integer.parseInt(request.getParameter("memType"));
		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");
		String memName = request.getParameter("memName");
		int user_birth_year = Integer.parseInt(request.getParameter("user_birth_year"));
		int user_birth_month = Integer.parseInt(request.getParameter("user_birth_month"));
		int user_birth_day = Integer.parseInt(request.getParameter("user_birth_day"));
		String memGen = request.getParameter("memGen");
		String memEmail = request.getParameter("memEmail");
		String memPhone = request.getParameter("memPhone");
		String memAdd_1 = request.getParameter("memAdd_1");
		String memAdd_2 = request.getParameter("memAdd_2");
		String memAdd_3 = request.getParameter("memAdd_3");

		MemberDAO mDao = MemberDAO.getInstance();
		mDao.adminMemUpdate(memId ,memType, memPwd,memName, user_birth_year,user_birth_month,user_birth_day,memGen,memEmail,memPhone,memAdd_1,memAdd_2,memAdd_3);

		return "redirect:/member_listAll";
	}


	@RequestMapping("/member_admin_delete")
	public String member_admin_delete(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");

		MemberDAO mDao = MemberDAO.getInstance();

		mDao.adminMemDelete(memId);

		return "redirect:/member_listAll";
	}


	/*회원가입 폼*/
	@RequestMapping(value = "/member_join_form")
	public String member_join_form() {
		return "/member/join";
	}

	/*회원가입*/
	@RequestMapping("/member_join")
	public String member_join(HttpServletRequest request, Model model) {

		String ab = null;
		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");
		String memName = request.getParameter("memName");
		String user_birth_year = request.getParameter("user_birth_year");
		String user_birth_month = request.getParameter("user_birth_month");
		String user_birth_day = request.getParameter("user_birth_day");
		String memGen = request.getParameter("memGen");
		String memEmail = request.getParameter("memEmail");
		String memPhone = request.getParameter("memPhone");
		String memAdd_1 = request.getParameter("memAdd_1");
		String memAdd_2 = request.getParameter("memAdd_2");
		String memAdd_3 = request.getParameter("memAdd_3");



		MemberVO mVo = new MemberVO();
		mVo.setMemId (memId);
		mVo.setMemPwd (memPwd);
		mVo.setMemName (memName);
		mVo.setUser_birth_year(Integer.parseInt(user_birth_year));
		mVo.setUser_birth_month(Integer.parseInt(user_birth_month));
		mVo.setUser_birth_day(Integer.parseInt(user_birth_day));
		mVo.setMemGen (memGen);
		mVo.setMemEmail (memEmail);
		mVo.setMemPhone (memPhone);
		mVo.setMemAdd_1 (memAdd_1);
		mVo.setMemAdd_2 (memAdd_2);
		mVo.setMemAdd_3 (memAdd_3);


		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.insertMember(mVo);
		HttpSession session = request.getSession();
		if (result == 1) {
			session.setAttribute("memId", mVo.getMemId());
			model.addAttribute("message", "회원가입에 성공했습니다.");
			ab = "member/joinsuccess";

		} else {
			model.addAttribute("message", "회원가입에 실패했습니다.");
			ab = "member/join";
		}
		return ab;
	}

	@RequestMapping("/admin_join_form")
	public String admin_join_form() {
		return "admin/admin_join";
	}

	@RequestMapping("/admin_join")
	public String admin_join(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");
		String memName = request.getParameter("memName");
		String memGen = request.getParameter("memGen");
		String memEmail = request.getParameter("memEmail");
		String memPhone = request.getParameter("memPhone");



		MemberVO mVo = new MemberVO();
		mVo.setMemId (memId);
		mVo.setMemPwd (memPwd);
		mVo.setMemName (memName);
		mVo.setMemGen (memGen);
		mVo.setMemEmail (memEmail);
		mVo.setMemPhone (memPhone);



		MemberDAO mDao = MemberDAO.getInstance();
		int result = mDao.insertAdmin(mVo);
		HttpSession session = request.getSession();
		if (result == 1) {
			session.setAttribute("memId", mVo.getMemId());
			request.setAttribute("message", "회원가입에 성공했습니다.");
		} else {
			request.setAttribute("message", "회원가입에 실패했습니다.");
		}
		return "/member/joinsuccess";
	}


	/*회원 정보 수정*/
	@RequestMapping("/member_update_form")
	public String member_update_form(HttpServletRequest request, Model model) {
		MemberDAO mDao = MemberDAO.getInstance();

		String memId = request.getParameter("memId");
		System.out.println(memId);
		MemberVO mVo = mDao.selectOneMemId(memId);
		model.addAttribute("member_mod", mVo);

		return "/member/mypage_mod";
	}

	@RequestMapping("/admin_update_form")
	public String admin_update_form(HttpServletRequest request, Model model) {
		MemberDAO mDao = MemberDAO.getInstance();

		String memId = request.getParameter("memId");
		System.out.println(memId);
		MemberVO mVo = mDao.selectOneMemId(memId);
		model.addAttribute("member_mod", mVo);

		return "/member/mypage_mod_admin";
	}

	@RequestMapping("/member_update")
	public String member_update(HttpServletRequest request, Model model) {
		MemberVO mVo = new MemberVO();

		System.out.println("update 1번");


		mVo.setMemNum(request.getParameter("memNum"));
		mVo.setMemType(request.getParameter("memType"));
		mVo.setMemId(request.getParameter("memId"));
		mVo.setMemPwd(request.getParameter("memPwd"));
		mVo.setMemName(request.getParameter("memName"));
		mVo.setUser_birth_year(Integer.parseInt(request.getParameter("user_birth_year")));
		mVo.setUser_birth_month(Integer.parseInt(request.getParameter("user_birth_month")));
		mVo.setUser_birth_day(Integer.parseInt(request.getParameter("user_birth_day")));
		mVo.setMemGen(request.getParameter("memGen"));
		mVo.setMemPhone(request.getParameter("memPhone"));
		mVo.setMemEmail(request.getParameter("memEmail"));
		mVo.setMemAdd_1(request.getParameter("memAdd_1"));
		mVo.setMemAdd_2(request.getParameter("memAdd_2"));
		mVo.setMemAdd_3(request.getParameter("memAdd_3"));

		System.out.println("update user번");
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateMember(mVo);

		return "/member/mypage";
	}
	@RequestMapping("/admin_update")
	public String admin_update(HttpServletRequest request, Model model) {
		MemberVO mVo = new MemberVO();

		System.out.println("update 1번");


		mVo.setMemNum(request.getParameter("memPwd"));
		mVo.setMemName(request.getParameter("memName"));
		mVo.setMemGen(request.getParameter("memGen"));
		mVo.setMemPhone(request.getParameter("memPhone"));
		mVo.setMemEmail(request.getParameter("memEmail"));

		System.out.println("update admin번");
		MemberDAO mDao = MemberDAO.getInstance();
		mDao.updateAdmin(mVo);
		return "/member/mypage";
	}

	//공지사항 리스트
	@RequestMapping(value = "/listSearch")
	public String listSearch(HttpServletRequest request, Model model) {
		String page=(String)request.getParameter("page");
		String pageDataCount=(String)request.getParameter("pageDataCount");
		if(page==null) {
			page="1";
		}
		if(pageDataCount==null) {
			pageDataCount="20";
		}
		String searchCol=(String)request.getParameter("searchCol");
		String searchVal=(String)request.getParameter("searchVal");
		if(searchCol==null||searchVal==null) {
			searchCol="bTitle";
			searchVal="";
		}
		if(searchCol.equals("")||searchVal.equals("")) {
			searchCol="bTitle";
			searchVal="";
		}

		System.out.println(page);
		System.out.println(pageDataCount);
		System.out.println(searchCol);
		System.out.println(searchVal);


		BoardDAO bDao=new BoardDAO();
		ArrayList<BDto> dtos
		=bDao.searchSelect(page,pageDataCount,searchCol,searchVal);
		request.setAttribute("dtos", dtos);				

		int totalDataCount=bDao.dataCount(searchCol,searchVal);
		BSearchDto bSearchDto=new BSearchDto();
		bSearchDto.makePage(Integer.parseInt(page)
				, Integer.parseInt(pageDataCount)
				, totalDataCount,searchCol,searchVal);
		request.setAttribute("bSearchDto", bSearchDto);

		System.out.println(bSearchDto);

		return "/board/listSearch";
	}

	

	@RequestMapping(value = "/content_view",  method = RequestMethod.GET)
	public String content_view(HttpServletRequest request, Model model) {
		String url = "board/content.jsp";
		String bId=request.getParameter("bId");
		System.out.println("String bId ==" + bId);

		BoardDAO dao=new BoardDAO();		
		BDto dto=dao.select(bId);
		System.out.println("1031 dto.bFile ==" + dto.getbFile());

		model.addAttribute("dto", dto);

		BSearchDto bSearchDto=new BSearchDto();
		
		int currentPageNum=Integer.parseInt(request.getParameter("page"));
		System.out.println("1038"+currentPageNum);

		bSearchDto.setCurrentPageNum(currentPageNum);
		int bPageDataCount=Integer.parseInt(request.getParameter("pageDataCount"));
		bSearchDto.setPageDataCount(bPageDataCount);
		System.out.println("1043"+currentPageNum);


		System.out.println("BContentCommand currentPageNum == "+currentPageNum);			
		System.out.println("BContentCommand bPageDataCount == "+bPageDataCount);

		bSearchDto.setSearchCol(request.getParameter("searchCol"));
		bSearchDto.setSearchVal(request.getParameter("searchVal"));

		// 여기서부터는 답글에 있는거 가져오는 법
		System.out.println("String bId ==" + bId);

		request.setAttribute("bSearchDto", bSearchDto);


		// 댓글 페이지
		String page=(String)request.getParameter("pageCo");
		String pageDataCount=(String)request.getParameter("pageCoDataCount");
		if(page==null) {
			page="1";
		}

		if(pageDataCount==null) {
			pageDataCount="20";
		}
		//			
		System.out.println("댓글 pageCo="+page+"입니다.");
		System.out.println("댓글 pageDataCount="+pageDataCount+"입니다.");
		BoardDAO bDao=new BoardDAO();


		System.out.println("String bId ==" + bId);
		List<BCommentDto> bcommentDtoList=bDao.searchCoSelect(page,pageDataCount,bId);		
		request.setAttribute("bcommentDtoList", bcommentDtoList);


		int totalCoDataCount=bDao.dataCoCount(bId);
		BComPageDto bComPageDto=new BComPageDto();

		System.out.println("totalCoDataCount" + Integer.parseInt(page));
		System.out.println("Integer.parseInt(pageDataCount)" + Integer.parseInt(pageDataCount));
		System.out.println("totalCoDataCount"+totalCoDataCount);

		bComPageDto.makeCoPage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalCoDataCount);
		request.setAttribute("bComPageDto", bComPageDto);


		System.out.println(bComPageDto);	

		return "/board/content";
	}


	@RequestMapping(value = "/write", method = RequestMethod.POST)
	public String write(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");
//      화일 올리는 경로 주는법
		

//		String path = (String) request.getAttribute("path");
		// request에있는 서블릿의 경로는 이미 서버에 있는 경로이다.
//		String path = request.getSession().getServletContext().getRealPath("images");
		// 절대경로로 줄 경우 \를 두개씩 써주어야 한다. 실제 서버에 올라가는 곳의 위치를 넣어야 한다.
		// String path = "D:\\JSP\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\20200806EazyandClean\\image";
//		String path = "D:\\SPRING\\springSTS2020\\Workspace\\20200806EazyandClean\\src\\main\\webapp\\resources\\boardImage";
		String path = "D:\\springSTS2020\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\test0805\\images";
		System.out.println(path);
	
		int maxSize = 500*1024*1024;
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		// multi에는 파일 뿐만 아니라 다른 title actor같은것들의 정보도 있다.
		String enctype = "UTF-8";
		MultipartRequest multi = new MultipartRequest(
				
				request,
				path,
				maxSize,
				enctype,
				policy
				
		);
		//DAO 객채 생성 및 insert	
		BoardDAO dao=new BoardDAO();
		String bName=multi.getParameter("bName");
		System.out.println("bName"+bName);
		String bTitle=multi.getParameter("bTitle");
		System.out.println("bTitle"+bTitle);
		String bContent=multi.getParameter("bContent");
		System.out.println("bContent"+bContent);
		String bFile=multi.getFilesystemName("bFile");
		System.out.println("bFile"+bFile);
		dao.insert(bName,bTitle,bContent,bFile);
		
		request.setAttribute("path", path);
		
		return "redirect:/listSearch";		
	}
		
	@RequestMapping(value = "/delete",  method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		String bId=request.getParameter("bId");
		BoardDAO dao=new BoardDAO();
		dao.delete(bId);
		return "redirect:/listSearch";
	}
	@RequestMapping(value = "/modefy_view",  method = RequestMethod.GET)
	public String modefy_view(HttpServletRequest request, Model model) {
		String url = "board/modefy.jsp";
		String bId = request.getParameter("bId");
		System.out.println("String bId ==" + bId);

		BoardDAO dao = new BoardDAO();
		BDto dto = dao.select(bId);
		System.out.println("수정에서의 dto.bFile ==" + dto.getbFile());

		request.setAttribute("dto", dto);

		BSearchDto bSearchDto = new BSearchDto();
		int currentPageNum = Integer.parseInt(request.getParameter("page"));
		System.out.println(currentPageNum);
		bSearchDto.setCurrentPageNum(currentPageNum);
		int bPageDataCount = Integer.parseInt(request.getParameter("pageDataCount"));
		bSearchDto.setPageDataCount(bPageDataCount);
		System.out.println(currentPageNum);

		System.out.println("BContentCommand currentPageNum == " + currentPageNum);
		System.out.println("BContentCommand bPageDataCount == " + bPageDataCount);

		bSearchDto.setSearchCol(request.getParameter("searchCol"));
		bSearchDto.setSearchVal(request.getParameter("searchVal"));

		request.setAttribute("bSearchDto", bSearchDto);
		
		return "/board/modefy";
	}

	//수정
	@RequestMapping(value = "/modefy",  method = RequestMethod.POST)
	public String modefy(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
			request.setCharacterEncoding("UTF-8");
			
	
//	      화일 올리는 경로 주는법		
//			ServletContext context = getServletContext();
//			String path = (String) request.getAttribute("path");
			// request에있는 서블릿의 경로는 이미 서버에 있는 경로이다.
//			String path = request.getServletContext().getRealPath("images");
			// 절대경로로 줄 경우 \를 두개씩 써주어야 한다. 실제 서버에 올라가는 곳의 위치를 넣어야 한다.
			// String path =
			// "D:\\JSP\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\20200702movie\\images";
			String path = "D:\\springSTS2020\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\test0805\\images";
			System.out.println(path);

			int maxSize = 500 * 1024 * 1024;
			DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
			// multi에는 파일 뿐만 아니라 다른 title actor같은것들의 정보도 있다.
			String enctype = "UTF-8";
			MultipartRequest multi = new MultipartRequest(

					request, path, maxSize, enctype, policy

			);
		
			// mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
			BoardDAO dao = new BoardDAO();
			String bId = multi.getParameter("bId");
			System.out.println("bName" + bId);
			String bTitle = multi.getParameter("bTitle");
			System.out.println("bTitle" + bTitle);
			String bContent = multi.getParameter("bContent");
			System.out.println("bContent" + bContent);
			String bFile = multi.getFilesystemName("bFile");
			System.out.println("bFile" + bFile);

		
		
			if(multi.getFilesystemName("bFile")==null) {
				bFile = multi.getParameter("nonmakeimg");
			}else {
				bFile = multi.getFilesystemName("bFile");		
			}
			
			
			dao.update(bId, bTitle, bContent, bFile);
			BDto dto = dao.select(bId);
			request.setAttribute("dto", dto);
			System.out.println("수정에서의 dto.bFile ==" + dto.getbFile());
			
			String bId2= multi.getParameter("bId");
			String page=multi.getParameter("page");
			String searchVal =multi.getParameter("searchVal");
			String searchCol =multi.getParameter("searchCol");
			String pageDataCount =multi.getParameter("pageDataCount");
			
			return "redirect:/content_view?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;

	}

	@RequestMapping(value = "/bContentCommand",  method = RequestMethod.GET)
	public String bContentCommand(HttpServletRequest request, Model model) {
		String url = "board/content.jsp";
		String bId=request.getParameter("bId");
		System.out.println("String bId ==" + bId);

		BoardDAO dao=new BoardDAO();		
		BDto dto=dao.select(bId);
		System.out.println("1195 dto.bFile ==" + dto.getbFile());


		request.setAttribute("dto", dto);

		BSearchDto bSearchDto=new BSearchDto();
		int currentPageNum=Integer.parseInt(request.getParameter("page"));
		System.out.println(currentPageNum);

		bSearchDto.setCurrentPageNum(currentPageNum);
		int bPageDataCount=Integer.parseInt(request.getParameter("pageDataCount"));
		bSearchDto.setPageDataCount(bPageDataCount);
		System.out.println(currentPageNum);


		System.out.println("BContentCommand currentPageNum == "+currentPageNum);			
		System.out.println("BContentCommand bPageDataCount == "+bPageDataCount);

		bSearchDto.setSearchCol(request.getParameter("searchCol"));
		bSearchDto.setSearchVal(request.getParameter("searchVal"));

		// 여기서부터는 답글에 있는거 가져오는 법
		System.out.println("1217 String bId ==" + bId);

		request.setAttribute("bSearchDto", bSearchDto);



		// 댓글 페이지
		String page=(String)request.getParameter("pageCo");
		String pageDataCount=(String)request.getParameter("pageCoDataCount");
		if(page==null) {
			page="1";
		}

		if(pageDataCount==null) {
			pageDataCount="20";
		}
		//			
		System.out.println("댓글 pageCo="+page+"입니다.");
		System.out.println("댓글 pageDataCount="+pageDataCount+"입니다.");
		BoardDAO bDao=new BoardDAO();


		System.out.println("String bId ==" + bId);
		List<BCommentDto> bcommentDtoList=bDao.searchCoSelect(page,pageDataCount,bId);		
		request.setAttribute("bcommentDtoList", bcommentDtoList);


		int totalCoDataCount=bDao.dataCoCount(bId);
		BComPageDto bComPageDto=new BComPageDto();

		System.out.println("totalCoDataCount" + Integer.parseInt(page));
		System.out.println("Integer.parseInt(pageDataCount)" + Integer.parseInt(pageDataCount));
		System.out.println("totalCoDataCount"+totalCoDataCount);

		bComPageDto.makeCoPage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalCoDataCount);
		request.setAttribute("bComPageDto", bComPageDto);


		System.out.println(bComPageDto);	

		return "redirect:/content_view?bId="+bId;
	}
	@RequestMapping(value = "/bContentCommand2",  method = RequestMethod.GET)
	public String bContentCommand2(HttpServletRequest request, Model model) {
		String url = "board/content.jsp";
		String bId=request.getParameter("bId");
		System.out.println("String bId ==" + bId);

		BoardDAO dao=new BoardDAO();		
		BDto dto=dao.select2(bId);
		System.out.println("dto.bFile ==" + dto.getbFile());


		request.setAttribute("dto", dto);

		BSearchDto bSearchDto=new BSearchDto();
		int currentPageNum=Integer.parseInt(request.getParameter("page"));
		System.out.println(currentPageNum);

		bSearchDto.setCurrentPageNum(currentPageNum);
		int bPageDataCount=Integer.parseInt(request.getParameter("pageDataCount"));
		bSearchDto.setPageDataCount(bPageDataCount);
		System.out.println(currentPageNum);


		System.out.println("BContentCommand currentPageNum == "+currentPageNum);			
		System.out.println("BContentCommand bPageDataCount == "+bPageDataCount);

		bSearchDto.setSearchCol(request.getParameter("searchCol"));
		bSearchDto.setSearchVal(request.getParameter("searchVal"));

		// 여기서부터는 답글에 있는거 가져오는 법
		System.out.println("String bId ==" + bId);

		request.setAttribute("bSearchDto", bSearchDto);



		// 댓글 페이지
		String page=(String)request.getParameter("pageCo");
		String pageDataCount=(String)request.getParameter("pageCoDataCount");
		if(page==null) {
			page="1";
		}

		if(pageDataCount==null) {
			pageDataCount="20";
		}

		System.out.println("댓글 pageCo="+page+"입니다.");
		System.out.println("댓글 pageDataCount="+pageDataCount+"입니다.");
		BoardDAO bDao=new BoardDAO();


		System.out.println("String bId ==" + bId);
		List<BCommentDto> bcommentDtoList=bDao.searchCoSelect(page,pageDataCount,bId);		
		request.setAttribute("bcommentDtoList", bcommentDtoList);


		int totalCoDataCount=bDao.dataCoCount(bId);
		BComPageDto bComPageDto=new BComPageDto();

		System.out.println("totalCoDataCount" + Integer.parseInt(page));
		System.out.println("Integer.parseInt(pageDataCount)" + Integer.parseInt(pageDataCount));
		System.out.println("totalCoDataCount"+totalCoDataCount);

		bComPageDto.makeCoPage(Integer.parseInt(page), Integer.parseInt(pageDataCount), totalCoDataCount);
		request.setAttribute("bComPageDto", bComPageDto);


		System.out.println(bComPageDto);	
		return "redirect:/content_view?bId="+bId;
	}

	@RequestMapping(value = "/BCommentInsert",  method = RequestMethod.GET)
	public String BCommentInsert(HttpServletRequest request, Model model) {
		String url = "bContentCommand.do";
		BCommentDto bcommentDto = new BCommentDto();
		bcommentDto.setNOTICE_COMMENT_ID(request.getParameter("NOTICE_COMMENT_ID"));
		bcommentDto.setNOTICE_COMMENT_BOARD(Integer.parseInt(request.getParameter("bId")));
		bcommentDto.setNOTICE_COMMENT_CONTENT(request.getParameter("NOTICE_COMMENT_CONTENT"));

		System.out.println("답글달기 답글등록 누르기");		
		BoardDAO BDao = new BoardDAO();
		BDao.insertBoardComment(bcommentDto);

		String bId=request.getParameter("bId");
		String page=request.getParameter("page");
		String searchVal =request.getParameter("searchVal");
		String searchCol =request.getParameter("searchCol");
		String pageDataCount =request.getParameter("pageDataCount"); 
		System.out.println("1349 사사나String bId ==" + bId);

		BoardDAO dao=new BoardDAO();		
		BDto dto=dao.select(bId);

		request.setAttribute("dto", dto);

		BSearchDto bSearchDto=new BSearchDto();
		int currentPageNum=Integer.parseInt(request.getParameter("page"));
		System.out.println("1354"+currentPageNum);
		bSearchDto.setCurrentPageNum(currentPageNum);
		int bPageDataCount=Integer.parseInt(request.getParameter("pageDataCount"));
		bSearchDto.setPageDataCount(bPageDataCount);
		System.out.println("1358"+currentPageNum);


		System.out.println("사사나BContentCommand currentPageNum == "+currentPageNum);			
		System.out.println("나나사BContentCommand bPageDataCount == "+bPageDataCount);

		bSearchDto.setSearchCol(request.getParameter("searchCol"));
		bSearchDto.setSearchVal(request.getParameter("searchVal"));

		request.setAttribute("bSearchDto", bSearchDto);
		return "redirect:/content_view?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;
	}
	
	@RequestMapping(value = "/BCommentReplyInsert",  method = RequestMethod.POST)
	public String BCommentReplyInsert(HttpServletRequest request, Model model) {
	
		String url = "bContentCommand.do";
		BCommentDto bcommentDto = new BCommentDto();
		bcommentDto.setNOTICE_COMMENT_ID(request.getParameter("NOTICE_COMMENT_ID"));
		bcommentDto.setNOTICE_COMMENT_BOARD(Integer.parseInt(request.getParameter("bId")));
		bcommentDto.setNOTICE_COMMENT_CONTENT(request.getParameter("NOTICE_COMMENT_CONTENT"));
		System.out.println(" request.getParameter(\"NOTICE_COMMENT_GROUPID\")) " + request.getParameter("NOTICE_COMMENT_GROUPID"));
		bcommentDto.setNOTICE_COMMENT_GROUPID(Integer.parseInt(request.getParameter("NOTICE_COMMENT_GROUPID")));
		bcommentDto.setNOTICE_COMMENT_INDENT(Integer.parseInt(request.getParameter("NOTICE_COMMENT_INDENT")));
		bcommentDto.setNOTICE_COMMENT_STEP(Integer.parseInt(request.getParameter("NOTICE_COMMENT_STEP")));

		System.out.println("답글달기 답글등록 누르기");		
		BoardDAO BDao = new BoardDAO();
		BDao.insertBoardCommentReply(bcommentDto);
		
		
		
		String bId=request.getParameter("bId");
		String page=request.getParameter("page");
		String searchVal =request.getParameter("searchVal");
		String searchCol =request.getParameter("searchCol");
		String pageDataCount =request.getParameter("pageDataCount"); 
		
		System.out.println("사사나String bId ==" + bId);

		BoardDAO dao=new BoardDAO();		
		BDto dto=dao.select(bId);

		request.setAttribute("dto", dto);

		BSearchDto bSearchDto=new BSearchDto();
		int currentPageNum=Integer.parseInt(request.getParameter("page"));
		System.out.println(currentPageNum);
		bSearchDto.setCurrentPageNum(currentPageNum);
		int bPageDataCount=Integer.parseInt(request.getParameter("pageDataCount"));
		bSearchDto.setPageDataCount(bPageDataCount);
		System.out.println(currentPageNum);


		System.out.println("사사나BContentCommand currentPageNum == "+currentPageNum);			
		System.out.println("나나사BContentCommand bPageDataCount == "+bPageDataCount);

		bSearchDto.setSearchCol(request.getParameter("searchCol"));
		bSearchDto.setSearchVal(request.getParameter("searchVal"));

		request.setAttribute("bSearchDto", bSearchDto);

		return "redirect:/content_view?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;
		
	}
}
