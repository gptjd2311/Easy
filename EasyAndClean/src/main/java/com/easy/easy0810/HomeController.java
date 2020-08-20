package com.easy.easy0810;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easy.easy0810.dao.IDao;
import com.easy.easy0810.del.BDao;
import com.easy.easy0810.del.BoardDAO;
import com.easy.easy0810.del.MemberDAO;
import com.easy.easy0810.del.ProductDAO;
import com.easy.easy0810.del.ResDao;
import com.easy.easy0810.del.ReserveDAO;
import com.easy.easy0810.del.SugDao;
import com.easy.easy0810.dto.BComPageDto;
import com.easy.easy0810.dto.BCommentDto;
import com.easy.easy0810.dto.BDto;
import com.easy.easy0810.dto.BSearchDto;
import com.easy.easy0810.dto.MemberVO;
import com.easy.easy0810.dto.ProductVO;
import com.easy.easy0810.dto.ReserveVO;
import com.easy.easy0810.dto.SugDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@Controller
public class HomeController {

	BDao dao;
	BoardDAO bDao;
	MemberDAO mDao;
	ProductDAO pDao;
	ResDao ResDao;
	ReserveDAO rDao;
	SugDao sDao;


	public BDao getDao() {
		return dao;
	}
	public void setDao(BDao dao) {
		this.dao = dao;
	}
	public BoardDAO getbDao() {
		return bDao;
	}
	public void setbDao(BoardDAO bDao) {
		this.bDao = bDao;
	}
	public MemberDAO getmDao() {
		return mDao;
	}
	public void setmDao(MemberDAO mDao) {
		this.mDao = mDao;
	}
	public ProductDAO getpDao() {
		return pDao;
	}
	public void setpDao(ProductDAO pDao) {
		this.pDao = pDao;
	}
	public ResDao getResDao() {
		return ResDao;
	}
	public void setResDao(ResDao resDao) {
		ResDao = resDao;
	}
	public ReserveDAO getrDao() {
		return rDao;
	}
	public void setrDao(ReserveDAO rDao) {
		this.rDao = rDao;
	}
	public SugDao getsDao() {
		return sDao;
	}
	public void setsDao(SugDao sDao) {
		this.sDao = sDao;
	}

