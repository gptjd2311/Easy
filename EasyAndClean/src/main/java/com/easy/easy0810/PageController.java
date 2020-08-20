package com.easy.easy0810;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

import com.easy.easy0810.del.BDao;
import com.easy.easy0810.del.BoardDAO;
import com.easy.easy0810.del.MemberDAO;
import com.easy.easy0810.del.ProductDAO;
import com.easy.easy0810.del.ResDao;
import com.easy.easy0810.del.ReserveDAO;
import com.easy.easy0810.del.SugDao;


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