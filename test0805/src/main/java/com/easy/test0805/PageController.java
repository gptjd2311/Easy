package com.easy.test0805;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.easy.test0805.dao.BDao;
import com.easy.test0805.dao.BoardDAO;
import com.easy.test0805.dao.MemberDAO;
import com.easy.test0805.dao.ProductDAO;
import com.easy.test0805.dao.ResDao;
import com.easy.test0805.dao.ReserveDAO;
import com.easy.test0805.dao.SugDao;


@Controller
public class PageController {

	private static final Logger logger = LoggerFactory.getLogger(PageController.class);

	BDao dao;
	BoardDAO bDao;
	MemberDAO mDao;
	ProductDAO pDao;
	ResDao ResDao;
	ReserveDAO rDao;
	SugDao sDao;


	
	
}