	@Autowired      //spring설정파일에서 만들어 놓은 bean 객체를 주입받음
	private SqlSession sqlSession;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "index";
	}
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
	@RequestMapping(value = "/product_buy_1")
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

	@RequestMapping(value = "/board_sug_write_view")
	public String board_sug_write_view() {
		return "/board/board_sug_write";
	}

	@RequestMapping(value = "/boardhome")
	public String boardhome() {
		return "/board/home";
	}

	@RequestMapping(value = "/notadmin")
	public String notadmin() {
		return "notadmin";
	}

	/*로그인*/
	@RequestMapping(value = "/login",  method = RequestMethod.GET)
	public String getlogin(HttpServletRequest request, Model model) {
		String checkpint = "로그인";
		String url = "/member/login";
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") != null && session.getAttribute("loginAdmin") == null) {// 이미로그인된 사용자라면
			url = "index"; // 메인페이지로 이동합니다
		}else if (session.getAttribute("loginUser") == null && session.getAttribute("loginAdmin") != null) {// 이미로그인된 사용자라면
			url = "index"; // 메인페이지로 이동합니다
		}
		return url;
	}

	/*로그인*/
	@RequestMapping(value = "/login.do",  method = RequestMethod.GET)
	public String logindo(HttpServletRequest request, Model model) {
		String url = "/member/login";
		HttpSession session = request.getSession();
		if (session.getAttribute("loginUser") != null && session.getAttribute("loginAdmin") == null) {// 이미로그인된 사용자라면
			url = "index"; // 메인페이지로 이동합니다
		}else if (session.getAttribute("loginUser") == null && session.getAttribute("loginAdmin") != null) {// 이미로그인된 사용자라면
			url = "index"; // 메인페이지로 이동합니다
		}
		return url;
	}

	/*로그인*/
	@RequestMapping(value = "/postlogin",  method = RequestMethod.POST)
	public String postlogin(HttpServletRequest request, Model model) {

		String memId = request.getParameter("memId");
		String memPwd = request.getParameter("memPwd");

		String url=null;

		IDao dao = sqlSession.getMapper(IDao.class);

		MemberVO mVo2 = dao.getMember(memId);


		if(mVo2 == null) {
			url = "/member/login";
			model.addAttribute("message", "로그인 실패 ! 아이디 or 비밀번호를 확인하세요");
		}else {
			int result = -1;
			String memTypeUser = "1";

			if(mVo2.getMemId() != null) {
				System.out.println("223"+mVo2.getMemId());
				if(memPwd.equals(mVo2.getMemPwd())){
					System.out.println("225"+mVo2.getMemPwd());
					System.out.println(memPwd);
					System.out.println("226"+mVo2.getMemAdd_1());
					String memType = mVo2.getMemType();
					if(memTypeUser.equals(memType)) {
						result = 2;
						//일반회원
					}else if(memType.equals("0")) {
						result=3;
						//관리자
					}else if(memType.equals("2")) {
						result=4;
						//탈퇴한 회원
					}
				}
			}

			if(result == 2){
				String memId2 = mVo2.getMemId();
				String memName = mVo2.getMemName();

				HttpSession session = request.getSession();
				session.setAttribute("loginUser", memId2);	
				session.setAttribute("loginUser_Name", memName);	
				session.setAttribute("result", result);		

				url = "index";				

			}else if(result == 3){
				String memId2 = mVo2.getMemId();
				String memName = mVo2.getMemName();

				HttpSession session = request.getSession();
				session.setAttribute("loginAdmin", memId2);	
				session.setAttribute("loginUser_name", memName);	
				session.setAttribute("result", result);		

				url = "index";				

			}else{
				url = "/member/login";
				model.addAttribute("message", "로그인 실패 ! 아이디 or 비밀번호를 확인하세요");

			}
		}

		return url;
	}
	/*로그아웃*/
	@RequestMapping(value = "/logout",  method = RequestMethod.GET)
	public String logout(HttpServletRequest request, Model model) {
		String checkpint = "로그인";
		HttpSession session = request.getSession();
		session.invalidate(); 

		return "index";
	}

	/*idCheck.do*/
	@RequestMapping(value = "/idCheck",  method = RequestMethod.GET)
	public String idCheck(HttpServletRequest request, Model model) {
		String memId  = request.getParameter("memId");

		IDao dao = sqlSession.getMapper(IDao.class);
		String conmemID = dao.confirmID(memId);


		int result = 0;

		if(conmemID != null) {
			result = 1;
		}else {
			result = -1;
		}	

		model.addAttribute("memId", memId);
		model.addAttribute("result", result);

		return "/member/idcheck";
	}

	/* 상품 부분 */
	@RequestMapping("/product_list")
	public String product_list(HttpServletRequest request, Model model) {


		IDao dao = sqlSession.getMapper(IDao.class);
		List<ProductVO> productList = dao.selectAllproduct();

		model.addAttribute("productList", productList);
		return "/product/product_res_inbucket";

	}


	/* 예약 관련 부분 */
	@RequestMapping("/reserve_list")
	public String reserve_list(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");

		System.out.println("listAction "+memId);

		IDao dao = sqlSession.getMapper(IDao.class);
		List<ReserveVO> list2 = dao.selectGroupReserve(memId);


		model.addAttribute("reserve_list", list2);
		model.addAttribute("reserve_list2", list2);
		return "/member/mypage_res";
	}

	@RequestMapping("/reserve_bucket")
	public String reserve_bucket(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");

		System.out.println("listAction "+memId);

		IDao rDao = sqlSession.getMapper(IDao.class);
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


		IDao rDao = sqlSession.getMapper(IDao.class);

		ProductVO pVo = rDao.ListselectProId(proId);
		
		String proType = pVo.getProType();
		String proName = pVo.getProName();
		int proPrice = pVo.getProPrice();

		int resCharge = 0;

		System.out.println(proPrice+","+resNum);
		resCharge = proPrice*resNum;		
		String resData = "수거중";

		MemberVO mVo = rDao.getMember(memId);
		
		String memAdd_1 = mVo.getMemAdd_1();
		String memAdd_2 = mVo.getMemAdd_2();
		String memAdd_3 = mVo.getMemAdd_3();
		
		rDao.ReserveInsert(memId,proId,proType,proName,resNum,resCharge,resData,memAdd_1,memAdd_2,memAdd_3);

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


		System.out.println(memId);

		IDao rDao = sqlSession.getMapper(IDao.class);

		rDao.ReserveBucketDelete(resId);

		return "redirect:/reserve_bucket?memId="+memId;
	}
	@RequestMapping(value = "/reserveBucketResAction", method = RequestMethod.POST)
	public String reserveBucketResAction(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");
		String ab = null;

		if(request.getParameterValues("chBox2") != null) {

			String[] resGet = request.getParameterValues("chBox2");

			int[] resId = new int[resGet.length];

			for(int i=0; i<resGet.length;i++) {
				resId[i] = Integer.parseInt(resGet[i]); 
			}

			IDao rDao = sqlSession.getMapper(IDao.class);

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

			System.out.println("서블릿 test"+resId2[0]);


			int[] resId = new int[resId2.length];

			for(int i=0; i < resId2.length; i++) {
				resId[i] = Integer.parseInt(resId2[i]);
			}
			System.out.println("서블릿 test2");

			IDao rDao = sqlSession.getMapper(IDao.class);

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

		if(resData.equals("수거중")) {
			int resGroup = Integer.parseInt(request.getParameter("resGroup"));
			String memId = request.getParameter("memId");

			System.out.println(memId);

			IDao rDao = sqlSession.getMapper(IDao.class);

			rDao.ReserveReserveDelete(resGroup);
			url = "redirect:/reserve_list?memId="+memId;
		}else if(resData.equals("서비스진행중")) {
			url = "/reserve/reserved";
		}else if(resData.equals("배송중")) {
			url = "/reserve/reserved";
		}

		return url;
	}
	@RequestMapping("/reserve_detail")
	public String reserve_detail(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");
		String resGroup = request.getParameter("resGroup");

		System.out.println(resGroup);

		IDao rDao = sqlSession.getMapper(IDao.class);

		List<ReserveVO> rVo = rDao.selectDetailReserve(resGroup);
		request.setAttribute("reserve_list", rVo);

		return "/member/mypage_res_detail";
	}
	
	@RequestMapping("/Member_Add_Update")
	public String Member_Add_Update(HttpServletRequest request, Model model) {
		String resGroup = request.getParameter("resGroup");
		String memAdd_1 = request.getParameter("memAdd_1");
		String memAdd_2 = request.getParameter("memAdd_2");
		String memAdd_3 = request.getParameter("memAdd_3");

		System.out.println(resGroup);
		System.out.println("549"+memAdd_1);
		System.out.println("550"+memAdd_2);
		System.out.println("551"+memAdd_3);

		IDao rDao = sqlSession.getMapper(IDao.class);

		rDao.Member_Add_Update(resGroup,memAdd_1,memAdd_2,memAdd_3);
		
		List<ReserveVO> rVo = rDao.selectDetailReserve(resGroup);
		request.setAttribute("reserve_list", rVo);

		return "redirect:/reserve_detail?resGroup="+resGroup;
	}
	
	
	@RequestMapping("/reserve_pay_list")
	public String reserve_pay_list(HttpServletRequest request, Model model) {
		String resGroup = request.getParameter("resGroup");

		System.out.println(resGroup);

		IDao rDao = sqlSession.getMapper(IDao.class);
		List<ReserveVO> rVo = rDao.selectDetailReserve(resGroup);

		request.setAttribute("reserve_list", rVo);

		return "redirect:/member/mypage_res_pay";
	}

	/*관리자 메뉴 - 예약*/		
	@RequestMapping(value="/reserve_listAll", method = RequestMethod.GET)
	public String getreserve_listAll(HttpServletRequest request, Model model) {
		String page=(String)request.getParameter("page");
		String pageDataCount=(String)request.getParameter("pageDataCount");
		if(page==null){
			page="1";//값이 넘어오지 않았을때 예외처리
		}
		if(pageDataCount==null){
			pageDataCount="30";//값이 넘어오지 않았을때 예외처리
		}

		System.out.println("Command test 1번");
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


		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println("548test");


		ArrayList<ReserveVO> rVo = dao.resSearchSelect(page,pageDataCount,
				searchCol,searchVal);

		System.out.println("942"+rVo);

		request.setAttribute("reserve_listAll", rVo);

		System.out.println("945"+searchCol);
		System.out.println(searchVal);

		int totalDataCount = dao.DataCountmemId(searchCol,searchVal);

		System.out.println("948"+totalDataCount);

		BSearchDto BSearchDto = new BSearchDto();

		BSearchDto.makePage(Integer.parseInt(page),
				Integer.parseInt(pageDataCount),
				totalDataCount,searchCol,searchVal);

		model.addAttribute("BSearchDto", BSearchDto);

		System.out.println(BSearchDto+" comm last test");

		return "/admin/admin_res";
	}
	@RequestMapping("/reserve_admin_view")
	public String reserve_admin_view(HttpServletRequest request, Model model) {
		String resId = request.getParameter("resId");

		IDao rDao = sqlSession.getMapper(IDao.class);
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
			pageDataCount="30";//값이 넘어오지 않았을때 예외처리
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


		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<ReserveVO> rVo = dao.resSearchSelectOld(page,pageDataCount,searchCol,searchVal);

		request.setAttribute("reserve_listAll", rVo);

		int totalDataCount = dao.DataCountmemIdOld(searchCol,searchVal);

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
			pageDataCount="30";//값이 넘어오지 않았을때 예외처리
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


		IDao dao = sqlSession.getMapper(IDao.class);
		ArrayList<ReserveVO> rVo = dao.resSearchSelectDel(page,pageDataCount,searchCol,searchVal);

		request.setAttribute("reserve_listAll", rVo);

		int totalDataCount = dao.DataCountmemIdDel(searchCol,searchVal);

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
		IDao rDao = sqlSession.getMapper(IDao.class);
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

		IDao rDao = sqlSession.getMapper(IDao.class);
		ProductVO pVo = rDao.ListselectProId(proId);

		String proType = pVo.getProType();
		String proName = pVo.getProName();
		int proPrice = pVo.getProPrice();

		int resCharge = 0;

		System.out.println(proPrice+","+resNum);
		resCharge = proPrice*resNum;		

		rDao.adminResUpdate(resId,proId,proType,proName,resNum,resCharge,resData);

		return "redirect:/reserve_listAll";


	}

	@RequestMapping("/reserve_admin_delete")
	public String reserve_admin_delete(HttpServletRequest request, Model model) {
		int resId = Integer.parseInt(request.getParameter("resId"));

		IDao rDao = sqlSession.getMapper(IDao.class);

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

		IDao rDao = sqlSession.getMapper(IDao.class);

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

		IDao rDao = sqlSession.getMapper(IDao.class);

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

		IDao rDao = sqlSession.getMapper(IDao.class);

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

		IDao rDao = sqlSession.getMapper(IDao.class);

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
			pageDataCount="30";//값이 넘어오지 않았을때 예외처리
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


		IDao dao = sqlSession.getMapper(IDao.class);
		System.out.println("833test");


		ArrayList<MemberVO> mVo = dao.memSearchSelect(page,pageDataCount,searchCol,searchVal);

		System.out.println("942"+mVo);

		request.setAttribute("member_listAll", mVo); 

		System.out.println("945"+searchCol);
		System.out.println(searchVal);

		int totalDataCount = (int) dao.DataCountmemName(searchCol,searchVal);


		System.out.println("948"+totalDataCount);
		BSearchDto BSearchDto = new BSearchDto();

		BSearchDto.makePage(Integer.parseInt(page),
				Integer.parseInt(pageDataCount),
				totalDataCount,searchCol,searchVal);

		model.addAttribute("BSearchDto", BSearchDto);

		System.out.println(BSearchDto);

		return "/admin/admin_mem";

	}

	@RequestMapping("/member_admin_view")
	public String member_admin_view(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");

		IDao dao = sqlSession.getMapper(IDao.class);
		MemberVO mVo = dao.selectOneMemByMemId(memId);
		request.setAttribute("list", mVo);

		return "/admin/admin_mem_view";
	}

	@RequestMapping("/member_admin_update_form")
	public String member_admin_update_form(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");


		IDao dao = sqlSession.getMapper(IDao.class);
		MemberVO mVo = dao.selectOneMemByMemId(memId);

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

		IDao dao = sqlSession.getMapper(IDao.class);
		dao.adminMemUpdate(memId, memType, memPwd, memName, user_birth_year, user_birth_month, user_birth_day, memGen, memEmail, memPhone, memAdd_1, memAdd_2, memAdd_3);

		return "redirect:/member_listAll";
	}

	/* 관리자 메뉴 회원 탈퇴*/
	@RequestMapping("/member_admin_delete")
	public String member_admin_delete(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");

		IDao dao = sqlSession.getMapper(IDao.class);
		dao.adminMemDelete(memId);

		return "redirect:/member_listAll";
	}

	/* mypage 개인정보수정 - 회원 탈퇴*/
	@RequestMapping("/member_delete_form")
	public String member_delete_form(HttpServletRequest request, Model model) {
		return "/member/delcheck";
	}

	/* mypage 개인정보수정 - 회원 탈퇴*/
	@RequestMapping("/member_delete")
	public void member_delete(HttpServletRequest request,HttpServletResponse response, Model model) throws IOException {
		String memId = request.getParameter("memId");

		IDao dao = sqlSession.getMapper(IDao.class);
		dao.member_res_Delete(memId);

		System.out.println("957test");
		dao.MemDelete(memId);
		System.out.println("959test");

		HttpSession session = request.getSession();
		session.invalidate(); 
		System.out.println("963test");


		response.setContentType("text/html; charset=euc-kr"); //한글이 인코딩
		PrintWriter out = response.getWriter(); //선언

		String str="";
		str = "<script language='javascript'>";
		str += "opener.window.location.reload();";  //오프너 새로고침
		str += "self.close();";   // 창닫기
		str += "</script>";
		out.print(str);
	}


	/*회원가입 폼*/
	@RequestMapping(value = "/member_join_form")
	public String member_join_form() {
		return "/member/join";
	}

	/*회원가입*/
	@RequestMapping("/member_join")
	public String member_join(HttpServletRequest request, Model model) {

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

		IDao dao = sqlSession.getMapper(IDao.class);
		dao.insertMember(mVo);
		HttpSession session = request.getSession();

		session.setAttribute("memId", mVo.getMemId());
		model.addAttribute("message", "회원가입에 성공했습니다.");
		return "member/joinsuccess";
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



		IDao dao = sqlSession.getMapper(IDao.class);
		dao.insertAdmin(mVo);
		HttpSession session = request.getSession();

		session.setAttribute("memId", mVo.getMemId());
		request.setAttribute("message", "회원가입에 성공했습니다.");

		return "/member/joinsuccess";
	}


	/*회원 정보 수정*/
	@RequestMapping("/member_update_form")
	public String member_update_form(HttpServletRequest request, Model model) {
		String memId = request.getParameter("memId");
		System.out.println(memId);
		IDao dao = sqlSession.getMapper(IDao.class);
		MemberVO mVo = dao.selectOneMemId(memId);
		model.addAttribute("member_mod", mVo);

		return "/member/mypage_mod";
	}

	@RequestMapping("/admin_update_form")
	public String admin_update_form(HttpServletRequest request, Model model) {

		String memId = request.getParameter("memId");
		System.out.println(memId);
		IDao dao = sqlSession.getMapper(IDao.class);
		MemberVO mVo = dao.selectOneMemId(memId);
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
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.updateMember(mVo);

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
		IDao dao = sqlSession.getMapper(IDao.class);
		dao.updateAdmin(mVo);

		return "/member/mypage";
	}

	//건의사항 컨트롤러 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ

	@RequestMapping(value = "/board_sug")
	public String board_sug(HttpServletRequest request, Model model) {
		String url = "건의사항 시작";
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


		IDao bDao = sqlSession.getMapper(IDao.class);
		ArrayList<SugDto> dtos=bDao.searchSelectSug(page,pageDataCount,searchCol,searchVal);
		model.addAttribute("dtos", dtos);				

		int totalDataCount=bDao.dataCountSug(searchCol,searchVal);
		BSearchDto bSearchDto=new BSearchDto();
		bSearchDto.makePage(Integer.parseInt(page)
				, Integer.parseInt(pageDataCount)
				, totalDataCount,searchCol,searchVal);
		request.setAttribute("bSearchDto", bSearchDto);

		System.out.println(bSearchDto);

		return "/board/board_sug";
	}

	@RequestMapping(value = "/board_sug_content_view",  method = RequestMethod.GET)
	public String board_sug_content_view(HttpServletRequest request, Model model) {
		String bId = request.getParameter("bId");
		IDao bDao = sqlSession.getMapper(IDao.class);
		SugDto dto = bDao.selectSug(bId);
		request.setAttribute("dto", dto);

		BSearchDto bSearchDto= new BSearchDto();
		int currentPageNum=Integer.parseInt(request.getParameter("page"));
		bSearchDto.setCurrentPageNum(currentPageNum);
		int bPageDataCount=Integer.parseInt(request.getParameter("pageDataCount"));
		bSearchDto.setPageDataCount(bPageDataCount);
		bSearchDto.setSearchCol(request.getParameter("searchCol"));
		bSearchDto.setSearchVal(request.getParameter("serachVal"));

		request.setAttribute("bSearchDto", bSearchDto);			

		return "/board/board_sug_content";
	}


	@RequestMapping(value = "/board_sug_write", method = RequestMethod.POST)
	public String board_sug_write(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\EasyandClean\\resources\\image";

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
		String bName=multi.getParameter("bName");
		System.out.println("bName"+bName);
		String bTitle=multi.getParameter("bTitle");
		System.out.println("bTitle"+bTitle);
		String bContent=multi.getParameter("bContent");
		System.out.println("bContent"+bContent);
		String bSugFile=multi.getFilesystemName("bSugFile");

		if(bSugFile == null) {
			bSugFile = "null";
		}else {
			System.out.println("bFile"+bSugFile);
		}

		System.out.println("bSugFile"+bSugFile);

		request.setAttribute("path", path);

		IDao bDao = sqlSession.getMapper(IDao.class);
		bDao.write(bName, bTitle, bContent, bSugFile);

		return "redirect:/board_sug";		
	}

	@RequestMapping(value = "/board_sug_delete",  method = RequestMethod.GET)
	public String board_sug_delete(HttpServletRequest request, Model model) {
		String bId=request.getParameter("bId");
		IDao bDao = sqlSession.getMapper(IDao.class);
		bDao.delete(bId);
		return "redirect:/board_sug";
	}
	@RequestMapping(value = "/board_sug_modify_view",  method = RequestMethod.GET)
	public String board_sug_modify_view(HttpServletRequest request, Model model) {

		String bId = request.getParameter("bId");
		System.out.println("String bId ==" + bId);

		IDao bDao = sqlSession.getMapper(IDao.class);
		SugDto dto = bDao.selectSug(bId);


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

		return "/board/board_sug_modify";
	}

	//수정
	@RequestMapping(value = "/board_sug_modify",  method = RequestMethod.POST)
	public String board_sug_modify(Locale locale, Model model, HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.setCharacterEncoding("UTF-8");

		String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\EasyandClean\\resources\\image";
		System.out.println(path);

		int maxSize = 500 * 1024 * 1024;
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		// multi에는 파일 뿐만 아니라 다른 title actor같은것들의 정보도 있다.
		String enctype = "UTF-8";
		MultipartRequest multi = new MultipartRequest(

				request, path, maxSize, enctype, policy

				);

		// mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		IDao bDao = sqlSession.getMapper(IDao.class);
		String bId = multi.getParameter("bId");
		System.out.println("bName" + bId);
		String bTitle = multi.getParameter("bTitle");
		System.out.println("bTitle" + bTitle);
		String bContent = multi.getParameter("bContent");
		System.out.println("bContent" + bContent);
		String bSugFile = multi.getFilesystemName("bSugFile");
		System.out.println("bFile" + bSugFile);



		if(multi.getFilesystemName("bSugFile")==null) {
			bSugFile = multi.getParameter("nonmakeimg");
		}else {
			bSugFile = multi.getFilesystemName("bSugFile");		
		}


		bDao.modify(bId, bTitle, bContent, bSugFile);		

		String page=multi.getParameter("page");
		String searchVal =multi.getParameter("searchVal");
		String searchCol =multi.getParameter("searchCol");
		String pageDataCount =multi.getParameter("pageDataCount");

		return "redirect:/board_sug_content_view?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;

	}
	@RequestMapping(value = "/board_sug_reply_form",  method = RequestMethod.GET)
	public String board_sug_reply_form(HttpServletRequest request, Model model) {

		String bId=request.getParameter("bId");
		IDao bDao = sqlSession.getMapper(IDao.class);
		SugDto dto = bDao.selectSug(bId);

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



		return "board/board_sug_reply_view";
	}
	@RequestMapping(value = "/board_sug_reply",  method = RequestMethod.GET)
	public String board_sug_reply_view(HttpServletRequest request, Model model) {

		String bId=request.getParameter("bId");
		IDao bDao = sqlSession.getMapper(IDao.class);
		SugDto dto = bDao.selectSug(bId);

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



		return "board/board_sug_reply_view";
	}
	@RequestMapping(value = "/board_sug_reply",  method = RequestMethod.POST)
	public String board_sug_reply(HttpServletRequest request, Model model) {

		IDao bDao = sqlSession.getMapper(IDao.class);


		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String bGroup = request.getParameter("bGroup");
		String bStep = request.getParameter("bStep");
		String bIndent = request.getParameter("bIndent");


		bDao.reply(bName, bTitle, bContent, bGroup, bStep, bIndent);


		return "redirect:/board_sug";
	}

	//공지사항 리스트
	@RequestMapping(value = "/listSearch")
	public String listSearch(HttpServletRequest request, Model model) {
		String url = "공지사항 시작";
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


		IDao bDao = sqlSession.getMapper(IDao.class);
		ArrayList<BDto> dtos
		=bDao.searchSelect(page,pageDataCount,searchCol,searchVal);
		request.setAttribute("dtos", dtos);				

		int totalDataCount=bDao.dataCountBoard2(searchCol,searchVal);

		System.out.println("1453"+totalDataCount);
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

		String bId=request.getParameter("bId");
		System.out.println("String bId ==" + bId);

		IDao dao = sqlSession.getMapper(IDao.class);		
		dao.updateHit(bId);

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



		System.out.println("String bId ==" + bId);
		List<BCommentDto> bcommentDtoList=dao.searchCoSelect(page,pageDataCount,bId);		
		request.setAttribute("bcommentDtoList", bcommentDtoList);


		int totalCoDataCount=dao.dataCoCount(bId);
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
		//	      화일 올리는 경로 주는법


		//			String path = (String) request.getAttribute("path");
		// request에있는 서블릿의 경로는 이미 서버에 있는 경로이다.
		//			String path = request.getSession().getServletContext().getRealPath("images");
		// 절대경로로 줄 경우 \를 두개씩 써주어야 한다. 실제 서버에 올라가는 곳의 위치를 넣어야 한다.
		// String path = "D:\\JSP\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\20200806EazyandClean\\image";
		//			String path = "D:\\SPRING\\springSTS2020\\Workspace\\20200806EazyandClean\\src\\main\\webapp\\resources\\boardImage";
		String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\EasyandClean\\resources\\image";

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
		IDao dao = sqlSession.getMapper(IDao.class);	
		String bName=multi.getParameter("bName");
		System.out.println("bName"+bName);
		String bTitle=multi.getParameter("bTitle");
		System.out.println("bTitle"+bTitle);
		String bContent=multi.getParameter("bContent");
		System.out.println("bContent"+bContent);
		String bFile=multi.getFilesystemName("bFile");

		if(bFile == null) {
			bFile = "null";
		}else {
			System.out.println("bFile"+bFile);
		}


		dao.insert(bName,bTitle,bContent,bFile);

		request.setAttribute("path", path);

		return "redirect:/listSearch";		
	}

	@RequestMapping(value = "/delete",  method = RequestMethod.GET)
	public String delete(HttpServletRequest request, Model model) {
		String bId=request.getParameter("bId");
		IDao dao = sqlSession.getMapper(IDao.class);	
		dao.delete(bId);
		return "redirect:/listSearch";
	}
	@RequestMapping(value = "/modefy_view",  method = RequestMethod.GET)
	public String modefy_view(HttpServletRequest request, Model model) {

		String bId = request.getParameter("bId");
		System.out.println("String bId ==" + bId);

		IDao dao = sqlSession.getMapper(IDao.class);	
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


		//		      화일 올리는 경로 주는법		
		//				ServletContext context = getServletContext();
		//				String path = (String) request.getAttribute("path");
		// request에있는 서블릿의 경로는 이미 서버에 있는 경로이다.
		//				String path = request.getServletContext().getRealPath("images");
		// 절대경로로 줄 경우 \를 두개씩 써주어야 한다. 실제 서버에 올라가는 곳의 위치를 넣어야 한다.
		// String path =
		// "D:\\JSP\\work\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\wtpwebapps\\20200702movie\\images";
		String path = "C:\\Program Files\\Apache Software Foundation\\Tomcat 8.5\\webapps\\EasyandClean\\resources\\image";
		System.out.println(path);

		int maxSize = 500 * 1024 * 1024;
		DefaultFileRenamePolicy policy = new DefaultFileRenamePolicy();
		// multi에는 파일 뿐만 아니라 다른 title actor같은것들의 정보도 있다.
		String enctype = "UTF-8";
		MultipartRequest multi = new MultipartRequest(

				request, path, maxSize, enctype, policy

				);

		// mmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmmm
		IDao dao = sqlSession.getMapper(IDao.class);	
		String bId=multi.getParameter("bId");
		String bName=multi.getParameter("bName");
		System.out.println("bName" + bName);
		String bTitle = multi.getParameter("bTitle");
		System.out.println("bTitle" + bTitle);
		String bContent = multi.getParameter("bContent");
		System.out.println("bContent" + bContent);
		String bFile = multi.getFilesystemName("bFile");
		System.out.println("bFile" + bFile);


		if(bFile == null) {
			bFile = "null";
			System.out.println("1691bFile"+bFile);
		}else {
			System.out.println("1693bFile"+bFile);
		}

		System.out.println("1696 null test"+bFile);

		dao.update(bId, bTitle, bContent, bFile);
		System.out.println("1696test");

		BDto dto = dao.select(bId);	
		request.setAttribute("dto", dto);

		System.out.println("수정에서의 dto.bFile ==" + dto.getbFile());


		String page=multi.getParameter("page");
		String searchVal =multi.getParameter("searchVal");
		String searchCol =multi.getParameter("searchCol");
		String pageDataCount =multi.getParameter("pageDataCount");

		return "redirect:/content_view?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;

	}

	@RequestMapping(value = "/bContentCommand",  method = RequestMethod.GET)
	public String bContentCommand(HttpServletRequest request, Model model) {

		String bId=request.getParameter("bId");
		System.out.println("String bId ==" + bId);

		IDao bDao = sqlSession.getMapper(IDao.class);
		BDto dto=bDao.select(bId);
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
		String bId=request.getParameter("bId");
		System.out.println("String bId ==" + bId);

		IDao bDao = sqlSession.getMapper(IDao.class);
		BDto dto=bDao.select2(bId);
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

	@RequestMapping(value = "/BCommentInsert",  method = RequestMethod.POST)
	public String BCommentInsert(HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {

		System.out.println("1864"+request.getParameter("NOTICE_COMMENT_CONTENT"));

		if(request.getParameter("NOTICE_COMMENT_CONTENT").equals("")) {
			System.out.println("1867 if test");
			BCommentDto bcommentDto = new BCommentDto();
			bcommentDto.setNOTICE_COMMENT_ID(request.getParameter("NOTICE_COMMENT_ID"));
			bcommentDto.setNOTICE_COMMENT_BOARD(Integer.parseInt(request.getParameter("bId")));			
			bcommentDto.setNOTICE_COMMENT_CONTENT(request.getParameter("NOTICE_COMMENT_CONTENT"));



			System.out.println("답글달기 답글등록 누르기");		
			IDao bDao = sqlSession.getMapper(IDao.class);

			int str = bcommentDto.getNOTICE_COMMENT_BOARD();
			bDao.downdateHit(str);

			String bId=request.getParameter("bId");
			String page=request.getParameter("page");
			String searchVal =request.getParameter("searchVal");
			String searchCol =request.getParameter("searchCol");
			String pageDataCount =request.getParameter("pageDataCount"); 
			System.out.println("1349 사사나String bId ==" + bId);


			BDto dto=bDao.select(bId);

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

			if(searchCol==null||searchVal==null) {
				searchCol="bTitle";
				searchVal="";
			}
			if(searchCol.equals("")||searchVal.equals("")) {
				searchCol="bTitle";
				searchVal="";
			}
			request.setAttribute("bSearchDto", bSearchDto);

			return "redirect:/content_view?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;

		}else {
			System.out.println("1921 else 출력?");
			BCommentDto bcommentDto = new BCommentDto();
			bcommentDto.setNOTICE_COMMENT_ID(request.getParameter("NOTICE_COMMENT_ID"));
			bcommentDto.setNOTICE_COMMENT_BOARD(Integer.parseInt(request.getParameter("bId")));
			bcommentDto.setNOTICE_COMMENT_CONTENT(request.getParameter("NOTICE_COMMENT_CONTENT"));



			System.out.println("답글달기 답글등록 누르기");		
			IDao bDao = sqlSession.getMapper(IDao.class);

			int str = bcommentDto.getNOTICE_COMMENT_BOARD();
			bDao.downdateHit(str);
			bDao.insertBoardComment(bcommentDto);

			String bId=request.getParameter("bId");
			String page=request.getParameter("page");
			String searchVal =request.getParameter("searchVal");
			String searchCol =request.getParameter("searchCol");
			String pageDataCount =request.getParameter("pageDataCount"); 
			System.out.println("1349 사사나String bId ==" + bId);


			BDto dto=bDao.select(bId);

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

			if(searchCol==null||searchVal==null) {
				searchCol="bTitle";
				searchVal="";
			}
			if(searchCol.equals("")||searchVal.equals("")) {
				searchCol="bTitle";
				searchVal="";
			}
			request.setAttribute("bSearchDto", bSearchDto);

			return "redirect:/content_view?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;
		}
	}

	@RequestMapping(value = "/BCommentReplyInsert",  method = RequestMethod.POST)
	public String BCommentReplyInsert(HttpServletRequest request, Model model) {

		if(request.getParameter("NOTICE_COMMENT_CONTENT").equals("")) {
			String bId=request.getParameter("bId");
			BCommentDto bcommentDto = new BCommentDto();
			bcommentDto.setNOTICE_COMMENT_ID(request.getParameter("NOTICE_COMMENT_ID"));
			bcommentDto.setNOTICE_COMMENT_BOARD(Integer.parseInt(request.getParameter("bId")));
			bcommentDto.setNOTICE_COMMENT_CONTENT(request.getParameter("NOTICE_COMMENT_CONTENT"));
			System.out.println(" request.getParameter(\"NOTICE_COMMENT_GROUPID\")) " + request.getParameter("NOTICE_COMMENT_GROUPID"));
			bcommentDto.setNOTICE_COMMENT_GROUPID(Integer.parseInt(request.getParameter("NOTICE_COMMENT_GROUPID")));
			bcommentDto.setNOTICE_COMMENT_INDENT(Integer.parseInt(request.getParameter("NOTICE_COMMENT_INDENT")));
			bcommentDto.setNOTICE_COMMENT_STEP(Integer.parseInt(request.getParameter("NOTICE_COMMENT_STEP")));

			System.out.println("답글달기 답글등록 누르기");		
			IDao bDao = sqlSession.getMapper(IDao.class);

			int str = bcommentDto.getNOTICE_COMMENT_BOARD();
			bDao.downdateHit(str);





			String page=request.getParameter("page");
			String searchVal =request.getParameter("searchVal");
			String searchCol =request.getParameter("searchCol");
			String pageDataCount =request.getParameter("pageDataCount"); 

			System.out.println("사사나String bId ==" + bId);


			BDto dto=bDao.select(bId);

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


			if(searchCol==null||searchVal==null) {
				searchCol="bTitle";
				searchVal="";
			}
			if(searchCol.equals("")||searchVal.equals("")) {
				searchCol="bTitle";
				searchVal="";
			}

			request.setAttribute("bSearchDto", bSearchDto);

			return "redirect:/content_view?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;

		}else {
			String bId=request.getParameter("bId");
			BCommentDto bcommentDto = new BCommentDto();
			bcommentDto.setNOTICE_COMMENT_ID(request.getParameter("NOTICE_COMMENT_ID"));
			bcommentDto.setNOTICE_COMMENT_BOARD(Integer.parseInt(request.getParameter("bId")));
			bcommentDto.setNOTICE_COMMENT_CONTENT(request.getParameter("NOTICE_COMMENT_CONTENT"));
			System.out.println(" request.getParameter(\"NOTICE_COMMENT_GROUPID\")) " + request.getParameter("NOTICE_COMMENT_GROUPID"));
			bcommentDto.setNOTICE_COMMENT_GROUPID(Integer.parseInt(request.getParameter("NOTICE_COMMENT_GROUPID")));
			bcommentDto.setNOTICE_COMMENT_INDENT(Integer.parseInt(request.getParameter("NOTICE_COMMENT_INDENT")));
			bcommentDto.setNOTICE_COMMENT_STEP(Integer.parseInt(request.getParameter("NOTICE_COMMENT_STEP")));

			System.out.println("답글달기 답글등록 누르기");		
			IDao bDao = sqlSession.getMapper(IDao.class);

			int str = bcommentDto.getNOTICE_COMMENT_BOARD();
			bDao.downdateHit(str);
			bDao.insertBoardCommentReply(bcommentDto);




			String page=request.getParameter("page");
			String searchVal =request.getParameter("searchVal");
			String searchCol =request.getParameter("searchCol");
			String pageDataCount =request.getParameter("pageDataCount"); 

			System.out.println("사사나String bId ==" + bId);


			BDto dto=bDao.select(bId);

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


			if(searchCol==null||searchVal==null) {
				searchCol="bTitle";
				searchVal="";
			}
			if(searchCol.equals("")||searchVal.equals("")) {
				searchCol="bTitle";
				searchVal="";
			}

			request.setAttribute("bSearchDto", bSearchDto);

			return "redirect:/content_view?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;
		}
	}


	@RequestMapping(value = "/delete_comment", method = RequestMethod.GET)
	public String delete_comment(HttpServletRequest request, Model model) {
		String NOTICE_COMMENT_NUM = request.getParameter("NOTICE_COMMENT_NUM");

		int bId2= Integer.parseInt(request.getParameter("bId"));
		String bId = request.getParameter("bId");

		IDao bDao = sqlSession.getMapper(IDao.class);


		bDao.downdateHit(bId2);

		bDao.delete_comment(NOTICE_COMMENT_NUM);

		String page=request.getParameter("page");
		String searchVal =request.getParameter("searchVal");
		String searchCol =request.getParameter("searchCol");
		String pageDataCount =request.getParameter("pageDataCount"); 

		System.out.println("사사나String bId ==" + bId);


		BDto dto=bDao.select(bId);

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


		if(searchCol==null||searchVal==null) {
			searchCol="bTitle";
			searchVal="";
		}
		if(searchCol.equals("")||searchVal.equals("")) {
			searchCol="bTitle";
			searchVal="";
		}

		request.setAttribute("bSearchDto", bSearchDto);

		return "redirect:/content_view?bId="+bId+"&page="+page+"&searchCol="+searchCol+"&searchVal="+searchVal+"&pageDataCount="+pageDataCount;

	}


}
