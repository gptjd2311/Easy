package com.easy.test0805;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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



@Controller
public class BoardController {

	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	
	BDao dao;
	BoardDAO bDao;
	MemberDAO mDao;
	ProductDAO pDao;
	ResDao ResDao;
	ReserveDAO rDao;
	SugDao sDao;

	
}